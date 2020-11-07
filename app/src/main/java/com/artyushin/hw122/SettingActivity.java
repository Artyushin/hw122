package com.artyushin.hw122;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SettingActivity extends AppCompatActivity {
    private String fileName;
    private EditText editText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView(R.layout.activity_setting);

        saveButton = (Button) findViewById(R.id.save_setting);
        saveButton.setOnClickListener(new OnClickListener () {
            @Override
            public void onClick(View v) {
                editText = (EditText) findViewById(R.id.file_name);
                fileName = String.valueOf (editText.getText ());
                NameImage.setFileName (fileName);
                finish ();
            }
        });
    }
}
