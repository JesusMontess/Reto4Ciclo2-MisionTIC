package model.dao;

//Estructura de datos
import java.util.ArrayList;

import javax.xml.transform.Result;

//Librerías para SQL y Base de Datos
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;

//Clase para conexión
import util.JDBCUtilities;

//Encapsulamiento de los datos
import model.vo.Lider;

public class LiderDao {

    public ArrayList<Lider> query_requerimiento_4() throws SQLException {
        //Conexion con la BD
        Connection conexion = JDBCUtilities.getConnection();
        //Creamos un Arreglo para para almacenar objetos tipo proyecto
        ArrayList<Lider> lideres = new ArrayList<Lider>();
        //Consultas
        try {
            //Ejecuta la consulta query
            ResultSet query = conexion.createStatement().executeQuery(
                "SELECT l.Nombre, l.Primer_Apellido FROM Proyecto p INNER JOIN Lider l ON l.ID_Lider = p.ID_Lider WHERE p.Ciudad = 'Manizales'"
            );
            //while Recorre los resultados del Query
            while (query.next()){
                //Almacenamos los resultados del query en un objeto Lider
                Lider objLider = new Lider(query.getString("Nombre"), query.getString("Primer_Apellido"));
                //Agregamos el objeto al arrayList
                lideres.add(objLider);

            }
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
        //Retornamos el ArrayList Lideres
        return lideres;
        
    }// Fin del método query_requerimiento_4

}