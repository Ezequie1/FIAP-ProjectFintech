package fintech.project.fiap.auth;

import fintech.project.fiap.dto.LoginRequestDTO;
import fintech.project.fiap.dto.RegisterRequestDTO;
import fintech.project.fiap.dto.TokenResponseDTO;
import fintech.project.fiap.model.User;
import fintech.project.fiap.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthControler {

    @Autowired
    private AuthenticationService service;

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> login(@RequestBody LoginRequestDTO request){
        return service.login(request);
    }

    @PostMapping("/register")
    public ResponseEntity<TokenResponseDTO> register(@RequestBody RegisterRequestDTO request){
        return service.register(request);
    }

    @GetMapping("/getUser")
    public ResponseEntity<User> getUser(@RequestHeader("Authorization") String token){
        return service.getContext(token);
    }
}
