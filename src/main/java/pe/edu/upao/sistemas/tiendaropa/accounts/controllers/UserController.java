package pe.edu.upao.sistemas.tiendaropa.accounts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.upao.sistemas.tiendaropa.accounts.controllers.serializers.LoginRequest;
import pe.edu.upao.sistemas.tiendaropa.accounts.controllers.serializers.LoginResponse;
import pe.edu.upao.sistemas.tiendaropa.accounts.models.User;
import pe.edu.upao.sistemas.tiendaropa.accounts.services.UserService;
import pe.edu.upao.sistemas.tiendaropa.config.JwtTokenUtil;
import pe.edu.upao.sistemas.tiendaropa.config.exceptions.ValidateException;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    UserService userService;

    @GetMapping("/")
    List<User> listUser() {
        return userService.list();
    }


    @PostMapping("/")
    User createUser(@RequestBody User user) {
        return userService.create(user);
    }



    @PostMapping("/login")
    LoginResponse login(@RequestBody LoginRequest request) throws ValidateException {

        User user = userService.login(request.username, request.password);
        if(user == null) {
            throw new ValidateException("Usuario o contraseña incorrecto");
        }
        LoginResponse response = new LoginResponse();
        response.username = user.username;
        response.token = jwtTokenUtil.generateToken(user.username);
        return response;
    }


}




