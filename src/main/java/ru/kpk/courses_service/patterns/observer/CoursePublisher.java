package ru.kpk.courses_service.patterns.observer;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CoursePublisher {
    // Список всех подписчиков
    private final ApplicationEventPublisher eventPublisher;

    public CoursePublisher(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    // Метод для оповещения всех подписчиков о завершении курса
    public void publishCourseCompleted(String studentName, String courseTitle) {
        System.out.println("Курс '" + courseTitle + "' завершён слушателем " + studentName + ".");
        System.out.println("Рассылка уведомления подписчикам...");

        // TODO: можно добавить асинхронность (@Async)
        eventPublisher.publishEvent(new CourseCompletedEvent(studentName, courseTitle));
    }
}
