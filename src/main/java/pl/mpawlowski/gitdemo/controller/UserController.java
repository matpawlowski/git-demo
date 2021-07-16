package pl.mpawlowski.gitdemo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;
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


    @GetMapping(value = "/{login}")
    public ResponseEntity<User> getByLogin(@PathVariable("login") String login) {
        try {
            userRecordService.InsertLoginOrIncrementCounter(login);
            userService.getUser(login);
            return ResponseEntity.ok(userService.getUser(login));
        } catch (HttpClientErrorException e) {
            if (e.getRawStatusCode() == 404) {
                throw new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "User not found", e);
            }
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR, "Internal server error", e);
        }
    }
}
