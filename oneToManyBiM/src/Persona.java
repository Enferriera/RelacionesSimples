import java.util.ArrayList;
import java.util.List;

public class Persona {
    private Long id;
    private String nombre;
    private List<Domicilio> domicilios = new ArrayList<>();

    public void addDomicilio(Domicilio domicilio) {
        domicilios.add(domicilio);
        domicilio.setPersona(this);
    }

    public void removeDomicilio(Domicilio domicilio) {
        domicilios.remove(domicilio);
        domicilio.setPersona(null);
    }

    // Getters y setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Domicilio> getDomicilios() {
        return domicilios;
    }

    public void setDomicilios(List<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }
}
