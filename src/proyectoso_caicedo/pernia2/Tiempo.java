/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoso_caicedo.pernia2;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Observable;

/**
 *
 * @author Luisp
 */
public class Tiempo extends Observable implements Runnable{
    
    String nombre;
    int duraciondias;
    int dias;

    public Tiempo(int duraciondias) {
        this.nombre = "Tiempo";
        this.duraciondias = duraciondias;
        this.dias = 0;
    }
    
    public void ModificarDuracionDias(int nuevo){
    duraciondias = nuevo*1000;
    }

    @Override
    public void run() {
    while(true){
        try {
            Thread.sleep(duraciondias);
            dias++;
            this.setChanged();
            this.notifyObservers(dias);
            this.clearChanged();
        } catch (InterruptedException ex) {
            System.out.println("Error");
        }
    }   
    }
    
    
    
    }
    

