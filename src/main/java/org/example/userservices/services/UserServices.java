package org.example.userservices.services;

import lombok.RequiredArgsConstructor;
import org.example.userservices.DTO.UserDTO;
import org.example.userservices.entities.User;
import org.example.userservices.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class UserServices {

private final UserRepository userRepository;

public UserDTO findById (Integer id){
    return UserDTO.toDTO(userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found")));
}

public List<UserDTO> findAll (){
    return userRepository.findAll().stream().map(UserDTO::toDTO).toList();
}

public void save (UserDTO userDTO){
    User entity = UserDTO.toEntity(userDTO);
    userRepository.save(entity);
}

public void update (Integer id, UserDTO userDTO){
    User entity = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    entity.setUsername(userDTO.getUsername());
    entity.setEmail(userDTO.getEmail());
    entity.setPassword(userDTO.getPassword());
    userRepository.save(entity);
}

public void delete (Integer id){
    User entity = userRepository.findById(id).orElseThrow(()-> new RuntimeException("User not found"));
    userRepository.deleteById(entity.getId());
}

}
