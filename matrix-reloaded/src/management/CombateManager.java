package management;

import entities.Agente;
import utils.ConsoleUtils;

public class CombateManager {
    private AgenteManager agenteManager;

    public CombateManager(AgenteManager agenteManager) {
        this.agenteManager = agenteManager;
    }

    public void registrarCombate(int agenteId) {
        Agente agente = agenteManager.buscarAgentePorId(agenteId);
        if (agente != null) {
            agente.registrarRecompensa("Recompensa por Combate");
            System.out.println("Combate registrado para " + agente.getNombre() + ". Recompensa otorgada.");
        } else {
            System.out.println("Agente no encontrado.");
        }
    }

    public void mostrarMenu() {
        boolean continuar = true;
        while (continuar) {
            System.out.println("\n=== Menú Combate ===");
            System.out.println("1. Registrar Combate");
            System.out.println("2. Volver al Menú Principal");
            int opcion = ConsoleUtils.leerEntero("Seleccione una opción: ");
            ConsoleUtils.limpiarBuffer();

            switch (opcion) {
                case 1 -> {
                    int agenteId = ConsoleUtils.leerEntero("Ingrese el ID del agente: ");
                    registrarCombate(agenteId);
                }
                case 2 -> continuar = false;
                default -> System.out.println("Opción no válida.");
            }
        }
    }
}
