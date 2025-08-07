package pedro.freitag.RestApiFurb.dto;

import pedro.freitag.RestApiFurb.model.Comanda;
import pedro.freitag.RestApiFurb.model.Produto;

import java.util.List;

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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getTelefoneUsuario() {
        return telefoneUsuario;
    }

    public void setTelefoneUsuario(String telefoneUsuario) {
        this.telefoneUsuario = telefoneUsuario;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
