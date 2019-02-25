package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NewLetterActivity extends AppCompatActivity implements View.OnClickListener {

    private final String TITLE = "Title";
    private final String SUBTITLE = "Subtitle";
    private final String CONTENT = "Content";

    Button button;
    EditText title, subtitle, content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_letter);

        button = findViewById(R.id.button_1);
        button.setOnClickListener(this);

        title = findViewById(R.id.title_edit_text);
        subtitle = findViewById(R.id.subtitle_edit_text);
        content = findViewById(R.id.content_edit_text);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button_1: {
                if (title.getText().toString() != "" || subtitle.getText().toString() != "" || content.getText().toString() != "") {
                    Intent intent = new Intent();
                    intent
                            .putExtra(TITLE, title.getText().toString())
                            .putExtra(SUBTITLE, subtitle.getText().toString())
                            .putExtra(CONTENT, content.getText().toString());

                    setResult(RESULT_OK, intent);
                    finish();
                }

                break;
            }
        }

    }
}
