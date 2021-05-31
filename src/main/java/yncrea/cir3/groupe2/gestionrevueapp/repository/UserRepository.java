package yncrea.cir3.groupe2.gestionrevueapp.repository;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yncrea.cir3.groupe2.gestionrevueapp.domain.security.User;

import java.util.List;
import java.util.Set;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    Set<User> findByIdNot(Long id, Sort sort);
    List<User> findFirst10ByUsernameContaining(String username);
}
