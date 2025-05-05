public class Fuego extends Javaling{    
     static {
        Javaling.setHpBase(60 + (int)(Math.random() * 6)); // HP base entre 60 y 65
     }

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
    }
    
}
