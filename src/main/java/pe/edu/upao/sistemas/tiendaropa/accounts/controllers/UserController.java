package pe.edu.upao.sistemas.tiendaropa.accounts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.sistemas.tiendaropa.accounts.controllers.serializers.LoginRequest;
import pe.edu.upao.sistemas.tiendaropa.accounts.controllers.serializers.LoginResponse;
import pe.edu.upao.sistemas.tiendaropa.accounts.models.User;
import pe.edu.upao.sistemas.tiendaropa.accounts.services.UserService;

import java.util.List;

@RestController
@RequestMapping("users")

public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    User getTask(@PathVariable String id){

        throw new IllegalArgumentException("");
    }

    @GetMapping("/")
    List<User> listUser(){
        return userService.list();
    }


    @PostMapping("/")
    User createUser(@RequestBody User user){
        return userService.create(user);
    }


    @PostMapping("/login")
    LoginResponse login(@RequestBody LoginRequest request){
       User user = userService.login(request.username, request.password);
     LoginResponse response = new LoginResponse();
     response.username = user.username;
     return response;
    }


}
