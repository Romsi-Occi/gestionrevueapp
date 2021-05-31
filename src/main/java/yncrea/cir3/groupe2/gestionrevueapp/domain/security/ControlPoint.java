package yncrea.cir3.groupe2.gestionrevueapp.domain.security;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ControlPoint {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "controlpoint")
    @SequenceGenerator(name="controlpoint", sequenceName = "seq_controlpoint")
    private Long id;

    @Id
    @Column
    private Long review_id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 255)
    private String description;

    @Column(length = 255)
    private String commentary;

    @Column(length = 255)
    private String vector;

    @Column
    private State state;

    @Column
    private Boolean conform;

    @Column
    private int CVSS;
}
