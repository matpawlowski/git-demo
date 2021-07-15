package pl.mpawlowski.gitdemo.model;


import lombok.Data;
import lombok.experimental.Accessors;
import lombok.experimental.FieldNameConstants;

@Data
@Accessors
@FieldNameConstants
public class User {
    private String id, login, name, type, avatarUrl,createdAt;
    private double calculations;
}
