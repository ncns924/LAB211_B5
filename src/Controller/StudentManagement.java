package Controller;

import Model.Student;
import Model.StudentList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import view.StudentView;


public class StudentManagement {
    private StudentList StudentList;
    private StudentView studentView;
    private Scanner scanner;

    public StudentManagement() {
        this.StudentList = new StudentList();
        this.studentView = new StudentView();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            studentView.displayMenu();
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    createStudent();
                    break;
                case 2:
                    findAndSortStudents();
                    break;
                case 3:
                    updateOrDeleteStudent();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Exiting program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

private void createStudent() {
    String continueChoice;
    do {
        System.out.print("Enter student ID: ");
        String idInput = scanner.nextLine();

        try {
            int ID = Integer.parseInt(idInput);
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter semester: ");
            int semester = Integer.parseInt(scanner.nextLine());
            System.out.print("Enter course (Java, .Net, C/C++): ");
            String course = scanner.nextLine().trim();

            // Pass the correct parameters to the Student constructor
            StudentList.addStudent(new Student(name, ID, course, semester));

            System.out.print("Do you want to continue (Y/N)? ");
            continueChoice = scanner.nextLine();
        } catch (NumberFormatException e) {
            System.out.println("Invalid input for student ID. Please enter a valid integer.");
            continueChoice = "Y"; // To ensure the loop continues in case of an exception
        }
    } while (continueChoice.equalsIgnoreCase("Y"));
}

    private void findAndSortStudents() {
        System.out.print("Enter student name: ");
        String searchName = scanner.nextLine();

        ArrayList<Student> result = new ArrayList<>();
        for (Student student : StudentList.getStudents()) {
            if (student.getName().toLowerCase().contains(searchName.toLowerCase())) {
                result.add(student);
            }
        }

        if (result.isEmpty()) {
            System.out.println("No matching students found.");
        } else {
            Collections.sort(result, (s1, s2) -> s1.getName().compareToIgnoreCase(s2.getName()));
            studentView.displayStudentList(result);
        }
    }

    private void updateOrDeleteStudent() {
    System.out.print("Enter student ID to update/delete: ");
    int idToUpdateDelete = Integer.parseInt(scanner.nextLine());

    int indexToUpdateDelete = -1;
    for (int i = 0; i < StudentList.getStudents().size(); i++) {
        if (StudentList.getStudents().get(i).getId() == idToUpdateDelete) {
            indexToUpdateDelete = i;
            break;
        }
    }

    if (indexToUpdateDelete != -1) {
        System.out.print("Do you want to update (U) or delete (D) the student? ");
        String choice = scanner.nextLine().toUpperCase();

        if (choice.equals("U")) {
            System.out.print("Enter new student name: ");
            String newName = scanner.nextLine();
            System.out.print("Enter new semester: ");
            int newSemester = Integer.parseInt(scanner.nextLine());

            // Update the name and semester directly in StudentList
            StudentList.getStudents().get(indexToUpdateDelete).setName(newName);
            StudentList.getStudents().get(indexToUpdateDelete).setSemester(newSemester);

            System.out.println("Student updated successfully.");
        } else if (choice.equals("D")) {
            StudentList.getStudents().remove(indexToUpdateDelete);
            System.out.println("Student deleted successfully.");
        } else {
            System.out.println("Invalid choice.");
        }
    } else {
        System.out.println("Student not found.");
    }
}



    private void generateReport() {
        studentView.displayReport(StudentList.getStudents());
    }
}