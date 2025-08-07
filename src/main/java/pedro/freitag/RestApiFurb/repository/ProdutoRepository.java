
package pedro.freitag.RestApiFurb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pedro.freitag.RestApiFurb.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {}
