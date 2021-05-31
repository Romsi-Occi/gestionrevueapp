package yncrea.cir3.groupe2.gestionrevueapp.form;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Data
public class UserForm {
    @Email
    @NotEmpty
    private String email;

    @NotEmpty
    private String username;

    @Length(min = 4)
    private String password;

    @Length(min = 4)
    private String password2;
}
