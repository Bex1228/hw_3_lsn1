package com.example.hw_3_lsn1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.nio.channels.InterruptedByTimeoutException;

public class MainActivity extends AppCompatActivity {
   private EditText etRecipient;
     private EditText etTheme;
     private EditText etMessage;
     private Button btnSend ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etRecipient = findViewById(R.id.recipient);
        etTheme = findViewById(R.id.et_theme);
        etMessage = findViewById(R.id.et_message);
        btnSend = findViewById(R.id.btn_send);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendEmail();
            }

        });
    }

        private void sendEmail() {
            String recipient = etRecipient.getText().toString();
            String subject = etTheme.getText().toString();
            String message = etMessage.getText().toString();

            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("Text/plain");

            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{recipient});
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
            emailIntent.putExtra(Intent.EXTRA_TEXT, message);

            startActivity(Intent.createChooser(emailIntent, "Отправить с помощью"));

    }
}