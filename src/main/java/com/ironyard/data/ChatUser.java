package com.ironyard.data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by osmanidris on 2/10/17.
 */
@Entity
public class ChatUser {
    @Id @GeneratedValue
    private Long ID;
    private String username;
    private String password;
    private String displayName;
    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Currently> history;

    public ChatUser(){}

    public ChatUser(String username, String password, String displayName){
        this.username = username;
        this.password = password;
        this.displayName = displayName;
    }

    public List<Currently> getHistory() {
        return history;
    }

    public void setHistory(List<Currently> history) {
        this.history = history;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}
