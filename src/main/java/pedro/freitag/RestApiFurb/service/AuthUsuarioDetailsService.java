package pedro.freitag.RestApiFurb.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import pedro.freitag.RestApiFurb.config.AuthUsuarioDetails;
import pedro.freitag.RestApiFurb.repository.AuthUsuarioRepository;

@Service
public class AuthUsuarioDetailsService implements UserDetailsService {

    private final AuthUsuarioRepository repository;

    public AuthUsuarioDetailsService(AuthUsuarioRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return repository.findByUsername(username)
                .map(AuthUsuarioDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));
    }
}