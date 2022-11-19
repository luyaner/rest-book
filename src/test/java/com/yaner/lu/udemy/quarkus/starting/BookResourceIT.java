package com.yaner.lu.udemy.quarkus.starting;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusIntegrationTest
public class BookResourceIT extends BookResourceTest {

    @Test
    void shouldGetBookById() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
                .pathParams("id", 1)
        .when()
                .get("/api/books/{id}")
        .then()
                .statusCode(200)
                .body("yearOfPublication", is(1998))
                .body("title", is("Foo"))
                .body("genre", is("IT"));
    }
}
