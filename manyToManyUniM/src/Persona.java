import java.util.HashSet;
import java.util.Set;

public class Persona {
    private Long id;
    private String nombre;
    private Set<Curso> cursos = new HashSet<>();

    public Persona() {}

    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public Set<Curso> getCursos() { return cursos; }

    public void setCursos(Set<Curso> cursos) { this.cursos = cursos; }

    public void agregarCurso(Curso curso) {
        this.cursos.add(curso);
    }
}