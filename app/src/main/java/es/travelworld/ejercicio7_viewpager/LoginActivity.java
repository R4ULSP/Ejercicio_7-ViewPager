package es.travelworld.ejercicio7_viewpager;


import static es.travelworld.ejercicio7_viewpager.domain.References.KEY_USER;
import static es.travelworld.ejercicio7_viewpager.domain.References.LOGIN_FRAGMENT;
import static es.travelworld.ejercicio7_viewpager.domain.References.LOGIN_SUCCESSFUL;
import static es.travelworld.ejercicio7_viewpager.domain.References.REGISTER_FRAGMENT;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;

import es.travelworld.ejercicio7_viewpager.databinding.ActivityLoginBinding;
import es.travelworld.ejercicio7_viewpager.domain.User;
import es.travelworld.ejercicio7_viewpager.fragments.LoginErrorFragment;
import es.travelworld.ejercicio7_viewpager.fragments.LoginFragment;
import es.travelworld.ejercicio7_viewpager.fragments.RegisterFragment;

public class LoginActivity extends AppCompatActivity implements LoginFragment.OnClickItemLoginFragment, RegisterFragment.OnClickItemRegisterFragment {

    private ActivityLoginBinding binding;
    private User user;
    private String currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        user = new User();
        if(getIntent().getParcelableExtra(KEY_USER) != null){
            user = getIntent().getParcelableExtra(KEY_USER);
        }


        startLoginFragment();
    }

    private void startLoginFragment() {
        LoginFragment fragment = (LoginFragment) getSupportFragmentManager().findFragmentByTag(LOGIN_FRAGMENT);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.loginFragmentFrame.getId(),
                        fragment != null ? fragment : LoginFragment.newInstance(user),
                        LOGIN_FRAGMENT)
                .addToBackStack(null)
                .commitAllowingStateLoss();
        currentFragment = LOGIN_FRAGMENT;

    }

    private void startRegisterFragment(User user) {
        RegisterFragment fragment = (RegisterFragment) getSupportFragmentManager().findFragmentByTag(REGISTER_FRAGMENT);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(binding.loginFragmentFrame.getId(),
                        fragment != null ? fragment : RegisterFragment.newInstance(user),
                        REGISTER_FRAGMENT)
                .addToBackStack(null)
                .commitAllowingStateLoss();
        currentFragment = REGISTER_FRAGMENT;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (currentFragment.equals(LOGIN_FRAGMENT)) {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        }else{
            startLoginFragment();
        }
    }

    @Override
    public void loginButton(User user, String code) {
        if (code.equals(LOGIN_SUCCESSFUL)) {
            Intent intent = new Intent(this, es.travelworld.ejercicio7_viewpager.HomeActivity.class);
            intent.putExtra(KEY_USER, user);
            startActivity(intent);
        } else {
            FragmentManager fragmentManager = getSupportFragmentManager();
            LoginErrorFragment loginErrorFragment = LoginErrorFragment.newInstance();
            loginErrorFragment.show(fragmentManager, null);
        }
    }

    @Override
    public void loginNewAccountButton(User user) {
        startRegisterFragment(user);
    }

    @Override
    public void registerJoinButton(User user) {
        this.user = user;
        startLoginFragment();
        Snackbar.make(binding.getRoot(), "Nombre: " + user.getName() + "  Apellidos: " + user.getLastname() + "  Edad:" + user.getAgeGroup(), BaseTransientBottomBar.LENGTH_LONG).show();
    }
}