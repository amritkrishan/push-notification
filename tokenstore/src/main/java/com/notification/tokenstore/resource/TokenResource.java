package com.notification.tokenstore.resource;

import com.notification.tokenstore.model.Token;
import com.notification.tokenstore.service.TokenServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/token")
public class TokenResource {

    @Autowired
    private TokenServiceImpl tokenServiceImpl;

    @PostMapping
    public void create(@RequestBody Token token){
        tokenServiceImpl.saveToken(token);
    }

    @GetMapping("/{userId}")
    public List<Token> getId(@PathVariable("userId") final int userId) {
        return tokenServiceImpl.getTokenByUserId(userId);
    }
}