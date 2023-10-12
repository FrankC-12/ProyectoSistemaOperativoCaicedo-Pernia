/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoso_caicedo.pernia2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Observer;

/**
 *
 * @author Luisp
 */
public class ProyectoSO_CaicedoPernia2 {

    
    Desarrollador[] HilosCapcom;
    Desarrollador[] HilosBethesda;
    static EmpresaCapcom Empresa1;
    static EmpresaBethesda Empresa2;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        
        Dashboard Interfaz = new Dashboard();
        
        Interfaz.setVisible(true);
        FileReader archivoLecturaC;
        FileReader archivoLecturaB;
        BufferedReader lector;
        BufferedReader lector2;
        
        
        //Se lee el TXT de Capcom
        archivoLecturaC = new FileReader("C:/Users/Luisp/OneDrive/Desktop/ArchivoTXTCapcom.txt");
        if (archivoLecturaC.ready()){
        lector = new BufferedReader(archivoLecturaC);
        String cadena;
        String[] Capcom = new String[8];
        int i = 0;
        while((cadena = lector.readLine())!=null){
        Capcom[i] = cadena;
        i++;
        }
        
        //Se crea el objeto Empresa Capcom
        Empresa1 = new EmpresaCapcom(Integer.parseInt(Capcom[0]),Integer.parseInt(Capcom[1]),Integer.parseInt(Capcom[2]),Integer.parseInt(Capcom[3]),Integer.parseInt(Capcom[4]),Integer.parseInt(Capcom[5]),Integer.parseInt(Capcom[6]),Integer.parseInt(Capcom[7]));
        Empresa1.InicializarHilos();
        Empresa1.ReasignarCantidades();
        
        
        //Se lee el TXT de Bethesda
        archivoLecturaB = new FileReader("C:/Users/Luisp/OneDrive/Desktop/ArchivoTXTBethesda.txt");
        if (archivoLecturaB.ready()){
        lector2 = new BufferedReader(archivoLecturaB);
        String cadena1;
        String[] Bethesda = new String[7];
        int i1 = 0;
        while((cadena1 = lector2.readLine())!=null){
        Bethesda[i1] = cadena1;
        i1++;
        }
        
        //Se crea el objeto Empresa Bethesda
        Empresa2 = new EmpresaBethesda(Integer.parseInt(Bethesda[0]),Integer.parseInt(Bethesda[1]),Integer.parseInt(Bethesda[2]),Integer.parseInt(Bethesda[3]),Integer.parseInt(Bethesda[4]),Integer.parseInt(Bethesda[5]),Integer.parseInt(Bethesda[6]));
        Empresa2.InicializarHilos();
        Empresa2.ReasignarCantidades();
        

        }
        }
        Empresa1.CrearHiloTiempo(Interfaz);
        
        Empresa1.CrearProjectManajer(Interfaz);
        
        
    }
    }
    

