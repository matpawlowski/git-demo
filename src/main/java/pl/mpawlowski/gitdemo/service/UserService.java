package pl.mpawlowski.gitdemo.service;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import pl.mpawlowski.gitdemo.model.User;

@Service
public class UserService {

    @Value("${git.url}")
    private String url;

    public User getUser(String login){
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<User> response
                = restTemplate.getForEntity(url + login, User.class);
        System.out.println(url);
        System.out.println(response);
        System.out.println(response.getStatusCode());
        System.out.println(response.getBody());
        return response.getBody();

    }


}
