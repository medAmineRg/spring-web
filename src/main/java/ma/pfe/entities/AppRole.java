package ma.pfe.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class AppRole {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idRole;
    private String nameRole;

    public AppRole() {
    }

    public AppRole(Long idRole, String nameRole) {
        this.idRole = idRole;
        this.nameRole = nameRole;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }
}
