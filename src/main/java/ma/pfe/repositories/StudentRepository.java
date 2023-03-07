package ma.pfe.repositories;

import ma.pfe.entities.StudentEntity;

import java.util.List;

public interface StudentRepository {

    StudentEntity create(StudentEntity studentEntity);
    boolean update(StudentEntity studentEntity);
    boolean delete(Long id);
    List<StudentEntity> readAll();
}
