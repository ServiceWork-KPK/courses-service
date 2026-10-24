package ru.kpk.courses_service.patterns.observer;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class TestResultObserver implements CourseObserver {
    @Override
    @EventListener
    public void onCourseCompleted(CourseCompletedEvent event) {
        System.out.println("[Тест] Результат итогового теста сохранен для " +
                event.getStudentName() + ".");

        // TODO: Сохранение TestResult в базу данных (score, passed, completed_at).
    }
}
