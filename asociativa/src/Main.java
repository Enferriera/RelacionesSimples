import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        InMemoryRepository<Persona> personaRepo = new InMemoryRepository<>();
        InMemoryRepository<Curso> cursoRepo = new InMemoryRepository<>();
        InMemoryRepository<Inscripcion> inscripcionRepo = new InMemoryRepository<>();

        // Crear entidades
        Persona lucia = new Persona("Lucía");
        Curso java = new Curso("Java");
        Curso bd = new Curso("Base de Datos");

        // Inscripciones
        Inscripcion insc1 = new Inscripcion(LocalDate.now(), 9.5);
        lucia.agregarInscripcion(insc1);
        java.agregarInscripcion(insc1);
        inscripcionRepo.save(insc1, Inscripcion::setId);

        Inscripcion insc2 = new Inscripcion(LocalDate.now(), 8.0);
        lucia.agregarInscripcion(insc2);
        bd.agregarInscripcion(insc2);
        inscripcionRepo.save(insc2, Inscripcion::setId);

        // Guardar entidades
        personaRepo.save(lucia, Persona::setId);
        cursoRepo.save(java, Curso::setId);
        cursoRepo.save(bd, Curso::setId);

        // Consultar y mostrar inscripciones de Lucía
        personaRepo.findById(lucia.getId()).ifPresent(persona -> {
            System.out.println("Inscripciones de " + persona.getNombre() + ":");
            for (Inscripcion i : persona.getInscripciones()) {
                System.out.println(" - Curso: " + i.getCurso().getNombre() + ", Nota: " + i.getNota());
            }
        });
    }
}
