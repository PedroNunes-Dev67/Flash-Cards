package FlashBrain_Backend.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Objects;

public class UsuarioDto {

    private String nome;
    @Email
    private String email;
    @NotBlank
    private String senha;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioDto that = (UsuarioDto) o;
        return Objects.equals(senha, that.senha);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(senha);
    }
}
