public class Dragon extends Javaling{

    public Dragon(String nombre){
        super(nombre);
        inicializarStats();
    }

    @Override
    public void inicializarStats(){
        this.setHpTotal(65 + (int)(Math.random() * 11) );
        this.setVelocidad(1 + (int)(Math.random() * 398));
        this.setMovimientos(new Movimiento[4]);
    }
}
