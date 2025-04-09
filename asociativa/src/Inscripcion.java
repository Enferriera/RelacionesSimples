import java.time.LocalDate;

public class Inscripcion {
    private Long id;
    private LocalDate fechaInscripcion;
    private double nota;
    private Persona persona;
    private Curso curso;

    public Inscripcion(LocalDate fechaInscripcion, double nota) {
        this.fechaInscripcion = fechaInscripcion;
        this.nota = nota;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDate getFechaInscripcion() { return fechaInscripcion; }
    public void setFechaInscripcion(LocalDate fechaInscripcion) { this.fechaInscripcion = fechaInscripcion; }

    public double getNota() { return nota; }
    public void setNota(double nota) { this.nota = nota; }

    public Persona getPersona() { return persona; }
    public void setPersona(Persona persona) { this.persona = persona; }

    public Curso getCurso() { return curso; }
    public void setCurso(Curso curso) { this.curso = curso; }
}
