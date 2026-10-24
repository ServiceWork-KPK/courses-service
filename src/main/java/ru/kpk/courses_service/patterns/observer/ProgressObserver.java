package ru.kpk.courses_service.patterns.observer;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ProgressObserver implements CourseObserver {
    @Override
    @EventListener
    public void onCourseCompleted(CourseCompletedEvent event) {
        System.out.println("[Прогресс] Прогресс слушателя " + event.getStudentName() +
                " по курсу '" + event.getCourseTitle() + "' обновлен на 100%.");

        // TODO: Обновление сущности Progress в БД (установка флага completed_at).
    }
}
