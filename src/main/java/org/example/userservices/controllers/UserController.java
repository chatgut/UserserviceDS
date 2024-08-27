package org.example.userservices.controllers;

import lombok.RequiredArgsConstructor;
import org.example.userservices.DTO.UserDTO;
import org.example.userservices.entities.User;
import org.example.userservices.services.UserServices;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserServices userservice;

    @GetMapping
    public List<UserDTO> findAll(){
        return userservice.findAll();
    }

    @GetMapping("/{id}")
    public UserDTO findById(@PathVariable Integer id){
        return userservice.findById(id);
    }

    @PostMapping
    public void save(@RequestBody UserDTO userDTO){
        userservice.save(userDTO);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Integer id, @RequestBody UserDTO userDTO){
        userservice.update(id, userDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        userservice.delete(id);
    }
}
