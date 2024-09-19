package daosImpl;

import java.sql.*;
import java.util.*;

import constantesSQL.ConstantesSQL;
import daos.SombrerosDAO;
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
public class SombrerosDAOImpl extends MasterDAO implements SombrerosDAO {

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
				s.setId(rs.getLong("id"));
				sombreros.add(s);
			}

		} catch (SQLException e) {
			System.out.println("Error al obtener los libros");
			e.printStackTrace();
		}
		super.desconectar();
		return sombreros;
	}

	@Override
	public void registrarSombrero(Sombrero s) {
		super.conectar();
		try {
			PreparedStatement ps = super.getCon().prepareStatement(ConstantesSQL.SQL_REGISTRAR_SOMBRERO);
//			ahora en orden, empezando por 1 debo decir que es cada ? de la consulta
			ps.setString(1, s.getNombre());
			ps.setString(2, s.getDesc());
			ps.setDouble(3, s.getPrecio());

			ps.execute();

		} catch (SQLException e) {
			System.out.println("La sql esta mal");
			e.printStackTrace();
		}
		super.desconectar();

	}// end registrar libro

	@Override
	public void borrarSombrero(int id) {
		super.conectar();
		try {
			PreparedStatement ps = super.getCon().prepareStatement(ConstantesSQL.SQL_BORRAR_SOMBRERO);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			System.out.println("SQL ESTA MAL");
			e.printStackTrace();
		}
		super.desconectar();
	}

	@Override
	public void editarSombrero(Sombrero s) {
		// TODO Auto-generated method stub

	}
}
