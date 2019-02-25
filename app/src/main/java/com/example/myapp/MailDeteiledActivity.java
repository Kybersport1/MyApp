package com.example.myapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class MailDeteiledActivity extends AppCompatActivity {

    private final String TITLE = "Title";
    private final String SUBTITLE = "Subtitle";
    private final String CONTENT = "Content";
    private final String DATE = "Date";
    private final String AVATAR = "Avatar URL";
    private final String CHECKBOX = "Check box";
    private final String POSITION = "Position";

    TextView title, subtitle, content, time;
    ImageView avatar;
    CheckBox checkBox;
    private boolean isChecked;
    private int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_deteiled);

        title = findViewById(R.id.title_text_view);
        subtitle = findViewById(R.id.subtitle_text_view);
        content = findViewById(R.id.content_text_view);
        time = findViewById(R.id.time_text_view);
        avatar = findViewById(R.id.avatar_img);
        checkBox = findViewById(R.id.checkBox);

        title.setText(getIntent().getStringExtra(TITLE));
        subtitle.setText(getIntent().getStringExtra(SUBTITLE));
        content.setText(getIntent().getStringExtra(CONTENT));
        time.setText(getIntent().getStringExtra(DATE));
        Glide.with(this).load(getIntent().getStringExtra(AVATAR)).into(avatar);
        checkBox.setChecked(getIntent().getBooleanExtra(CHECKBOX, false));
        isChecked = getIntent().getBooleanExtra(CHECKBOX, false);
        position = getIntent().getIntExtra(POSITION, 1);

        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (((CheckBox) v).isChecked()) {
                    isChecked = true;
                } else {
                    isChecked = false;
                }
            }
        });
    }


    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(CHECKBOX, isChecked)
                .putExtra(POSITION, position);
        setResult(RESULT_OK, intent);
        finish();
    }
}
