package com.guptaji.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.guptaji.proxyInterface.PostApiClient;

@Path("/postApi")
public class PostApiResource {

  /*
  Here in this API we are checking the liveness our API and the readiness of our DB i.e. the API that we want to
  call is live or not and the DB with which we want to perform CRUD operations is ready or not.

  url to check health and liveness data
  http://localhost:8086/q/health  for all liveness and readiness
  http://localhost:8086/q/health/live for liveness annotation
  http://localhost:8086/q/health/ready for readiness annotation
  http://localhost:8086/q/health-ui/ for health ui

   */

  @Inject @RestClient public PostApiClient postApiClient;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllPostData() {
    return Response.ok(postApiClient.getPostJsonApiData()).build();
  }
}
