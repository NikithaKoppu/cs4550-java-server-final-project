package repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{


	@Query("SELECT u FROM Student u WHERE"
			+ " u.username=:username")
	Optional<Student> findUserByUsername(
			@Param("username") String username);
}
