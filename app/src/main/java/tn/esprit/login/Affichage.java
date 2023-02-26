package tn.esprit.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

public class Affichage extends AppCompatActivity {


    private TextView textView2;
    private TextView textView4;
    private TextView textView3;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affichage);

        textView2 = findViewById(R.id.slogan_namee);

        textView4 = findViewById(R.id.slogan_nameeee);
        textView3 = findViewById(R.id.logo_name);

        textView2.setText(getIntent().getStringExtra("username"));
        textView4.setText(getIntent().getStringExtra("email"));
        textView3.setText("welcom " +getIntent().getStringExtra("email"));

    }
}