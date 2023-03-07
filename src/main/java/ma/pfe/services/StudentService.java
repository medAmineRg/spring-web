package ma.pfe.services;

import ma.pfe.dtos.StudentDto;
import ma.pfe.entities.StudentEntity;

import java.util.List;

public interface StudentService {


    StudentDto create(StudentDto studentEntity);
    boolean update(StudentDto studentEntity);
    boolean delete(Long id);
    List<StudentDto> readAll();
}
