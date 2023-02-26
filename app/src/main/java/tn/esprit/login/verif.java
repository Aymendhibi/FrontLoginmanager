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

public class verif extends AppCompatActivity {

EditText age;
    LoginApi retrofitInterface;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verif);
        age = findViewById(R.id.verif);
        String baseUrl = "http://192.168.1.22:9091/user/";

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Button gooo = findViewById(R.id.ver);

        retrofitInterface = retrofit.create(LoginApi.class);
        gooo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rest();

            }


        });
    }
            private void rest(){
                Call<String> call = retrofitInterface.postAge(Integer.parseInt(age.getText().toString()));

                call.enqueue(new Callback<String>() {
                    @Override
                    public void onResponse(Call<String> call, Response<String> response) {
                        if (response.isSuccessful()) {

                            navigate();
                            // Traitez l'âge ici
                        } else if (response.code() == 404) {
                            Toast.makeText(verif.this, "Wrong Credentials",
                                    Toast.LENGTH_LONG).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<String> call, Throwable t) {
                        Toast.makeText(verif.this, "test2",
                                Toast.LENGTH_LONG).show();


                    }
                });
            }


            private void navigate(){

                Intent intent = new Intent(verif.this, confirmerpassword.class);

                startActivity(intent);
            }

        }

