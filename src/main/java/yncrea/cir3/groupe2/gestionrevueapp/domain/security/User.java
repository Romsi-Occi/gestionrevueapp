package yncrea.cir3.groupe2.gestionrevueapp.domain.security;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
public class User {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user")
    @SequenceGenerator(name="user", sequenceName = "seq_user")
    private Long id;

    @Column(length = 100, nullable = false)
    private String name;

    @Column(length = 100, nullable = false)
    private String firstName;

    @Column(length = 100, nullable = false)
    private String mail;

    @Column
    private Rank rank;

    @Column(length = 100)
    private String pwd;

    @Column
    private Date inscription;

    @Column
    private Boolean deleted;

    @Column
    private Boolean banned;
}
