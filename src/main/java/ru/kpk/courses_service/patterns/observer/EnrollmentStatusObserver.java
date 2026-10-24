package ru.kpk.courses_service.patterns.observer;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EnrollmentStatusObserver implements CourseObserver {
    @Override
    @EventListener
    public void onCourseCompleted(CourseCompletedEvent event) {
        System.out.println("[Статус] Запись слушателя " + event.getStudentName() +
                " переведена в статус COMPLETED.");

        // TODO: Сохранение обновленного статуса 'completed' в БД (EnrollmentRepository).
    }
}
