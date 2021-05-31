package yncrea.cir3.groupe2.gestionrevueapp.domain.security;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Project {

    @Id @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project")
    @SequenceGenerator(name="project", sequenceName = "seq_project")
    private Long id;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 255)
    private String description;


}
