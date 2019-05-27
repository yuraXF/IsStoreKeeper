package com.example.data.repository;

import com.example.domain.repository.AuthRepository;

import javax.inject.Inject;

public class AuthRepositoryImpl implements AuthRepository {

    @Inject
    public AuthRepositoryImpl() {
    }

    @Override
    public Boolean singUp(String userName, String password) {
        return true;
    }

    @Override
    public Boolean singIn(String userName, String password) {
        return true;
    }

    @Override
    public Boolean isCurrentUser() {
        return true;
    }

}
