package edu.course.sisumss.sisumss.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.course.sisumss.sisumss.dtos.FacultyDTO;
import edu.course.sisumss.sisumss.dtos.FacultyMapper;
import edu.course.sisumss.sisumss.dtos.UniversityDTO;
import edu.course.sisumss.sisumss.exceptions.NotFoundException;
import edu.course.sisumss.sisumss.models.Faculty;
import edu.course.sisumss.sisumss.models.University;
import edu.course.sisumss.sisumss.repositories.FacultyRepository;
import edu.course.sisumss.sisumss.repositories.UniversityRepository;

@Component
public class FacultyServices {

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private FacultyMapper facultyMapper;

    public FacultyDTO getFaculty(String facultyUuId) {

        Faculty faculty = facultyRepository.findOneByUuid(facultyUuId);

        if (faculty == null) {
            throw new NotFoundException("Faculty", facultyUuId);

        }

        return facultyMapper.toDTO(faculty, true);
    }

    public FacultyDTO saveFaculty(FacultyDTO facultyDTO) {

        UniversityDTO universityDTO = facultyDTO.getUniversity();

        if (universityDTO == null) {

            throw new NotFoundException("University primero", null);
        }

        University university = universityRepository.findOneBYUuId(universityDTO.getUuid());

        if (university == null) {
            throw new NotFoundException("University", universityDTO.getUuid());
        }

        Faculty faculty = facultyMapper.getFaculty(facultyDTO, university);
        facultyRepository.save(faculty);

        return facultyMapper.toDTO(faculty, true);
    }

}
