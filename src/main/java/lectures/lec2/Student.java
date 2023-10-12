package lectures.lec2;

import java.util.Objects;

public class Student {
    private String surname;
    private int age;
    private String group;

    public Student(String surname, int age) {
        this.surname = surname;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(surname, student.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, age);
    }
}
