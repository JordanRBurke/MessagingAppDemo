package com.jordanburke.messagingappdemo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterActivity extends AppCompatActivity {

    @BindView(R.id.input_email_text)
    protected EditText inputEmail;
    @BindView(R.id.input_password_text)
    protected EditText inputPassword;
    @BindView(R.id.sign_up_button)
    protected Button signUp;
    private Button signIn;
    @BindView(R.id.progress_bar)
    protected ProgressBar progress;
    @BindView(R.id.have_account_buttom)
    protected Button accountTrue;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);

        auth = FirebaseAuth.getInstance();

    }

    @OnClick(R.id.have_account_buttom)
    protected void moveOnMethod() {
        Intent continued = new Intent(RegisterActivity.this, LoginActivity.class);
        startActivity(continued);

    }





    @OnClick(R.id.sign_up_button)
    protected void signUpMethod() {
        String email = inputEmail.getText().toString().trim();
        String password = inputPassword.getText().toString().trim();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter your email", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length() < 4) {
            Toast.makeText(getApplicationContext(), "Password too short", Toast.LENGTH_LONG).show();
            return;
        }

        progress.setVisibility(View.VISIBLE);
        // Creates user
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(RegisterActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(RegisterActivity.this, "Created user" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        progress.setVisibility(View.GONE);
                        if (!task.isSuccessful()) {
                            Toast.makeText(RegisterActivity.this, "SignUp failed." + task.getException(), Toast.LENGTH_SHORT).show();
                        } else {
                            Intent mainMenu = new Intent(RegisterActivity.this, MainActivity.class);
                            startActivity(mainMenu);
                    }
                }




    });


}
}