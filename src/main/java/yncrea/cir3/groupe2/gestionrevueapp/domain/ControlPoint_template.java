package yncrea.cir3.groupe2.gestionrevueapp.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ControlPoint_template {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "controlpoint_template")
    @SequenceGenerator(name="controlpoint_template", sequenceName = "seq_controlpoint_template")
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 255)
    private String description;

    @ManyToOne
    private Review_template parent_template;

    @ManyToOne
    private Family parent_family;
}
