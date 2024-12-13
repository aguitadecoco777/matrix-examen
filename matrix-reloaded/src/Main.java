import management.AgenteManager;
import management.AnomaliaManager;
import management.CombateManager;
import utils.ConsoleUtils;

public class Main {
    public static void main(String[] args) {
        boolean continuar = true;
        AgenteManager agenteManager = new AgenteManager();
        AnomaliaManager anomaliaManager = new AnomaliaManager();
        CombateManager combateManager = new CombateManager(agenteManager);

        while (continuar) {
            System.out.println("Bienvenido a Matrix Reloaded: Salvando la Humanidad");
            System.out.println("Elige una píldora para continuar:");
            System.out.println("1. Píldora Roja: Agentes de la Resistencia");
            System.out.println("2. Píldora Azul: Control de Anomalías");
            System.out.println("3. Píldora Verde: Gestión de Combates");
            System.out.println("4. Salir");

            int opcion = ConsoleUtils.leerEntero("Selecciona una opción (1, 2, 3 o 4): ");

            switch (opcion) {
                case 1 -> agenteManager.mostrarMenu();
                case 2 -> anomaliaManager.mostrarMenu();
                case 3 -> combateManager.mostrarMenu();
                case 4 -> continuar = false;
                default -> System.out.println("Opción no válida. Por favor, selecciona de nuevo.");
            }
        }
        System.out.println("Gracias por jugar. ¡Adiós!");
    }
}
