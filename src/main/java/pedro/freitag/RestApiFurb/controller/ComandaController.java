
package pedro.freitag.RestApiFurb.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pedro.freitag.RestApiFurb.dto.ComandaDTO;
import pedro.freitag.RestApiFurb.model.Comanda;
import pedro.freitag.RestApiFurb.model.Produto;
import pedro.freitag.RestApiFurb.model.Usuario;
import pedro.freitag.RestApiFurb.service.ComandaService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/comandas")
public class ComandaController {

    @Autowired
    private ComandaService comandaService;

    public ComandaController(ComandaService comandaService) {
        this.comandaService = comandaService;
    }

    @GetMapping
    @Operation(summary = "Buscar todas as comandas", description = "Busca todas as comandas, informando os dados do usuário que estiverem cadastrados para a comanda")
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok(comandaService.findAll().stream().map(Comanda::getUsuario).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar comanda por ID", description = "Busca a comanda com o ID indicado nos parâmetros")
    public ResponseEntity<ComandaDTO> getById(@PathVariable Long id) {
        Comanda comanda = comandaService.findById(id);
        if (comanda == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new ComandaDTO(comanda));
    }

    @PostMapping
    @Operation(summary = "Criar nova comanda", description = "Cria uma nova comanda, utilizando o id do Usuário indicado e gerando uma lista de produtos a partir dos IDs passados por parâmetro")
    public ResponseEntity<Comanda> create(@RequestParam Long usuarioId, @RequestParam List<Long> produtosIds) {
        return ResponseEntity.ok(comandaService.create(usuarioId, produtosIds));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Atualizar itens da comanda", description = "Atualiza os itens da comanda, inserindo os produtos a partir dos IDs passados nos parâmetros")
    public ResponseEntity<Comanda> updateProdutos(@PathVariable Long id, @RequestParam List<Long> produtosIds) {
        return ResponseEntity.ok(comandaService.updateProdutos(id, produtosIds));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar comanda", description = "Deletar comanda utilizando o ID indicado para efetuar a exclusão.")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        comandaService.delete(id);
        return ResponseEntity.ok().body("{\"success\":{\"text\":\"comanda removida\"}}");
    }
}
