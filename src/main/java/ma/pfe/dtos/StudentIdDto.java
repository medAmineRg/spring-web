package ma.pfe.dtos;

import java.util.Objects;

public class StudentIdDto {

    private Long id;
    private String code;

    public StudentIdDto() {
    }

    public StudentIdDto(Long id, String code) {
        this.id = id;
        this.code = code;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StudentIdDto studentId = (StudentIdDto) o;
        return Objects.equals(id, studentId.id) && Objects.equals(code, studentId.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, code);
    }
}
