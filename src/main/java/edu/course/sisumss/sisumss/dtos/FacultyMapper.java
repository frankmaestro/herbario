package edu.course.sisumss.sisumss.dtos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.course.sisumss.sisumss.models.Faculty;
import edu.course.sisumss.sisumss.models.University;

@Component
public class FacultyMapper {

    @Autowired
    private UniversityMapper universityMapper;

    public FacultyDTO toDTO(Faculty faculty, boolean mapUniversity) {

        FacultyDTO facultyDTO = new FacultyDTO();
        facultyDTO.setUuid(faculty.getUuid());
        facultyDTO.setName(faculty.getName());
        facultyDTO.setCode(faculty.getCode());
        if (mapUniversity) {
            facultyDTO.setUniversity(universityMapper.toDTO(faculty.getUniversity()));
        }

        return facultyDTO;

    }

    public Faculty getFaculty(FacultyDTO facultyDTO, University university) {

        Faculty faculty = new Faculty();
        faculty.setUiud(facultyDTO.getUuid());
        faculty.setName(facultyDTO.getName());
        faculty.setCode(facultyDTO.getCode());
        faculty.setUniversity(university);

        return faculty;

    }

}
