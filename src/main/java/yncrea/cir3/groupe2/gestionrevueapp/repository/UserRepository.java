package yncrea.cir3.groupe2.gestionrevueapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yncrea.cir3.groupe2.gestionrevueapp.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
