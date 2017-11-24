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
public class Comuna {
    
    int id;
    String n_comuna;

    public void Init() {
        this.id = 0;
        this.n_comuna = "";
    }
    public Comuna()
    {
        Init();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getN_comuna() {
        return n_comuna;
    }

    public void setN_comuna(String n_comuna) {
        this.n_comuna = n_comuna;
    }

   
    
    
}
