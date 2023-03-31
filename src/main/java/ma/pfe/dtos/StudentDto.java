package ma.pfe.dtos;
import java.util.List;

public class StudentDto {

    private StudentIdDto studentId;
    private String name;
    private AdresseDto adresse;
    private List<CourseDto> courses;

    public StudentIdDto getStudentId() {
        return studentId;
    }

    public void setStudentId(StudentIdDto studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AdresseDto getAdresse() {
        return adresse;
    }

    public void setAdresse(AdresseDto adresse) {
        this.adresse = adresse;
    }

    public List<CourseDto> getCourses() {
        return courses;
    }

    public void setCourses(List<CourseDto> courses) {
        this.courses = courses;
    }
}
