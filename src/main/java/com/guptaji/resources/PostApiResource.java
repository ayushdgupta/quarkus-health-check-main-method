package com.guptaji.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.guptaji.proxyInterface.PostApiClient;
import com.guptaji.proxyInterface.PostApiClient2;
import com.guptaji.proxyInterface.PostApiClient3;
import com.guptaji.proxyInterface.PostApiClient4ConfigKey;

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

  @Inject @RestClient public PostApiClient2 postApiClient2;

  @Inject @RestClient public PostApiClient3 postApiClient3;

  @Inject @RestClient public PostApiClient4ConfigKey postApiClient4ConfigKey;

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllPostData() {
    return Response.ok(postApiClient.getPostJsonApiData()).build();
  }

  @GET
  @Path("/comment")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllCommentData() {
    return Response.ok(postApiClient.getCommentApiData()).build();
  }

  // calling the post API and provide baseURI from application.yaml using package name
  @GET
  @Path("/postAPI2")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllPostDataFromPostApi2() {
    return Response.ok(postApiClient2.getPostJsonApi2Data()).build();
  }

  // Standard Microprofile annotations
  @GET
  @Path("/postAPI3")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllPostDataFromPostApi3() {
    return Response.ok(postApiClient3.getPostJsonApi3Data()).build();
  }

  @GET
  @Path("/postAPI4ConfigKey")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAllPostDataFromPostApi4() {
    return Response.ok(postApiClient4ConfigKey.getPostJsonApi4Data()).build();
  }
}
