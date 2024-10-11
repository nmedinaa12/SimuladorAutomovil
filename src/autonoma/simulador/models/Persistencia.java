/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simulador.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Persistencia {

    public static Vehiculo cargarVehiculo(String archivoConfiguracion) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(archivoConfiguracion));
        String linea;
        Llanta llantas = null;
        Motor motor = null;

        while ((linea = br.readLine()) != null) {
            String[] partes = linea.split(" ");
            switch (partes[0]) {
                case "llantas":
                    llantas = crearLlantas(partes[1]);
                    break;
                case "motor":
                    motor = crearMotor(Integer.parseInt(partes[1]));
                    break;
            }
        }
        br.close();
        return new Vehiculo(motor, llantas);
    }

    private static Llanta crearLlantas(String tipo) {
        switch (tipo) {
            case "Buenas":
                return new Llanta("Buenas", 110); // Límite de velocidad para "Buenas"
            case "Bonitas":
                return new Llanta("Bonitas", 70); // Límite de velocidad para "Bonitas"
            case "Baratas":
                return new Llanta("Baratas", 50); // Límite de velocidad para "Baratas"
            default:
                throw new IllegalArgumentException("Tipo de llanta no válido: " + tipo);
        }
    }

    private static Motor crearMotor(int cilindraje) {
        switch (cilindraje) {
            case 1000:
                return new Motor(100); // Velocidad máxima para 1000 cc
            case 2000:
                return new Motor(160); // Velocidad máxima para 2000 cc
            case 3000:
                return new Motor(220); // Velocidad máxima para 3000 cc
            default:
                throw new IllegalArgumentException("Cilindraje no válido: " + cilindraje);
        }
    }
}
