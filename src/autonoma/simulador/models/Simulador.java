/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simulador.models;

import autonoma.simulador.exceptions.LimiteMotorException;

/**
 *
 * @author nmedi
 */
public class Simulador {
    
    //Atributos
    private Vehiculo vehiculo;
    
    //Constructor
    public Simulador(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
    }
    
    //Metodos de acceso
    public double getVelocidadVehiculo(){
        return this.vehiculo.getVelocidad();
    }
    //Metodos
    public void encenderVehiculo(){
        this.vehiculo.encender();
    }
    
    public void apagarVehiculo(){
        this.vehiculo.apagar();
    }
    
    public void acelerarVehiculo(double velocidad)throws LimiteMotorException{
        try{
            this.vehiculo.acelerar(velocidad);
        } catch(Exception e){
            this.vehiculo.accidentarVehiculo();
            throw e;
        }
    }
    
    
}
