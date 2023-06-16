package edu.course.sisumss.sisumss.controllers;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.course.sisumss.sisumss.dtos.DepartametDTO;
import edu.course.sisumss.sisumss.dtos.FacultyDTO;
import edu.course.sisumss.sisumss.services.FacultyServices;

@RestController
@RequestMapping("/faculty")
public class FacultyController {

    @Autowired
    private FacultyServices facultyServices;

    @GetMapping(path = "/{facultyUuId}")
    public FacultyDTO get(@PathVariable String facultyUuId) {

        return facultyServices.getFaculty(facultyUuId);

        // return new FacultyDTO(UUID.randomUUID().toString(),"FCYT", "Facultad de
        // Ciencias y Tegnologia");

    }

    @PostMapping()
    public FacultyDTO create(@RequestBody FacultyDTO facultyDTO) {

        return facultyServices.saveFaculty(facultyDTO);

        // facultyDTO.setUuid(UUID.randomUUID().toString());

        // return facultyDTO;

    }

    @RequestMapping(method = RequestMethod.PUT, path = "/faculty/{facultyUuId}")
    public FacultyDTO update(@PathVariable String facultyUuId, @RequestBody FacultyDTO facultyDTO) {

        return new FacultyDTO(facultyUuId, "FCYT", "Facultad de Ciencias y Tegnologia");

    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/faculty/{facultyUuId}")
    public FacultyDTO delete(@PathVariable String facultyUuId) {

        return new FacultyDTO(facultyUuId, "FCYT", "Facultad de Ciencias y Tegnologia");

    }

    @RequestMapping(method = RequestMethod.GET, path = "/faculty/{facultyUuId}/departaments")
    public List<DepartametDTO> getDepartaments(@PathVariable String facultyUuId) {

        return Collections
                .singletonList(new DepartametDTO(UUID.randomUUID().toString(), "InfSis", "Informatica y Sistemas"));

    }

}
