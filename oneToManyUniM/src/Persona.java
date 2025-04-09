
import java.util.ArrayList;
import java.util.List;

public class Persona {
    private Long id;
    private String nombre;
    private List<Domicilio> domicilios = new ArrayList<>();

    public Persona() {}

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Domicilio> getDomicilios() {
        return domicilios;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDomicilios(List<Domicilio> domicilios) {
        this.domicilios = domicilios;
    }

    public void addDomicilio(Domicilio domicilio) {
        this.domicilios.add(domicilio);
    }
}