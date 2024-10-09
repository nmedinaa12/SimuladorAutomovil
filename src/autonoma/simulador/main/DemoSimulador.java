package autonoma.simulador.main;

import autonoma.simulador.models.Motor;
import autonoma.simulador.models.Simulador;
import autonoma.simulador.models.Vehiculo;


/**
 *
 * @author nmedi
 */
public class DemoSimulador {
    
    public static void main(String[] args) {
        
        Motor motor = new Motor(200,200);
        Vehiculo vehiculo = new Vehiculo(motor);
        Simulador simulador = new Simulador(vehiculo);
        
        simulador.encenderVehiculo();
        
        try {
            simulador.acelerarVehiculo(50);
            System.out.println(simulador.getVelocidadVehiculo());
            simulador.acelerarVehiculo(151);
        } catch (Exception e) {
            System.out.println("VEHICULO ACCIDENTADO = HA SOBREPASADO LA VELOCIDAD PERMITIDA POR EL MOTOR");
            System.exit(0);
        }
        
        System.out.println("Has acelerado el vehiculo exitosamente");
    }
    
}
