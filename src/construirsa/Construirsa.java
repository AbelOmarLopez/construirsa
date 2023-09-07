/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package construirsa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


/**
 *
 * @author aolopez
 */
public class Construirsa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost/construirsa", "root", "");

            String sql = "select * from herramienta where stock > 0";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                System.out.println("id: " + resultado.getInt("idHerramienta"));
                System.out.println("nombre:" + resultado.getString("nombre"));
                System.out.println("stock:" + resultado.getInt("stock"));
                System.out.println("-------------------------------------");

            }

        


        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null,"Error en drivers de coneccion");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error en la conexion");
        } 
        
        
    }
    
    
            //para insertar empleaados
             /*   String sql= "INSERT INTO empleado(dni,apellido,nombre,acceso,esstado) VALUES (22554771,'Ilacqua','Claudio',3,true)";
            PreparedStatement ps= conn.prepareStatement(sql);
            int filas=ps.executeUpdate();
            if (filas>0) {
             JOptionPane.showMessageDialog(null,"empleado cargado exitosamente");
             }*/
    
              //insertar herramienta
               // String sql= "INSERT INTO herramienta(nombre,descripcion,stock,estado) VALUES ('Autoelevador','autoelevador 4500kg',2,true)" ; 
            //PreparedStatement ps= conn.prepareStatement(sql);
            //int filass=ps.executeUpdate();
                 //  if (filass>0) {
                   //     JOptionPane.showMessageDialog(null,"Herramienta cargada exitosamente");
}
