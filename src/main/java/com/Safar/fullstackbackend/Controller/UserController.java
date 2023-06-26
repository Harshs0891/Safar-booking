package com.Safar.fullstackbackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Safar.fullstackbackend.Exception.UserNotFoundException;
import com.Safar.fullstackbackend.Model.User;
import com.Safar.fullstackbackend.Repository.UserRepository;

@RestController  // used to define a RESTful controller
// @CrossOrigin("https://safar-boolean-autocrats.netlify.app/") //allows our web application running in one domain to access resources (such as APIs) on a different domain
public class UserController {
    
    @Autowired //for automatic dependency injection
    private UserRepository userRepository;

    @PostMapping("/user") //for http post request
    User newUser(@RequestBody User newUser){
        return userRepository.save(newUser);
    }

    @GetMapping("/users") //for http get request for all users
    List<User>getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}") //for getting user by their id
    User getUserById(@PathVariable Long id){
        return userRepository.findById(id)
                .orElseThrow(()->new UserNotFoundException(id));
    }

    @PutMapping("/user/{id}") //for editing the old data
    User updatUser(@RequestBody User newUser, @PathVariable Long id){ //RequestBody :- to bind the HTTP request body to a method parameter in a controller / 
        // PathVariable :- to extract values from parts of the URL path and bind them to method parameters in a controller
        return userRepository.findById(id)
                .map(user -> {
                    user.setName(newUser.getName());
                    user.setEmail(newUser.getEmail());
                    user.setAddress(newUser.getAddress());
                    user.setUserPhone(newUser.getUserPhone());
                    user.setUserDestination(newUser.getUserDestination());
                    user.setUserCount(newUser.getUserCount());
                    user.setuserName(newUser.getuserName());
                    user.setUserLeavingDate(newUser.getUserLeavingDate());

                    return userRepository.save(user);
                }).orElseThrow(()->new UserNotFoundException(id));//exception handling
    }

    @DeleteMapping("/user/{id}") //for deleting the data from database
    String deleteUser(@PathVariable Long id){
        if(!userRepository.existsById(id)){ //excetipion handling
            throw new UserNotFoundException(id);
        }

        userRepository.deleteById(id);

        return "Booking with id "+id+"has been deleted successfully"; //message on successfully deletion
    }


}
