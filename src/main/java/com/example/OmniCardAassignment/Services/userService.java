package com.example.OmniCardAassignment.Services;


import com.example.OmniCardAassignment.Modals.User;
import com.example.OmniCardAassignment.Repositories.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class userService {
    @Autowired
    private userRepository user_repository;


    @CacheEvict(value = "listOfEmailsByPattern", allEntries = true)
    public String addUserData(User user)
    {
        user_repository.save(user);
        return "added successfully";
    }


    @Cacheable("listOfEmailsByPattern")
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
