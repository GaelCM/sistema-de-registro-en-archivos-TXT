/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ventana;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author GaelCM
 */
public class Metodos {
    
    Vector vPrincipal = new Vector();
    
    public void guardarDatos(Datos dato){
        vPrincipal.addElement(dato);
    }
    
    public void guardarArchivo(Datos datos){
        try{
            FileWriter fw= new FileWriter("DataBase.txt",true);
            BufferedWriter bf=new BufferedWriter(fw);
            PrintWriter pw= new PrintWriter(bf);
            pw.print("|"+datos.getNombre());
            pw.print("|"+datos.getAño());
            pw.print("|"+datos.getAutor());
            pw.print("|"+datos.getGenero());
            pw.println("|"+datos.getDiscografica());
            pw.close();
        }catch(Exception a){
         JOptionPane.showMessageDialog(null, "Error al crear el archivo");
        }
    }
    
    
    public DefaultTableModel listaCanciones(){
        
        Vector lista=new Vector();
        
        lista.addElement("Nombre");
        lista.addElement("Año");
        lista.addElement("Autor");
        lista.addElement("Genero");
        lista.addElement("Discografica");
        
        DefaultTableModel tabla=new DefaultTableModel(lista,0);
        
        try{
            FileReader fr= new FileReader("Database.txt");
            BufferedReader br= new BufferedReader(fr);
            String c;
            while((c=br.readLine())!= null){
                StringTokenizer dato= new StringTokenizer(c,"|");
                Vector x=new Vector();
                while(dato.hasMoreTokens()){
                    x.addElement(dato.nextToken());
                }
                tabla.addRow(x);
            }
            
        }catch(Exception b){
            JOptionPane.showMessageDialog(null, "error");
        }
        
        return tabla;
    }
   
    
    
}
