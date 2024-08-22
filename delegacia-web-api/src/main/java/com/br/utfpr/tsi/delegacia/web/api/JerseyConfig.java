package com.br.utfpr.tsi.delegacia.web.api;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;
import com.br.utfpr.tsi.delegacia.web.api.endpoint.BoletimEndpoint;
import jakarta.ws.rs.ApplicationPath;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		this.register(BoletimEndpoint.class);
		this.register(ConteinersInterceptor.class);
	}
}