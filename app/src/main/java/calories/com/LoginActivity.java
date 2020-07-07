package calories.com;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private final String TAG = "LoginActivity";

    private FirebaseAuth auth;

    private TextInputLayout cont_email, cont_password;
    private TextInputEditText email, password;
    private TextView tv_register;
    private MaterialButton button_login;
    private FrameLayout progress_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
        initView();

    }

    private void initView(){
        cont_email = findViewById(R.id.cont_email);
        cont_password = findViewById(R.id.cont_password);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        tv_register = findViewById(R.id.tv_register);
        button_login = findViewById(R.id.button_login);
        progress_bar = findViewById(R.id.fl_progress_bar);

        tv_register.setOnClickListener(this);
        button_login.setOnClickListener(this);

        //change listener
        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                cont_email.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                cont_password.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onClick(View V){
        switch (V.getId()){
            case R.id.button_login:
                loginAccount();
                break;
            case R.id.tv_register:
                startActivity(new Intent(getApplicationContext(), RegisterActivity.class));
                finish();
                break;
        }
    }

    private boolean isValidForm(){
        boolean isValid = true;
        if (email.getText().toString().isEmpty()){
            cont_email.setError("Email tidak boleh kosong!");
            isValid = false;
        }
        if (password.getText().toString().isEmpty()){
            cont_password.setError("Password tidak boleh kosong!");
            isValid = false;
        }
        return isValid;
    }

    private void loginAccount(){
        if (!isValidForm()) return;

        progress_bar.setVisibility(View.VISIBLE);

        String txt_email = email.getText().toString();
        String txt_password = password.getText().toString();

        auth.signInWithEmailAndPassword(txt_email, txt_password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
                else {
                    Log.w(TAG,"createUserWithEmail:failure", task.getException());
                    Toast.makeText(LoginActivity.this, "Login gagal!", Toast.LENGTH_SHORT).show();
                }
                progress_bar.setVisibility(View.GONE);
            }
        });

    }

}
