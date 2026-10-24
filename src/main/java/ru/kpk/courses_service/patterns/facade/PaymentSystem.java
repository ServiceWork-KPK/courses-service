package ru.kpk.courses_service.patterns.facade;

public class PaymentSystem {
    public void processPayment(String studentName, String courseTitle, double amount) {
        // TODO: вызов Payment Service (через REST API) для создания транзакции.
        //  После успешной оплаты Payment Service должен отправить callback
        //  в Courses Service для смены статуса на PENDING_REVIEW или ACTIVE.
        System.out.println("Сумма " + amount + " руб. внесена студентом " + studentName +
                " для оплаты курса '" + courseTitle + "'.\nОплата прошла успешно." );
    }
}
