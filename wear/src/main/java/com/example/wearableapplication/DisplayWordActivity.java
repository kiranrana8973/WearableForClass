package com.example.wearableapplication;

import android.os.Bundle;
import android.support.wearable.activity.WearableActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayWordActivity extends WearableActivity {

    private TextView tvOutput;
    private Button btnShow;
    private EditText etFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_word);

        tvOutput = findViewById(R.id.tvOutput);
        btnShow = findViewById(R.id.btnShow);
        etFirst = findViewById(R.id.etFirst);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvOutput.setText(etFirst.getText().toString());
            }
        });

        // Enables Always-on
        setAmbientEnabled();
    }
}
