package edu.course.sisumss.sisumss.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import edu.course.sisumss.sisumss.dtos.FacultyDTO;
import edu.course.sisumss.sisumss.dtos.UniversityDTO;
import edu.course.sisumss.sisumss.services.UniversityServices;

@RestController
@RequestMapping("/universities")
public class UniversityController {

  @Autowired
  private UniversityServices universityServices;

  // @RequestMapping(method = RequestMethod.GET, path = "/universities")
  @GetMapping
  public List<UniversityDTO> getAll() {
    // return Collections.singletonList( new
    // UniversityDTO(UUID.randomUUID().toString(), "UMSS", "Universidad mayor de san
    // jose"));
    return universityServices.getAllUniversities();
  }

  @GetMapping(path = "/{universityUuId}")
  public UniversityDTO get(@PathVariable String universityUuId) {

    return universityServices.getUniversities(universityUuId);

  }

  /*
   * @RequestMapping(method = RequestMethod.GET, path = "/universities")
   * public List<UniversityDTO> getAll(){
   * // return Collections.singletonList( new
   * UniversityDTO(UUID.randomUUID().toString(), "UMSS",
   * "Universidad mayor de san jose"));
   * return universityServices.getAllUniversities();
   * 
   * }
   * 
   * /*
   * 
   * @RequestMapping(method = RequestMethod.GET, path =
   * "/universities/{universityUuId}")
   * public UniversityDTO get(@PathVariable String universityUuId){
   * 
   * return universityServices.getUniversities(universityUuId);
   * 
   * }
   */
  @PostMapping()
  public ResponseEntity<UniversityDTO> create(@RequestBody UniversityDTO universityDTO) {
    // universityDTO.setUiud(UUID.randomUUID().toString()); return universityDTO;

    // return universityServices.saveUniversity(universityDTO);
    UniversityDTO universityDTO2 = universityServices.saveUniversity(universityDTO);

    // return new ResponseEntity<UniversityDTO>(dto, HttpStatus.CREATED);
    // URI uri = new URI("/universities/"+universityDTO2.getUuid());

    URI uri = ServletUriComponentsBuilder
        .fromCurrentRequest()
        .path("/{universityUuId}")
        .buildAndExpand(universityDTO2.getUuid())
        .toUri();

    // return ResponseEntity
    // .created(uri)
    // .body(universityDTO);

    return ResponseEntity
        .status(HttpStatus.CREATED)
        .header(HttpHeaders.LOCATION, uri.toString())
        .body(universityDTO2);

  }
  /*
   * @RequestMapping(method = RequestMethod.POST, path = "/universities")
   * public ResponseEntity<UniversityDTO> create(@RequestBody UniversityDTO
   * universityDTO) throws URISyntaxException{
   * //universityDTO.setUiud(UUID.randomUUID().toString()); return universityDTO;
   * 
   * //return universityServices.saveUniversity(universityDTO);
   * UniversityDTO universityDTO2 =
   * universityServices.saveUniversity(universityDTO);
   * 
   * //return new ResponseEntity<UniversityDTO>(dto, HttpStatus.CREATED);
   * // URI uri = new URI("/universities/"+universityDTO2.getUuid());
   * 
   * URI uri = ServletUriComponentsBuilder
   * .fromCurrentRequest()
   * .path("/{universityUuId}")
   * .buildAndExpand(universityDTO2.getUuid())
   * .toUri();
   * 
   * //return ResponseEntity
   * // .created(uri)
   * // .body(universityDTO);
   * 
   * return ResponseEntity
   * .status(HttpStatus.CREATED)
   * .header(HttpHeaders.LOCATION, uri.toString())
   * .body(universityDTO2);
   * 
   * }
   */

  // @GetMapping("/universidad")
  // @RequestMapping(method = RequestMethod.GET, path = "/unive")
  //@PutMapping("/{universityUuId}")
  @RequestMapping(method = RequestMethod.DELETE, path ="/{universityUuId}")
  //public UniversityDTO delete(@PathVariable String universityUuId, @RequestBody UniversityDTO universityDTO) {
  public UniversityDTO delete(@PathVariable String universityUuId) {

    //return new UniversityDTO(universityUuId, "UMSS", "universidad Mayor de San Simon 2");
    return universityServices.deleteUniversity(universityUuId);

  }

  // @GetMapping("/universidad")
  // @RequestMapping(method = RequestMethod.GET, path = "/unive")
  //@PutMapping("/{universityUuId}")
  @RequestMapping(method = RequestMethod.PUT, path = "/{universityUuId}")
  //public UniversityDTO update(@PathVariable String universityUuId, @RequestBody UniversityDTO universityDTO) {
  public UniversityDTO update(@RequestBody UniversityDTO universityDTO) {

    //return new UniversityDTO(universityUuId, "UMSS", "universidad Mayor de San Simon 2");
    return universityServices.updateUniversity(universityDTO);

  }

  @GetMapping(path = "/{UniversityUuId}/falcuties")
  public List<FacultyDTO> getFaculties(@PathVariable String UniversityUuId) {

    return this.universityServices.getFaculties(UniversityUuId);

    // return Collections.singletonList(new FacultyDTO(UUID.randomUUID().toString(),
    // "FCTY", "Facultad de ciensias y Tegologia"));

  }

  public UniversityServices getUniversityServices() {
    return universityServices;
  }

  public void setUniversityServices(UniversityServices universityServices) {
    this.universityServices = universityServices;
  }

}
