package yncrea.cir3.groupe2.gestionrevueapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yncrea.cir3.groupe2.gestionrevueapp.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}
