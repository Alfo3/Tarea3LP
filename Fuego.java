public class Fuego extends Javaling{    
    private int enLlamas; // al llegar a 3 ataques de potencia > 0 se activa el boost de ataque


    public Fuego(String nombre){ 
        super(nombre);
        inicializarStats();
        }

    public int getEnLlamas() {
        return enLlamas;
    }

    public void setEnLlamas(int enLlamas) {
        this.enLlamas = enLlamas;
    }

    @Override
    public void inicializarStats(){
        this.setHpTotal(55 + (int)(Math.random() * 11) );
        this.setVelocidad(1 + (int)(Math.random() * 398));
        this.setMovimientos(new Movimiento[4]);
    }
    
}
