package yncrea.cir3.groupe2.gestionrevueapp.controller;


import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import yncrea.cir3.groupe2.gestionrevueapp.domain.security.User;
import yncrea.cir3.groupe2.gestionrevueapp.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    @Autowired
    private UserRepository users;

    @GetMapping("/{id}")
    @JsonView(User.UserViews.ExtendedData.class)
    public User get(@PathVariable(required = true) Long id) {
        return users.findById(id).orElseThrow(
                () -> new RuntimeException("Not found")
        );
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UserSearchDto {
        Long id;
        String label;
        String value;
    }

    @GetMapping({"", "/"})
    public List<UserSearchDto> search(@RequestParam("term") String search, @AuthenticationPrincipal User user) {
        // search user matching the ?term= using the repository
        List<User> matches = users.findFirst10ByUsernameContaining(search);

        // create the result list
        List<UserSearchDto> result = new ArrayList<>();

        // map User to UserSearchDto
        for (User u : matches) {
            // skip logged user (we can't play against ourself)
            if (Objects.equals(u.getId(), user.getId())) continue;

            UserSearchDto dto = new UserSearchDto(u.getId(), u.getUsername(), u.getUsername());
            result.add(dto);
        }

        return result;
    }
}

