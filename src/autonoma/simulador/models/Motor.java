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
public class Motor {
    
    // Atributos
    private boolean encendido;
    private double velocidadMaxima;
    private int cilindraje;
    
    //Constructor
    public Motor(double velocidadMaxima, int cilindraje){
        this.encendido = false;
        this.velocidadMaxima = velocidadMaxima;
        this.cilindraje = cilindraje;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public void setEncendido(boolean encendido) {
        this.encendido = encendido;
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }

    public void setVelocidadMaxima(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
    }

    public int getCilindraje() {
        return cilindraje;
    }

    public void setCilindraje(int cilindraje) {
        this.cilindraje = cilindraje;
    }
    
    //Metodos
    public void encender(){ 
        this.encendido = true;
    }
    
    public void apagar(){
        this.encendido = false;
    }
    
    //validarVelocidadMaxima
    public void validarVelocidadMaxima(double velocidad){
        if(velocidad > this.velocidadMaxima){
            throw new LimiteMotorException();
        }
    }
    
    
    
}
