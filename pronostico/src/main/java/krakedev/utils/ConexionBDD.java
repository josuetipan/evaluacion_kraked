package krakedev.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import krakedev.excepciones.KarkeDevExcepcion;



public class ConexionBDD {

	public static Connection obtenerConexion() throws KarkeDevExcepcion {
		Context ctx = null;
		DataSource ds = null;
		Connection con = null;

		try {
			ctx = new InitialContext();
			ds = (DataSource) ctx.lookup("java:/comp/env/jdbc/Partidos");
			con = ds.getConnection();
		} catch (NamingException | SQLException e) {
			e.printStackTrace();
			throw new KarkeDevExcepcion("Error de conexión");
		}
		return con;
	}
}
