package com.br.utfpr.tsi.delegacia.web.api;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import com.br.utfpr.tsi.delegacia.web.api.endpoint.BoletimEndpoint;
import com.br.utfpr.tsi.delegacia.web.api.endpoint.VeiculoEndpoint;

import jakarta.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		this.register(ConteinersInterceptor.class);
		this.register(BoletimEndpoint.class);
		this.register(VeiculoEndpoint.class);
	}
}