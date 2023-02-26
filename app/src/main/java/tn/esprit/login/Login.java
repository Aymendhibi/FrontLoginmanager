package tn.esprit.login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Pair;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Login extends AppCompatActivity {
Button callSignUp,go ;
ImageView image;
TextInputLayout username, pass;
EditText email , password;
private LoginApi retrofitInterface;

    //private  static  int SPLASH_SCREEN=5000;

    Animation topAnim, bottomAnim;
    ImageView imagee;
    TextView logo, slogan;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

       // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);





        callSignUp = findViewById(R.id.singnup_screen);


        String baseUrl = "http://192.168.1.22:9091/user/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(LoginApi.class);



        username = findViewById(R.id.username);

        email = findViewById(R.id.idemail);
        password = findViewById(R.id.idpassword);
        go = findViewById(R.id.login);



        callSignUp.setOnClickListener((view) ->{
            Intent intent = new Intent( Login.this,Forget.class);
            Pair[] pairs =  new Pair[2];

            pairs[0] = new Pair<View,String>(username,"username_tran");


            pairs[1 ] = new Pair<View,String>(callSignUp,"login");
            ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Login.this,pairs);
            startActivity(intent,options.toBundle());


        } );
        go.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                LoginResult loginResult = new LoginResult(email.getText().toString(),password.getText().toString());
                Call<LoginResult> call = retrofitInterface.login(loginResult);

                call.enqueue(new Callback<LoginResult>() {
                    @Override
                    public void onResponse( Call<LoginResult> call,  Response<LoginResult> response) {

                        if (response.code() == 200) {

                            LoginResult result = response.body();
                            Toast.makeText(Login.this, "test",
                                    Toast.LENGTH_LONG).show();
                            //navigate( result);
                            navigate(result);
                        } else if (response.code() == 404) {
                            Toast.makeText(Login.this, "Wrong Credentials",
                                    Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<LoginResult> call, Throwable t) {
                        Toast.makeText(Login.this, "test2",
                                Toast.LENGTH_LONG).show();


                    }
                });
            // Login2();
            }
        });


    }
    private void navigate(LoginResult result){

        Intent intent = new Intent(Login.this, Affichage.class);
        intent.putExtra("username",result.getUsername());

        intent.putExtra("email",result.getEmail());
        intent.putExtra("pa",result.getEmail());
        startActivity(intent);
    }
}