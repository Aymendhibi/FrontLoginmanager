package tn.esprit.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class confirmerpassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmerpassword);


        Button logi = findViewById(R.id.logi);
        logi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                navigate();
            }
            private void navigate(){

                Intent intent = new Intent(confirmerpassword.this, Login.class);

                startActivity(intent);
            }

        });
    }
}