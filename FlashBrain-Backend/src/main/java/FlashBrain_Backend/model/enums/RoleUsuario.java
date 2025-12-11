package FlashBrain_Backend.model.enums;

public enum RoleUsuario {

    USUARIO("usuario"),
    ADMIN("admin");

    private String role;

    RoleUsuario(String role){
        this.role = role;
    }

    public String getRole(){
        return role;
    }
}
