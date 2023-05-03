package ma.pfe.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.tags.Tag;
import ma.pfe.dtos.RoleUser;
import ma.pfe.entities.AppRole;
import ma.pfe.entities.AppUser;
import ma.pfe.services.AccountService;

import ma.pfe.utils.JWTUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Tag(name = "User", description = "The User API. Contains all the operations that can be performed on a user.")
public class AccountController {

    private AccountService accountService;
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/users")
    public List<AppUser> listAllUsers() {
        return accountService.listAllUsers();
    }

    @PostMapping("/users")
    public AppUser addNewUser(@RequestBody AppUser user) {
        return accountService.addNewUser(user);
    }

    @PostMapping("/roles")
    public AppRole addNewUser(@RequestBody AppRole role) {
        return accountService.addNewRole(role);
    }

    @PostMapping("/role-to-user")
    public void addRoleToUser(@RequestBody RoleUser roleUser) {
        accountService.addRoleToUser(roleUser.getUsername(), roleUser.getRole());
    }

    @GetMapping("/refresh-token")
    public void generateNewAccessToken(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String authToken = req.getHeader("Authorization");
        System.out.println(authToken);
        if(authToken != null && authToken.startsWith(JWTUtils.AUTH_PREFIX)) {
            try {
                String token = authToken.substring(7);
                Algorithm algorithm = Algorithm.HMAC256(JWTUtils.SECRET);
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(token);
                String username = decodedJWT.getSubject();
                AppUser user = accountService.loadUserByUsername(username);
                String accessToken = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(new Date(System.currentTimeMillis()+ 1*60*1000))
                        .withIssuer(req.getRequestURL().toString())
                        .withClaim("roles", user.getUserRoles().stream().map(r -> r.getNameRole()).collect(Collectors.toList()))
                        .sign(algorithm);
                Map<String, String> twoTokens = new HashMap<>();
                twoTokens.put("access-token", accessToken);
                twoTokens.put("refresh-token", token);
                res.setContentType("application/json");
                new ObjectMapper().writeValue(res.getOutputStream(), twoTokens);
            } catch (Exception e) {
                throw e;
            }

        } else {
            throw new RuntimeException("Token required");
        }
    }
}
