package com.example.yura.irbisstore.mvvm.viewmodel;

import com.example.data.repository.AuthRepositoryImpl;
import com.example.domain.model.Nothing;
import com.example.domain.repository.AuthRepository;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;

public class SingInViewModel extends ViewModel {

    private AuthRepository authRepository;
    public MutableLiveData<String> userName=new MutableLiveData<>();
    public MutableLiveData<String> userPassword=new MutableLiveData<>();
    public MutableLiveData<String> actionCaption=new MutableLiveData<>();

    public MutableLiveData<Event<Nothing>> showMainActivity=new MutableLiveData<>();

    public MutableLiveData<String> errorText=new MutableLiveData<>();

    public MutableLiveData<Boolean> isSuccessfullEntrance=new MutableLiveData<>();

    private String currentMode;
    private String currentModeInfo;
    private final String REGISTRATION="singUp";
    private final String ENTRANCE="singIn";

    @Inject
    public SingInViewModel(AuthRepository authRepository) {

        this.authRepository = authRepository;

        userName.postValue("");
        userPassword.postValue("");
        errorText.postValue("");

        if(authRepository.isCurrentUser()==false){
            actionCaption.postValue("Зарегистрироваться");
            currentMode=REGISTRATION;
            currentModeInfo="регистрации";
        }else{
            actionCaption.postValue("Войти");
            currentMode=ENTRANCE;
            currentModeInfo="входа";
        }

        isSuccessfullEntrance.postValue(false);

        userName.observeForever(new Observer<String>() {
            @Override
            public void onChanged(String s) {
                if(userName.getValue().isEmpty()){
                    errorText.postValue("Имя пользователя не может быть пустым!");
                }
            }
        });
    }

    public void doEntrance() {
        if (currentMode == REGISTRATION) {
            singUp();
        } else if (currentMode == ENTRANCE) {
            singIn();
        }
    }

    public void navigateToMainActivity() {
        doEntrance();
    }

    private void singUp() {
        isSuccessfullEntrance.postValue(true);
        showMainActivity.postValue(new Event<Nothing>(new Nothing()));
        /*authRepository.singUp(userName.getValue(), userPassword.getValue())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        isSuccessfullEntrance.postValue(aBoolean);
                        showMainActivity.postValue(new Event<Nothing>(new Nothing()));
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorText.postValue(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });*/
    }

    private void singIn() {
        isSuccessfullEntrance.postValue(true);
        showMainActivity.postValue(new Event<Nothing>(new Nothing()));
        /*authRepository.singIn(userName.getValue(), userPassword.getValue())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<Boolean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Boolean aBoolean) {
                        isSuccessfullEntrance.postValue(aBoolean);
                        showMainActivity.postValue(new Event<Nothing>(new Nothing()));
                    }

                    @Override
                    public void onError(Throwable e) {
                        errorText.postValue(e.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });*/
    }

    public String getCurrentModeInfo() {
        return currentModeInfo;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
