package com.example.example_rest.proxy;

import com.example.example_rest.config.ProjectConfig;
import com.example.example_rest.model.Contact;
import com.example.example_rest.model.Response;
import feign.Headers;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "contact", url = "http://localhost:8080/api/contact",
        configuration = ProjectConfig.class)
public interface ContactProxy {

    @RequestMapping(method = RequestMethod.GET, value = "/getMessagesByStatus")
    @Headers(value = "Content-Type: application/json")
    public List<Contact> getMessagesByStatus(@RequestParam("status") String status);



}
