package daos;

import java.sql.*;
import java.util.*;

import constantesSQL.ConstantesSQL;
import masterDAO.MasterDAO;
import modelo.Sombrero;

/**
 * DAO= estandar en java, Data Access Object Un DAO es el elemento desde el que
 * se haecn operaciones tipo CRUD del tipo de dato indicado
 * 
 * SombrerosDAO = registrarSombrero,obtenerSombrero,etc...
 * 
 * PedidosDAO = registrarPedido, etc...
 * 
 * clase Sombrero: indicara que tiene un libro: titulo, desc etc...
 */
public class SombrerosDAO extends MasterDAO {

	public ArrayList<Sombrero> obtenerSombrero() {
		super.conectar();
		ArrayList<Sombrero> sombreros = new ArrayList<Sombrero>();
		try {
			Statement st = super.getCon().createStatement();
			ResultSet rs = st.executeQuery(ConstantesSQL.SQL_OBTENER_SOMBREROS_NOMBRE);
			while (rs.next()) {
				Sombrero s = new Sombrero();
				s.setNombre(rs.getString("nombre"));// nombre de columna de la base de datos
				s.setDesc(rs.getString("description"));
				s.setPrecio(rs.getDouble("precio"));
				sombreros.add(s);
			}

		} catch (SQLException e) {
			System.out.println("Error al obtener los libros");
			e.printStackTrace();
		}
		super.desconectar();
		return sombreros;
	}
}
