/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoso_caicedo.pernia2;

import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.Semaphore;
import static proyectoso_caicedo.pernia2.ProyectoSO_CaicedoPernia2.Empresa1;

/**
 *
 * @author Luisp
 */
public class EmpresaCapcom {
    
    
    Desarrollador[] Hilos;
    Thread HiloTiempo;
    int DuracionDia;
    int DiasLanzamiento;
    int CantidadNiveles;
    int CantidadNarrativa;
    int CantidadLogica;
    int CantidadDLC;
    int CantidadArtista;
    int CantidadIntegrador;
    int PagosEmpleados;
    Tiempo t1;
    ProjectManager P1;
    Director D1;
    

    public EmpresaCapcom(int DuracionDia,  int CantidadNarrativa, int CantidadNiveles, int CantidadArtista, int CantidadLogica, int CantidadDLC,  int cantidadIntegrador, int DiasLanzamiento) {
        this.DuracionDia = DuracionDia * 1000;
        this.CantidadNarrativa = CantidadNarrativa;
        this.CantidadNiveles = CantidadNiveles;
        this.CantidadArtista = CantidadArtista;
        this.CantidadLogica = CantidadLogica;
        this.CantidadDLC = CantidadDLC;
        this.CantidadIntegrador = cantidadIntegrador;
        this.Hilos = new Desarrollador[18];
        this.PagosEmpleados = 0;
        this.DiasLanzamiento = DiasLanzamiento;
    }
    
    
    //Se inicializan los hilos en 0
    public void InicializarHilos(Dashboard Interfaz){
        Semaphore Semaforo = new Semaphore(1); 
        Drive Carpetas = new Drive("Carpetas", this, null);
        Carpetas.InicializarcantidadjuegosinDLCVar(3);
        Carpetas.addObserver(Interfaz);
        for (int i = 0; i < Hilos.length; i++) {
            Hilos[i] = new Desarrollador(0,0,DuracionDia,Semaforo,Carpetas,0,1,2,6,5,1,400000,3,750000);
            Hilos[i].start();
        }
        this.CrearDirector(Interfaz, Carpetas, Empresa1, null);
    }
      
    //Se clasifican los hilos segun su tipo
     public void ReasignarCantidades(){
     for (int i = 0; i < CantidadNarrativa; i++) {
            Hilos[i].tipo = 1;
            Hilos[i].DiasporProducto = 4;
        }
     
     for (int i = CantidadNarrativa; i < CantidadNarrativa + CantidadNiveles; i++) {
            Hilos[i].tipo = 2;
            Hilos[i].DiasporProducto = 4;
        }
     
     for (int i = CantidadNarrativa + CantidadNiveles; i < CantidadNarrativa + CantidadNiveles + CantidadArtista; i++) {
            Hilos[i].tipo = 3;
            Hilos[i].ProductoporDia = 1;
        }
     
     for (int i = CantidadNarrativa + CantidadNiveles + CantidadArtista; i < CantidadNarrativa + CantidadNiveles + CantidadArtista + CantidadLogica; i++) {
            Hilos[i].tipo = 4;
            Hilos[i].ProductoporDia = 5;
        }
     
     for (int i = CantidadNarrativa + CantidadNiveles + CantidadArtista + CantidadLogica; i < CantidadNarrativa + CantidadNiveles + CantidadArtista + CantidadLogica + CantidadDLC; i++) {
            Hilos[i].tipo = 5;
            Hilos[i].DiasporProducto = 2;
        }
     
          for (int i = CantidadNarrativa + CantidadNiveles + CantidadArtista + CantidadLogica + CantidadDLC; i < CantidadNarrativa + CantidadNiveles + CantidadArtista + CantidadLogica + CantidadDLC + CantidadIntegrador; i++) {
 
              Hilos[i].tipo = 6;
        }
     
     }
     
     public void ReasignarCantidadesInterfaz(int CantidadNarrativa, int CantidadNiveles, int CantidadArtista, int CantidadLogica, int CantidadDLC, int CantidadIntegrador){
     for (int i = 0; i < CantidadNarrativa; i++) {
            Hilos[i].tipo = 1;
            Hilos[i].DiasporProducto = 4;
        }
     
     for (int i = CantidadNarrativa; i < CantidadNarrativa + CantidadNiveles; i++) {
            Hilos[i].tipo = 2;
            Hilos[i].DiasporProducto = 4;
        }
     
     for (int i = CantidadNarrativa + CantidadNiveles; i < CantidadNarrativa + CantidadNiveles + CantidadArtista; i++) {
            Hilos[i].tipo = 3;
            Hilos[i].ProductoporDia = 1;
        }
     
     for (int i = CantidadNarrativa + CantidadNiveles + CantidadArtista; i < CantidadNarrativa + CantidadNiveles + CantidadArtista + CantidadLogica; i++) {
            Hilos[i].tipo = 4;
            Hilos[i].ProductoporDia = 5;
        }
     
     for (int i = CantidadNarrativa + CantidadNiveles + CantidadArtista + CantidadLogica; i < CantidadNarrativa + CantidadNiveles + CantidadArtista + CantidadLogica + CantidadDLC; i++) {
            Hilos[i].tipo = 5;
            Hilos[i].DiasporProducto = 2;
        }
     
          for (int i = CantidadNarrativa + CantidadNiveles + CantidadArtista + CantidadLogica; i < CantidadNarrativa + CantidadNiveles + CantidadArtista + CantidadLogica + CantidadDLC + CantidadIntegrador; i++) {
            Hilos[i].tipo = 6;
        }
     
     }
     
     public void CrearHiloTiempo(Observer Interfaz){
        t1 = new Tiempo(DuracionDia);
        t1.addObserver(Interfaz);
        HiloTiempo = new Thread(t1);
        HiloTiempo.start();
        
     }
     
     public void CalculodelCostoEmpleados(){
         for (int i = 0; i < Hilos.length; i++) {
            PagosEmpleados += Hilos[i].CostoporEmpleado;
        }
     }
         
    public void CrearProjectManajer(Observer Interfaz){
    P1 = new ProjectManager(DuracionDia,DiasLanzamiento);
    P1.addObserver(Interfaz);
    Thread HiloProjectManager = new Thread(P1);
    HiloProjectManager.start();
    }
    
    public void CrearDirector(Observer Interfaz, Drive Carpeta, EmpresaCapcom CAP,EmpresaBethesda BET){
    D1 = new Director(DiasLanzamiento,DuracionDia,P1,Carpeta,CAP,BET); 
    D1.addObserver(Interfaz);
    Thread HiloDirector = new Thread(D1);
    HiloDirector.start();
    }
     
     }
     
     
    
        

        
    
    
    
    
    
    
    
   
    
    

