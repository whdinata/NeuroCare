package universityofedinburgh.neurocare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import universityofedinburgh.neurocare.helper.API;
import universityofedinburgh.neurocare.helper.Validator;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private View btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView(){
        etUsername = (EditText) findViewById(R.id.username);
        etPassword = (EditText) findViewById(R.id.password);

        btLogin = findViewById(R.id.login);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (isValid()) {
                    
                    //API.login(etUsername.getText().toString(), etPassword.getText().toString());
                }
            }
        });
    }

    private boolean isValid() {
        String userName = etUsername.getText().toString();
        String password = etPassword.getText().toString();

//        if (!Validator.isEmailValid(userName)){
//            Toast.makeText(this, "Username is not valid", Toast.LENGTH_SHORT).show();
//            return false;
//        }
//
//        if(!Validator.isPasswordValid(password)){
//            Toast.makeText(this, "Username and password are not matched", Toast.LENGTH_SHORT).show();
//            return false;
//        }

        return true;
    }

}
