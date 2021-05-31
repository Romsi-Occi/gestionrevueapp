package yncrea.cir3.groupe2.gestionrevueapp.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Review {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review")
    @SequenceGenerator(name="review", sequenceName = "seq_review")
    private Long id;


    @Column
    private Long id_project;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(length = 255)
    private String description;

    @Column
    private int highest_CVSS;

    @Column
    private int noncompliances;

    //@ManyToMany
    //private ArrayList<Family> family;

    @ManyToMany
    private List<Review_template> template;
}
