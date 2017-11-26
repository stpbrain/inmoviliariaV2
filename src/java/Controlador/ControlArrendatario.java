/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DB.Conexion;
import Modelo.Departamento;
import Modelo.Edificio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on : 20-nov-2017, 21:51:07
 *  Author     : Kathy
 */
public class ControlArrendatario {

    public static boolean editarResidente(Integer idDpto, String residente) {

        try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("inmobiliaria");
            Statement stms = conexion.createStatement();
            
            String consulta = "UPDATE tb_departamento SET RESIDENTE = UPPER('" + residente + "') WHERE ID_DEPARTAMENTO = " + idDpto;
            
            System.out.println("Fue agregado: "+consulta);
            
            stms.executeUpdate(consulta);           
            
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
     public boolean permisoMunicipal(String numEdificio){
        try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("inmobiliaria");
            Statement stmt = conexion.createStatement();
            
            String consulta = "SELECT posee_perm_mun FROM tb_edificio "
                    + "WHERE id_edificio = " + numEdificio +";";
            
            stmt.executeUpdate(consulta);
            
            int temporal = stmt.executeUpdate(consulta);
             if (temporal != 0)
                 return true;
             else{
                System.out.println("El edificio no cuenta con los permisos municipales necesarios para arrendar.");
                return false;
             }
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }
    
    public boolean buscarEdificio(String numEdificio){
         try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("inmobiliaria");
            Statement stmt = conexion.createStatement();
            
            String consulta = "SELECT id_edificio FROM tb_edificio "
                    + "WHERE id_edificio = " + numEdificio + ";";
            
            stmt.executeUpdate(consulta);
            
            int temporal = stmt.executeUpdate(consulta);
             if (temporal != 0)
                 return true;
             else{
                System.out.println("El ID de edificio no está registrado");
                return false;
             }
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }
    
    public ArrayList ListarDepartamentos(String idEdificio)
    {
        ArrayList<Departamento> listaDepto = new ArrayList<Departamento>();
        try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("inmobiliaria");
            Statement stms = conexion.createStatement();
            
            
            String listar = "SELECT id_departamento, id_edificio, numero, residente FROM tb_departamento WHERE id_EDIFICIO = '"+ idEdificio +"'";
            
            System.out.println(listar);
            
             ResultSet rs = stms.executeQuery(listar);
             
             while(rs.next())
             {
                 Departamento dpto = new Departamento();
                 
                 dpto.setId_departamento(rs.getInt("id_departamento"));
                 dpto.setId_edificio(rs.getString("id_edificio"));
                 dpto.setNumero_d(rs.getInt("numero"));
                 dpto.setResidente(rs.getString("residente"));
                 
                 listaDepto.add(dpto);
             }
             return listaDepto;
            
        } catch (Exception e) {
            e.printStackTrace();
            return listaDepto;
        }
    }
    
    public boolean GuardarDpto(Departamento dpto)
    {
        try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("inmobiliaria");
            Statement stms = conexion.createStatement();
            
            String consulta = "INSERT INTO tb_departamento (ID_EDIFICIO, NUMERO, RESIDENTE) VALUES (UPPER('" + dpto.getId_edificio() +"')," + dpto.getNumero_d() +", UPPER('" + dpto.getResidente() +"'))";
            
            System.out.println("Fue agregado: "+consulta);
            
            stms.executeUpdate(consulta);           
            
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public ArrayList ObtenerIdEdificio()
    {
     ArrayList<Edificio> depa = new ArrayList<Edificio>();
        try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("inmobiliaria");
            Statement stms = conexion.createStatement();
            
            String edificio = "SELECT id_edificio, nom_edificio FROM tb_edificio;";
            
             ResultSet rs = stms.executeQuery(edificio);
             
             while(rs.next())
             {
                 Edificio edif = new Edificio();
                 edif.setId_edificio(rs.getString("id_edificio"));
                 edif.setN_edifico(rs.getString("nom_edificio"));
                 depa.add(edif);
               
             }
             return depa;
            
        } catch (Exception e) {
            e.getStackTrace();
            return depa;
        }
    }
    
    public ArrayList ObtenerDepartamentos()
    {
     ArrayList<Departamento> depa = new ArrayList<Departamento>();
        try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("inmobiliaria");
            Statement stms = conexion.createStatement();
            
            String depto = "SELECT numero FROM tb_departamento;";
            
             ResultSet rs = stms.executeQuery(depto);
             
             while(rs.next())
             {
                 Departamento dpto = new Departamento();
                 dpto.setNumero_d(rs.getInt("numero"));
                 //depa.add(dpto);
               
             }
             return depa;
            
        } catch (Exception e) {
            e.getStackTrace();
            return depa;
        }
    }
    
     public List<Departamento> buscarDepartamento(String numEdificio) {
        List<Departamento> depa = new ArrayList<>();
        try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("inmobiliaria");
            Statement stmt = conexion.createStatement();

            String consulta = "SELECT id_departamento, id_edificio, numero, residente FROM tb_departamento "
                    + "WHERE id_edificio = '" + numEdificio + "'";

            ResultSet rs = stmt.executeQuery(consulta);

            while (rs.next()) {
                Departamento dpto = new Departamento();
                dpto.setId_departamento(rs.getInt("id_departamento"));
                dpto.setId_edificio(rs.getString("id_edificio"));
                dpto.setNumero_d(rs.getInt("numero"));
                dpto.setResidente(rs.getString("residente"));
                depa.add(dpto);
            }

            return depa;

        } catch (Exception e) {
            e.getStackTrace();
        }
        return null;
    }

    public Object ListarEdificios(int idCondominio) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    }    

