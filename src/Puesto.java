import java.io.Serializable;

public class Puesto implements Serializable {
    private String nombrePuesto;
    private String descripcionPuesto;

    public Puesto(String nombrePuesto, String descripcionPuesto) {
        this.nombrePuesto = nombrePuesto;
        this.descripcionPuesto = descripcionPuesto;
    }

    public String getNombrePuesto() {
        return nombrePuesto;
    }

    @Override
    public String toString() {
        return "Puesto: [Nombre del puesto: "+ nombrePuesto + ", Descripción: " + descripcionPuesto + "]";
    }

    public void setNombrePuesto(String nombrePuesto) {
        this.nombrePuesto = nombrePuesto;
    }

    public String getDescripcionPuesto() {
        return descripcionPuesto;
    }

    public void setDescripcionPuesto(String descripcionPuesto) {
        this.descripcionPuesto = descripcionPuesto;
    }
}
