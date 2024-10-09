/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simulador.models;

/**
 *
 * @author nmedi
 */
public class Vehiculo {
    
    
    //Atributos
    private double velocidad;
    private Motor motor;
    
    //Constructor
    
   public Vehiculo (Motor motor){
       this.motor = motor;
       this.velocidad = 0;
   }
   
   //Metodos de acceso
    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }
    
    //Metodos
    
    public void encender(){
        this.motor.encender();
    }
    
    public void apagar(){
        this.motor.apagar();
    }
    
    public void acelerar(double velocidad){
        double nVelocidad = this.velocidad + velocidad;
        this.motor.validarVelocidadMaxima(nVelocidad);
        this.setVelocidad(nVelocidad);
    }
    
    public void accidentarVehiculo(){
        this.setVelocidad(0);
        this.apagar();
    }
    
    
   
}
