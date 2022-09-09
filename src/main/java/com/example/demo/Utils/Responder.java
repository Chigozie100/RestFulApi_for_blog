package com.example.demo.Utils;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Responder {
    public ResponseEntity<String> ok(){
        return new ResponseEntity<>("Request Successful", HttpStatus.OK);
    }

    public ResponseEntity<String> notFound(){
        return new ResponseEntity<>("Request not found", HttpStatus.NOT_FOUND);
    }
}

