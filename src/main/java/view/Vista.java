package view;


import java.sql.SQLException;
import java.util.ArrayList;

import controller.Controlador;
import model.vo.Lider;
import model.vo.Proyecto;

public class Vista {
    //Instanciamos el controlador de manera estatica
    public static final Controlador controlador = new Controlador();
    //generamos la vista para el requerimiento 1
    public static void vista_requerimiento_1() {

        try {
            //Lista para la consulta del requerimiento1
            ArrayList<Proyecto> proyectos = controlador.Solucionar_requerimiento_1();
            //Recorremos la lista para mostrar la informacion de las consultas
            for (int i = 0; i < proyectos.size(); i++) {
                //Datos para mostrar en Consola
                String info = "Fecha_Inicio: " + proyectos.get(i).getFecha_inicio();
                info += " - Numero_Habitaciones: " + proyectos.get(i).getNum_habitaciones();
                info += " - Clasificación: " + proyectos.get(i).getClasificacion();
                //Imprimir los datos iterador del array List
                System.out.println(info);

            }

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }

    }
    //generamos la vista para el requerimiento 2
    public static void vista_requerimiento_2() {
        try {
            //Lista para la consulta del requerimiento2
            ArrayList<Proyecto> proyectos = controlador.Solucionar_requerimiento_2();
            //Recorremos la lista para mostrar la informacion de las consultas
            for (int i = 0; i < proyectos.size(); i++) {
                //Datos para mostrar en Consola
                String info = "Fecha_Inicio: " + proyectos.get(i).getFecha_inicio();
                info += " - Numero_Habitaciones: " + proyectos.get(i).getNum_habitaciones();
                info += " - Clasificación: " + proyectos.get(i).getClasificacion();
                info += " - Nombre_Lider: " + proyectos.get(i).getLider().getNombre();
                info += " - Apellido_Lider: " + proyectos.get(i).getLider().getApellido();
                info += " - Estrato_Proyecto: " + proyectos.get(i).getEstrato_proyecto();
                //Imprimir los datos iterado del array List
                System.out.println(info);

            }

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
        

    }
    //generamos la vista para el requerimiento 3
    public static void vista_requerimiento_3() {
        try {
            //Lista para la consulta del requerimiento3
            ArrayList<Proyecto> proyectos = controlador.Solucionar_requerimiento_3();
            //Recorremos la lista para mostrar la informacion de las consultas
            for (int i = 0; i < proyectos.size(); i++) {
                //Datos para mostrar en Consola
                String info = "Condominios: " + proyectos.get(i).getNum_condominios();
                info += " - Constructora: " + proyectos.get(i).getNombre_constructora();
                
                //Imprimir los datos iterado del array List
                System.out.println(info);

            }

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
   
        
    }

    public static void vista_requerimiento_4() {
        try {
            //Lista para la consulta del requerimiento2
            ArrayList<Lider> lideres = controlador.Solucionar_requerimiento_4();
            //Recorremos la lista para mostrar la informacion de las consultas
            for (int i = 0; i < lideres.size(); i++) {
                //Datos para mostrar en Consola
                String info = "Nombre_Lider: " + lideres.get(i).getNombre() + 
                " - Apellido_Lider: " + lideres.get(i).getApellido();
                //Imprimir los datos iterado del array List
                System.out.println(info);

            }

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
        
    }

    public static void vista_requerimiento_5() {
        try {
            //Lista para la consulta del requerimiento5
            ArrayList<Proyecto> proyectos = controlador.Solucionar_requerimiento_5();
            //Recorremos la lista para mostrar la informacion de las consultas
            for (int i = 0; i < proyectos.size(); i++) {
                //Datos para mostrar en Consola
                String info = "Condominios: " + proyectos.get(i).getNum_condominios();
                info += " - Constructora: " + proyectos.get(i).getNombre_constructora();
                
                //Imprimir los datos iterado del array List
                System.out.println(info);

            }

        } catch (SQLException e) {
            System.err.println("Ha ocurrido un error!" + e.getMessage());
        }
        
    }

}
