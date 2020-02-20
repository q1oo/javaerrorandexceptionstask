package entity;

import java.util.*;
import static entity.LearningCourse.*;
import exeption.*;

public class University {
    public final String nameOfUniversity;
    public static List<Faculty> faculties;

    public University() {
        this.nameOfUniversity = "MGU";
        try {
            this.faculties = createListOfFaculties((int)(3 + Math.random()*3));
        } catch (EmptyUniversityException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Map<LearningCourse, Integer> createMapOfCourses() throws WrongGradeInitialisationException, EmptyStudentLearningCoursesException {
        Map<LearningCourse, Integer> courses = new HashMap<>();
        for (int j = 0; j < 4; j++) {
            int grade = (int)(Math.random()*11);
            if (grade < 0 || grade > 10) {
                throw new WrongGradeInitialisationException("The grade must be between 0 and 10!");
            } else {
                courses.put(getNameOfCourse(j), grade);
            }
        }
        if (courses.isEmpty()) {
            throw new EmptyStudentLearningCoursesException("The student must have at least one learning course!");
        }
        return courses;
    }

    public static List<Student> createListOfStudents(int size) throws EmptyGroupException {
        List<Student> students = new ArrayList<>();
        for (int i = 1; i < size + 1; i++) {
            Student student = null;
            try {
                student = new Student(i, "StudentNumber" + i, createMapOfCourses());
            } catch (WrongGradeInitialisationException | EmptyStudentLearningCoursesException e) {
                System.err.println(e.getMessage().replace("!", " (StudentNumber" + i + ")!"));
            }
            students.add(student);
        }
        if (students.isEmpty()) {
            throw new EmptyGroupException("The group must have students!");
        }
        return students;
    }

    public static List<Group> createListOfGroups(int size) throws EmptyFacultyException {
        List<Group> groups = new ArrayList<>();
        for (int i = 1; i < size + 1; i++) {
            Group group = null;
            try {
                group = new Group("GroupNumber" + i, createListOfStudents((int)(15 + Math.random()*6)));
            } catch (EmptyGroupException e) {
                System.err.println(e.getMessage().replace("!", " (GroupNumber" + i + ")!"));
            }
            groups.add(group);
        }
        if (groups.isEmpty()) {
            throw new EmptyFacultyException("The faculty must have groups of students!");
        }
        return groups;
    }

    public static List<Faculty> createListOfFaculties(int size) throws EmptyUniversityException {
        List<Faculty> faculties = new ArrayList<>();
        for (int i = 1; i < size + 1; i++) {
            Faculty faculty = null;
            try {
                faculty = new Faculty("FacultyNumber" + i, createListOfGroups((int)(2 + Math.random()*3)));
            } catch (EmptyFacultyException e) {
                System.err.println(e.getMessage().replace("!", " (FacultyNumber" + i + ")!"));
            }
            faculties.add(faculty);
        }
        if (faculties.isEmpty()) {
            throw new EmptyUniversityException("The university don't have faculties, what is wrong with you?!");
        }
        return faculties;
    }

    public static double getUniversityAverageGradeOfLeraningCourse(LearningCourse course) {
        int sumOfGrade = 0;
        for (Faculty faculty : faculties) {
            sumOfGrade += faculty.getFacultyAverageGradeOfLeraningCourse(course);
        }
        return Math.floor((double)sumOfGrade/faculties.size() * 1e2)/1e2;
    }

    public static LearningCourse getNameOfCourse(int i) {
        LearningCourse course = null;
        switch (i) {
            case 0:
                course = CHEMISTRY;
                break;
            case 1:
                course = ENGLISH;
                break;
            case 2:
                course = HIGH_MATH;
                break;
            case 3:
                course = PHYSICS;
                break;
        }
        return course;
    }
}
