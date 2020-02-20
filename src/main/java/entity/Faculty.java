package entity;

import java.util.List;

public class Faculty {
    private String name;
    private List<Group> groups;

    public Faculty(String name, List<Group> groups) {
        this.name = name;
        this.groups = groups;
    }

    public double getFacultyAverageGradeOfLeraningCourse(LearningCourse course) {
        int sumOfGrade = 0;
        for (Group group : groups) {
            sumOfGrade += group.getGroupAverageGradeOfLeraningCourse(course);
        }
        return Math.floor((double)sumOfGrade/this.groups.size() * 1e2)/1e2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "name='" + name + '\'' +
                '}';
    }
}
