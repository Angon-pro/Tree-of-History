package com.angon.tree_of_history;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EditingActivity extends AppCompatActivity {

    Button save, deletePhoto;
    EditText personName, personSurname, personAge, personInformation;
    ImageView photo;
    String photoPath, photoName;
    SQLiteDatabase database;
    PeopleDatabase db;
    int id, generation;
    public final String[] EXTERNAL_PERMISSIONS = {Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editing);

        photo = findViewById(R.id.photo);
        save = findViewById(R.id.save);
        personName = findViewById(R.id.personName);
        personSurname = findViewById(R.id.personSurname);
        personAge = findViewById(R.id.personAge);
        personInformation = findViewById(R.id.personInformation);
        deletePhoto = findViewById(R.id.deletePhoto);
        deletePhoto.setEnabled(false);
        deletePhoto.setTextColor(Color.parseColor("#A10000"));

        db = new PeopleDatabase(this);
        database = db.getWritableDatabase();

        Cursor cursor = database.query("PeopleData", null, "Name = ? AND Surname = ? AND Age = ?",
                new String[]{getIntent().getSerializableExtra("personName").toString(),
                        getIntent().getSerializableExtra("personSurname").toString(),
                        getIntent().getSerializableExtra("personAge").toString()}, null, null, null);
        cursor.moveToFirst();
        id = cursor.getInt(0);
        photoName = id + "";
        generation = cursor.getInt(6);
        if (savedInstanceState != null) {
            personName.setText(savedInstanceState.getString("personName"));
            personSurname.setText(savedInstanceState.getString("personSurname"));
            personAge.setText(savedInstanceState.getString("personAge"));
            personInformation.setText(savedInstanceState.getString("personInformation"));
            if (savedInstanceState.containsKey("photo")) {
                photo.setImageDrawable(Drawable.createFromPath(savedInstanceState.getString("photo")));
                deletePhoto.setEnabled(true);
                deletePhoto.setTextColor(Color.parseColor("#FFFFFF"));
            }
        } else {
            personName.setText(getIntent().getSerializableExtra("personName").toString());
            personSurname.setText(getIntent().getSerializableExtra("personSurname").toString());
            personAge.setText(getIntent().getSerializableExtra("personAge").toString());
            personInformation.setText(getIntent().getSerializableExtra("personInformation").toString());
            if (cursor.getString(5) != null) {
                photoPath = cursor.getString(5);
                photo.setImageDrawable(Drawable.createFromPath(photoPath));
                deletePhoto.setEnabled(true);
                deletePhoto.setTextColor(Color.parseColor("#FFFFFF"));
            }
        }
        cursor.close();

        deletePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getApplicationContext().deleteFile(photoName);
                ContentValues values = new ContentValues();
                String nullPhotoPath = null;
                values.put("PhotoPath", nullPhotoPath);
                database.update("PeopleData", values, "_id = ?", new String[] {Integer.toString(id)});
                photoPath = null;
                Toast toast = Toast.makeText(getApplicationContext(), "Photo removed", Toast.LENGTH_SHORT);
                toast.show();
                startActivity(getIntent());
                finish();
                overridePendingTransition(0, 0);
            }
        });

        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityCompat.requestPermissions(EditingActivity.this, EXTERNAL_PERMISSIONS, 1);
                Intent selectPhotoIntent = new Intent(Intent.ACTION_PICK);
                selectPhotoIntent.setType("image/*");
                startActivityForResult(selectPhotoIntent, 1);
            }
        });

        EditText[] editTexts = {personName, personSurname, personAge};
        EnterFieldsWatcher enterFieldsWatcher = new EnterFieldsWatcher(editTexts, save);
        for (final EditText editText : editTexts) {
            editText.addTextChangedListener(enterFieldsWatcher);
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = personName.getText().toString();
                String surname = personSurname.getText().toString();
                int age = Integer.parseInt(personAge.getText().toString());
                String information = personInformation.getText().toString();
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
                if (generation == 1) {
                    if (age < 5 || age > 100) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Age cannot be so", Toast.LENGTH_SHORT);
                        toast.show();
                        return;
                    }
                } else {
                    if (age > 100) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Age cannot be so", Toast.LENGTH_SHORT);
                        toast.show();
                        return;
                    }
                }
                Cursor cursor = database.query("PeopleData", null, null, null,
                        null, null, null);
                while (cursor.moveToNext()) {
                    if (name.equals(cursor.getString(1)) && surname.equals(cursor.getString(2)) &&
                            age == cursor.getInt(3) && id != cursor.getInt(0)) {
                        Toast toast = Toast.makeText(getApplicationContext(), "Such person already exists", Toast.LENGTH_SHORT);
                        toast.show();
                        return;
                    }
                }
                cursor.close();
                Intent toViewingActivity = new Intent();
                toViewingActivity.putExtra("finishRequest", "finish");
                setResult(RESULT_OK, toViewingActivity);
                ContentValues values = new ContentValues();
                values.put("Name", name);
                values.put("Surname", surname);
                values.put("Age", age);
                values.put("Information", information);
                if (photoPath != null) {
                    values.put("PhotoPath", photoPath);
                }
                database.update("PeopleData", values, "_id = ?", new String[] {Integer.toString(id)});
                Intent intent = new Intent(EditingActivity.this, TreeActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        Bitmap bitmap = null;
        if (resultCode == RESULT_OK) {
            if (imageReturnedIntent != null) {
                Uri selectedPhoto = imageReturnedIntent.getData();
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedPhoto);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                photo.setImageBitmap(bitmap);
                deletePhoto.setEnabled(true);
                deletePhoto.setTextColor(Color.parseColor("#FFFFFF"));

                File photoFile = new File(EditingActivity.this.getFilesDir(), photoName);
                OutputStream outputStream = null;
                try {
                    outputStream = new FileOutputStream(photoFile);
                    bitmap.compress(Bitmap.CompressFormat.PNG, 60, outputStream);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (outputStream != null) {
                            outputStream.close();
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                photoPath = photoFile.getAbsolutePath();
            }
        }
    }


    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        saveInstanceState.putString("personName", personName.getText().toString());
        saveInstanceState.putString("personSurname", personSurname.getText().toString());
        saveInstanceState.putString("personAge", personAge.getText().toString());
        saveInstanceState.putString("personInformation", personInformation.getText().toString());
        saveInstanceState.putString("photoPath", photoPath);
        if (photoPath != null) {
            saveInstanceState.putString("photo", photoPath);
        }
        super.onSaveInstanceState(saveInstanceState);
    }
}