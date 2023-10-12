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
public class Drive extends Observable {
    
    String nombre;
    
    char[] CarpetaNarrativa;
    int posicionNarrativa;
    int posicionNiveles;
    int posicionArtista;
    int posicionLogica;
    int posicionDLC;
    int posicionJuegosconDLC;
    int posicionJuegossinDLC;
    EmpresaCapcom C;
    EmpresaBethesda B;
 
    char[] CarpetaNiveles;
    char[] CarpetaArtista;
    char[] CarpetaLogica;
    char[] CarpetaDLC;
    char[] CarpetaJuegossinDLC;
    char[] CarpetaJuegosconDLC;
    int cantidadjuegosinDLCVar;
    

    public Drive(String nombre, EmpresaCapcom C, EmpresaBethesda B) {
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
        this.C = C;
        this.B = B;
        this.cantidadjuegosinDLCVar = 0;
    }
    
    public void InicializarcantidadjuegosinDLCVar(int cantidad){
    cantidadjuegosinDLCVar = cantidad;
    }
    
    public void InsertarNarrativa(char g){
        if (posicionNarrativa==CarpetaNarrativa.length-1){
        }
        else{
        CarpetaNarrativa[posicionNarrativa] = g;
        posicionNarrativa++;
        this.setChanged();
        this.notifyObservers(posicionNarrativa);
        this.clearChanged();
        }
    }
    
    public void InsertarNiveles(char g){
        if (posicionNiveles==CarpetaNiveles.length-1){
        }
        else{
        CarpetaNiveles[posicionNiveles] = g;
        posicionNiveles++;
        this.setChanged();
        this.notifyObservers(posicionNiveles);
        this.clearChanged();
        }
    }
    
    public void InsertarArtistas(char g){
        if (posicionArtista==CarpetaArtista.length-1){
        } 
        else{
        CarpetaArtista[posicionArtista] = g;
        posicionArtista++;
        this.setChanged();
        this.notifyObservers(posicionArtista);
        this.clearChanged();
        }
    }
    
    public void InsertarLogicas(char g){
        if (posicionLogica==CarpetaLogica.length-1){
        } 
        else{
        CarpetaLogica[posicionLogica] = g;
        posicionLogica++;
        this.setChanged();
        this.notifyObservers(posicionLogica);
        this.clearChanged();
        }
    }
    
    public void InsertarDLC(char g){
        if (posicionDLC==CarpetaDLC.length-1){
        }else{
        CarpetaDLC[posicionDLC] = g;
        posicionDLC++;
        this.setChanged();
        this.notifyObservers(posicionDLC);
        this.clearChanged();
        }
    }
    
    public void InsertarJuegoconDLC(char g){
        if (posicionJuegosconDLC==CarpetaJuegosconDLC.length-1){
            
        }else{
        CarpetaJuegosconDLC[posicionJuegosconDLC] = g;
        posicionJuegosconDLC++;
        this.setChanged();
        this.notifyObservers(posicionJuegosconDLC);
        this.clearChanged();
        }
    }
    
    public void InsertarJuegosinDLC(char g){
        if (posicionJuegossinDLC==CarpetaJuegossinDLC.length-1){
        }else{
        CarpetaJuegossinDLC[posicionJuegossinDLC] = g;
        posicionJuegossinDLC++;
        this.setChanged();
        this.notifyObservers(posicionJuegossinDLC);
        this.clearChanged();
        }
    }
    
    public void EliminarNarrativa(int cantidad){
        for (int i = 0; i < cantidad; i++) {
            CarpetaNarrativa[posicionNarrativa] = ' ';
            posicionNarrativa--;
            this.setChanged();
            this.notifyObservers(posicionNarrativa);
            this.clearChanged();
        }
    }
    
    public void EliminarNiveles(int cantidad){
        for (int i = 0; i < cantidad; i++) {
            CarpetaNiveles[posicionNiveles] = ' ';
            posicionNiveles--;
            this.setChanged();
            this.notifyObservers(posicionNiveles);
            this.clearChanged();
        }
    }
        
    public void EliminarArtista(int cantidad){
        for (int i = 0; i < cantidad; i++) {
            CarpetaArtista[posicionArtista] = ' ';
            posicionArtista--;
            this.setChanged();
            this.notifyObservers(posicionArtista);
            this.clearChanged();
        }
    }
        
    public void EliminarLogica(int cantidad){
       for (int i = 0; i < cantidad; i++) {
            CarpetaLogica[posicionLogica] = ' ';
            posicionLogica--;
            this.setChanged();
            this.notifyObservers(posicionLogica);
            this.clearChanged();
        } 
    }
    
    public void EliminarDLC(int cantidad){
        
    for (int i = 0; i < cantidad; i++) {
            CarpetaDLC[posicionDLC] = ' ';
            posicionDLC--;
            this.setChanged();
            this.notifyObservers(posicionDLC);
            this.clearChanged();
        } 
    }
    
    public void EliminarJuegosconDLC(){
      /*  if(posicionJuegosconDLC>0){
        for (int i = posicionJuegosconDLC; i > 0; i--) {
            CarpetaJuegosconDLC[i] = ' ';
            posicionJuegosconDLC--;
            this.setChanged();
            this.notifyObservers("0");
            this.clearChanged();
        } 
        }
        else {
            System.out.println("No hay");
        }*/
    }
    
    public void EliminarJuegossinDLC(){
       /* if(posicionJuegossinDLC>0){
        for (int i = posicionJuegossinDLC; i > 0; i--) {
            CarpetaJuegossinDLC[i] = ' ';
            posicionJuegossinDLC--;
            this.setChanged();
            this.notifyObservers("0");
            this.clearChanged();
        } }
        else{
            System.out.println("No hay");
                }*/
    }
    
    
    
    
    public boolean ComprobarCantidadessinDLC(int cantidad1, int cantidad2, int cantidad3, int cantidad4){
    
        boolean Var1 = posicionNarrativa>cantidad1;
        boolean Var2 = posicionNiveles>cantidad2;
        boolean Var3 = posicionArtista>cantidad3;
        boolean Var4 = posicionLogica>cantidad4;
        
        if(Var1 && Var2 && Var3 && Var4){
        return true;
        }
        else{
        return false;
        }
    }
    
    public boolean ComprobarCantidadesconDLC(int cantidad1, int cantidad2, int cantidad3, int cantidad4, int cantidad5){
    
        boolean Var1 = posicionNarrativa>cantidad1;
        boolean Var2 = posicionNiveles>cantidad2;
        boolean Var3 = posicionArtista>cantidad3;
        boolean Var4 = posicionLogica>cantidad4;
        boolean Var5 = posicionDLC>cantidad5;
        
        if(Var1 && Var2 && Var3 && Var4 && Var5){
        return true;
        }
        else{
        return false;
        }
    }

    
    }
    

