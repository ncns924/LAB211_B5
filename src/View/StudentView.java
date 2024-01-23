package view;

import Model.Student;

import java.util.ArrayList;

public class StudentView {
    public void displayMenu() {
        System.out.println("WELCOME TO STUDENT MANAGEMENT");
        System.out.println("1. Create");
        System.out.println("2. Find and Sort");
        System.out.println("3. Update/Delete");
        System.out.println("4. Report");
        System.out.println("5. Exit");
        System.out.print("Please choose an option: ");
    }

    public void displayStudentList(ArrayList<Student> students) {
    System.out.printf("%-15s%-15s%-15s\n", "Name", "Semester", "Course");
    for (Student student : students) {
        System.out.printf("%-15s%-15s%-15s\n", student.getName(), student.getSemester(), student.getCourse());
    }
}

public void displayReport(ArrayList<Student> students) {
    System.out.printf("%-15s%-15s%-15s\n", "Name", "Course", "Count");
    for (Student student : students) {
        System.out.printf("%-15s%-15s%-15s\n", student.getName(), student.getCourse(), countCourses(students, student.getCourse(), student.getId()));
    }
}

    private int countCourses(ArrayList<Student> students, String course, int id) {
        int count = 0;
        for (Student student : students) {
            if (id == student.getId() && course.equals(student.getCourse())) {
                count++;
            }
        }
        return count;
    }
}