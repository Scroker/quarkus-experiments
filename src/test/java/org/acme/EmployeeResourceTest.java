package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;


@QuarkusTest
public class EmployeeResourceTest {

    @Test
    public void testEmployeeZero() {
        given()
          .when().get("/api/employee/0")
          .then()
             .statusCode(200)
             .body(is("{\"id\":0,\"name\":\"Giorgio\",\"surname\":\"Dramis\"}"));
    }
   
    @Test
    public void testEmployeeOne() {
        given()
          .when().get("/api/employee/1")
          .then()
            .statusCode(200)
            .body(is("{\"id\":1,\"name\":\"Bianca\",\"surname\":\"Buzzi\"}"));
    }

}