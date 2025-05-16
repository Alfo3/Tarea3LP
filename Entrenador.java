
import java.util.Random;

public class Entrenador{
    private boolean esCamepon;
    private Javaling[] equipo;


    public Entrenador(){
        this.equipo = new Javaling[6];
        this.esCamepon = false;
    }

    public void generarEquipoAleatorio(int piso){
        Random random = new Random();
        int cantidadJavalings = esCamepon ? 6 : 0; // 6 si es campeón, 0 si no lo es
        if (!esCamepon){
            if (piso <= 20){
                cantidadJavalings = random.nextInt(2) + 1; // 1 o 2 javalings
            } else if (piso <= 30){
                cantidadJavalings = random.nextInt(3) + 2; // 2 o 3 javalings
            } else if (piso <= 40){
                cantidadJavalings = random.nextInt(4) + 3; // 3 o 4 javalings
            } else if (piso <= 50){
                cantidadJavalings = random.nextInt(5) + 4; // 4 o 5 javalings
            } else {
                cantidadJavalings = random.nextInt(6) + 5; // 5 o 6 javalings
            }
        }
        
        for (int i = 0; i < cantidadJavalings; i++){
            int nivel = 0;
            if (esCamepon){
                nivel = piso + 5;
            } else if (piso <= 5){
                nivel = random.nextInt(3) + 4; // 4, 5 o 6
            } else {
                int levelBase = random.nextInt(3*piso) + 1;
                nivel = levelBase + random.nextInt(7) - 3;
            }

            Javaling javaling;
            if (esCamepon && i == 0){
                javaling = new Dragon("Dragon Del CAMPEON");
            } else if (esCamepon && random.nextInt(100) < 20){
                javaling = new Dragon("Dragon");
            } else{
                javaling = generarJavalingAleatorio(nivel);
            }

            javaling.setNivel(nivel);
            javaling.inicializarStats();
            equipo[i] = javaling;

        }
    }

    private Javaling generarJavalingAleatorio(int nivel){
        Random random = new Random();
        String[] nombrerandom = {"Fuego", "Agua", "Planta", "Dragon"};
        String nombre = nombrerandom[random.nextInt(nombrerandom.length)];

        int tipo = -1;
        for (int i = 0; i < nombrerandom.length; i++){
            if (nombre.equals(nombrerandom[i])){
                tipo = i;
                break;
            }
        }
        
        Javaling javaling = null;
        switch (tipo) {
            case 0:
                javaling = new Fuego(nombre);
                break;
            case 1:
                javaling = new Agua(nombre);
                break;
            case 2:
                javaling = new Planta(nombre);
                break;
            case 3:
                javaling = new Dragon(nombre);
                break;
        }
        if (javaling != null){
            javaling.setNivel(nivel);
            javaling.inicializarStats();
        }
        return javaling;
    }
    public Javaling[] getEquipo() {
        return equipo;
    }

    public void setEsCampeon(boolean esCampeon) {
        this.esCamepon = esCampeon;
    }
    public boolean getEsCampeon() {
        return esCamepon;
    }
}

