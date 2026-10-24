package ru.kpk.courses_service.patterns.facade;

public class EnrollmentFacade {
    private final SeatChecker seatChecker;
    private final EnrollmentCreator enrollmentCreator;
    private final PaymentSystem paymentSystem;

    public EnrollmentFacade() {
        this.seatChecker = new SeatChecker();
        this.enrollmentCreator = new EnrollmentCreator();
        this.paymentSystem = new PaymentSystem();
    }

    public void enroll(String studentName, String courseTitle, boolean isPaid, double price) {
        System.out.println("Запись на курс '" + courseTitle + "'.");

        // Проверка свободных мест
        if (!seatChecker.hasAvailableSeats(courseTitle)) {
            System.out.println("Ошибка: свободных мест нет.");
            return;
        }

        // Создание записи
        try {
            enrollmentCreator.createEnrollment(studentName, courseTitle);
        } catch (Exception e) {
            System.out.println("Ошибка: запись не была создана. Повторите попытку.");
            return;
        }

        // Оплата, если курс платный
        if (isPaid) {
            try {
                paymentSystem.processPayment(studentName, courseTitle, price);
            } catch (Exception e) {
                System.out.println("Ошибка: оплата не прошла. Запись отменена.");
                // TODO: удалить созданную запись или перевести
                //  её в статус REJECTED/CANCELLED, так как оплата не прошла.
                return;
            }
        } else {
            System.out.println("Курс бесплатный. Оплата не требуется.");
        }

        System.out.println("Студент " + studentName + " успешно записан на курс '"
                + courseTitle + "'.");
    }
}
