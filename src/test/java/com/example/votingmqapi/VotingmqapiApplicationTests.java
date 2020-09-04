package com.example.votingmqapi;

import com.example.votingmqapi.VoteController.VoteController;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.net.URISyntaxException;

@RunWith(SpringRunner.class)
@Import(VoteController.class)
@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
class VotingmqapiApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private TestRestTemplate restTemplate;


    @LocalServerPort
    int serverPort;

    @Test
    public void testAddVotePostRequest() throws URISyntaxException, JSONException {

        final String baseUrl = "http://localhost:" + serverPort + "/vote";
        URI uri = new URI(baseUrl);

        JSONObject body = new JSONObject();
        body.put("animal", "dog");

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(body.toString(), headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
    }

    @Test
    public void testCouldNotPlaceVote() throws URISyntaxException, JSONException {

        final String baseUrl = "http://localhost:" + serverPort + "/vote";
        URI uri = new URI(baseUrl);

        JSONObject body = new JSONObject();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> request = new HttpEntity<>(body.toString(), headers);

        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);

        Assert.assertEquals(200, result.getStatusCodeValue());
        Assert.assertEquals("Could not place the vote", result.getBody());
    }

}
