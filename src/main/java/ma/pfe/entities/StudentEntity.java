package ma.pfe.entities;

import javax.persistence.*;

import java.util.List;

@Entity
@Table(name="student")
public class StudentEntity {
    @EmbeddedId
    private StudentId studentId;
    @Column(name = "student_name")
    private String name;
    @Embedded
    private Adresse adresse;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST}, fetch = FetchType.EAGER) @JoinTable(name = "tab_courses")
    private List<CourseEntity> courses;



    public List<CourseEntity> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseEntity> courses) {
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public StudentId getStudentId() {
        return studentId;
    }

    public void setStudentId(StudentId studentId) {
        this.studentId = studentId;
    }


    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    @Override
    public String toString() {
        return "StudentEntity{" +
                "studentId=" + studentId +
                ", name='" + name + '\'' +
                ", adresse=" + adresse +
                ", courses=" + courses +
                '}';
    }
}
