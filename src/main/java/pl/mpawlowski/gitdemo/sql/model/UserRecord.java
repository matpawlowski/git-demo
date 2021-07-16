package pl.mpawlowski.gitdemo.dao;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
public class UserRecord {
@Id
private String login;
    private int requestCount;


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(int requestCount) {
        this.requestCount = requestCount;
    }


    public void incrementRequestCount(){
        this.requestCount++;
    }
}
