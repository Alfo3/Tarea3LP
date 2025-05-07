import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Elige un tipo de Javaling:");
        System.out.println("1. Agua");
        System.out.println("2. Planta");
        System.out.println("3. Fuego");
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer

        if (opcion < 1 || opcion > 3) {
            System.out.println("Opción no válida.");
            System.exit(0);
        }
        System.out.print("Ingresa el nombre de tu Javaling: ");
        String nombre = scanner.nextLine();
        Javaling javaling = null;
        if (opcion == 1) {
            javaling = new Agua(nombre);
            } 
        else if (opcion == 2) {
            javaling = new Planta(nombre);
            } 
        else if (opcion == 3) {
            javaling = new Fuego(nombre);
            }

        System.out.println("Has elegido un Javaling de tipo " + javaling.getClass().getSimpleName() + " llamado " + javaling.getNombre() + ".");
        System.out.println("Sus stats iniciales son:");
        System.out.println("HP Total: " + javaling.getHpTotal());
        System.out.println("Velocidad: " + javaling.getVelocidad());
        System.out.println("Movimientos: ");
        for (Movimiento movimiento : javaling.getMovimientos()) {
            if (movimiento != null) {
                System.out.println("- " + movimiento.getNombre() + " (Potencia: " + movimiento.getPotencia() + ", Tipo: " + movimiento.getTipo() + ")");
            }
        }
        scanner.close();
    }
}
