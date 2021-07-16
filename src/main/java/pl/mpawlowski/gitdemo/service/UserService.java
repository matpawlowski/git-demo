package pl.mpawlowski.gitdemo.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mpawlowski.gitdemo.model.User;

import java.util.Map;

@Service
public class UserService {

    @Value("${git.url}")
    private String url;

    public User getUser(String login){
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Map> response
                = restTemplate.getForEntity(url + login, Map.class);

//        return response.getBody();
        return new User(response.getBody());

    }


}
