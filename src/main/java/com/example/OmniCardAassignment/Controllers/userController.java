package com.example.OmniCardAassignment.Controllers;


import com.example.OmniCardAassignment.Modals.User;
import com.example.OmniCardAassignment.Services.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/OmniCard")
public class userController {

    @Autowired
    private userService user_service;


    @PostMapping("/addUserData")
    public ResponseEntity addUserData(@RequestBody User user)
    {

        try{
            String result = user_service.addUserData(user);
            return new ResponseEntity(result, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }

    }


    @GetMapping("/getEmailsByPattern")
    public ResponseEntity getEmailsByPattern(@RequestParam String pattern)
    {

        try{
            List<String>emailsList = user_service.getEmailsByPattern(pattern);
            return new ResponseEntity(emailsList,HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
