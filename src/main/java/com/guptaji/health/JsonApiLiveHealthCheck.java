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
public class JsonApiLiveHealthCheck implements HealthCheck {

  @Inject @RestClient public PostApiClient postApiClient;

  @Override
  public HealthCheckResponse call() {
    postApiClient.getPostJsonApiData();

    // Here we commented the health check of comment API because whenever there will be an error our code on
    // ui-side was not able to show error in which API it is coming so we created another class with @liveness
    // annotation to handle this problem. May be in future i'll get some technique to achieve this in one single
    // class, so till then wait.
    //    postApiClient.getCommentApiData();

    // so here if you see we are not checking whether any exception came during API call or not
    // because that
    // part will be taken care by the our @Liveness annotation so no need for us to worry about that
    // part. but we can also put this under try catch to handle and show the proper error to the user.
    return HealthCheckResponse.named("Post Json API is ready so do ur operations").up().build();
  }
}
