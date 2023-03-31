package com.guptaji.proxyInterface;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.guptaji.entity.PostJsonApiEntity;

// we will use different methods to provide the base URI
@RegisterRestClient
public interface PostApiClient2 {

  @GET
  @Path("/posts")
  @Produces(MediaType.APPLICATION_JSON)
  List<PostJsonApiEntity> getPostJsonApi2Data();
}
