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
public class Departamento {
    
    int id_departamento,numero_d;
    String id_edificio,residente;

    public void Init() {
        this.id_departamento = 0;
        this.numero_d = 0;
        this.id_edificio = "";
        this.residente = "";
    }
    
    public Departamento()
    {
        Init();
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public int getNumero_d() {
        return numero_d;
    }

    public void setNumero_d(int numero_d) {
        this.numero_d = numero_d;
    }

    public String getId_edificio() {
        return id_edificio;
    }

    public void setId_edificio(String id_edificio) {
        this.id_edificio = id_edificio;
    }

    public String getResidente() {
        return residente;
    }

    public void setResidente(String residente) {
        this.residente = residente;
    }
    
    
    
    
    
}
