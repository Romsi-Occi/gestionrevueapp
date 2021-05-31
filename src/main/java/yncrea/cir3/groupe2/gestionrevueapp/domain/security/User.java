package yncrea.cir3.groupe2.gestionrevueapp.domain.security;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;

@Getter
@Setter
@Entity
@Table(name = "\"user\"")
public class User implements UserDetails {
    public interface UserViews {
        interface BasicData {}
        interface ExtendedData extends BasicData {}
    }

    @Id @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user")
    @SequenceGenerator(name="user", sequenceName = "seq_user")
    @JsonView(UserViews.BasicData.class)
    private Long id;

    @Column(length = 100, unique = true)
    @JsonView(UserViews.BasicData.class)
    private String username;

    @Column(length = 100)
    private String password;

    @Column(length = 100, unique = true)
    @JsonView(UserViews.BasicData.class)
    private String email;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Authority> authorities;

    @Override
    @JsonView(UserViews.ExtendedData.class)
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    @JsonView(UserViews.ExtendedData.class)
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    @JsonView(UserViews.ExtendedData.class)
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    @JsonView(UserViews.ExtendedData.class)
    public boolean isEnabled() {
        return true;
    }
}
