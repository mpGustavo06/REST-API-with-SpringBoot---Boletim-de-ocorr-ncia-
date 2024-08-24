package com.br.utfpr.tsi.delegacia.web.api.endpoint;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.br.utfpr.tsi.delegacia.web.api.controller.VeiculoController;
import com.br.utfpr.tsi.delegacia.web.api.model.Veiculo;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Component
@Path("veiculos")
public class VeiculoEndpoint {
	@Autowired(required = false)
	private VeiculoController veiculoController;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response listarVeiuculosRoubados(@QueryParam("placa") String placa, 
											@QueryParam("cor") String cor, 
											@QueryParam("tipo") String tipo) throws Exception
	{
		List<Veiculo> selecionados = new ArrayList<>();
		
		if (placa != null) 
		{
			Veiculo veiculo = veiculoController.procurarPorPlaca(placa);
			try 
			{
				return Response.ok(veiculo).build();
			} 
			catch (Exception e) 
			{
				return Response.status(Response.Status.NOT_FOUND).entity(e.getMessage()).build();
			}
		}
		else
		{
			if (cor == null && tipo == null) 
			{
				selecionados = veiculoController.listarVeiculos();
			}
			else if (cor != null && tipo == null) 
			{
				selecionados = veiculoController.procurarPorCor(cor);
			}
			else if (cor == null && tipo != null) 
			{
				selecionados = veiculoController.procurarPorTipo(tipo);
			}
			else if (cor != null && tipo != null) 
			{
				List<Veiculo> cores = veiculoController.procurarPorCor(cor);
				
				for (Veiculo veic : cores) 
				{
					if (veic.getTipoVeiculo().equalsIgnoreCase(tipo)) 
					{
						selecionados.add(veic);
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
}
