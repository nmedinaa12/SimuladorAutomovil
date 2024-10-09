/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package autonoma.simulador.exceptions;

/**
 *
 * @author nmedi
 */
public class LimiteMotorException extends RuntimeException{
    
    public LimiteMotorException(){
        super("La velocidad exedió el limite permitido por el motor");
    }
    
}
