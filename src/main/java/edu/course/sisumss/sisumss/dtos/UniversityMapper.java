package edu.course.sisumss.sisumss.dtos;

import org.springframework.stereotype.Component;

import edu.course.sisumss.sisumss.models.University;

@Component
public class UniversityMapper {

    /* */
    public UniversityDTO toDTO(University university) {

        UniversityDTO universityDTO = new UniversityDTO();
        universityDTO.setUiud(university.getUuid());
        universityDTO.setName(university.getName());
        universityDTO.setCode(university.getCode());

        return universityDTO;

    }

    public University getUniversity(UniversityDTO universityDTO) {

        University university = new University();
        university.setUiud(universityDTO.getUuid());
        university.setName(universityDTO.getName());
        university.setCode(universityDTO.getCode());

        return university;

    }
}

/*
 * public UniversityDTO toDTO(University university){
 * return new UniversityDTO(university.getUuid(), university.getCode(),
 * university.getName());
 * 
 * }
 */

/*
 * public University getUniversity(UniversityDTO universityDTO){
 * return new University(null, universityDTO.getUuid(), universityDTO.getName(),
 * universityDTO.getCode(), null) {
 * 
 * }
 */
