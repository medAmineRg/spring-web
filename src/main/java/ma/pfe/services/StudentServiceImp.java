package ma.pfe.services;

import ma.pfe.dtos.StudentDto;
import ma.pfe.entities.StudentEntity;
import ma.pfe.mappers.StudentMapper;
import ma.pfe.repositories.StudentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImp implements  StudentService{

    private final Logger LOG = LoggerFactory.getLogger(StudentServiceImp.class);
    StudentRepository studentRepository;
    StudentMapper studentMapper ;

    public StudentServiceImp(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    @Override
    public StudentDto create(StudentDto studentDto) {

        LOG.debug("start method create");
        StudentEntity studentEntity = studentRepository.create(studentMapper.convertToEntity(studentDto));
        LOG.debug("end method create");
        return studentMapper.convertToDto(studentEntity);
    }

    @Override
    public boolean update(StudentDto studentDto) {

        LOG.debug("start method update");
        boolean bool = studentRepository.update(studentMapper.convertToEntity(studentDto));
        LOG.debug("end method update");
        return bool;
    }

    @Override
    public boolean delete(Long id) {

        LOG.debug("start method delete");
        boolean bool = studentRepository.delete(id);
        LOG.debug("end method delete");
        return bool;
    }

    @Override
    public List<StudentDto> readAll() {
        LOG.debug("start method read all");
        List<StudentDto> studentDtoList = studentMapper.convertToDto(studentRepository.readAll());
        LOG.debug("end method read all");
        return studentDtoList;
    }
}
