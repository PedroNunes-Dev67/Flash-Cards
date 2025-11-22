package FlashBrain_Backend.dto;

import FlashBrain_Backend.model.Usuario;

public class UsuarioResponseDto {

    private Long id;
    private String nome;
    private String email;

    public UsuarioResponseDto(Usuario usuario) {

        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.email = usuario.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
