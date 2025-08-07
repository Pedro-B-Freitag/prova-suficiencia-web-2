
package pedro.freitag.RestApiFurb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pedro.freitag.RestApiFurb.model.Comanda;
import pedro.freitag.RestApiFurb.model.Produto;
import pedro.freitag.RestApiFurb.model.Usuario;
import pedro.freitag.RestApiFurb.repository.ComandaRepository;
import pedro.freitag.RestApiFurb.repository.ProdutoRepository;
import pedro.freitag.RestApiFurb.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ComandaService {

    @Autowired
    private ComandaRepository comandaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Comanda> findAll() {
        return comandaRepository.findAll();
    }

    public Comanda findById(Long id){
        Optional<Comanda> comanda = findOptionalById(id);
        if(comanda.isPresent()) {
            return comanda.get();
        }
        return null;
    }

    public Optional<Comanda> findOptionalById(Long id) {
        return comandaRepository.findById(id);
    }

    public Comanda create(Long usuarioId, List<Long> produtoIds) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        List<Produto> produtos = produtoRepository.findAllById(produtoIds);

        Comanda comanda = new Comanda();
        comanda.setUsuario(usuario);
        comanda.setProdutos(produtos);
        return comandaRepository.save(comanda);
    }

    public Comanda updateProdutos(Long id, List<Long> produtoIds) {
        Comanda comanda = comandaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comanda não encontrada"));
        List<Produto> produtos = produtoRepository.findAllById(produtoIds);
        for(Produto produto : produtos){
            comanda.getProdutos().add(produto);
        }
        return comandaRepository.save(comanda);
    }

    public void delete(Long id) {
        comandaRepository.deleteById(id);
    }
}
