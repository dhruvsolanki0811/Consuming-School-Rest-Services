package com.example.example_rest.controller;

import com.example.example_rest.model.Contact;
import com.example.example_rest.model.Response;
import com.example.example_rest.proxy.ContactProxy;
import feign.Headers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
public class ContactController {

    @Autowired
    ContactProxy contactProxy;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    WebClient webClient;


    @GetMapping("/getMessages")
    public List<Contact> getMessageByStatus(@RequestParam("status") String status){
        return contactProxy.getMessagesByStatus(status);
    }

    @PostMapping("/saveMsg")
    public ResponseEntity<Response> responseEntity(@RequestBody Contact contact){
        String uri="http://localhost:8080/api/contact/saveMsg";
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.add("invocationFrom","RestController");
        HttpEntity<Contact> httpEntity= new HttpEntity<>(contact,httpHeaders);
        ResponseEntity<Response> responseEntity=restTemplate.exchange(uri, HttpMethod.POST,httpEntity,Response.class);
        return responseEntity;

    }

    @PostMapping("/saveMessage")
    public Mono<Response> saveMessage(@RequestBody Contact contact){
        String uri = "http://localhost:8080/api/contact/saveMsg";
        return webClient.post().uri(uri)
                .header("invocationFrom","WebClient")
                .body(Mono.just(contact),Contact.class)
                .retrieve()
                .bodyToMono(Response.class);
    }



}
