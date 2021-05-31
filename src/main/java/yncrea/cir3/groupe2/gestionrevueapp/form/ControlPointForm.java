package yncrea.cir3.groupe2.gestionrevueapp.form;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import yncrea.cir3.groupe2.gestionrevueapp.domain.ControlPoint;
import yncrea.cir3.groupe2.gestionrevueapp.domain.Review;

@Getter
@Setter
@Data
public class ControlPointForm {

    private long id;

    private String commentary;

    private String vector;

    private ControlPoint.State state;

    private Boolean conform;

    private int CVSS;

    private Review parent;

}
