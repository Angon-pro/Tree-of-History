package com.angon.tree_of_history;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddingActivity extends AppCompatActivity {

    SQLiteDatabase database;
    PeopleDatabase db;
    Button continueButton;
    EditText name, surname, age, information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding);

        db = new PeopleDatabase(this);
        database = db.getWritableDatabase();

        continueButton = findViewById(R.id.add);
        continueButton.setEnabled(false);
        continueButton.setTextColor(getResources().getColor(R.color.pressedButtonColor));
        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        age = findViewById(R.id.age);
        information = findViewById(R.id.information);
        EditText[] editTexts = {name, surname, age};
        EnterFieldsWatcher enterFieldsWatcher = new EnterFieldsWatcher(editTexts, continueButton);
        for (final EditText editText : editTexts) {
            editText.addTextChangedListener(enterFieldsWatcher);
        }

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = AddingActivity.this.name.getText().toString();
                String surname = AddingActivity.this.surname.getText().toString();
                String age = AddingActivity.this.age.getText().toString();
                String information = AddingActivity.this.information.getText().toString();
                if (name.length() > 12) {
                    Toast toast = Toast.makeText(getApplicationContext(), "The name is too long", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                if (surname.length() > 12) {
                    Toast toast = Toast.makeText(getApplicationContext(), "The surname is too long", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                if (Integer.parseInt(age) > 100) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Age cannot be so", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                Cursor cursor = database.query("PeopleData", null, null, null,
                        null, null, null);
                while (cursor.moveToNext()) {
                    if (name.equals(cursor.getString(1)) && surname.equals(cursor.getString(2)) &&
                            age.equals(Integer.toString(cursor.getInt(3)))) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Such person already exists", Toast.LENGTH_SHORT);
                        toast.show();
                        return;
                    }
                }
                cursor.close();
                Intent toTreeActivity = new Intent();
                toTreeActivity.putExtra("finishRequest", "finish");
                setResult(RESULT_OK, toTreeActivity);
                Intent intent = new Intent(AddingActivity.this, AddingPhotoActivity.class);
                intent.putExtra("personName", name);
                intent.putExtra("personSurname", surname);
                intent.putExtra("personAge", age);
                intent.putExtra("personInformation", information);
                intent.putExtra("personGeneration", getIntent().getSerializableExtra("personGeneration"));
                startActivity(intent);
                finish();
            }
        });
    }
}