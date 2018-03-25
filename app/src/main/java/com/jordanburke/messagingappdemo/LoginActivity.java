package com.jordanburke.messagingappdemo;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.input_email)
    protected EditText enterEmailBox;
    @BindView(R.id.input_password)
    protected EditText enterPasswordBox;
    @BindView(R.id.confirm_login_button)
    protected Button confirmButton;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        auth = FirebaseAuth.getInstance();

//        if (auth.getCurrentUser() != null) {
//            Intent loginActivity = new Intent(LoginActivity.this, MainActivity.class);
//            startActivity(loginActivity);
//            finish();
//
//        }
    }
    @OnClick(R.id.confirm_login_button)
    protected void loginProcess() {
        final String email = enterEmailBox.getText().toString();
        final String password = enterPasswordBox.getText().toString();

        if (TextUtils.isEmpty(email)) {
            Toast.makeText(getApplicationContext(), "Enter email please", Toast.LENGTH_SHORT).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(getApplicationContext(), "Enter password please", Toast.LENGTH_SHORT).show();
        }

        auth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(LoginActivity.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            if (password.length() < 4) {
                                Toast.makeText(getApplicationContext(), "To low", Toast.LENGTH_SHORT).show();

                            } else {
                                Toast.makeText(getApplicationContext(), "Login failed", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Intent intent = new Intent(LoginActivity.this, ConnectorActivity.class);
                            intent.putExtra("EMAIL_INFO", email);
                            startActivity(intent);
                            finish();
                        }
                    }
                });
    }


}
