package com.guptaji.proxyInterface;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.guptaji.entity.PostJsonApiEntity;

// The standard MicroProfile Rest Client properties notation can also be used to configure the
// client:

@RegisterRestClient
public interface PostApiClient3 {

  @GET
  @Path("/posts")
  @Produces(MediaType.APPLICATION_JSON)
  List<PostJsonApiEntity> getPostJsonApi3Data();
}
