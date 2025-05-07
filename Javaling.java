public abstract class Javaling {
    private String nombre;
    private int hpBase;
    private int velocidad;
    private int hpTotal;
    private int hpActual;
    private int nivel;
    private Tipo tipo;
    private Movimiento[] movimientos;

    public abstract void inicializarStats();

    public Javaling(String nombre){
        this.nombre = nombre;
        this.movimientos = new Movimiento[4];
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHpBase() {
        return hpBase;
    }

    public void setHpBase(int hpBase) {
        this.hpBase = hpBase;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getHpTotal() {
        return hpTotal;
    }

    public void setHpTotal(int hpTotal) {
        this.hpTotal = hpTotal;
    }

    public int getHpActual() {
        return hpActual;
    }

    public void setHpActual(int hpActual) {
        this.hpActual = hpActual;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Movimiento[] getMovimientos(){
        return movimientos;
    }
    
    public void setMovimientos(Movimiento[] movimientos) {
        this.movimientos = movimientos;
    }
}
