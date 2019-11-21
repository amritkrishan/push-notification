package com.notification.tokenstore.service;

import com.notification.tokenstore.model.Token;
import com.notification.tokenstore.repository.TokenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import java.util.List;

public class TokenServiceImpl implements TokenService {

    @Autowired
    private TokenRepository tokenRepository;

    @Transactional
    public void saveToken(Token token) {
        tokenRepository.save(token);
    }

    @Transactional
    public List<Token> getAllTokens() {
        return tokenRepository.findAll();
    }

    @Transactional
    public List<Token> getTokenByUserId(int userId) {
        return tokenRepository.findTokenByUserId(userId);
    }
}
