package com.angon.tree_of_history;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    Button continueButton;
    EditText name, surname, age, information;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        continueButton = findViewById(R.id.register);
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
                String name = RegisterActivity.this.name.getText().toString();
                String surname = RegisterActivity.this.surname.getText().toString();
                String age = RegisterActivity.this.age.getText().toString();
                String information = RegisterActivity.this.information.getText().toString();
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
                if (Integer.parseInt(age) < 5 || Integer.parseInt(age) > 100) {
                    Toast toast = Toast.makeText(getApplicationContext(), "Age cannot be so", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                Intent intent = new Intent(RegisterActivity.this, AddingPhotoActivity.class);
                intent.putExtra("personName", name);
                intent.putExtra("personSurname", surname);
                intent.putExtra("personAge", age);
                intent.putExtra("personInformation", information);
                intent.putExtra("personGeneration", 1);
                startActivity(intent);
                finish();
            }
        });
    }
}