/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoso_caicedo.pernia2;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Luisp
 */
public class Drive {
    
    String nombre;
    
    char[] CarpetaNarrativa;
    int posicionNarrativa;
    int posicionNiveles;
    int posicionArtista;
    int posicionLogica;
    int posicionDLC;
    int posicionJuegos;
 
    char[] CarpetaNiveles;
    char[] CarpetaArtista;
    char[] CarpetaLogica;
    char[] CarpetaDLC;
    char[] CarpetaJuegos;
    

    public Drive(String nombre) {
        this.nombre = nombre;
        this.CarpetaNarrativa = new char[25] ;
        this.CarpetaNiveles = new char[20];
        this.CarpetaArtista = new char[55];
        this.CarpetaLogica = new char[35];
        this.CarpetaDLC = new char[10]; 
        this.CarpetaJuegos = new char[100];
        this.posicionNarrativa = 0;
        this.posicionNiveles = 0;
        this.posicionArtista = 0;
        this.posicionLogica = 0;


    }
    
    public synchronized void InsertarNarrativa(char g){
        if (posicionNarrativa==CarpetaNarrativa.length-1){
        }
        else{
        CarpetaNarrativa[posicionNarrativa] = g;
        posicionNarrativa++;
        }
        notifyAll();
    }
    
    public synchronized void InsertarNiveles(char g){
        if (posicionNiveles==CarpetaNiveles.length-1){
        }
        else{
        CarpetaNiveles[posicionNiveles] = g;
        posicionNiveles++;
        }
        notifyAll();
    }
    
    public synchronized void InsertarArtistas(char g){
        if (posicionArtista==CarpetaArtista.length-1){
        } 
        else{
        CarpetaArtista[posicionArtista] = g;
        posicionArtista++;
        }
        notifyAll();
    }
    
    public synchronized void InsertarLogicas(char g){
        if (posicionLogica==CarpetaLogica.length-1){
        } 
        else{
        CarpetaLogica[posicionLogica] = g;
        posicionLogica++;
        }
        notifyAll();
    }
    
    public synchronized void InsertarDLC(char g){
        if (posicionDLC==CarpetaDLC.length-1){
        }else{
        CarpetaDLC[posicionDLC] = g;
        posicionDLC++;
        }
        notifyAll();
    }
    
    public synchronized void InsertarJuego(char g){
        if (posicionJuegos==CarpetaJuegos.length-1){
        }else{
        CarpetaJuegos[posicionJuegos] = g;
        posicionJuegos++;
        }
        notifyAll();
    }
    
    public synchronized void EliminarNarrativa(int cantidad){
        while(posicionNarrativa<cantidad){
               try {
                   wait();
               } catch (InterruptedException e) {
                   System.out.println("Error: " + e);;
               }
           }
        for (int i = 0; i < cantidad; i++) {
            CarpetaNarrativa[posicionNarrativa] = ' ';
            posicionNarrativa--;
        }
        notifyAll();
    }
    
    public synchronized void EliminarNiveles(int cantidad){
        while(posicionNiveles<cantidad){
               try {
                   wait();
               } catch (InterruptedException e) {
                   System.out.println("Error: " + e);;
               }
           }
        for (int i = 0; i < cantidad; i++) {
            CarpetaNiveles[posicionNiveles] = ' ';
            posicionNiveles--;
        }
        notifyAll();
    }
        
    public synchronized void EliminarArtista(int cantidad){
        while(posicionArtista<cantidad){
               try {
                   wait();
               } catch (InterruptedException e) {
                   System.out.println("Error: " + e);;
               }
           }
        for (int i = 0; i < cantidad; i++) {
            CarpetaArtista[posicionArtista] = ' ';
            posicionArtista--;
        }
        notifyAll();
    }
        
    public synchronized void EliminarLogica(int cantidad){
        while(posicionLogica<cantidad){
               try {
                   wait();
               } catch (InterruptedException e) {
                   System.out.println("Error: " + e);;
               }
           }
       for (int i = 0; i < cantidad; i++) {
            CarpetaLogica[posicionLogica] = ' ';
            posicionLogica--;
        } 
       notifyAll();
    }
    
    public synchronized void EliminarDLC(int cantidad){
        while(posicionDLC<cantidad){
               try {
                   wait();
               } catch (InterruptedException e) {
                   System.out.println("Error: " + e);;
               }
           }
    for (int i = 0; i < cantidad; i++) {
            CarpetaDLC[posicionDLC] = ' ';
            posicionDLC--;
        } 
    notifyAll();
    }
    
    }
    

