import java.io.Serializable;

public class Empleado implements Serializable {
    private String nombre;
    private String matricula;
    private int edad;
    private String apellidos;
    private Puesto puesto;


    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Empleado[" +
                "Nombre='" + nombre + '\'' +
                ", Apellidos='" + apellidos + '\'' +
                ", Edad=" + edad +
                ", Matricula='" + matricula + '\'' +
                ", Puesto=" + puesto +
                ']';
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Empleado(String nombre, String matricula, int edad, String apellidos, Puesto puesto) {
        this.nombre = nombre;
        this.matricula = matricula;
        this.edad = edad;
        this.apellidos = apellidos;
        this.puesto = puesto;
    }
}
