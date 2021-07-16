package pl.mpawlowski.gitdemo.sql.model;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class UserRecord {
@Id
private String login;
    private int requestCount;


    public UserRecord(String login) {
        this.login = login;
        this.requestCount=1;
    }


    public UserRecord() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getRequestCount() {
        return requestCount;
    }


    public void incrementRequestCount(){
        this.requestCount++;
    }
}
