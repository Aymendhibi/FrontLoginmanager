package tn.esprit.login;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {


    TextView helloTv;
    EditText subject;
    EditText body;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        helloTv = findViewById(R.id.helloTV);
        subject = findViewById(R.id.subjectET);
        body = findViewById(R.id.bodyET);
        send = findViewById(R.id.sendBtn);

        String username = getIntent().getStringExtra("username");

        helloTv.setText("Hello " + username);


        send.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_SUBJECT, subject.getText().toString());
            intent.putExtra(Intent.EXTRA_EMAIL, "skander.chamakhi@esprit.tn");
            intent.putExtra(Intent.EXTRA_TEXT, body.getText().toString());
            startActivity(intent);
        });

    }
}