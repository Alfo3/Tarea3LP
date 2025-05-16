import java.util.Scanner;

public class main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa tu nombre de entrenador: ");
        Jugador jugador = new Jugador(scanner.nextLine());

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
        jugador.getEquipo()[0] = javaling;
        System.out.println("¡Bienvenido " + jugador.getNombre() + " al maravilloso mundo de Javaling, ");
        System.out.println("donde los Javaling son tus amigos y compañeros de aventura!");
        System.out.println("Haz elegido a " + jugador.getEquipo()[0].getNombre() + " como tu primer Javaling!");
        jugador.mostrarStats(0);

        boolean continuar = true;
        int piso = 1;
        while (continuar){
            System.out.println("\n ¿Qué deseas hacer?");
            System.out.println("1. Entrar en combate");
            System.out.println("2. Ver stats de tu Javaling");
            System.out.println("3. Usar objeto");
            System.out.println("4. Salir");
            int accion = scanner.nextInt();
            switch (accion) {
                case 1:
                    iniciarCombate(jugador, piso, scanner);
                    break;
                case 4:
                    System.out.println("¡Gracias por jugar! Hasta luego.");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }

        scanner.close();
    }
    public static void iniciarCombate(Jugador jugador, int piso, Scanner scanner) {
        System.out.println("¡Has entrado en combate!");
        Entrenador rival = new Entrenador();
        rival.generarEquipoAleatorio(piso);
        System.out.println("Te enfrentas a un entrenador rival con el siguiente equipo:");
        for (Javaling javaling : rival.getEquipo()){
            if (javaling != null) {
                System.out.println("- " + javaling.getNombre() + " (Nivel: " + javaling.getNivel() + ")");
            }
        }
        boolean continuar = true;
        while (continuar){
            System.out.println("\n Tu Javaling: " + jugador.getEquipo()[0].getNombre());
            System.out.println("HP " + jugador.getEquipo()[0].getHpActual() + "/" + jugador.getEquipo()[0].getHpTotal());
            System.out.println("¿Qué deseas hacer?");
            Movimiento[] movimientos = jugador.getEquipo()[0].getMovimientos();
            for (int i = 0; i < movimientos.length; i++){
                if (movimientos[i] != null){
                    System.out.println((i + 1) + ". " + movimientos[i].getNombre() + " (Potencia: " + movimientos[i].getPotencia() + ")");
                }
            }
            System.out.println("Elige un movimiento:");
            int movimientoElegido = scanner.nextInt();
            if (movimientoElegido < 0 || movimientoElegido > (movimientos.length + 1) || movimientos[movimientoElegido] == null) {
                System.out.println("Movimiento no válido.");
                continue;
            }

            Javaling rivalJavaling = rival.getEquipo()[0];
            int dano = jugador.getEquipo()[0].atacar(rivalJavaling, movimientoElegido - 1);
            rivalJavaling.setHpActual(rivalJavaling.getHpActual() - dano);
            System.out.println("Has hecho " + dano + " de daño a " + rivalJavaling.getNombre() + "!");
            if(rivalJavaling.getHpActual() <= 0){
                System.out.println(rivalJavaling.getNombre() + " ha sido derrotado!");
                for (int i = 1; i < rival.getEquipo().length; i++){
                    if (rival.getEquipo()[i] != null){
                        rival.getEquipo()[0] = rival.getEquipo()[i];
                        rival.getEquipo()[i] = null;
                        break;
                    }
                }
                //no quedan javalings
                if (rival.getEquipo()[0] == null){
                    System.out.println("Has ganado el combate!");
                    continuar = false;
                } else {// quedan javalings y lanza al otro javaling 
                    System.out.println("El rival ha enviado a " + rival.getEquipo()[0].getNombre() + "!");
                    rivalJavaling = rival.getEquipo()[0];
                }
            }

            //turno del rival
            Movimiento[] movimientosRival = rivalJavaling.getMovimientos();
            int danorival = rivalJavaling.atacar(jugador.getEquipo()[0], 0);
            jugador.getEquipo()[0].setHpActual(jugador.getEquipo()[0].getHpActual() - danorival);
            System.out.println("El rival ha usado " + movimientosRival[0].getNombre() + "!");
            System.out.println(rivalJavaling.getNombre() + " ha hecho " + danorival + " de daño a " + jugador.getEquipo()[0].getNombre() + "!");
            if(jugador.getEquipo()[0].getHpActual() <= 0){
                System.out.println(jugador.getEquipo()[0].getNombre() + " ha sido derrotado!");
                continuar = false;
            }
        }
    }
}
