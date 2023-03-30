package com.guptaji.health;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class DbReadinessHealthCheck implements HealthCheck {

  @Inject private DataSource dataSource;

  @Override
  public HealthCheckResponse call() {
    try {
      Connection connection = dataSource.getConnection();
      // here timeout is in seconds
      if (connection.isValid(2)) {
        return HealthCheckResponse.named(
                "Database is ready to perform CRUD or whatever so do it and get lost")
            .up()
            .build();
      } else {
        return HealthCheckResponse.named("Database is down so get lost").down().build();
      }
    } catch (SQLException throwables) {
      return HealthCheckResponse.named(
              "Abe db connection mai error hai parameters check kr jake. erro -- "
                  + throwables.getMessage())
          .down()
          .build();
    }
  }
}
