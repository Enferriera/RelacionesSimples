//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        InMemoryRepository<Domicilio> domicilioRepo = new InMemoryRepository<>();
        InMemoryRepository<Persona> personaRepo = new InMemoryRepository<>();

        // Crear domicilios
        Domicilio d1 = new Domicilio();
        d1.setCalle("Av. Siempre Viva 742");
        d1.setCiudad("Springfield");
        domicilioRepo.save(d1, Domicilio::setId);

        Domicilio d2 = new Domicilio();
        d2.setCalle("Calle Falsa 123");
        d2.setCiudad("Shelbyville");
        domicilioRepo.save(d2, Domicilio::setId);

        // Crear persona
        Persona persona = new Persona();
        persona.setNombre("Homero Simpson");
        persona.addDomicilio(d1);
        persona.addDomicilio(d2);
        personaRepo.save(persona, Persona::setId);

        // Buscar y mostrar
        Persona encontrada = personaRepo.findById(persona.getId()).orElse(null);
        if (encontrada != null) {
            System.out.println("Persona: " + encontrada.getNombre());
            for (Domicilio d : encontrada.getDomicilios()) {
                System.out.println("Domicilio: " + d.getCalle() + ", " + d.getCiudad());
            }
        } else {
            System.out.println("Persona no encontrada.");
        }
    }
}
