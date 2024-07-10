package cl.praxis.models;

public class Usuario {
    private int id;
    private String nombre;
    private String correo;
    private String password;
    private String nick;
    private int peso;

    
    public Usuario(String nombre, String correo, String password, String nick, int peso) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
        this.nick = nick;
        this.peso = peso;
    }

   
    public Usuario(String nombre, String correo, String password) {
        this.nombre = nombre;
        this.correo = correo;
        this.password = password;
    }

  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}
