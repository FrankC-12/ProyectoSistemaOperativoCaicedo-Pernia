/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoso_caicedo.pernia2;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

/**
 *
 * @author Luisp
 */
public class Director extends Observable implements Runnable{
    
    int DiasLanzamiento;
    int DiasLanzamientoVariable;
    float Duraciondias;
    int GananciasTotales;
    int Costos;
    int Utilidad;
    ProjectManager PM;
    float hora;
    float HorasdeunDia;
    int faltas;
    int PMDescuento;
    Drive Carpeta;
    EmpresaCapcom CAP;
    EmpresaBethesda BET;
    

    public Director(int DiasLanzamiento, int Duraciondias, ProjectManager PM, Drive Carpeta, EmpresaCapcom CAP,EmpresaBethesda BET) {
        this.DiasLanzamiento = DiasLanzamiento;
        this.DiasLanzamientoVariable = DiasLanzamiento;
        this.Duraciondias = Duraciondias;
        this.GananciasTotales = 0;
        this.Costos = 0;
        this.Utilidad = 0;
        this.PM = PM;
        this.hora = Duraciondias/24;
        this.HorasdeunDia = 24;
        this.faltas = 0;
        this.PMDescuento = 0;
        this.Carpeta = Carpeta;
        this.CAP = CAP;
        this.BET = BET;
    }
   
    
    public void ModificarDuracion(int DuracionNueva, int LanzamientoNuevo){
        hora = DuracionNueva/24;
        Duraciondias = DuracionNueva;
        DiasLanzamiento = LanzamientoNuevo;
        DiasLanzamientoVariable = LanzamientoNuevo;
    }
    
    public void run(){
        try {
        while(true){
            
            
            if(DiasLanzamientoVariable>0){
                for (int i = 0; i < DiasLanzamiento; i++) {
                HorasdeunDia = Duraciondias;
                /*this.setChanged();
                this.notifyObservers("11111");
                this.clearChanged();*/
                Random random = new Random();
                int numeroAleatorio = random.nextInt(24 - 0 + 1) + 0;
                HorasdeunDia -= numeroAleatorio*hora;
                Thread.sleep((long) (numeroAleatorio*hora));
                if("Ve Stream".equals(PM.Estado)){
                    
                faltas+=1;
                PMDescuento+=50;
                this.setChanged();
                this.notifyObservers(faltas);
                this.clearChanged();
                this.setChanged();
                this.notifyObservers(PMDescuento);
                this.clearChanged();
                }
               
                Thread.sleep((long) HorasdeunDia);
                DiasLanzamientoVariable--;
            }
}
            
        else{
              
            this.setChanged();
            this.notifyObservers("123");
            this.clearChanged();
            if(BET==null){
            Thread.sleep((long) Duraciondias);
            Carpeta.EliminarJuegosconDLC();
            Carpeta.EliminarJuegossinDLC();
                for (int i = 0; i < CAP.Hilos.length; i++) {
                    if(CAP.Hilos[i].tipo == 6){
                    GananciasTotales += CAP.Hilos[i].GananciaIntegradores;
                    }
                }
                
                for (int i = 0; i < CAP.Hilos.length; i++) {
                    Costos += CAP.Hilos[i].CostoporEmpleado;
                    Costos += (PM.CostoEmpleado-PMDescuento);
                }
                
                Utilidad = GananciasTotales - Costos;
                this.setChanged();
                this.notifyObservers(Utilidad);
                this.clearChanged();
                this.setChanged();
                this.notifyObservers(GananciasTotales);
                this.clearChanged();
                this.setChanged();
                this.notifyObservers(Costos);
                this.clearChanged();
                DiasLanzamientoVariable += DiasLanzamiento;
            }
            else{
            Thread.sleep((long) Duraciondias);
            Carpeta.EliminarJuegosconDLC();
            Carpeta.EliminarJuegossinDLC();
                for (int i = 0; i < BET.Hilos.length; i++) {
                    if(BET.Hilos[i].tipo == 6){
                    GananciasTotales += BET.Hilos[i].GananciaIntegradores;
                    }
                }
                
                for (int i = 0; i < BET.Hilos.length; i++) {
                    Costos += BET.Hilos[i].CostoporEmpleado;
                    Costos += (PM.CostoEmpleado-PMDescuento);
                }
                
                Utilidad = GananciasTotales - Costos;
                this.setChanged();
                this.notifyObservers(Utilidad);
                this.clearChanged();
                this.setChanged();
                this.notifyObservers(GananciasTotales);
                this.clearChanged();
                this.setChanged();
                this.notifyObservers(Costos);
                this.clearChanged();
                DiasLanzamientoVariable += DiasLanzamiento;
            }
            
            
            
            }
        }
            }catch (InterruptedException ex) {
            Logger.getLogger(Director.class.getName()).log(Level.SEVERE, null, ex);}
            
        
        
        
        
        }
    
    
    }
    
    
    
    

