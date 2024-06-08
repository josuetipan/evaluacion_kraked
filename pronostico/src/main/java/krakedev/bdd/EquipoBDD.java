package krakedev.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import krakedev.entidades.Paises;
import krakedev.excepciones.KarkeDevExcepcion;
import krakedev.utils.ConexionBDD;

public class EquipoBDD {
	public void insertar(Paises paises) throws KarkeDevExcepcion {
		Connection con = null;
		PreparedStatement ps=null;
		
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("INSERT INTO public.paises("
					+ "	codigo_int, nombre)"
					+ "	VALUES (?, ?);");
			
			ps.setInt(1,paises.getCodigo());
			ps.setString(2, paises.getNombre());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KarkeDevExcepcion("Error al insertar equipo");
		} catch (KarkeDevExcepcion e) {
			throw e;
		}finally {
			if(con!=null) {	
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	
	
	
}
