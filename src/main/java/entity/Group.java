package entity;

import java.util.List;

public class Group {
    private String name;
    private List<Student> students;

    public Group(String name, List<Student> students) {
        this.name = name;
        this.students = students;
    }

    public double getGroupAverageGradeOfLeraningCourse(LearningCourse course) {
        int sumOfGrade = 0;
        for (Student student : this.students) {
            sumOfGrade += student.getStudentCourses().get(course);
        }
        return Math.floor((double)sumOfGrade/this.students.size() * 1e2)/1e2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Group{" +
                "name='" + name + '\'' +
                '}';
    }
}
