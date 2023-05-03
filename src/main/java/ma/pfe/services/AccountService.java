package ma.pfe.services;

import ma.pfe.entities.AppRole;
import ma.pfe.entities.AppUser;

import java.util.List;

public interface AccountService {
    AppUser addNewUser(AppUser appUser);
    AppRole addNewRole(AppRole appRole);
    void addRoleToUser (String username, String role);
    AppUser loadUserByUsername(String username);
    List<AppUser> listAllUsers();

}
