package modelo;

import java.util.*;

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
public class SombrerosDAO {
	public ArrayList obtenerSombrero() {
		ArrayList<String> sombreros = new ArrayList<String>();
		sombreros.add("Mariachi, mexicano, precio:15€");
		sombreros.add("TopHat, Gangster, precio:15€");
		sombreros.add("GorroCoptero, Japones, precio:???€");
		return sombreros;
	}
}
