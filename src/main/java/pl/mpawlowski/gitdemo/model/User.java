package pl.mpawlowski.gitdemo.model;


import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

import java.util.Map;

@Data
@Accessors
@FieldNameConstants
public class User {
    private String id, login, name, type, avatarUrl,createdAt, calculations;

    public User() {
        System.out.println("empty constructor");

    }

    public User(Map map) {
        int followers = (Integer)map.get("followers");
        int publicRepos = (Integer)map.get("public_repos");
        if(followers==0) {
            this.calculations = String.valueOf(Double.NaN);
        }else{
            this.calculations =String.valueOf( 6d/followers*(2+publicRepos));
        }
        System.out.println(this.calculations);
        this.id = String.valueOf(map.get("id"));
        this.login = (String) map.get("login");
        this.name = (String) map.get("name");
        this.type = (String) map.get("type");
        this.avatarUrl =(String) map.get("avatar_url");
        this.createdAt = (String) map.get("created_at");

        System.out.println("full constructor");
    }
}
