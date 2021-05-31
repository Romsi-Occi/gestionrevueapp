package yncrea.cir3.groupe2.gestionrevueapp.form;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import yncrea.cir3.groupe2.gestionrevueapp.domain.Projet;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Getter
@Setter
@Data
public class ReviewForm {

    private Long id;

    @Size(min = 2, max = 100)
    private String title;

    private String description;

    private int highest_CVSS;

    private int noncompliances;

    private Projet parent_review;

    private Set<Long> points;
}
