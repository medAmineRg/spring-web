package ma.pfe.services;

import ma.pfe.dtos.StudentDto;
import ma.pfe.dtos.StudentIdDto;

import java.util.List;

public interface StudentService {


    StudentDto findStudentById(StudentIdDto StudentIdDto);
    Long create(StudentDto studentEntity);
    Long update(StudentDto studentEntity);
    boolean delete(StudentIdDto id);
    List<StudentDto> readAll();
}
