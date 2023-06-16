package edu.course.sisumss.sisumss.repositories;
/* 
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
*/

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import edu.course.sisumss.sisumss.models.University;

//@Component

//@Repository
//@Transactional
public interface UniversityRepository extends JpaRepository<University, Integer> {

    @Query("SELECT u FROM University u WHERE u.uuid = ?1")
    University findOneBYUuId(String uuid);

    // @Query("SELECT u FROM faculty u WHERE u.university = ?1")
    // University getByUniversityI(String uuid);

    /*
     * public UniversityRepository {
     * 
     * private static int idCounter;
     * 
     * @PersistenceContext
     * private EntityManager entityManager;
     * 
     * private static List<University> universityList = new ArrayList<>();
     * 
     * static {
     * 
     * idCounter = 4;
     * universityList.add( new University(1, UUID.randomUUID().toString(),
     * "Universidad mayor de san jan", "UMSS", new Date()));
     * universityList.add( new University(2, UUID.randomUUID().toString(),
     * "Universidad privada del valle", "Univalle", new Date()));
     * universityList.add( new University(3, UUID.randomUUID().toString(),
     * "Universidad Catolica de Bolivia", "USB", new Date()));
     * 
     * 
     * }
     * 
     * public List<University> findAll(){
     * return universityList;
     * }
     * 
     * public University save(University newUniversity){
     * entityManager.persist(newUniversity);
     * 
     * return newUniversity;
     * }
     * /*
     * public University save(University newUniversity){
     * newUniversity.setId(idCounter);
     * newUniversity.setUiud(UUID.randomUUID().toString());
     * universityList.add(newUniversity);
     * idCounter++;
     * 
     * return newUniversity;
     * }
     */

    /*
     * public University findOneBYUuId(String uuId){
     * 
     * return universityList
     * .stream()
     * .filter(University -> University.getUuid().equals(uuId))
     * .findAny()
     * .orElse(null);
     * }
     * 
     * 
     * public static int getIdCounter() {
     * return idCounter;
     * }
     * 
     * public static void setIdCounter(int idCounter) {
     * UniversityRepository.idCounter = idCounter;
     * }
     * 
     */

}
