package com.angon.tree_of_history;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewingActivity extends AppCompatActivity {

    Button delete, edit;
    TextView personName, personSurname, personAge, personInformation;
    ImageView photo;
    SQLiteDatabase database;
    PeopleDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewing);

        photo = findViewById(R.id.photo);
        delete = findViewById(R.id.deletePerson);
        edit = findViewById(R.id.editPerson);
        personName = findViewById(R.id.personName);
        personSurname = findViewById(R.id.personSurname);
        personAge = findViewById(R.id.personAge);
        personInformation = findViewById(R.id.personInformation);
        personInformation.setMovementMethod(new ScrollingMovementMethod());

        db = new PeopleDatabase(this);
        database = db.getWritableDatabase();

        Cursor cursor = database.query("PeopleData", null, "Generation = ?",
                new String[] {getIntent().getSerializableExtra("Generation").toString()}, null, null, null);
        cursor.moveToPosition(Integer.parseInt(getIntent().getSerializableExtra("Number").toString()) - 1);
        if (cursor.getString(5) != null) {
            photo.setImageDrawable(Drawable.createFromPath(cursor.getString(5)));
        }
        personName.setText(cursor.getString(1));
        personSurname.setText(cursor.getString(2));
        personAge.setText(cursor.getString(3));
        if (!cursor.getString(4).equals("")) {
            personInformation.setText(cursor.getString(4));
            personInformation.setTextColor(Color.parseColor("#FFFFFF"));
        }
        final String photoName = cursor.getInt(0) + "";
        cursor.close();

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toTreeActivity = new Intent();
                toTreeActivity.putExtra("finishRequest", "finish");
                setResult(RESULT_OK, toTreeActivity);
                Intent intent = new Intent(ViewingActivity.this, EditingActivity.class);
                intent.putExtra("personName", personName.getText().toString());
                intent.putExtra("personSurname", personSurname.getText().toString());
                intent.putExtra("personAge", personAge.getText().toString());
                if (!personInformation.getText().toString().equals("No extra information about the person")) {
                    intent.putExtra("personInformation", personInformation.getText().toString());
                } else {
                    intent.putExtra("personInformation", "");
                }
                startActivityForResult(intent, 2);
                overridePendingTransition(0, 0);
            }
        });

        if (Integer.parseInt(getIntent().getSerializableExtra("Generation").toString()) == 1 &&
                Integer.parseInt(getIntent().getSerializableExtra("Number").toString()) == 1) {
            delete.setEnabled(false);
            delete.setTextColor(Color.parseColor("#A10000"));
        } else {
            delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent toTreeActivity = new Intent();
                    toTreeActivity.putExtra("finishRequest", "finish");
                    setResult(RESULT_OK, toTreeActivity);
                    database.delete("PeopleData", "Name = ? AND Surname = ? AND Age = ?",
                            new String[] {personName.getText().toString(), personSurname.getText().toString(),
                                    personAge.getText().toString()});
                    getApplicationContext().deleteFile(photoName);
                    Intent intent = new Intent(ViewingActivity.this, TreeActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        startActivity(getIntent());
        finish();
        overridePendingTransition(0, 0);
    }


    @Override
    public void onBackPressed() {
        Intent toTreeActivity = new Intent();
        toTreeActivity.putExtra("finishRequest", "finish");
        setResult(RESULT_OK, toTreeActivity);
        Intent intent = new Intent(ViewingActivity.this, TreeActivity.class);
        startActivity(intent);
        finish();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent finishRequest) {
        super.onActivityResult(requestCode, resultCode, finishRequest);
        if (finishRequest != null) {
            finish();
        }
    }
}