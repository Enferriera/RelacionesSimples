import java.util.HashSet;
import java.util.Set;

public class Persona {
    private Long id;
    private String nombre;
    private Set<Inscripcion> inscripciones = new HashSet<>();

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public void agregarInscripcion(Inscripcion inscripcion) {
        inscripciones.add(inscripcion);
        inscripcion.setPersona(this);
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public Set<Inscripcion> getInscripciones() { return inscripciones; }
}
