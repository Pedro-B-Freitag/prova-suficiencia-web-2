package pedro.freitag.RestApiFurb.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import pedro.freitag.RestApiFurb.model.AuthUsuario;

public interface AuthUsuarioRepository extends JpaRepository<AuthUsuario, Long> {
    Optional<AuthUsuario> findByUsername(String username);
}
