/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DB.Conexion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
/**
 *
 * @author pc-ccarreno
 */
public class ControlUsuario {
    
    public static boolean registrarUsuario(Usuario usuario)
    {
        try {
            
            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("inmobiliaria");
            Statement stms = conexion.createStatement();
            
            String hashedPass = convierteMD5(usuario.getPass());
            usuario.setPass(hashedPass);
            
            String sql = "INSERT into tb_usuario VALUES (UPPER('" + usuario.getRut() + "')," + 
                    "UPPER('" + usuario.getN_usuario() + "'), '" + hashedPass + "')";
            
            System.out.println("CREAR USUARIO => "+ sql);
            
            stms.executeUpdate(sql);
                    
            return true;
            
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Usuario validaLogin(String nomUsuario, String contrasena) {
        
        Usuario usuario = null;
        
        try {

            Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("inmobiliaria");
            Statement stms = conexion.createStatement();
            
            String hashedPass = convierteMD5(contrasena);

            String sql = "SELECT *  FROM tb_usuario WHERE NOM_USUARIO = UPPER('" + nomUsuario + "') AND CONTRASENA = '" + hashedPass + "'";
            
            System.out.println("consulta = " + sql);
            
            ResultSet rs = stms.executeQuery(sql);

            if (rs != null && rs.next()) {
                
                usuario = new Usuario();
                usuario.setRut(rs.getString("RUT"));
                usuario.setN_usuario(rs.getString("NOM_USUARIO"));
                usuario.setPass(rs.getString("CONTRASENA"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return usuario;
    }

    static String convierteMD5(String contrasena) {
        
        try {
            
            java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
            byte[] array = md.digest(contrasena.getBytes());
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < array.length; ++i) {
                sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
            }
            return sb.toString();
            
        } catch (java.security.NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public ArrayList ListarUsuario()
    {
        ArrayList<Usuario> lu = new ArrayList<Usuario>();
        
        try {
             Conexion conn = new Conexion();
            Connection conexion = conn.getConnection("inmobiliaria");
            Statement stms = conexion.createStatement();
            
            String listUser = "Select rut, nom_usuario from tb_usuario ;";
            
             ResultSet rs = stms.executeQuery(listUser);

            if (rs != null && rs.next()) {
                
                Usuario u = new Usuario();
                u.setRut(rs.getString("rut"));
                u.setN_usuario(rs.getString("nom_usuario"));
                u.setPass("");
                lu.add(u);
            }
            
            return lu;
            
        } catch (Exception e) {
            e.getStackTrace();
            return lu;
        }
    
    
    }
}
