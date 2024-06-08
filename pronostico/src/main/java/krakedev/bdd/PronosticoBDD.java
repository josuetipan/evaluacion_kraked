package krakedev.bdd;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import krakedev.entidades.Paises;
import krakedev.entidades.Partidos;
import krakedev.entidades.Pronostico;
import krakedev.entidades.Usuario;
import krakedev.excepciones.KarkeDevExcepcion;
import krakedev.utils.ConexionBDD;

public class PronosticoBDD {

	public ArrayList<Pronostico> buscar(String subcadena) throws KarkeDevExcepcion{
		ArrayList<Pronostico> pronos = new ArrayList<Pronostico>();
		Connection con = null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		Pronostico pronosticos = null;
		try {
			con = ConexionBDD.obtenerConexion(); 
			ps=con.prepareStatement("SELECT cod_pro, cedula_user, cod_par, cod_equipo1, cod_equipo2, marc_e1, marc_e2"
					+ "	FROM public.pronosticos where cedula_user =  ?");
			ps.setString(1,subcadena);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int codigo = rs.getInt("codigo_pro");
				String cedula = rs.getString("cedula_user");
				int codPartido = rs.getInt("cod_par");
				int codEquipo1 = rs.getInt("cod_equipo1");
				int codEquipo2 = rs.getInt("cod_equipo2");
				int codMarcadorE1 = rs.getInt("marc_e1");
				int codMarcadorE2 = rs.getInt("marc_e2");
				
				Usuario user= new Usuario();
				user.setCedula(cedula);
				Partidos par = new Partidos();
				par.setCodigo(codPartido);
				Paises pas = new Paises();
				pas.setCodigo(codEquipo1);
				Paises pws = new Paises();
				pws.setCodigo(codEquipo2);
				
				pronosticos = new Pronostico();
				pronosticos.setCodigoPro(codigo);
				pronosticos.setCedulaUser(user);
				pronosticos.setCodigoPartido(par);
				pronosticos.setCodigoEquipo1(pas);
				pronosticos.setCodigoEquipo2(pws);
				pronosticos.setMarcadorEquipo1(codMarcadorE1);
				pronosticos.setMarcadorEquipo2(codMarcadorE2);
				
				pronos.add(pronosticos);
				
				
			}
		} catch (KarkeDevExcepcion e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KarkeDevExcepcion("Error al consultar: Detalle:"+e.getMessage());
		}finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return pronos;
	}
	
	public void insertar(Pronostico pronostico) throws KarkeDevExcepcion {
		Connection con = null;
		PreparedStatement ps=null;
		
		try {
			con = ConexionBDD.obtenerConexion();
			ps = con.prepareStatement("INSERT INTO public.pronosticos("
					+ "	cod_pro, cedula_user, cod_par, cod_equipo1, cod_equipo2, marc_e1, marc_e2)"
					+ "	VALUES (?, ?, ?, ?, ?, ?, ?);");
			
			ps.setInt(1,pronostico.getCodigoPro());
			ps.setString(2, pronostico.getCedulaUser().getCedula());
			ps.setInt(3, pronostico.getCodigoPartido().getCodigo());
			ps.setInt(4, pronostico.getCodigoEquipo1().getCodigo());
			ps.setInt(5, pronostico.getCodigoEquipo2().getCodigo());
			ps.setInt(6, pronostico.getMarcadorEquipo1());
			ps.setInt(7, pronostico.getMarcadorEquipo2());
			
			ps.executeUpdate();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new KarkeDevExcepcion("Error al insertar pronostico");
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
