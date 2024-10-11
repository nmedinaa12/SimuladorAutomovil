/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simulador.models;

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
                return new Llanta("Buenas", 110);
            case "Bonitas":
                return new Llanta("Bonitas", 90);
            default:
                return new Llanta("Regulares", 80);
        }
    }

    private static Motor crearMotor(double velocidadMaxima) {
        return new Motor(velocidadMaxima);
    }
}

