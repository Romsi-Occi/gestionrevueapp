package yncrea.cir3.groupe2.gestionrevueapp.domain;

import lombok.Getter;
import lombok.Setter;
import yncrea.cir3.groupe2.gestionrevueapp.domain.security.Family;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Review_template {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review_template")
    @SequenceGenerator(name="review_template", sequenceName = "seq_review_template")
    private Long id;

    @Column(length = 100, nullable = false)
    private String Title;

    @ManyToMany
    private List<Family> families;

    @OneToMany
    private List<ControlPoint_template> points;
}
