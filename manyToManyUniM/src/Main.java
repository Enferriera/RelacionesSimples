//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        InMemoryRepository<Curso> cursoRepo = new InMemoryRepository<>();
        InMemoryRepository<Persona> personaRepo = new InMemoryRepository<>();

        // Lambda para asignar ID
        InMemoryRepository.IdSetter<Curso> cursoIdSetter = (curso, id) -> curso.setId(id);
        InMemoryRepository.IdSetter<Persona> personaIdSetter = (persona, id) -> persona.setId(id);

        Curso curso1 = new Curso("Java Básico");
        Curso curso2 = new Curso("Base de Datos");

        cursoRepo.save(curso1, cursoIdSetter);
        cursoRepo.save(curso2, cursoIdSetter);

        Persona persona1 = new Persona("Lucía");
        persona1.agregarCurso(curso1);
        persona1.agregarCurso(curso2);

        personaRepo.save(persona1, personaIdSetter);

        System.out.println("¡Persona y cursos persistidos en memoria!");

        // Mostrar
        personaRepo.findAll().forEach(p -> {
            System.out.println("Persona: " + p.getNombre() + ", ID: " + p.getId());
            p.getCursos().forEach(c ->
                    System.out.println("  Curso: " + c.getNombre() + ", ID: " + c.getId())
            );
        });
    }
}