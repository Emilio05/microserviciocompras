package ce.pucmm.microserviciocompra.Model;

public class Usuario {

    private int id;

    private String username;

    private String password;

    private String email;

    private String rol_id;

    public Usuario(){

    }

    public Usuario(int id, String username, String password, String email, String rol_id) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.rol_id = rol_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRol_id() {
        return rol_id;
    }

    public void setRol_id(String rol_id) {
        this.rol_id = rol_id;
    }
}
