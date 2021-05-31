package yncrea.cir3.groupe2.gestionrevueapp.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import yncrea.cir3.groupe2.gestionrevueapp.repository.UserRepository;

@Service
public class DbUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository users;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserDetails user = users.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException(email);
        }

        return user;
    }
}

