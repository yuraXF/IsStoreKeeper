package com.example.domain.repository;

public interface AuthRepository {

    Boolean singUp(String userName, String password);

    Boolean singIn(String userName, String password);

    Boolean isCurrentUser();

}
