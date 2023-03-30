package com.guptaji.health;

import javax.inject.Inject;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.guptaji.proxyInterface.PostApiClient;

@Liveness
public class JsonApiLiveHealthCheck implements HealthCheck {

  @Inject @RestClient public PostApiClient postApiClient;

  @Override
  public HealthCheckResponse call() {
    postApiClient.getPostJsonApiData();

    // so here if you see we are not checking whether any exception came during API call or not
    // because that
    // part will be taken care by the our @Liveness annotation so no need for us to worry about that
    // part.
    return HealthCheckResponse.named("Post Json API is ready so do ur operations").up().build();
  }
}
