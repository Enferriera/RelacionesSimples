//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Crear repositorios
        InMemoryRepository<Domicilio> domicilioRepo = new InMemoryRepository<>();
        InMemoryRepository<Persona> personaRepo = new InMemoryRepository<>();

        // Crear domicilio
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Av. Siempre Viva 742");
        domicilio.setCiudad("Springfield");
        domicilioRepo.save(domicilio, Domicilio::setId);

        // Crear persona
        Persona persona = new Persona();
        persona.setNombre("Homero Simpson");
        persona.setDomicilio(domicilio);
        personaRepo.save(persona, Persona::setId);

        // Buscar persona
        Persona encontrada = personaRepo.findById(persona.getId()).orElse(null);

        if (encontrada != null) {
            System.out.println("Persona: " + encontrada.getNombre());
            System.out.println("Domicilio: " + encontrada.getDomicilio().getCalle() + ", " +
                    encontrada.getDomicilio().getCiudad());
        } else {
            System.out.println("Persona no encontrada");
        }
    }
}