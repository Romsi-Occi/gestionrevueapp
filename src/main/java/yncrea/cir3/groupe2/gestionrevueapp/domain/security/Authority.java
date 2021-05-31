package yncrea.cir3.groupe2.gestionrevueapp.domain.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Authority implements GrantedAuthority {
    @Id @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authority")
    @SequenceGenerator(name="authority", sequenceName = "seq_authority")
    private Long id;

    private String authority;
}
