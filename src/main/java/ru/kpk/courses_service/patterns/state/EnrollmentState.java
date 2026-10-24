package ru.kpk.courses_service.patterns.state;

import org.springframework.context.ApplicationEventPublisher;

public interface EnrollmentState {
    void pay(EnrollmentContext context); // Оплатить
    void approve(EnrollmentContext context); // Одобрить
    void reject(EnrollmentContext context); // Отклонить
    void complete(EnrollmentContext context, ApplicationEventPublisher eventPublisher); // Завершить

    String getStatusName(); // Узнать текущий статус
}
