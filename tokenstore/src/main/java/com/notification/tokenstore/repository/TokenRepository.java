package com.notification.tokenstore.repository;

import com.notification.tokenstore.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface TokenRepository extends JpaRepository<Token, Integer> {

    @Query(value="SELECT * FROM token",nativeQuery = true)
    List<Token> findAll();

    @Query(value="SELECT * FROM token WHERE userId = ?1" ,nativeQuery = true)
    List<Token> findTokenByUserId(int userId);

}