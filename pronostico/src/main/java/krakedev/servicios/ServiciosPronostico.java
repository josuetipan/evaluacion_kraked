package krakedev.servicios;

import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import krakedev.bdd.PronosticoBDD;
import krakedev.entidades.Pronostico;
import krakedev.excepciones.KarkeDevExcepcion;

@Path("pronostico")
public class ServiciosPronostico {

	@Path("registrar")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response crear(Pronostico pros) {
		PronosticoBDD prosBDD = new PronosticoBDD();
		try {
			prosBDD.insertar(pros);
			return Response.ok().build();
		} catch (KarkeDevExcepcion e) {
			e.printStackTrace();
			return Response.serverError().build();
		}
	}
	
	@Path("buscar/{usuario}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response buscar(@PathParam("usuario") String subcadena){
		PronosticoBDD prodBDD = new PronosticoBDD();
		ArrayList<Pronostico> pronos =null;
		try {
			pronos = prodBDD.buscar(subcadena);
			return Response.ok(pronos).build();
		} catch (KarkeDevExcepcion e) {
			e.printStackTrace();
			return Response.serverError().build();	
		}
	}
	
}
