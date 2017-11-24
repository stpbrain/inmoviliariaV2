/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author papalominos
 */
public class Edificio {
    
    String id_edificio,n_edifico,direccion;
    int id_comuna;
    int posee_permiso; // la variable en la BD es bool , pero se maneja con 0 = false y 1= true  

    public void Init() {
        this.id_edificio = "";
        this.n_edifico = "";
        this.direccion = "";
       
        this.id_comuna = 0;
        this.posee_permiso = 0;
    }
    public Edificio()
    {
       Init();
    }

    public String getId_edificio() {
        return id_edificio;
    }

    public void setId_edificio(String id_edificio) {
        this.id_edificio = id_edificio;
    }

    public String getN_edifico() {
        return n_edifico;
    }

    public void setN_edifico(String n_edifico) {
        this.n_edifico = n_edifico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getId_comuna() {
        return id_comuna;
    }

    public void setId_comuna(int id_comuna) {
        this.id_comuna = id_comuna;
    }

    public int getPosee_permiso() {
        return posee_permiso;
    }

    public void setPosee_permiso(int posee_permiso) {
        this.posee_permiso = posee_permiso;
    }
            
    
    
    
    
}
