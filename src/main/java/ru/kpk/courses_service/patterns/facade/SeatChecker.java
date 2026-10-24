package ru.kpk.courses_service.patterns.facade;

public class SeatChecker {
    public boolean hasAvailableSeats(String courseTitle) {
        System.out.println("Проверка мест для курса '" + courseTitle + "'.");
        // TODO: вызов EnrollmentRepository для подсчёта кол-ва активных записей
        //  (enrollment.countByCourseId(courseId) и сравнения с лимитом мест
        //  (course.getCapacity())
        return true;
    }
}
