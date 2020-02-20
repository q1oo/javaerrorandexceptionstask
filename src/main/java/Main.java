import entity.*;

import static entity.LearningCourse.*;

public class Main {
    public static void main(String[] args) {
        University university = new University();

        try {
//      1. Средний балл по всем предметам конкретного студента:
            System.out.println("The average grade of [" + university.faculties.get(0).getGroups().get(0).getStudents().get(0).getName()
                    + " (" + university.faculties.get(0).getGroups().get(0).getName() + ", " + university.faculties.get(0).getName()
                    + ")] is " + university.faculties.get(0).getGroups().get(0).getStudents().get(0).getStudentAverageGrade() + ".");

//      2. Средний балл по конкретному предмету в конкретной группе:
            System.out.println("The average grade of students [" + university.faculties.get(0).getGroups().get(0).getName()
                    + " (" + university.faculties.get(0).getName() + ")] in " + ENGLISH + " is "
                    + university.faculties.get(0).getGroups().get(0).getGroupAverageGradeOfLeraningCourse(ENGLISH) + ".");

//      3. Средний балл по конкретному предмету на конкретном факультете:
            System.out.println("The average grade of students [" + university.faculties.get(0).getName() + "] in " + ENGLISH + " is "
                    + university.faculties.get(0).getFacultyAverageGradeOfLeraningCourse(ENGLISH));

//      4. Cредний балл по конкретному предмету для всего университета:
            System.out.println("The average grade of students [" + university.nameOfUniversity + "] in " + ENGLISH + " is "
                    + university.getUniversityAverageGradeOfLeraningCourse(ENGLISH));
        } catch (NullPointerException e) {
            System.err.println("There is some problem higher..");
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}
