package pl.mpawlowski.gitdemo.service;


import org.springframework.stereotype.Service;
import pl.mpawlowski.gitdemo.model.User;

//@Service
public interface UserService {


    public User getUser(String login);


}
