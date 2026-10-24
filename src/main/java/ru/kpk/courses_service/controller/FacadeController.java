package ru.kpk.courses_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kpk.courses_service.patterns.facade.EnrollmentFacade;

@RestController
public class FacadeController {

    @GetMapping("/test_facade")
    public String testFacade() {
        EnrollmentFacade facade = new EnrollmentFacade();

        // Тест 1: Платный курс
        facade.enroll("Иванов Иван", "Java-разработчик", true, 15000.0);

        // Тест 2: Бесплатный курс
        facade.enroll("Петров Петр", "Введение в Java", false, 0.0);

        return "Проверка Фасада завершена.";
    }
}
