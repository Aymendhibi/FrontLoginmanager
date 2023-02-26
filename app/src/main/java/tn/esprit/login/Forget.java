package tn.esprit.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Forget extends AppCompatActivity {

    LoginApi retrofitInterface;
    EditText email;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        Button goo = findViewById(R.id.go);
        email = findViewById(R.id.restpassword);
        String baseUrl = "http://192.168.1.22:9091/user/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

         retrofitInterface = retrofit.create(LoginApi.class);
        goo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rest();

            }


    });




}
private void rest(){
    LoginResult loginResult = new LoginResult(email.getText().toString());
    Call<LoginResult> call = retrofitInterface.restPassword(loginResult);

    call.enqueue(new Callback<LoginResult>() {
        @Override
        public void onResponse( Call<LoginResult> call,  Response<LoginResult> response) {

            if (response.code() == 200) {

               // LoginResult result = response.body();
                Toast.makeText(Forget.this, "test",
                        Toast.LENGTH_LONG).show();
                navigate();

            } else if (response.code() == 404) {
                Toast.makeText(Forget.this, "Wrong Credentials",
                        Toast.LENGTH_LONG).show();
            }

        }

        @Override
        public void onFailure(Call<LoginResult> call, Throwable t) {
            Toast.makeText(Forget.this, "test2",
                    Toast.LENGTH_LONG).show();


        }
    });
}
    private void navigate(){

        Intent intent = new Intent(Forget.this, verif.class);

        startActivity(intent);
    }
}