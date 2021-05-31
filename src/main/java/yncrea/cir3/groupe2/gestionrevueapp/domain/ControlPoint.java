package yncrea.cir3.groupe2.gestionrevueapp.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class ControlPoint extends ControlPoint_template {

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

    @ManyToOne
    private Review parent;

    public enum State {unchecked, checked, NA}
}
