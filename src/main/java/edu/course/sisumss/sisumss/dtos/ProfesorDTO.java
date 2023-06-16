package edu.course.sisumss.sisumss.dtos;

public class ProfesorDTO {

    // @JsonIgnore
    // private long id;

    private String uuid;
    private String code;
    private String lastname;

    public ProfesorDTO() {
    }

    public ProfesorDTO(String uuid, String code, String lastname) {
        this.uuid = uuid;
        this.code = code;
        this.lastname = lastname;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return lastname;
    }

    public void setName(String lastname) {
        this.lastname = lastname;
    }

    public void setUiud(String uuid) {
        this.uuid = uuid;
    }

    public String getUuid() {
        return uuid;
    }

}
