package pedro.freitag.RestApiFurb.dto;

import lombok.Getter;
import lombok.Setter;
import pedro.freitag.RestApiFurb.model.Comanda;
import pedro.freitag.RestApiFurb.model.Produto;

import java.util.List;

@Getter
@Setter

public class ComandaDTO {
    private long id;
    private long idUsuario;
    private String nomeUsuario;
    private String telefoneUsuario;
    private List<Produto> produtos;

    public ComandaDTO(Comanda comanda) {
        id = comanda.getId();
        idUsuario = comanda.getUsuario().getId();
        nomeUsuario = comanda.getUsuario().getNome();
        telefoneUsuario = comanda.getUsuario().getTelefone();
        produtos = comanda.getProdutos();
    }
}
