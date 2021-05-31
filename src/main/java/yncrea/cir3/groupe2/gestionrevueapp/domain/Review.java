package yncrea.cir3.groupe2.gestionrevueapp.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Review extends Review_template {

    @Column
    private int highest_CVSS;

    @Column
    private int noncompliances;

    @OneToMany
    private List<ControlPoint> points;
}
