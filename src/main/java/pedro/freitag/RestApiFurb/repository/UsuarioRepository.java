
package pedro.freitag.RestApiFurb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pedro.freitag.RestApiFurb.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {}
