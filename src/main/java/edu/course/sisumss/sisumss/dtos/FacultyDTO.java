package edu.course.sisumss.sisumss.dtos;

public class FacultyDTO {

   // @JsonIgnore
   // private String id;

    private String uuid;
    private String code;
    private String name;

    private UniversityDTO university;

    public FacultyDTO() {

    }

    public FacultyDTO(String uuid, String code, String name) {
        this.uuid = uuid;
        this.code = code;
        this.name = name;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }
 
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public UniversityDTO getUniversity() {
        return university;
    }

    public void setUniversity(UniversityDTO university) {
        this.university = university;
    }

}
