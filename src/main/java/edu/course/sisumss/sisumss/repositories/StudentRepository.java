package edu.course.sisumss.sisumss.repositories;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import edu.course.sisumss.sisumss.models.University;
import edu.course.sisumss.sisumss.models.Student;

//@Component
public interface StudentRepository extends JpaRepository<Student, Integer> {

    // List<Faculty> getByUniversity(String uuid);

    // @Query("SELECT f FROM Faculty f WHERE f.uuid = ?1")
    // Faculty findOneByUuid(String uuid);

    // @Query("SELECT f FROM Faculty f WHERE f.university = ?1")
    // List<Faculty> findAllByUniversityId(University university);

    // @Query("SELECT f FROM Faculty f WHERE f.university = ?1")
    // @Query(value ="SELECT * FROM Faculty f WHERE f.university.id = ?1",
    // nativeQuery = true)
    // List<Faculty> getByUniversityId(University university);

}
