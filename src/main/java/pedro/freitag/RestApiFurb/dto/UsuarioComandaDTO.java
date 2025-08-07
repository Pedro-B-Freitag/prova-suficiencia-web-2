package pedro.freitag.RestApiFurb.dto;

import lombok.Getter;
import lombok.Setter;
import pedro.freitag.RestApiFurb.model.Usuario;

@Getter
@Setter
public class UsuarioComandaDTO {
    private long idUsuario;
    private String nomeUsuario;
    private String telefoneUsuario;

    public UsuarioComandaDTO(Usuario usuario) {
        this.idUsuario = usuario.getId();
        this.nomeUsuario = usuario.getNome();
        this.telefoneUsuario = usuario.getTelefone();
    }
}
