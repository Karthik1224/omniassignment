package com.example.OmniCardAassignment.Services;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.OmniCardAassignment.Modals.User;
import com.example.OmniCardAassignment.Repositories.userRepository;

@Service
public class userService {
    @Autowired
    private userRepository user_repository;


    
    public String addUserData(User user)
    {
        user_repository.save(user);
        return "added successfully";
    }


   
    public List<String> getEmailsByPattern(String pattern) throws Exception
    {
        List<User> list = user_repository.findAll();
        if(list.isEmpty())
        {
            throw new Exception("We don't have any user data");
        }
        List<String>emailList = new ArrayList<>();
        for(User user :list)
        {
            String email = user.getUserEmail();
            if(email.contains(pattern))
            {
                emailList.add(email);
            }
        }
        return emailList;

    }
}
