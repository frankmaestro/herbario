package edu.course.sisumss.sisumss.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Component;

import edu.course.sisumss.sisumss.dtos.FacultyDTO;
import edu.course.sisumss.sisumss.dtos.FacultyMapper;
import edu.course.sisumss.sisumss.dtos.UniversityDTO;
import edu.course.sisumss.sisumss.dtos.UniversityMapper;
import edu.course.sisumss.sisumss.exceptions.NotFoundException;
import edu.course.sisumss.sisumss.models.Faculty;
import edu.course.sisumss.sisumss.models.University;
import edu.course.sisumss.sisumss.repositories.FacultyRepository;
import edu.course.sisumss.sisumss.repositories.UniversityRepository;

@Component
public class UniversityServices {

    @Autowired
    private UniversityRepository universityRepository;

    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private FacultyMapper facultyMapper;

    @Autowired
    private UniversityMapper universityMapper;

    public List<UniversityDTO> getAllUniversities() {

        return universityRepository
                .findAll()
                .stream()
                .map(university -> universityMapper.toDTO(university))
                .collect(Collectors.toList());
    }

    public UniversityDTO getUniversities(String universityUuId) {

        University university = universityRepository.findOneBYUuId(universityUuId);

        if (university == null) {
            throw new NotFoundException("University", universityUuId);

        }

        return universityMapper.toDTO(university);
    }

    public UniversityDTO saveUniversity(UniversityDTO universityDTO) {

        University university = universityMapper.getUniversity(universityDTO);

        return universityMapper.toDTO(universityRepository.save(university));

    }

    public List<FacultyDTO> getFaculties(String universityUuid) {

        University example1 = new University();
        example1.setUiud(universityUuid);
        Optional<University> optionalUniversity = universityRepository.findOne(Example.of(example1));

        // University university = universityRepository.findOneBYUuId(universityUuid);

        // if (university == null) {
        if (optionalUniversity.isEmpty()) {
            throw new NotFoundException("Universiy", universityUuid);
        }

        University university = optionalUniversity.get();

        // List<Faculty> faculties =
        // facultyRepository.findAllByUniversityId(university);

        Faculty example = new Faculty();
        University universityExample = new University();
        universityExample.setId(university.getId());
        example.setUniversity(universityExample);

        List<Faculty> faculties = facultyRepository.findAll(Example.of(example));
        return faculties
                .stream()
                .map(faculty -> facultyMapper.toDTO(faculty, false))
                .collect(Collectors.toList());

        // return Collections.emptyList();

    }

    public UniversityRepository getUniversityRepository() {
        return universityRepository;
    }

    public void setUniversityRepository(UniversityRepository universityRepository) {
        this.universityRepository = universityRepository;
    }

    public UniversityMapper getUniversityMapper() {
        return universityMapper;
    }

    public void setUniversityMapper(UniversityMapper universityMapper) {
        this.universityMapper = universityMapper;
    }

    public UniversityDTO updateUniversity(UniversityDTO universityDTO) {

        University example1 = new University(universityDTO.getUuid());
        // example1.setUiud(universityUuId);
        Optional<University> optionalUniversity = universityRepository.findOne(Example.of(example1));

        if (optionalUniversity.isEmpty()) {
            throw new NotFoundException("Universiy", universityDTO.getUuid());
        }

        University university = optionalUniversity.get();

        university.setCode(universityDTO.getCode());
        university.setName(universityDTO.getName());

        universityRepository.save(university);

        return universityMapper.toDTO(university);
    }

    public UniversityDTO deleteUniversity(String universityUuId) {

        University example1 = new University(universityUuId);
        // example1.setUiud(universityUuId);
        Optional<University> optionalUniversity = universityRepository.findOne(Example.of(example1));

        if (optionalUniversity.isEmpty()) {
            throw new NotFoundException("Universiy", universityUuId);
        }

        University university = optionalUniversity.get();

        universityRepository.delete(university);

        return universityMapper.toDTO(university);

    }

}
