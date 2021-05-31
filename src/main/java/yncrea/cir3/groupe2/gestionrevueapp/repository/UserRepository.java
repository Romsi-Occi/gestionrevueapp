package yncrea.cir3.groupe2.gestionrevueapp.repository;

import fr.yncrea.cir3.othello.domain.security.User;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    Set<User> findByIdNot(Long id, Sort sort);
    List<User> findFirst10ByUsernameContaining(String username);
}
