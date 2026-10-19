package ru.kpk.courses_service.patterns.state;

public class CompletedState implements EnrollmentState {

    @Override
    public void pay(EnrollmentContext context) {
        System.out.println("Ошибка: курс уже завершен.");
    }

    @Override
    public void approve(EnrollmentContext context) {
        System.out.println("Ошибка: курс уже завершен.");
    }

    @Override
    public void reject(EnrollmentContext context) {
        System.out.println("Ошибка: нельзя отклонить завершенный курс.");
    }

    @Override
    public void complete(EnrollmentContext context) {
        System.out.println("Курс уже завершен.");
    }

    @Override
    public String getStatusName() {
        return "COMPLETED";
    }
}
