package com.marceloscorporation.dscommerce.services;

import com.marceloscorporation.dscommerce.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public void validateSelfOrAdmin(long userId){
        //User me = userService.authenticaded();
        //if (){

       // }

    }


}
