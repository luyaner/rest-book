package com.yaner.lu.udemy.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class BookResourceTest {

    @Test
    void shouldGetAllBooks() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON)
        .when()
                .get("/api/books")
        .then()
                .statusCode(200).body("size()", is(2));
    }

    @Test
    void shouldCountAllBooks() {
        given()
                .header(HttpHeaders.ACCEPT, MediaType.TEXT_PLAIN)
        .when()
                .get("/api/books/count")
        .then()
                .statusCode(200).body(is("2"));
    }

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
                .body("genre", is("Information Technology"));
    }
}