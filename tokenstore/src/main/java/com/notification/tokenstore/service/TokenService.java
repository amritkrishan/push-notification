package com.notification.tokenstore.service;

import com.notification.tokenstore.model.Token;
import java.util.List;

public interface TokenService
{
    void saveToken(Token token);
    List<Token> getAllTokens();
    List<Token> getTokenByUserId(int userId);
}