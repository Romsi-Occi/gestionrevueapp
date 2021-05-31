package yncrea.cir3.groupe2.gestionrevueapp.form;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Data
public class ReviewForm {

    private Long id;

    private Long id_project;

    @NotBlank
    @Size(min = 2, max = 100)
    private String title;

    private String description;

    @NotBlank
    private int highest_CVSS;

    @NotBlank
    private int noncompliances;
}
