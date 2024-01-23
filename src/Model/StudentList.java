package Model;

import Model.Student;

import java.util.ArrayList;

public class StudentList {
    private ArrayList<Student> students = new ArrayList<>();
    public void addStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student> getStudents() {
        return students;
    }
}