package com.guptaji.proxyInterface;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.guptaji.entity.PostJsonApiEntity;

// Here we will use one config key instead of describing the entire package name in application.yaml

@RegisterRestClient(configKey = "microprofile-config-key")
public interface PostApiClient4ConfigKey {

  @GET
  @Path("/posts")
  @Produces(MediaType.APPLICATION_JSON)
  List<PostJsonApiEntity> getPostJsonApi4Data();
}
