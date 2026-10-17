package ru.kpk.courses_service.patterns.state;

public class PendingPaymentState implements EnrollmentState {

    @Override
    public void pay(EnrollmentContext context) {
        System.out.println("Оплата получена. Запись отправлена на проверку.");
        context.setCurrentState(new PendingReviewState());
    }

    @Override
    public void approve(EnrollmentContext context) {
        System.out.println("Ошибка: нельзя одобрить неоплаченный курс.");
    }

    @Override
    public void reject(EnrollmentContext context) {
        System.out.println("Заявка отклонена.");
        context.setCurrentState(new RejectedState());
    }

    @Override
    public void complete(EnrollmentContext context) {
        System.out.println("Ошибка: нельзя завершить неоплаченный курс.");
    }

    @Override
    public String getStatusName() {
        return "PENDING_PAYMENT";
    }
}
