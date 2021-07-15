package pl.mpawlowski.gitdemo.controller;


import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mpawlowski.gitdemo.model.User;
import pl.mpawlowski.gitdemo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    UserService userService;

    @GetMapping(value="/{login}")
    public ResponseEntity<User> getByLogin(@PathVariable("login")String login){
        userService.getUser(login);
        return ResponseEntity.ok(userService.getUser(login));
    }
}
