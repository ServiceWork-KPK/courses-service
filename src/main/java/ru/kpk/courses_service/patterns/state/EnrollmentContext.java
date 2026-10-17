package ru.kpk.courses_service.patterns.state;

public class EnrollmentContext {
    private EnrollmentState currentState; // Текущий статус

    // Новая запись по умолчанию ждёт оплату
    public EnrollmentContext() {
        this.currentState = new PendingPaymentState();
    }

    // Сменить статус
    public void setCurrentState(EnrollmentState state) {
        this.currentState = state;
    }

    // Узнать текущий статус
    public String getStatus() {
        return currentState.getStatusName();
    }

    void pay() { currentState.pay(this); };
    void approve() { currentState.approve(this); }
    void reject() { currentState.reject(this); }
    void complete() { currentState.complete(this); }
}
