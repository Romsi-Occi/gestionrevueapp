package yncrea.cir3.groupe2.gestionrevueapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Projet {

    @Id @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project")
    @SequenceGenerator(name="project", sequenceName = "seq_project")
    private Long id;

    @Column(length = 100)
    private String title;

    @Column(length = 255)
    private String description;

    @OneToMany
    private List<Review> reviews;


}
