package ru.kpk.courses_service.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kpk.courses_service.patterns.state.EnrollmentContext;

@RestController
public class EnrollmentController {

    // Успешное прохождение курса
    @GetMapping("/test_state_success")
    public String testState1() {
        EnrollmentContext enrollment = new EnrollmentContext();
        StringBuilder result = new StringBuilder();

        result.append("1. Создана запись. Статус: ").
                append(enrollment.getStatus()).append("<br>");

        enrollment.approve(); // Попытка одобрить неоплаченную запись
        enrollment.complete(); // Попытка завершить неоплаченный курс


        enrollment.pay(); // Оплачиваем запись
        result.append("2. После оплаты. Статус: ").
                append(enrollment.getStatus()).append("<br>");

        enrollment.approve(); // Одобряем запись
        result.append("3. После одобрения. Статус: ").
                append(enrollment.getStatus()).append("<br>");

        enrollment.pay(); // Попытка оплатить оплаченный и активный курс

        enrollment.reject(); // Попытка отклонить активную запись

        enrollment.complete(); // Завершаем курс
        result.append("4. После завершения. Статус: ").
                append(enrollment.getStatus()).append("<br>");

        enrollment.pay(); // Попытка оплатить завершённый курс
        enrollment.approve(); // Попытка одобрить завершённый курс
        enrollment.reject(); // Попытка отклонить завершённый курс
        enrollment.complete(); // Попытка завершить завершённый курс

        return result.toString();
    }

    // Отклонённая заявка на курс
    @GetMapping("/test_state_reject")
    public String testState2() {
        EnrollmentContext enrollment = new EnrollmentContext();
        StringBuilder result = new StringBuilder();

        result.append("1. Создана запись. Статус: ").
                append(enrollment.getStatus()).append("<br>");

        enrollment.reject(); // Отклоняем запись
        result.append("2. После отклонения. Статус: ").
                append(enrollment.getStatus()).append("<br>");

        enrollment.pay(); // Попытка оплатить отклонённую запись
        enrollment.approve(); // Попытка одобрить отклонённую запись
        enrollment.complete(); // Попытка завершить  отклонённую запись

        return result.toString();
    }
}
