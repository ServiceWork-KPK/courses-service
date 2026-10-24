package ru.kpk.courses_service.patterns.state;

import org.springframework.context.ApplicationEventPublisher;

public class EnrollmentContext {
    private EnrollmentState currentState; // Текущий статус
    private final ApplicationEventPublisher eventPublisher; // Для отправки событий

    // Новая запись по умолчанию ждёт оплату
    public EnrollmentContext(ApplicationEventPublisher eventPublisher) {
        this.currentState = new PendingPaymentState();
        this.eventPublisher = eventPublisher;
    }

    // Сменить статус
    public void setCurrentState(EnrollmentState state) {
        this.currentState = state;
    }

    // Узнать текущий статус
    public String getStatus() {
        return currentState.getStatusName();
    }

    public void pay() { currentState.pay(this); }
    public void approve() { currentState.approve(this); }
    public void reject() { currentState.reject(this); }
    public void complete() { currentState.complete(this, this.eventPublisher); }
}
