package calories.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    private String TAG = "RegisterActivity";
    private FirebaseAuth auth;
    private TextInputLayout cont_name, cont_email, cont_password, cont_pass_conf;
    private TextInputEditText name, email, password, conf_password;
    private TextView tv_login;
    private MaterialButton button_register;
    private FrameLayout progress_bar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        auth = FirebaseAuth.getInstance();
        initView();
    }

    private void initView() {
        cont_name = findViewById(R.id.cont_name);
        cont_email = findViewById(R.id.cont_email);
        cont_password = findViewById(R.id.cont_password);
        cont_pass_conf = findViewById(R.id.cont_password_conf);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        conf_password = findViewById(R.id.password_confirmation);
        tv_login = findViewById(R.id.tv_login);
        button_register = findViewById(R.id.button_register);
        progress_bar = findViewById(R.id.fl_progress_bar);

        tv_login.setOnClickListener(this);
        button_register.setOnClickListener(this);

        //changelistener nama
        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                cont_name.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

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
                cont_pass_conf.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        conf_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                cont_password.setError(null);
                cont_pass_conf.setError(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    @Override
    public void onClick(View V){
        switch (V.getId()){
            case R.id.button_register:
                createAccount();
                break;
            case R.id.tv_login:
                startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                finish();
                break;
        }
    }

    private boolean isValidForm(){
        boolean isValid = true;
        if (name.getText().toString().isEmpty()){
            cont_name.setError("Nama tidak boleh kosong!");
            isValid = false;
        }
        if (email.getText().toString().isEmpty()){
            cont_email.setError("Email tidak boleh kosong!");
            isValid = false;
        }
        if (password.getText().toString().isEmpty()){
            cont_password.setError("Password tidak boleh kosong!");
            isValid = false;
        }
        if (password.getText().toString().length() < 8){
            cont_password.setError("Password terlalu pendek!");
            isValid = false;
        }
        if (!conf_password.getText().toString().equals(password.getText().toString())){
            cont_pass_conf.setError("Konfirmasi password tidak sesuai!");
            isValid = false;
        }
        if (conf_password.getText().toString().isEmpty()){
            cont_pass_conf.setError("Konfirmasi password tidak boleh kosong!");
            isValid = false;
        }
        return isValid;
    }

    private void createAccount(){
        if (!isValidForm()) return;
        String txt_name = name.getText().toString();
        String txt_email = email.getText().toString();
        String txt_password = password.getText().toString();
        progress_bar.setVisibility(View.VISIBLE);
        auth.createUserWithEmailAndPassword(txt_email, txt_password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser user = auth.getCurrentUser();
                    Toast.makeText(RegisterActivity.this, "User berhasil terdaftar!", Toast.LENGTH_SHORT).show();
                }
                else{
                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                    Toast.makeText(RegisterActivity.this, "User gagal mendaftar!", Toast.LENGTH_SHORT).show();
                }
                progress_bar.setVisibility(View.GONE);
            }
        });
    }
}
