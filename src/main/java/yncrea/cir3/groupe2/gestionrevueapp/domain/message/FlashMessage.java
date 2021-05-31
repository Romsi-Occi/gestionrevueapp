package yncrea.cir3.groupe2.gestionrevueapp.domain.message;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class FlashMessage implements Serializable {
    private String text;
    private FlashMessageLevel level;
}
