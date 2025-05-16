public class Movimiento {
    private String nombre;
    private int potencia;
    private int precision;
    private Javaling.Tipo tipo;
    private boolean esEstado;

    public Movimiento(String nombre, int potencia, int precision, Javaling.Tipo tipo, boolean esEstado) {
        this.nombre = nombre;
        this.potencia = potencia;
        this.precision = precision;
        this.tipo = tipo;
        this.esEstado = esEstado;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPotencia() {
        return potencia;
    }

    public void setPotencia(int potencia) {
        this.potencia = potencia;
    }   

    public int getPrecision() {
        return precision;
    }

    public void setPrecision(int precision) {
        this.precision = precision;
    }

    public Javaling.Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Javaling.Tipo tipo) {
        this.tipo = tipo;
    }

    public boolean isEsEstado() {
        return esEstado;
    }

    public void setEsEstado(boolean esEstado) {
        this.esEstado = esEstado;
    }

}
