package ma.pfe.repositories;

import ma.pfe.entities.StudentEntity;
import ma.pfe.entities.StudentId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<StudentEntity, StudentId> {

}
