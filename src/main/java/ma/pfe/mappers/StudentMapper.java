package ma.pfe.mappers;

import ma.pfe.dtos.StudentDto;
import ma.pfe.dtos.StudentIdDto;
import ma.pfe.entities.StudentEntity;
import ma.pfe.entities.StudentId;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper
public interface StudentMapper {
     StudentEntity studentDtoToEntity(StudentDto dto);
     StudentDto studentEntityToDto(StudentEntity studentEntity) ;
     List<StudentDto> studentEntiesToDtos(List<StudentEntity> studentEntities) ;
     StudentId studentIdDtoToStudentId(StudentIdDto studentIdDTO) ;

}
