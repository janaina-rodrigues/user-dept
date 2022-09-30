package com.api.userdept.userdept.controllers;

import com.api.userdept.userdept.dtos.UserDTO;
import com.api.userdept.userdept.services.models.UserModel;
import com.api.userdept.userdept.services.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*", maxAge =3600)
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDTO userDTO){

        var userModel = new UserModel();
        BeanUtils.copyProperties(userDTO, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));

    }

    @GetMapping
    public ResponseEntity<List<UserModel>> getAllUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneUser(@PathVariable(value = "id") Long id){
        Optional<UserModel> parkingSpotModelOptional = userService.findById(id);
        if (!parkingSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotModelOptional.get());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") Long id){
        Optional<UserModel> parkingSpotModelOptional = userService.findById(id);
        if (!parkingSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        userService.delete(parkingSpotModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("User deleted successfully.");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateUser(@PathVariable(value = "id") Long id,
                                                    @RequestBody @Valid UserDTO userDTO){
        Optional<UserModel> parkingSpotModelOptional = userService.findById(id);
        if (!parkingSpotModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.");
        }
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDTO, userModel);
        userModel.setId(parkingSpotModelOptional.get().getId());
        return ResponseEntity.status(HttpStatus.OK).body(userService.save(userModel));
    }

}
