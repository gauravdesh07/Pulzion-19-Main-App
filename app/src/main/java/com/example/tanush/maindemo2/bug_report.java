package com.example.tanush.maindemo2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class bug_report extends AppCompatActivity {
    CardView dev1, dev2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug_report);

        dev1 = (CardView) findViewById(R.id.dev1);
        dev2 = (CardView) findViewById(R.id.dev2);

        dev1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "8059130863"));
                startActivity(intent);
            }
        });
        dev2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + "7507457622"));
                startActivity(intent);
            }
        });
    }
}
