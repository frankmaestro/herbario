package edu.course.sisumss.sisumss.dtos;

import java.util.List;

public class GroupDTO {

    // @JsonIgnore
    // private long id;

    private String uuid;
    private String code;
    private String name;
    private List<Schedule> schedule;
    private ProfesorDTO profesor;
    private SubjetDTO subject;

    public GroupDTO() {
    }

    public GroupDTO(String uuid, String code, String name) {
        this.uuid = uuid;
        this.code = code;
        this.name = name;
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

    public void setUiud(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

    public void setSchedule(List<Schedule> schedule) {
        this.schedule = schedule;
    }

    public List<Schedule> getSchedule() {
        return schedule;
    }

    public ProfesorDTO getProfesor() {
        return profesor;
    }

    public void setProfesor(ProfesorDTO profesor) {
        this.profesor = profesor;
    }

    public SubjetDTO getSubject() {
        return subject;
    }

    public void setSubject(SubjetDTO subject) {
        this.subject = subject;
    }

}
