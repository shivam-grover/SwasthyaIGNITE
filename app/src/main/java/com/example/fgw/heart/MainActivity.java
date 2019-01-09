package com.example.fgw.heart;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    EditText weight;
    Button calculate;
    DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weight = findViewById(R.id.editText2);
        calculate = findViewById(R.id.button);
        databaseReference = FirebaseDatabase.getInstance().getReference("weight");

//        Typeface typeface = Typeface.createFromAsset(getAssets(), "keepcalm.ttf");
//
//        weight.setTypeface(typeface);
//        calculate.setTypeface(typeface);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReference.setValue(weight.getText().toString());
                startActivity(new Intent(MainActivity.this, dietAssist.class));

                //String url = "https://console.dialogflow.com/api-client/demo/embedded/42b2370d-1d00-46c7-8708-bf032657ac4a";

//                Uri uri = Uri.parse(url);
//                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//                startActivity(intent);
            }
        });

    }
}
