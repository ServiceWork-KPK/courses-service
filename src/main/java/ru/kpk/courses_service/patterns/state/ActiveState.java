package ru.kpk.courses_service.patterns.state;

public class ActiveState implements EnrollmentState {

    @Override
    public void pay(EnrollmentContext context) {
        System.out.println("Ошибка: курс уже оплачен и активен.");
    }

    @Override
    public void approve(EnrollmentContext context) {
        System.out.println("Курс уже активен.");
    }

    @Override
    public void reject(EnrollmentContext context) {
        System.out.println("Ошибка: нельзя отклонить активный курс.");
    }

    @Override
    public void complete(EnrollmentContext context) {
        System.out.println("Курс успешно завершён!");
        context.setCurrentState(new CompletedState());
    }

    @Override
    public String getStatusName() {
        return "ACTIVE";
    }
}
