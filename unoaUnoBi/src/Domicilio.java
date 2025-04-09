
public class Domicilio {
    private Long id;
    private String calle;
    private String ciudad;
    private Persona persona;

    public Domicilio() {}

    public Long getId() {
        return id;
    }

    public String getCalle() {
        return calle;
    }

    public String getCiudad() {
        return ciudad;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}