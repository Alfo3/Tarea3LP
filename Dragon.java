public class Dragon extends Javaling{
    static{
        Javaling.setHpBase(70 + (int)(Math.random() * 6)); // HP base entre 70 y 75
    }

    public Dragon(String nombre){
        super(nombre);
        inicializarStats();
    }

    @Override
    public void inicializarStats(){
    }
}
