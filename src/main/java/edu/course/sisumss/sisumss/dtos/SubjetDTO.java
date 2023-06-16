package edu.course.sisumss.sisumss.dtos;

public class SubjetDTO {

    private String uuid;
    private String code;
    private String name;

    public SubjetDTO() {
       
    }

    public SubjetDTO(String uuid, String name, String code) {
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

}
