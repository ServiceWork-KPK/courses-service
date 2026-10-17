package ru.kpk.courses_service.patterns.state;

public class RejectedState implements EnrollmentState {

    @Override
    public void pay(EnrollmentContext context) {
        System.out.println("Ошибка: заявка отклонена.");
    }

    @Override
    public void approve(EnrollmentContext context) {
        System.out.println("Ошибка: заявка отклонена.");
    }

    @Override
    public void reject(EnrollmentContext context) {
        System.out.println("Заявка уже отклонена.");
    }

    @Override
    public void complete(EnrollmentContext context) {
        System.out.println("Ошибка: заявка отклонена.");
    }

    @Override
    public String getStatusName() {
        return "REJECTED";
    }
}
