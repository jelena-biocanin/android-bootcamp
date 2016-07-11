package com.example.jelenanikolic.androidbootcamp1;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

/**
 * @author jelena.nikolic
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button pressButton = (Button)findViewById(R.id.button);
        pressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //get the entered value
                EditText editText = (EditText) findViewById(R.id.editText);
                int number = 0;
                try {
                    number = Integer.parseInt(editText.getText().toString());
                } catch (NumberFormatException e) {
                    Log.e("ERROR","You must enter the correct number"); // TODO check if this is the correct usaage
                    throw e;
                }

                //generate random value
                Random r = new Random();
                int randomNum = r.nextInt(number) + 1;

                //populate text field
                TextView showText = (TextView) findViewById(R.id.textView2);
                //play with resources
                showText.setText(getResources().getString(R.string.chosen_number).concat(String.valueOf(number)).
                        concat(getResources().getString(R.string.dot)).concat(getResources().getString(R.string.random_number)).
                        concat(String.valueOf(randomNum)).concat(getResources().getString(R.string.dot)));
                showText.setVisibility(View.VISIBLE);
            }
        });
    }
}
