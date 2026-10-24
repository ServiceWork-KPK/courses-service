package ru.kpk.courses_service.patterns.observer;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class CertificateObserver implements CourseObserver {
    @Override
    @EventListener
    public void onCourseCompleted(CourseCompletedEvent event) {
        System.out.println("[Сертификат] Сформирован PDF-сертификат для " +
                event.getStudentName() + " об успешном завершении курса '" + event.getCourseTitle() + "'.");
        // TODO: вызов Builder для сборки данных сертификата и сохранение PDF-файла
        //  в объектное хранилище и запись метаданных в таблицу Certificate.
    }
}
