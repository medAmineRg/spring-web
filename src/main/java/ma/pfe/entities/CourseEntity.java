package ma.pfe.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    public CourseEntity() {
    }

    public CourseEntity(Long id, String name) {
        this.id = id;
        this.name = name;

    }
    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CourseEntity{" +
                "courseId=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
