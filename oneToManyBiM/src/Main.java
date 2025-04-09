public class Main {
    public static void main(String[] args) {
        InMemoryRepository<Persona> personaRepo = new InMemoryRepository<>();
        InMemoryRepository<Domicilio> domicilioRepo = new InMemoryRepository<>();

        Persona persona = new Persona();
        persona.setNombre("Marge Simpson");

        Domicilio d1 = new Domicilio();
        d1.setCalle("Evergreen Terrace 742");
        d1.setCiudad("Springfield");

        Domicilio d2 = new Domicilio();
        d2.setCalle("Workplace Ave 100");
        d2.setCiudad("Springfield");

        persona.addDomicilio(d1);
        persona.addDomicilio(d2);

        // Guardamos persona
        Long personaId = personaRepo.save(persona, Persona::setId);

        // Guardamos domicilios manualmente y asignamos IDs
        domicilioRepo.save(d1, Domicilio::setId);
        domicilioRepo.save(d2, Domicilio::setId);

        // Buscar persona
        Persona encontrada = personaRepo.findById(personaId).orElse(null);

        if (encontrada != null) {
            System.out.println("Persona: " + encontrada.getNombre());
            for (Domicilio d : encontrada.getDomicilios()) {
                System.out.println("Domicilio: " + d.getCalle() + ", " + d.getCiudad());
                System.out.println("Navego a persona demostrando la bidireccionalidad: " + d.getPersona().getNombre());
            }
        }
        System.out.println("-----Demuestro la Bidireccionalidad ----------------");

        Domicilio encontradDom = domicilioRepo.findById(2L).orElse(null);
        System.out.println("Persona: " + encontradDom.getPersona().getNombre());
        System.out.println("Domicilio: " + encontradDom.getCalle() + ", " + encontradDom.getCiudad());
    }
}
