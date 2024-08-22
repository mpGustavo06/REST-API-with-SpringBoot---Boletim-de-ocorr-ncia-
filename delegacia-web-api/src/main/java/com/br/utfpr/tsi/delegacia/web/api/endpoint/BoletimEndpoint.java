package com.br.utfpr.tsi.delegacia.web.api.endpoint;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.br.utfpr.tsi.delegacia.web.api.controller.BoletimFurtoController;
import com.br.utfpr.tsi.delegacia.web.api.model.BoletimFurto;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Component
@Path("boletins")
public class BoletimEndpoint {

	@Autowired
	private BoletimFurtoController boletimFurtoController;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@QueryParam("identificador") String identificador, 
						@QueryParam("cidade") String cidade, 
						@QueryParam("periodoOcorrido") String periodoOcorrido) throws SQLException 
	{
		List<BoletimFurto> selecionados = new ArrayList();
		
		if (identificador != null) 
		{
			Optional<BoletimFurto> boletim = boletimFurtoController.procurarPorIdentificador(identificador);
			try 
			{
				return Response.ok(boletim).build();
			} 
			catch (Exception e) 
			{
				return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
			}
		}
		else
		{
			if (cidade == null && periodoOcorrido == null) 
			{
				selecionados = boletimFurtoController.listarBoletins();
			}
			else if (cidade != null && periodoOcorrido == null) 
			{
				selecionados = boletimFurtoController.procurarPorCidade(cidade);
			}
			else if (cidade == null && periodoOcorrido != null) 
			{
				selecionados = boletimFurtoController.procurarPorPeriodo(periodoOcorrido);
			}
			else if (cidade != null && periodoOcorrido != null) 
			{
				List<BoletimFurto> cidades = boletimFurtoController.procurarPorCidade(cidade);
				
				for (BoletimFurto boletim : cidades)
				{
					if (boletim.getPeriodoOcorrido().equalsIgnoreCase(periodoOcorrido)) 
					{
						selecionados.add(boletim);
					}
				}
			}
			
			try 
			{
				return Response.ok(selecionados).build();
			} 
			catch (Exception e) 
			{
				return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
			}
		}
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@ResponseStatus(HttpStatus.CREATED)
	public Response cadastrar(BoletimFurto boletim) 
	{
		boletimFurtoController.cadastrarBoletim(boletim);
		return Response.ok(boletim).build();
	}
	
	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editar(@QueryParam("identificador") String identificador, BoletimFurto boletim)
	{
		BoletimFurto novoBoletim = boletimFurtoController.alterarBoletim(identificador, boletim);
		return Response.ok(novoBoletim).build();
	}
	
	@DELETE
	public Response remover(@QueryParam("identificador") String identificador)
	{
		boletimFurtoController.removerBoletim(identificador);
		return Response.ok().build();
	}
}
