public class Planta extends Javaling{
    static{
        Javaling.setHpBase(65 + (int)(Math.random() * 6)); // HP base entre 65 y 70
    }

    public Planta(String nombre){
        super(nombre);

        inicializarStats();
        }
    
    @Override
    public void inicializarStats() {
    }
}
