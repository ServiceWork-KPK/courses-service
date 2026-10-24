package ru.kpk.courses_service.patterns.observer;

public class CourseCompletedEvent {
    private final String studentName;
    private final String courseTitle;

    public CourseCompletedEvent(String studentName, String courseTitle) {
        this.studentName = studentName;
        this.courseTitle = courseTitle;
    }

    public String getStudentName() { return studentName; }
    public String getCourseTitle() { return courseTitle; }
}