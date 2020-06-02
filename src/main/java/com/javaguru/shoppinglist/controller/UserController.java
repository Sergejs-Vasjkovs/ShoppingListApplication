package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.domain.User;
import com.javaguru.shoppinglist.dto.UserDTO;
import com.javaguru.shoppinglist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/id/{id}")
    public @ResponseBody
    ResponseEntity<UserDTO> findUserById(@PathVariable Long id) {
        User user = userService.findUserByID(id);
        return new ResponseEntity<>(userToDTO(user), HttpStatus.OK);
    }

    @GetMapping("/name/{name}")
    public @ResponseBody
    ResponseEntity<UserDTO> findUserByName(@PathVariable String name) {
        User user = userService.findUserByName(name);
        return ResponseEntity.ok(userToDTO(user));
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> findAllUsers() {
        List<User> userList = userService.findAllUsers();
        List<UserDTO> userDTOList = new ArrayList<>();

        userList.forEach(user -> {
            UserDTO dto = new UserDTO();
            dto.setId(user.getId());
            dto.setName(user.getName());
            userDTOList.add(dto);
        });

        return ResponseEntity.ok(userDTOList);
    }

    @PostMapping
    public void createUser(@RequestBody UserDTO request) {
        User user = new User();
        user.setName(request.getName());
        userService.save(user);
    }

    @DeleteMapping("/id")
    public void deleteUserById(@RequestBody UserDTO request) {
        userService.deleteUserById(request.getId());
    }

    @DeleteMapping("/name")
    public void deleteUserByName(@RequestBody UserDTO request) {
        userService.deleteUserByName(request.getName());
    }

    @PutMapping
    public void updateUser(@RequestBody UserDTO request) {
        userService.updateUserById(request.getId(), request.getName());
    }

    public UserDTO userToDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setId(user.getId());
        dto.setName(user.getName());
        return dto;
    }


}
