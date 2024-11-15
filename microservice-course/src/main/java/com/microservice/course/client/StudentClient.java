package com.microservice.course.client;

import com.microservice.course.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

//El nombre que hay que poner es el nombre del microservicio al que le vamos a pasar la consulta
//Dicho nombre estara en el application.yml del microservicio de estudiantes
// Y el puerto se pone el que tiene tambien el application.yml del microservicio de estudiantes
// Y el /api/student viene del controller de estudiantes
@FeignClient(name = "msvc-student",url = "localhost:8090/api/student")
public interface StudentClient {

    @GetMapping("/search-ny-course/{idCourse}")
    List<StudentDTO> findAllStudentByCourse(@PathVariable Long idCourse);
}
