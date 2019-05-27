package com.example.yura.irbisstore.mvvm.view.screen.sing_in;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerAppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.example.domain.model.Nothing;
import com.example.domain.repository.AuthRepository;
import com.example.yura.irbisstore.R;
import com.example.yura.irbisstore.databinding.ActivitySingInBinding;
import com.example.yura.irbisstore.mvvm.viewmodel.Event;
import com.example.yura.irbisstore.mvvm.viewmodel.SingInViewModel;
import com.example.yura.irbisstore.mvvm.viewmodel.SingInViewModelFactory;
import com.google.android.material.textfield.TextInputEditText;

import javax.inject.Inject;

public class SingInActivity extends DaggerAppCompatActivity {

    @Inject
    AuthRepository authRepository;
    @Inject
    SingInViewModelFactory singInViewModelFactory;
    private SingInViewModel singInViewModel;

    private TextInputEditText textInputEditText_userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        singInViewModel = ViewModelProviders
                .of(this, singInViewModelFactory)
                .get(SingInViewModel.class);

        singInViewModel.showMainActivity.observe(this, new Observer<Event<Nothing>>() {
            @Override
            public void onChanged(Event<Nothing> event) {
                if (event.peekContentIfNotHandled() != null) {
                    if (singInViewModel.isSuccessfullEntrance.getValue()) {
                        /*Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();*/
                        Toast.makeText(getApplicationContext(), "Вход прошел успешно!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Произошла ошибка " + singInViewModel.getCurrentModeInfo() + "!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        ActivitySingInBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_sing_in);
        binding.setLifecycleOwner(this);
        binding.setVm(singInViewModel);

        textInputEditText_userName=binding.userNameTextInputEditText;

        singInViewModel.errorText.observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textInputEditText_userName.setError(singInViewModel.errorText.getValue());
            }
        });

    }
}
