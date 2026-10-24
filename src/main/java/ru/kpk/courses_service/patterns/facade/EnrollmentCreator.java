package ru.kpk.courses_service.patterns.facade;

public class EnrollmentCreator {
    public void createEnrollment(String studentName, String courseTitle) {
        // TODO: вызов EnrollmentRepository.save() для сохранения новой записи
        //  в базу данных (со статусом PENDING_PAYMENT).
        //  Также вызов Auth & Users Service для получения ID пользователя.
        System.out.println("Создана запись для " + studentName + " на курс '" + courseTitle + "'.");
    }
}
