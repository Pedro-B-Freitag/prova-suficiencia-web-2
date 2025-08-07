package pedro.freitag.RestApiFurb.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pedro.freitag.RestApiFurb.dto.AuthUsuarioDTO;
import pedro.freitag.RestApiFurb.model.AuthUsuario;
import pedro.freitag.RestApiFurb.repository.AuthUsuarioRepository;

@RestController
@RequestMapping("/auth-usuarios")
public class AuthUsuarioController {

    private final AuthUsuarioRepository authUsuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthUsuarioController(AuthUsuarioRepository authUsuarioRepository, PasswordEncoder passwordEncoder) {
        this.authUsuarioRepository = authUsuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }
    @PostMapping("/admin")
    public ResponseEntity<String> criarAdmin(@RequestBody AuthUsuarioDTO dto) {
        if (authUsuarioRepository.findByUsername(dto.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Usuário já existe.");
        }

        AuthUsuario admin = new AuthUsuario();
        admin.setUsername(dto.getUsername());
        admin.setPassword(passwordEncoder.encode(dto.getPassword()));
        admin.setRole("ADMIN");

        authUsuarioRepository.save(admin);
        return ResponseEntity.ok("Criado!");
    }
}