package edu.course.sisumss.sisumss.controllers;

import java.time.DayOfWeek;
import java.util.Collections;
//import java.util.List;
import java.util.UUID;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.course.sisumss.sisumss.dtos.GroupDTO;
import edu.course.sisumss.sisumss.dtos.ProfesorDTO;
import edu.course.sisumss.sisumss.dtos.Schedule;
import edu.course.sisumss.sisumss.dtos.SubjetDTO;

@RestController
public class SubjectController {

    @RequestMapping(method = RequestMethod.GET, path = "/subjects/{subjectsUuId}/groups")
    public GroupDTO getAllGroups(@PathVariable String subjectsUuId) {

        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName("Grupo 1");
        groupDTO.setProfesor(new ProfesorDTO(UUID.randomUUID().toString(), "Juan Carlos", "Grcia"));
        groupDTO.setSchedule(Collections.singletonList(new Schedule(DayOfWeek.MONDAY, "6:!5", "8:15")));

        return groupDTO;

        // return Collections.singletonList(groupDTO);

    }

    @RequestMapping(method = RequestMethod.POST, path = "/subjects/{subjectsUuId}/groups")
    public GroupDTO getAllGroups(@PathVariable String subjectsUuId, @RequestBody GroupDTO group) {

        group.setUiud(UUID.randomUUID().toString());

        group.setProfesor(new ProfesorDTO(group.getProfesor().getUuid(), "Juan Carlos", "Grcia"));
        group.setSubject(new SubjetDTO(group.getSubject().getUuid(), "Intro a la programacion", "INTRO101"));

        return group;
        // return Collections.singletonList(group);

    }

    @RequestMapping(method = RequestMethod.GET, path = "/subjects/{subjectsUuId}/groups/{groupUuId}")
    public GroupDTO get(@PathVariable String subjectsUuId, @PathVariable String groupUuId) {

        GroupDTO groupDTO = new GroupDTO();
        groupDTO.setName("Grupo 1");
        groupDTO.setProfesor(new ProfesorDTO(UUID.randomUUID().toString(), "Juan Carlos", "Grcia"));
        groupDTO.setSchedule(Collections.singletonList(new Schedule(DayOfWeek.MONDAY, "6:!5", "8:15")));

        return groupDTO;
        // return Collections.singletonList(group);

    }
}
