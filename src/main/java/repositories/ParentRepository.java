package repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import model.Parent;

public interface ParentRepository extends CrudRepository<Parent, Integer>{


	@Query("SELECT u FROM Parent u WHERE"
			+ " u.username=:username")
	Optional<Parent> findUserByUsername(
			@Param("username") String username);
}
