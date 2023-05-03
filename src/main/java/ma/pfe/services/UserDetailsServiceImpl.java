package ma.pfe.services;

import ma.pfe.entities.AppUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private AccountService accountService;

    public UserDetailsServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser user = accountService.loadUserByUsername(username);
        System.out.println("user.getUserRoles() = " + user.getUserRoles());
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        user.getUserRoles().stream().forEach(r -> authorities.add(new SimpleGrantedAuthority(r.getNameRole())));
        return new User(user.getUsername(), user.getPassword(), authorities);
    }
}
