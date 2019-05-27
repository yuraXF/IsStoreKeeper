package com.example.yura.irbisstore.mvvm.viewmodel;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class SingInViewModelFactory implements ViewModelProvider.Factory {

    private final SingInViewModel singInViewModel;

    @Inject
    public SingInViewModelFactory(SingInViewModel singInViewModel) {
        this.singInViewModel = singInViewModel;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) singInViewModel;
    }
}
