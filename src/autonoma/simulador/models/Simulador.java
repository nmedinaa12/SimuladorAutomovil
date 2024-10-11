/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simulador.models;

import autonoma.simulador.exceptions.LimiteMotorException;
import autonoma.simulador.exceptions.PatinajeVehiculoException;
import autonoma.simulador.exceptions.VehiculoAccidentadoException;
import autonoma.simulador.exceptions.VehiculoApagadoException;
import autonoma.simulador.exceptions.VehiculoEncendidoException;

/**
 *
 * @author nmedi
 */
public class Simulador {
    private Vehiculo vehiculo;

    // Constructor
    public Simulador(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public void encenderVehiculo() throws VehiculoEncendidoException {
        vehiculo.encender();
    }

    public void apagarVehiculo() throws VehiculoApagadoException, VehiculoAccidentadoException {
        vehiculo.apagar();
    }

    public void acelerarVehiculo(double velocidad) throws LimiteMotorException, VehiculoApagadoException {
        vehiculo.acelerar(velocidad);
    }

    public void frenarVehiculo(double velocidad) throws VehiculoApagadoException {
        vehiculo.frenar(velocidad);
    }

    public void frenarBruscamenteVehiculo() throws PatinajeVehiculoException, VehiculoApagadoException {
        vehiculo.frenarBruscamente();
    }

    public double getVelocidadVehiculo() {
        return vehiculo.getVelocidad();
    }
    
    public Vehiculo getVehiculo() {
        return vehiculo;
    }
}

