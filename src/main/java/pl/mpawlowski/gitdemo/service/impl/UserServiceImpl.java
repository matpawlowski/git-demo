package pl.mpawlowski.gitdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import pl.mpawlowski.gitdemo.model.User;
import pl.mpawlowski.gitdemo.service.UserService;

import java.util.Map;


@Service
public class UserServiceImpl implements UserService {

    @Value("${git.url}")
    private String url;

    private RestTemplate restTemplate;

    @Autowired
    public UserServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public User getUser(String login) {

        ResponseEntity<Map> response = restTemplate.getForEntity(url + login, Map.class);
        return new User(response.getBody());

    }


}
