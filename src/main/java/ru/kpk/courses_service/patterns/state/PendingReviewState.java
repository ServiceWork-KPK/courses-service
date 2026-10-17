package ru.kpk.courses_service.patterns.state;

public class PendingReviewState implements EnrollmentState {

    @Override
    public void pay(EnrollmentContext context) {
        System.out.println("Ошибка: курс уже оплачен, ожидает проверки.");
    }

    @Override
    public void approve(EnrollmentContext context) {
        System.out.println("Заявка одобрена. Доступ к курсу открыт.");
        context.setCurrentState(new ActiveState());
    }

    @Override
    public void reject(EnrollmentContext context) {
        System.out.println("Заявка отклонена.");
        context.setCurrentState(new RejectedState());
    }

    @Override
    public void complete(EnrollmentContext context) {
        System.out.println("Ошибка: нельзя завершить курс, он ещё не активен.");
    }

    @Override
    public String getStatusName() {
        return "PENDING_REVIEW";
    }
}
