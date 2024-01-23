package Model;

public class Student {

    private int id;
    private String name;
    private int semester;
    private String course;

    public Student(String name, int id, String course, int semester) {
        this.id = id;
        this.name = name;
        this.semester = semester;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSemester() {
        return semester;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", semester=" + semester +
                ", course='" + course + '\'' +
                '}';
    }
public void setName(String name) {
    this.name = name;
}
public void setSemester(int semester) {
    this.semester = semester;
}
}
