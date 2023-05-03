package ma.pfe.controllers;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.tags.Tag;
import ma.pfe.dtos.StudentDto;
import ma.pfe.dtos.StudentIdDto;
import ma.pfe.services.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/student")
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Student", description = "The Student API. Contains all the operations that can be performed on a user.")
public class StudentController {
    private StudentService studentService;
    private final Logger LOG = LoggerFactory.getLogger(StudentController.class);
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
    @GetMapping
    public List<StudentDto> readAll() {
        LOG.debug("start method read All");
        List<StudentDto> studentDtoList =  studentService.readAll();
        return studentDtoList;
    }
    @GetMapping("/{id}/{code}")
    public StudentDto findStudentById(@PathVariable("id") Long id,@PathVariable("code") String code) {
        StudentIdDto studentIdDto = new StudentIdDto(id, code);
        LOG.debug("find student by id method {}", studentIdDto);
        StudentDto student = studentService.findStudentById(studentIdDto);
        return student;
    }

    @PostMapping
    public Long save(@RequestBody StudentDto dto) {
        LOG.debug("start method save :{}", dto);
        return  studentService.create(dto);
    }

    @PutMapping
    public Long update(@RequestBody StudentDto dto) {
        LOG.debug("start method update: {}", dto);
        return studentService.update(dto);
    }

    @DeleteMapping("/{id}/{code}")
    public boolean delete(@PathVariable("id") Long id,@PathVariable("code") String code) {
        StudentIdDto studentIdDto = new StudentIdDto(id, code);
        LOG.debug("start method delete: {}", studentIdDto);
        return studentService.delete(studentIdDto);
    }

}
