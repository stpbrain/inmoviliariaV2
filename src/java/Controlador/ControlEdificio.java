/*
 * To change this license header, choose License Headers in Project Properties.
 * To change t
his template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DB.Conexion;
import Modelo.Comuna;
import Modelo.Edificio;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author papalominos
 */
public class ControlEdificio {
    
    public ArrayList ObtererComuna()
    {
     ArrayList<Comuna> com = new ArrayList<Comuna>();
        try {
                    Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("inmobiliaria");
            Statement stms = conexion.createStatement();
            
            String comunas = "SELECT ID_COMUNA,DESCRIPCION FROM tb_comuna;";
            
             ResultSet rs = stms.executeQuery(comunas);
             
             while(rs.next())
             {
                 Comuna c = new Comuna();
                 c.setId(rs.getInt("ID_COMUNA"));
                 c.setN_comuna(rs.getString("DESCRIPCION"));
                 com.add(c);
             }
             return com;
            
        } catch (Exception e) {
            e.getStackTrace();
            return com;
        }
    }
    
    public boolean InsertarEdificio(Edificio ed)
    {
        try {
              Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("inmobiliaria");
            Statement stms = conexion.createStatement();
            
       String ins = "INSERT tb_edificio VALUE ('"+ed.getId_edificio()+"','"+ed.getN_edifico()+"','"+ed.getDireccion()+"',"+ed.getId_comuna()+","+ed.getPosee_permiso()+");";
            
             stms.executeUpdate(ins);
           
            
            System.out.println("esta es la query =>"+ins);
            return true;
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    }
    
    public ArrayList ListarEdificios(int cod)
    {
        ArrayList<Edificio> list_edi = new ArrayList<Edificio>();
        try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("inmobiliaria");
            Statement stms = conexion.createStatement();
            
            
            String listar = "SELECT ID_EDIFICIO, NOM_EDIFICIO, DIRECCION, ID_COMUNA, POSEE_PERM_MUN FROM tb_edificio WHERE ID_COMUNA = "+cod+"; ";
            
             ResultSet rs = stms.executeQuery(listar);
             
             while(rs.next())
             {
                 Edificio e = new Edificio();
                 
                 e.setId_edificio(rs.getString("ID_EDIFICIO"));
                 e.setN_edifico(rs.getString("NOM_EDIFICIO"));
                 e.setDireccion(rs.getString("DIRECCION"));
                 e.setId_comuna(rs.getInt("ID_COMUNA"));
                 e.setPosee_permiso(rs.getInt("POSEE_PERM_MUN"));
                 
                 list_edi.add(e);
             }
             return list_edi;
            
        } catch (Exception e) {
            e.getStackTrace();
            return list_edi;
        }
    }
    public String TraeComuna( int com)
    {
        String comuna = "";
        try {
             Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("inmobiliaria");
            Statement stms = conexion.createStatement();
            
            
            String listar = "SELECT DESCRIPCION FROM tb_comuna WHERE ID_COMUNA = "+com+"; ";
            
             ResultSet rs = stms.executeQuery(listar);
             System.out.println("query lista=>"+listar);
             while(rs.next())
             {
                 comuna = rs.getString("DESCRIPCION");
                 
             }
             return comuna;
             
            
        } catch (Exception e) {
            e.getStackTrace();
            return comuna;
        }
    
    }
    
    public void Hablitar(String id)
    {
        try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("inmobiliaria");
            Statement stms = conexion.createStatement();
            String hab = "UPDATE tb_edificio set posee_perm_mun = 1 WHERE id_edificio = '"+id+"';";
            
            stms.executeUpdate(hab);
            
            
        } catch (Exception e) {
            e.getStackTrace();
        }
    }   
    public boolean modEdificio(Edificio enuevo, Edificio eori)
    {
        
             try {
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("inmobiliaria");
            Statement stms = conexion.createStatement();
            String n,d;
            int p;
            
            if(!eori.getN_edifico().equals(enuevo.getN_edifico()))
            {
                n = enuevo.getN_edifico();
            }else {n = eori.getN_edifico(); }
            if(!eori.getDireccion().equals(enuevo.getDireccion()))
            {
                d = enuevo.getDireccion();
            }else {d = eori.getDireccion();}
            if(enuevo.getPosee_permiso() == 3)
            {
                p = eori.getPosee_permiso();
            }else{p = enuevo.getPosee_permiso();}
            
            
            String act = "UPDATE tb_edificio set NOM_EDIFICIO = '"+n+"', DIRECCION = '"+d+"',POSEE_PERM_MUN = "+p+"  WHERE ID_EDIFICIO = '"+eori.getId_edificio()+"' AND NOM_EDIFICIO = '"+eori.getN_edifico()+"';";
            stms.executeUpdate(act);
             return true;
            
             
            
        } catch (Exception e) {
            e.getStackTrace();
            return false;
        }
    
    }
}
