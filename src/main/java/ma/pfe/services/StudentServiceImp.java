package ma.pfe.services;

import ma.pfe.dtos.StudentDto;
import ma.pfe.dtos.StudentIdDto;
import ma.pfe.mappers.StudentMapper;
import ma.pfe.repositories.StudentRepository;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentServiceImp implements StudentService{

    private final Logger LOG = LoggerFactory.getLogger(StudentServiceImp.class);
    private StudentRepository studentRepository;
    private static final StudentMapper studentMapper = Mappers.getMapper(StudentMapper.class);

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> readAll() {
        LOG.debug("start method readall dto : {} ");
        return studentMapper.studentEntiesToDtos(studentRepository.findAll());
    }
    @Override
    public StudentDto findStudentById(StudentIdDto idDto) {
        LOG.debug("start method findStudentById: {} ");
        return studentMapper.studentEntityToDto(
                studentRepository
                        .findById(
                                studentMapper
                                        .studentIdDtoToStudentId(idDto)).orElse(null));

    }
    @Override
    public Long create(StudentDto studentDto) {
        LOG.debug("start method create dto : {} ", studentDto);
        StudentDto student = studentMapper.studentEntityToDto(studentRepository.save(studentMapper.studentDtoToEntity(studentDto)));
        return student.getStudentId().getId();
    }

    @Override
    public Long update(StudentDto studentDto) {

        LOG.debug("start method update dto : {} ", studentDto);
        StudentDto student = studentMapper.studentEntityToDto(studentRepository.save(studentMapper.studentDtoToEntity(studentDto)));
        return student.getStudentId().getId();
    }
    @Override
    public boolean delete(StudentIdDto id) {
        LOG.debug("start method delete dto : {} ", id);
        studentRepository.deleteById(studentMapper.studentIdDtoToStudentId(id));
        return true;
    }

}
