package ru.kpk.courses_service.patterns.observer;

public interface CourseObserver {
    void onCourseCompleted(CourseCompletedEvent event); // Вызовется, когда курс будет завершён
}
