package edu.course.sisumss.sisumss.dtos;
//import java.util.UUID;



//@JsonFilter()
public class UniversityDTO {
       // private long id;
        private String uuid;
        private String code;
        private String name;

        public UniversityDTO() {
        }

        public UniversityDTO(String uuid, String code, String name) {
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



