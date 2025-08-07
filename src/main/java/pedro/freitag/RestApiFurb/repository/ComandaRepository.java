
package pedro.freitag.RestApiFurb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pedro.freitag.RestApiFurb.model.Comanda;

public interface ComandaRepository extends JpaRepository<Comanda, Long> {}
