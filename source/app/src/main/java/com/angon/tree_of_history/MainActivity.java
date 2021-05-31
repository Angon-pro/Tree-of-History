package com.angon.tree_of_history;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase database;
    PeopleDatabase db;
    TextView tree, history, makeYourOwn;
    boolean firstStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new PeopleDatabase(this);
        database = db.getWritableDatabase();

        Cursor cursor = database.query("PeopleData", null, null, null,
                null, null, null);
        if (cursor.getCount() == 0) {
            firstStart = true;
        } else {
            firstStart = false;
        }
        cursor.close();

        makeYourOwn = findViewById(R.id.make_your_own);
        tree = findViewById(R.id.tree);
        history = findViewById(R.id.history);
        Animation appearance = AnimationUtils.loadAnimation(this, R.anim.appearance);
        Animation disappearance = AnimationUtils.loadAnimation(this, R.anim.disappearance);
        disappearance.setStartOffset(1650);
        tree.startAnimation(disappearance);
        appearance.setStartOffset(1850);
        history.startAnimation(appearance);
        silence();
    }


    private void silence() {
        Animation silence = new AlphaAnimation(1.0f, 1.0f);
        silence.setDuration(3250);
        silence.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                if (!firstStart) {
                    startActivity(new Intent(MainActivity.this, TreeActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(MainActivity.this, RegisterActivity.class));
                    finish();
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        makeYourOwn.startAnimation(silence);
    }
}