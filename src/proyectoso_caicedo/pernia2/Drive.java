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
    int posicionJuegosconDLC;
    int posicionJuegossinDLC;
 
    char[] CarpetaNiveles;
    char[] CarpetaArtista;
    char[] CarpetaLogica;
    char[] CarpetaDLC;
    char[] CarpetaJuegossinDLC;
    char[] CarpetaJuegosconDLC;
    

    public Drive(String nombre) {
        this.nombre = nombre;
        this.CarpetaNarrativa = new char[25] ;
        this.CarpetaNiveles = new char[20];
        this.CarpetaArtista = new char[55];
        this.CarpetaLogica = new char[35];
        this.CarpetaDLC = new char[10]; 
        this.CarpetaJuegossinDLC = new char[100];
        this.CarpetaJuegosconDLC = new char[100];
        this.posicionNarrativa = 0;
        this.posicionNiveles = 0;
        this.posicionArtista = 0;
        this.posicionLogica = 0;
        this.posicionJuegosconDLC = 0;
        this.posicionJuegossinDLC = 0;
        


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
    
    public synchronized void InsertarJuegoconDLC(char g){
        if (posicionJuegosconDLC==CarpetaJuegosconDLC.length-1){
        }else{
        CarpetaJuegosconDLC[posicionJuegosconDLC] = g;
        posicionJuegosconDLC++;
        }
        notifyAll();
    }
    
    public synchronized void InsertarJuegosinDLC(char g){
        if (posicionJuegossinDLC==CarpetaJuegossinDLC.length-1){
        }else{
        CarpetaJuegossinDLC[posicionJuegossinDLC] = g;
        posicionJuegossinDLC++;
        }
        notifyAll();
    }
    
    public synchronized void EliminarNarrativa(int cantidad){
        while(posicionNarrativa<cantidad){
               try {
                   wait();
               } catch (InterruptedException e) {
                   System.out.println("Error: " + e);
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
                   System.out.println("Error: " + e);
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
                   System.out.println("Error: " + e);
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
                   System.out.println("Error: " + e);
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
                   System.out.println("Error: " + e);
               }
           }
    for (int i = 0; i < cantidad; i++) {
            CarpetaDLC[posicionDLC] = ' ';
            posicionDLC--;
        } 
    notifyAll();
    }
    
    public synchronized void EliminarJuegosconDLC(){
        while(posicionJuegosconDLC>0){
               try {
                   wait();
               } catch (InterruptedException e) {
                   System.out.println("Error: " + e);
               }
           }
    for (int i = 0; i > 0; i++) {
            CarpetaJuegosconDLC[posicionJuegosconDLC] = ' ';
            posicionJuegosconDLC--;
        } 
    notifyAll();
    }
    
    public synchronized void EliminarJuegossinDLC(){
        while(posicionJuegossinDLC>0){
               try {
                   wait();
               } catch (InterruptedException e) {
                   System.out.println("Error: " + e);
               }
           }
    for (int i = 0; i > 0; i++) {
            CarpetaJuegossinDLC[posicionJuegossinDLC] = ' ';
            posicionJuegossinDLC--;
        } 
    notifyAll();
    }
    
    }
    

