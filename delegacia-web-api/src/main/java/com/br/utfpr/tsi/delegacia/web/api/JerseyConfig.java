package com.br.utfpr.tsi.delegacia.web.api;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import com.br.utfpr.tsi.delegacia.web.api.endpoint.BoletimFurtoEndpoint;
import jakarta.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		this.register(BoletimFurtoEndpoint.class);
		this.register(ConteinersInterceptor.class);
	}
}