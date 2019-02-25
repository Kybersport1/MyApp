package com.example.myapp;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements EmailAdapter.EmailItemClicked {

    private final int NEW_LETTER_ACTIVITY_CODE = 1;
    private final int DETEILED_ACTIVITY_CODE = 2;
    private final String TITLE = "Title";
    private final String SUBTITLE = "Subtitle";
    private final String CONTENT = "Content";
    private final String DATE = "Date";
    private final String AVATAR = "Avatar URL";
    private final String CHECKBOX = "Check box";
    private final String POSITION = "Position";
    EmailAdapter emailAdapter;
    RecyclerView emailRecycler;
    private List<EmailItem> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = generateEmailList();

        emailRecycler = findViewById(R.id.email_recycler_view);
        emailRecycler.setLayoutManager(new LinearLayoutManager(this));
        emailAdapter = new EmailAdapter(list, this);
        emailRecycler.setAdapter(emailAdapter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NewLetterActivity.class);
                startActivityForResult(intent, NEW_LETTER_ACTIVITY_CODE);
            }
        });
    }

    // переопределённый метод callback. Вызывается при кликах на элементы.
    // Больше информации можно найти в классе адаптера
    @Override
    public void itemClickedCallback(int itemPosition) {
        Intent intentDeteiled = new Intent(this, MailDeteiledActivity.class);
        intentDeteiled
                .putExtra(TITLE, list.get(itemPosition).getTitle())
                .putExtra(SUBTITLE, list.get(itemPosition).getSubTitle())
                .putExtra(CONTENT, list.get(itemPosition).getContent())
                .putExtra(DATE, list.get(itemPosition).getDate())
                .putExtra(AVATAR, list.get(itemPosition).getAvatar())
                .putExtra(CHECKBOX, list.get(itemPosition).getChechBox())
                .putExtra(POSITION, itemPosition);

        startActivityForResult(intentDeteiled,DETEILED_ACTIVITY_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to

        switch (requestCode) {
            case NEW_LETTER_ACTIVITY_CODE: {
                // Make sure the request was successful
                if (resultCode == RESULT_OK) {
                    if (data != null) {
                        list.add(new EmailItem(
                                data.getStringExtra(TITLE),
                                data.getStringExtra(SUBTITLE),
                                data.getStringExtra(CONTENT),
                                "A moment ago",
                                "https://bizraise.pro/wp-content/uploads/2014/09/no-avatar-300x300.png",
                                false
                        ));
                        emailAdapter.setEmailsPreviewList(list);
                    }
                }
                break;
            }
            case DETEILED_ACTIVITY_CODE: {
                list.get(data.getIntExtra(POSITION, 1)).setCheckBox(data.getBooleanExtra(CHECKBOX, false));
                emailAdapter.setEmailsPreviewList(list);
                break;
            }
        }
    }


    private List<EmailItem> generateEmailList() {
        List<EmailItem> list = new ArrayList<>();
        list.add(new EmailItem("Alex Buranov", "Companies Worldwide Mana ge Their Business with NetSuite.", "consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoqu", "A moment ago", "https://99px.ru/sstorage/1/2019/02/image_10702190633073904429.jpg", false));
        list.add(new EmailItem("Mike Street", "Real-Time Dashboards ", "etuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis", "20m", "https://99px.ru/sstorage/1/2018/12/image_12512181414322405922.jpg", false));
        list.add(new EmailItem("Lucas 9-9", "Why is Python so popular despite being so slow? ", "ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis", "55m", "https://99px.ru/sstorage/1/2019/01/image_12801191533563880669.jpg", false));
        list.add(new EmailItem("Amazon Rose", "Will Canada buy the F-35? ", "Thanks for accepting my connection, it’s great to have someone with similar interests in my network!", "1h", "https://99px.ru/sstorage/1/2019/02/image_10702190633073904429.jpg", false));
        list.add(new EmailItem("Kazi Ahmed", null, "Lorem impus... WHAT???!!!", "4h", "https://99px.ru/sstorage/1/2018/11/image_12311182358347917344.jpg", false));
        list.add(new EmailItem("New letter", "Artem sent you a new message", "Thanks for accepting my connection, it’s great to have someone with similar interests in my network!", "2d", "https://99px.ru/sstorage/1/2018/12/image_12512181411192326453.jpg", false));
        list.add(new EmailItem(null, "I hacked your computer", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, ", "2d", "https://99px.ru/sstorage/1/2018/12/image_11212180111046638602.png", false));
        list.add(new EmailItem("Pushpendra Yad", "", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, ", "2d", "https://99px.ru/sstorage/1/2019/02/image_10702190633073904429.jpg", false));
        list.add(new EmailItem("Alex Buranov", "Companies Worldwide Manage Their Business with NetSuite.", "consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoqu", "3d", "https://99px.ru/sstorage/1/2018/12/image_11212180111046638602.png", false));
        list.add(new EmailItem("Mike Street", "Real-Time Dashboards ", "etuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis", "3d", "https://99px.ru/sstorage/1/2018/12/image_12512181414322405922.jpg", false));
        list.add(new EmailItem("Lucas 9-9", "Why is Python so popular despite being so slow? ", "ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis", "3d", "https://99px.ru/sstorage/1/2019/01/image_12801191533563880669.jpg", false));
        list.add(new EmailItem("Amazon Rose", "Will Canada buy the F-35? ", "Thanks for accepting my connection, it’s great to have someone with similar interests in my network!", "3d", "https://99px.ru/sstorage/1/2018/12/image_12512181411192326453.jpg", false));
        list.add(new EmailItem("Kazi Ahmed", null, "Lorem impus... WHAT???!!!", "3d", "https://99px.ru/sstorage/1/2018/11/image_12311182358347917344.jpg", false));
        list.add(new EmailItem("New letter", "Artem sent you a new message", "Thanks for accepting my connection, it’s great to have someone with similar interests in my network!", "3d", "https://99px.ru/sstorage/1/2019/02/image_10702190633073904429.jpg", false));
        list.add(new EmailItem(null, "I hacked your computer", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, ", "3d", "https://99px.ru/sstorage/1/2018/12/image_12512181411192326453.jpg", false));
        list.add(new EmailItem("Pushpendra Yad", "", "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, ", "4d", "https://99px.ru/sstorage/1/2018/12/image_12512181414322405922.jpg", false));
        return list;
    }
}

