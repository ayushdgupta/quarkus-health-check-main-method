package com.guptaji.health;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.guptaji.proxyInterface.PostApiClient;

@Liveness
@ApplicationScoped
public class CommentApiHealthCheck implements HealthCheck {

  @Inject @RestClient public PostApiClient postApiClient;

  @Override
  public HealthCheckResponse call() {

    postApiClient.getCommentApiData();
    return HealthCheckResponse.named("Comment Json API is ready so do ur operations")
        .up()
        .withData("ApiName", "Comment API")
        .build();
  }
}
