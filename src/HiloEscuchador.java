import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class HiloEscuchador implements Runnable {
    private Thread hilo;
    private static int numCliente = 0;
    private Socket enchufeAlCliente;

    public HiloEscuchador(Socket cliente) {
        numCliente++;
        hilo = new Thread(this, "Cliente" + numCliente);
        this.enchufeAlCliente = cliente;
        hilo.start();
    }

    @Override
    public void run() {
        System.out.println("Estableciendo comunicación con " + hilo.getName());
        try {
            ObjectInputStream entrada = new ObjectInputStream(enchufeAlCliente.getInputStream());
            ObjectOutputStream salida = new ObjectOutputStream(enchufeAlCliente.getOutputStream());

            while (true) {  // Bucle para múltiples consultas
                try {
                    String nombreEmpleado = (String) entrada.readObject();
                    if ("FIN".equals(nombreEmpleado)) { // Termina la conexión si el cliente envía "FIN"
                        System.out.println(hilo.getName() + " ha cerrado la comunicación");
                        break;
                    }
                    System.out.println(hilo.getName() + " solicita información de: " + nombreEmpleado);

                    // Buscamos el empleado en la lista
                    Empleado empleadoEncontrado = null;
                    for (Empleado emp : ServidorM.getEmpleados()) {  // Asegúrate de que este método está bien escrito
                        if (emp.getNombre().equalsIgnoreCase(nombreEmpleado)) {
                            empleadoEncontrado = emp;
                            break;
                        }
                    }

                    if (empleadoEncontrado != null) {
                        salida.writeObject(empleadoEncontrado);
                        System.out.println(hilo.getName() + " ha enviado la información del empleado");
                    } else {
                        salida.writeObject(null); // Enviamos null si no se encuentra el empleado
                        System.out.println(hilo.getName() + " no encontró al empleado");
                    }
                } catch (ClassNotFoundException e) {
                    System.out.println("Error al deserializar objeto: " + e.getMessage());
                    break; // Sale del bucle en caso de error de deserialización
                }
            }

            entrada.close();
            salida.close();
            enchufeAlCliente.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}