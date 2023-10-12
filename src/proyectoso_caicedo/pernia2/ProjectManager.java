/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoso_caicedo.pernia2;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luisp
 */
public class ProjectManager extends Observable implements Runnable {
    
    int Duraciondias;
    float MediaHora;
    float horasdeldia16;
    float horasdeldiasumador;
    int DiasLanzamiento;
    int DiasLanzamientoVariable;
    int VerStream;
    int CostoEmpleado;
    String Estado;
    

    public ProjectManager(int Duraciondias, int DiasLanzamiento) {
        this.Duraciondias = Duraciondias;
        this.DiasLanzamientoVariable = DiasLanzamiento;
        this.DiasLanzamiento = DiasLanzamiento;
        this.horasdeldia16 = (16*Duraciondias)/24;
        this.MediaHora = (float) ((0.5*horasdeldia16)/16);
        this.horasdeldiasumador = 0;
        this.VerStream = 0;
        this.CostoEmpleado=0;
        this.Estado = "";
    }

    @Override
    public void run() {
    while(true){
        CostoEmpleado += 20*24;
        while(horasdeldiasumador<horasdeldia16){
            if(VerStream == 0){
            try {
                Estado = "Tareas Administrativas";
                Thread.sleep((long) MediaHora);
                VerStream = 1;
                horasdeldiasumador+=MediaHora;
                this.setChanged();
                this.notifyObservers(Estado);
                this.clearChanged();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            else {
                if(VerStream == 1){
            try {
                Estado = "Ve Stream";
                Thread.sleep((long) MediaHora);
                VerStream = 0;
                horasdeldiasumador+=MediaHora;
                this.setChanged();
                this.notifyObservers("Ve Stream");
                this.clearChanged();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
                
            }
            }
        
        horasdeldiasumador = 0;
        Estado = "Cambiando Contador";
        this.setChanged();
        this.notifyObservers(Estado);
        this.clearChanged();
        this.setChanged();
        this.notifyObservers(Integer.toString(DiasLanzamientoVariable));
        this.clearChanged();
        try {
            Thread.sleep(8*Duraciondias/24);
        } catch (InterruptedException ex) {
            Logger.getLogger(ProjectManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        DiasLanzamientoVariable--;
        if (DiasLanzamientoVariable == 0){
        DiasLanzamientoVariable = DiasLanzamiento;
        }
        }
        
        
       
    }
    }
    


    
    
    
    
    

