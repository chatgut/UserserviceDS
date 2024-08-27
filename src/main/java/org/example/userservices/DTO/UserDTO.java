package org.example.userservices.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.userservices.entities.User;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class UserDTO {

    private int id;
    private String password;
    private String email;
    private String username;

    public static UserDTO toDTO(User user) {
        return new UserDTO(user.getId(), user.getPassword(), user.getEmail(), user.getUsername());
    }

    public static User toEntity(UserDTO dto) {
        return new User(dto.getId(), dto.getPassword(), dto.getEmail(), dto.getUsername());
    }
}
