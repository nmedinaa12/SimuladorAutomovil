/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simulador.models;

import autonoma.simulador.exceptions.LimiteMotorException;
import autonoma.simulador.exceptions.VehiculoApagadoException;
import autonoma.simulador.exceptions.PatinajeVehiculoException;
import autonoma.simulador.exceptions.VehiculoAccidentadoException;
import autonoma.simulador.exceptions.VehiculoEncendidoException;

/**
 *
 * @author nmedi
 */
public class Vehiculo {
    private double velocidad;
    private Motor motor;
    private Llanta llantas;
    private boolean encendido;
    private boolean accidentado;
    private boolean patinando;

    // Constructor
    public Vehiculo(Motor motor, Llanta llantas) {
        this.motor = motor;
        this.llantas = llantas;
        this.velocidad = 0;
        this.encendido = false;
        this.accidentado = false;
        this.patinando = false;
    }

    // Métodos para acceder a los atributos
    
    public Llanta getLlantas() {
        return llantas;
    }
    
    public Motor getMotor() {
        return motor;
    }
    
    public double getVelocidad() {
        return velocidad;
    }

    public boolean isEncendido() {
        return encendido;
    }

    public boolean isAccidentado() {
        return accidentado;
    }

    public boolean isPatinando() {
        return patinando;
    }
    
    public boolean isEncender() {
        return encendido;
    }

    // Encender el vehículo
    public void encender() throws VehiculoEncendidoException {
        if (this.encendido) {
            throw new VehiculoEncendidoException("El vehículo ya está encendido.");
        }
        this.motor.encender();
        this.encendido = true;
    }

    // Apagar el vehículo
    public void apagar() throws VehiculoApagadoException, VehiculoAccidentadoException {
        if (!this.encendido) {
            throw new VehiculoApagadoException("El vehículo ya está apagado.");
        }
        if (this.velocidad > 60) {
            accidentar();
            throw new VehiculoAccidentadoException("El vehículo se accidentó al intentar apagarlo a alta velocidad.");
        }
        this.motor.apagar();
        this.encendido = false;
        System.out.println("Vehículo apagado.");
    }

    // Acelerar el vehículo
    public void acelerar(double incremento) throws LimiteMotorException, VehiculoApagadoException {
        if (!this.encendido) {
            throw new VehiculoApagadoException("El vehículo está apagado. No se puede acelerar.");
        }
        double nuevaVelocidad = this.velocidad + incremento;
        this.motor.validarVelocidadMaxima(nuevaVelocidad);
        this.velocidad = nuevaVelocidad;
        System.out.println("Vehículo acelerado. Velocidad actual: " + this.velocidad + " Km/h.");
    }

    // Frenar el vehículo
    public void frenar(double decremento) throws VehiculoApagadoException {
        if (!this.encendido) {
            throw new VehiculoApagadoException("El vehículo está apagado. No se puede frenar.");
        }
        if (this.velocidad == 0) {
            throw new VehiculoApagadoException("El vehículo ya está detenido.");
        }
        this.velocidad -= decremento;
        if (this.velocidad < 0) {
            this.velocidad = 0;
        }
        System.out.println("Vehículo frenado. Velocidad actual: " + this.velocidad + " Km/h.");
    }

    // Frenar bruscamente
    public void frenarBruscamente() throws PatinajeVehiculoException, VehiculoApagadoException {
        if (this.velocidad > llantas.getLimitePatinaje()) {
            this.patinar();
            throw new PatinajeVehiculoException("El vehículo patinó al frenar bruscamente.");
        } else if (0 > this.velocidad) {
            this.patinar();
            throw new PatinajeVehiculoException("El vehículo patinó por frenar bruscamente con mayor intensidad que la velocidad.");
        }
        this.frenar(this.velocidad);
    }

    // Accidentar el vehículo
    public void accidentar() {
        this.accidentado = true;
        this.velocidad = 0;
        this.encendido = false;
        System.out.println("El vehículo ha tenido un accidente.");
    }

    // Patinar el vehículo
    public void patinar() {
        this.patinando = true;
        this.velocidad = 0;
        System.out.println("El vehículo está patinando.");
    }
}
