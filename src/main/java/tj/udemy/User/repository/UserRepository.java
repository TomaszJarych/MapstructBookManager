package tj.udemy.User.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tj.udemy.User.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
