package edu.course.sisumss.sisumss.controllers;

import java.time.DayOfWeek;
import java.util.Collections;
import java.util.List;
import java.util.UUID;



import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.course.sisumss.sisumss.dtos.GroupDTO;
import edu.course.sisumss.sisumss.dtos.Schedule;
import edu.course.sisumss.sisumss.dtos.SubjetDTO;



@RestController
public class ProfesorController {

    @RequestMapping(method = RequestMethod.GET, path = "/profesor/{profesorUuId}/groups")
    public List<GroupDTO> getAllGroups(@PathVariable String profesorUuId ){
        
        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName("Grupo 1");
        groupDTO.setSubject(new SubjetDTO(UUID.randomUUID().toString(), "Intro a la programacion", "INTRO101"));
        groupDTO.setSchedule(Collections.singletonList(new Schedule(DayOfWeek.MONDAY, "6:!5", "8:15")));


        return Collections.singletonList(groupDTO);
    
}
}
