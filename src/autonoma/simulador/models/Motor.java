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
    private boolean encendido;
    private double velocidadMaxima;

    // Constructor
    public Motor(double velocidadMaxima) {
        this.velocidadMaxima = velocidadMaxima;
        this.encendido = false;
    }

    public void encender() {
        this.encendido = true;
        System.out.println("Motor encendido.");
    }

    public void apagar() {
        this.encendido = false;
        System.out.println("Motor apagado.");
    }

    public void validarVelocidadMaxima(double velocidad) throws LimiteMotorException {
        if (velocidad > this.velocidadMaxima) {
            throw new LimiteMotorException("Se ha excedido la velocidad máxima del motor.");
        }
    }

    public double getVelocidadMaxima() {
        return velocidadMaxima;
    }
    
    public boolean isEncendido() {
        return encendido;
    }
}
