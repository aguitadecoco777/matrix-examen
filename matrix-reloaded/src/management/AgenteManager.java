package management;

import entities.Agente;
import utils.ConsoleUtils;

import java.util.ArrayList;

public class AgenteManager {
    private ArrayList<Agente> agentes;

    public AgenteManager() {
        this.agentes = new ArrayList<>();
    }

    public void registrarAgente(Agente agente) {
        agentes.add(agente);
        agente.registrarRecompensa("Medalla");
        System.out.println("Agente registrado con éxito: " + agente.getNombre());
    }

    public void registrarAgenteInteractivo() {
        int id = ConsoleUtils.leerEntero("Ingrese el ID del agente: ");
        ConsoleUtils.limpiarBuffer();

        String nombre = ConsoleUtils.leerTexto("Ingrese el nombre del agente: ");
        String habilidad = ConsoleUtils.leerTexto("Ingrese la habilidad especial del agente: ");

        Agente nuevoAgente = new Agente(id, nombre, habilidad);
        agentes.add(nuevoAgente);
        nuevoAgente.registrarRecompensa("Medalla");
        System.out.println("Agente registrado con éxito: " + nuevoAgente.getNombre());
    }

    public Agente buscarAgentePorId(int id) {
        for (Agente agente : agentes) {
            if (agente.getId() == id) {
                return agente;
            }
        }
        return null;
    }

    public void mostrarAgentes() {
        if (agentes.isEmpty()) {
            System.out.println("No hay agentes registrados.");
            return;
        }
        System.out.println("=== Lista de Agentes ===");
        for (Agente agente : agentes) {
            System.out.println(agente);
        }
    }

    public void mostrarMenu() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Menú Agentes ===");
            System.out.println("1. Registrar Agente");
            System.out.println("2. Mostrar Agentes");
            System.out.println("3. Salir");
            int opcion = ConsoleUtils.leerEntero("Seleccione una opción: ");
            ConsoleUtils.limpiarBuffer();

            switch (opcion) {
                case 1 -> registrarAgenteInteractivo();
                case 2 -> mostrarAgentes();
                case 3 -> continuar = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}
