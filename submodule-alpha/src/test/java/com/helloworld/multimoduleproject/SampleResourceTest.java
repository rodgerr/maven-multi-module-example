package com.helloworld.multimoduleproject;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SampleResourceTest {

    @Autowired
    Environment environment;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void sayHello() {
        String port = environment.getProperty("local.server.port");

        // Erstellen Sie die URL für den HTTP-Aufruf
        String url = "http://localhost:" + port + "/hello-world?name=JohnDoe";

        // Senden Sie den HTTP-Aufruf und speichern Sie die Antwort
        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        // Überprüfen Sie, ob der Statuscode der Antwort 200 OK ist
        assertEquals(200, response.getStatusCodeValue());

        // Überprüfen Sie, ob der Inhalt der Antwort der Erwartung entspricht
        assertEquals("hello JohnDoe", response.getBody());
    }
}