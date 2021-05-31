package yncrea.cir3.groupe2.gestionrevueapp.form;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;


@Getter
@Setter
@Data
public class ProjetForm {
    private Long id;

    private String title;

    private String description;

    private Set<Long> reviews;
}
