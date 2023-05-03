package ma.pfe.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.Collection;


@Entity
public class AppUser {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER) @JoinTable(name = "user_role")
    private Collection<AppRole> userRoles = new ArrayList<>();

    public AppUser() {
    }

    public AppUser(Long id, String username, String password, Collection<AppRole> userRoles) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.userRoles = userRoles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Collection<AppRole> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Collection<AppRole> userRoles) {
        this.userRoles = userRoles;
    }
}
