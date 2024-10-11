package autonoma.simulador.main;

import autonoma.simulador.models.Persistencia;
import autonoma.simulador.models.Simulador;
import autonoma.simulador.models.Vehiculo;
import autonoma.simulador.views.VentanaPrincipal;


/**
 *
 * @author nmedi
 */
import java.io.IOException;

public class DemoSimulador {
    public static void main(String[] args) throws IOException {

        Vehiculo vehiculo = Persistencia.cargarVehiculo("src/autonoma/packages/txt/config.txt");
        Simulador simulador = new Simulador(vehiculo);

        new VentanaPrincipal(simulador).setVisible(true);
    }
}

