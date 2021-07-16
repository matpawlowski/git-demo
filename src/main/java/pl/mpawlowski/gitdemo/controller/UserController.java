package pl.mpawlowski.gitdemo.controller;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mpawlowski.gitdemo.sql.model.UserRecord;
import pl.mpawlowski.gitdemo.model.User;
import pl.mpawlowski.gitdemo.service.UserService;
import pl.mpawlowski.gitdemo.sql.service.UserRecordService;

@RestController
@RequestMapping("/users")
public class UserController {


    @Autowired
    UserService userService;

    @Autowired
    UserRecordService userRecordService;




    @GetMapping(value="/{login}")
    public ResponseEntity<User> getByLogin(@PathVariable("login")String login){
        userService.getUser(login);
        return ResponseEntity.ok(userService.getUser(login));
    }
}
