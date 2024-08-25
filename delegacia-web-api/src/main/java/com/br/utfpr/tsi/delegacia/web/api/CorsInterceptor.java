package com.br.utfpr.tsi.delegacia.web.api;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;
import java.util.List;

@Provider
public class CorsInterceptor implements ContainerResponseFilter {
   private final Integer corsPreflightMaxAgeInSeconds = 1800;

   public void filter(ContainerRequestContext request, ContainerResponseContext response) throws IOException {
      response.getHeaders().add("Access-Control-Allow-Origin", request.getHeaderString("origin"));
      response.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");
      response.getHeaders().add("Access-Control-Allow-Credentials", "true");
      
      List<String> allowedHeaders = (List)request.getHeaders().get("Access-Control-Request-Headers");
      
      if (allowedHeaders != null) {
    	  for (String allowedHeader : allowedHeaders) {
				response.getHeaders().add("Access-Control-Allow-Headers", allowedHeader);
    	  }
      }

      response.getHeaders().add("Access-Control-Max-Age", this.corsPreflightMaxAgeInSeconds);
   }
}