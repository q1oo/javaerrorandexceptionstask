package entity;

import java.util.Map;

public class Student {
    private int studentId;
    private String name;
    private Map<LearningCourse, Integer> studentCourses;

    public Student(int studentId, String name, Map<LearningCourse, Integer> studentCourses) {
        this.studentId = studentId;
        this.name = name;
        this.studentCourses = studentCourses;
    }

    public double getStudentAverageGrade() {
        int sumOfGrades = 0;
        for (Integer value : this.studentCourses.values()) {
            sumOfGrades += value;
        }
        return Math.floor((double)sumOfGrades/this.studentCourses.size() * 1e2)/1e2;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<LearningCourse, Integer> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(Map<LearningCourse, Integer> studentCourses) {
        this.studentCourses = studentCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", studentCourses=" + studentCourses +
                '}' + "\n";
    }
}
