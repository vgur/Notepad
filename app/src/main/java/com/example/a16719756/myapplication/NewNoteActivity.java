package com.example.a16719756.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.a16719756.myapplication.data.Note;
import com.example.a16719756.myapplication.data.NoteOne;

import java.io.Serializable;

public class NewNoteActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.a16719756.myapplication.REPLY";

    private EditText id;
    private EditText title;
    private EditText content;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_word);

        id = findViewById(R.id.new_id);
        title = findViewById(R.id.new_title);
        content = findViewById(R.id.new_content);

        final Button button = findViewById(R.id.button_save);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent replyIntent = new Intent();
                replyIntent.putExtra("uid", id.getText().toString());
                if (TextUtils.isEmpty(title.getText())) {
                    replyIntent.putExtra("title","Hello");
                } else {
                    replyIntent.putExtra("title",title.getText().toString());
                }
                if (TextUtils.isEmpty(content.getText())) {
                    replyIntent.putExtra("content","Vasia");
                } else {
                    replyIntent.putExtra("content",content.getText().toString());
                }
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });
    }
}

