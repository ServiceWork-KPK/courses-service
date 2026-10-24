package ru.kpk.courses_service.patterns.state;

import org.springframework.context.ApplicationEventPublisher;
import ru.kpk.courses_service.patterns.observer.CourseCompletedEvent;

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
    public void complete(EnrollmentContext context, ApplicationEventPublisher eventPublisher) {
        System.out.println("Курс успешно завершён!");
        context.setCurrentState(new CompletedState());

        eventPublisher.publishEvent(new CourseCompletedEvent("Иванов Иван", "Java-разработчик"));
    }

    @Override
    public String getStatusName() {
        return "ACTIVE";
    }
}
