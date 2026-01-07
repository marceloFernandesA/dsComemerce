package com.marceloscorporation.dscommerce.services;

import com.marceloscorporation.dscommerce.entities.User;
import com.marceloscorporation.dscommerce.services.execeptions.ForbiddenException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;

@Service
public class AuthService {

    @Autowired
    private UserService userService;

    public void validateSelfOrAdmin(long userId) throws ForbiddenException {
        User me = userService.authenticated();
        if (!me.hasRole("ADMIN") && !me.getId().equals(userId)){
            throw new ForbiddenException("Acesso negado");
        }



    }


}
