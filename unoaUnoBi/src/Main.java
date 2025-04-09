public class Main {
    public static void main(String[] args) {
        InMemoryRepository<Domicilio> domicilioRepo = new InMemoryRepository<>();
        InMemoryRepository<Persona> personaRepo = new InMemoryRepository<>();

        // Crear domicilio
        Domicilio domicilio = new Domicilio();
        domicilio.setCalle("Wallaby Way 42");
        domicilio.setCiudad("Sydney");
        domicilioRepo.save(domicilio, Domicilio::setId);

        // Crear persona y asociar domicilio
        Persona persona = new Persona();
        persona.setNombre("Dory");
        persona.setDomicilio(domicilio); // Relación bidireccional
        personaRepo.save(persona, Persona::setId);

        // Buscar y mostrar
        Persona encontrada = personaRepo.findById(persona.getId()).orElse(null);
        if (encontrada != null) {
            System.out.println("Persona: " + encontrada.getNombre());
            System.out.println("Domicilio: " + encontrada.getDomicilio().getCalle());
        } else {
            System.out.println("Persona no encontrada.");
        }

        System.out.println(" -------------- MUESTRO LA BIDIRECCIONALIDAD");

        Domicilio encontradoDom = domicilioRepo.findById(domicilio.getId()).orElse(null);
        if (encontradoDom != null) {
            System.out.println("Persona: " +encontradoDom.getPersona().getNombre() );
            System.out.println("Domicilio: " + encontradoDom.getCalle());
        } else {
            System.out.println("Persona no encontrada.");
        }


    }
}