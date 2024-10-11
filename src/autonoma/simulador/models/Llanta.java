/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simulador.models;

/**
 *
 * @author user
 */
public class Llanta {
    private String tipo;
    private double limitePatinaje;

    public Llanta(String tipo, double limitePatinaje) {
        this.tipo = tipo;
        this.limitePatinaje = limitePatinaje;
    }

    public String getTipo() {
        return tipo;
    }

    public double getLimitePatinaje() {
        return limitePatinaje;
    }
}

