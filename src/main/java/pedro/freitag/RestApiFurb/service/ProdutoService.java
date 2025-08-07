package pedro.freitag.RestApiFurb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pedro.freitag.RestApiFurb.model.Comanda;
import pedro.freitag.RestApiFurb.model.Produto;
import pedro.freitag.RestApiFurb.model.Produto;
import pedro.freitag.RestApiFurb.model.Usuario;
import pedro.freitag.RestApiFurb.repository.ProdutoRepository;
import pedro.freitag.RestApiFurb.repository.ProdutoRepository;
import pedro.freitag.RestApiFurb.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Optional<Produto> findById(Long id) {
        return produtoRepository.findById(id);
    }

    public void delete(Long id) {
        produtoRepository.deleteById(id);
    }
}
