package yncrea.cir3.groupe2.gestionrevueapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

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

    @ManyToOne
    private List<ControlPoint_template> points;
}
