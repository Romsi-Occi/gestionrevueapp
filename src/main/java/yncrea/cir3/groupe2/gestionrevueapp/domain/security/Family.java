package yncrea.cir3.groupe2.gestionrevueapp.domain.security;

import lombok.Getter;
import lombok.Setter;
import yncrea.cir3.groupe2.gestionrevueapp.domain.ControlPoint_template;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Family {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "family")
    @SequenceGenerator(name="family", sequenceName = "seq_family")
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @OneToMany
    private List<ControlPoint_template> points;
}
