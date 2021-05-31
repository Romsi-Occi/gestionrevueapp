package yncrea.cir3.groupe2.gestionrevueapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import yncrea.cir3.groupe2.gestionrevueapp.domain.ControlPoint;


public interface PointRepository extends JpaRepository<ControlPoint, Long> {
}
