package ru.kpk.courses_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kpk.courses_service.patterns.observer.CoursePublisher;

@RestController
public class ObserverController {

    private final CoursePublisher coursePublisher;

    public ObserverController(CoursePublisher coursePublisher) {
        this.coursePublisher = coursePublisher;
    }

    @GetMapping("/test_observer")
    public String testObserver() {
        coursePublisher.publishCourseCompleted("Иванов Иван", "Java-разработчик");

        return "Проверка Наблюдателя завершена.";
    }
}