/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoso_caicedo.pernia2;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Luisp
 */
public class Desarrollador extends Thread{
    
    int DiasporProducto;
    int ProductoporDia;
    int DuracionDia;
    Semaphore Semaforo;
    Drive Carpeta;
    int CostoporEmpleado;
    int GananciaIntegradores;
    int tipo;
    
    int cantidadGuiones;
    int cantidadNiveles;
    int cantidadGraficos;
    int cantidadSistemas;
    int cantidadDLC;
    
    int GananciaJuego;
    int cantidadDeJuegossinDLC;
    int GananciaJuegoDLC;
    int cantidadDeJuegossinDLCvariable;

    public Desarrollador(int DiasporProducto, int ProductoporDia, int DuracionDia, Semaphore Semaforo, Drive Carpeta, int tipo, int cantidadGuiones, int cantidadNiveles, int cantidadGraficos, int cantidadSistemas, int cantidadDLC, int GananciaJuego, int cantidadDeJuegossinDLC, int GananciaJuegoDLC) {
        this.DiasporProducto = DiasporProducto;
        this.ProductoporDia = ProductoporDia;
        this.DuracionDia = DuracionDia;
        this.Semaforo = Semaforo;
        this.Carpeta = Carpeta;
        this.tipo = tipo;
        this.cantidadGuiones = cantidadGuiones;
        this.cantidadNiveles = cantidadNiveles;
        this.cantidadGraficos = cantidadGraficos;
        this.cantidadSistemas = cantidadSistemas;
        this.cantidadDLC = cantidadDLC;
        this.GananciaJuego = GananciaJuego;
        this.cantidadDeJuegossinDLC = cantidadDeJuegossinDLC;
        this.cantidadDeJuegossinDLCvariable = cantidadDeJuegossinDLC;
        this.GananciaJuegoDLC = GananciaJuegoDLC;
        this.CostoporEmpleado = 0;
        this.GananciaIntegradores = 0;
    }

    
    public void run(){
    while (true){
    try{
    if(tipo==1){
        
            sleep(DuracionDia*DiasporProducto);   
            CostoporEmpleado+= 10*24;
            Semaforo.acquire();
            char guion = 'g';
            Carpeta.InsertarNarrativa(guion);
            Semaforo.release();
    }
    else if(tipo == 2){
        
            sleep(DuracionDia*DiasporProducto);  
            CostoporEmpleado+= 13*24;
            Semaforo.acquire();
            char nivel = 'n';
            Carpeta.InsertarNiveles(nivel);
            Semaforo.release();
    
    }
    else if(tipo == 3){
        
        sleep(DuracionDia);
        CostoporEmpleado+= 20*24;
        Semaforo.acquire();
        char artista = 'a';
        for (int i = 1; i <=ProductoporDia; i++) {
        Carpeta.InsertarArtistas(artista);    
        }
        Semaforo.release();
        }
    
    
    else if(tipo == 4){
        
        sleep(DuracionDia);
        CostoporEmpleado+= 8*24;
        Semaforo.acquire();
        char sistemas = 's';
        for (int i = 1; i <=ProductoporDia; i++) {
            Carpeta.InsertarLogicas(sistemas);
        }
        Semaforo.release();
    
    }
    else if(tipo == 5){
        
        sleep(DuracionDia*DiasporProducto);
        CostoporEmpleado+= 17*24;
        Semaforo.acquire();
        char DLC = 'd';
        Carpeta.InsertarDLC(DLC);
        Semaforo.release();
    
    }
    
   
    else if(tipo == 6){
        sleep(DuracionDia*2);
        CostoporEmpleado+= 25*24*2;
        Semaforo.acquire();
        if (Carpeta.cantidadjuegosinDLCVar==0){
        
        if(Carpeta.ComprobarCantidadesconDLC(cantidadGuiones, cantidadNiveles, cantidadGraficos, cantidadSistemas,cantidadDLC)){
        Carpeta.EliminarNarrativa(cantidadGuiones);
        Carpeta.EliminarNiveles(cantidadNiveles);
        Carpeta.EliminarArtista(cantidadGraficos);
        Carpeta.EliminarLogica(cantidadSistemas);
        Carpeta.EliminarDLC(cantidadDLC);
        Carpeta.InsertarJuegoconDLC('J');
        Carpeta.InicializarcantidadjuegosinDLCVar(cantidadDeJuegossinDLC);
        GananciaIntegradores += GananciaJuegoDLC;
        //cantidadDeJuegossinDLCvariable = cantidadDeJuegossinDLC;
        Semaforo.release();
        } else{
            System.out.println("Nada");
            Semaforo.release();
        }
    
        }
        else{
        
        if(Carpeta.ComprobarCantidadessinDLC(cantidadGuiones, cantidadNiveles, cantidadGraficos, cantidadSistemas)){
        Carpeta.EliminarNarrativa(cantidadGuiones);
        Carpeta.EliminarNiveles(cantidadNiveles);
        Carpeta.EliminarArtista(cantidadGraficos);
        Carpeta.EliminarLogica(cantidadSistemas);
        Carpeta.InsertarJuegosinDLC('J');
        GananciaIntegradores += GananciaJuego;
        Carpeta.InicializarcantidadjuegosinDLCVar(Carpeta.cantidadjuegosinDLCVar-1);
        //cantidadDeJuegossinDLCvariable--;
        Semaforo.release();
        }
        else{
        System.out.println("Nada");
        Semaforo.release();
        }
        }    
    }
    else{
    
    }
    }catch(Exception e){
        System.out.println("Error:" + e);    
    }
    }
    }
    
    
    
            
    
    
}
