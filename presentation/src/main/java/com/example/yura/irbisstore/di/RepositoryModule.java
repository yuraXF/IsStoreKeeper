package com.example.yura.irbisstore.di;

import com.example.data.repository.AuthRepositoryImpl;
import com.example.domain.repository.AuthRepository;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    AuthRepository provideAuthRepository(){
        return new AuthRepositoryImpl();
    }

}
