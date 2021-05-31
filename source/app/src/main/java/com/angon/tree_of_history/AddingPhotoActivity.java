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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class AddingPhotoActivity extends AppCompatActivity {

    SQLiteDatabase database;
    PeopleDatabase db;
    TextView personName;
    Button addPhoto, continueButton;
    ImageView imageView;
    File newPhoto;
    String photoPath;
    public final String[] EXTERNAL_PERMISSIONS = {Manifest.permission.READ_EXTERNAL_STORAGE};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adding_photo);

        db = new PeopleDatabase(this);
        database = db.getWritableDatabase();
        photoPath = null;

        imageView = findViewById(R.id.photo);
        personName = findViewById(R.id.personName);
        addPhoto = findViewById(R.id.addPhoto);
        continueButton = findViewById(R.id.continue_button);
        if (savedInstanceState != null) {
            personName.setText(savedInstanceState.getString("personNameText"));
            personName.setTextColor(savedInstanceState.getInt("personNameTextColor"));
            addPhoto.setText(savedInstanceState.getString("addPhotoText"));
            continueButton.setText(savedInstanceState.getString("continueButtonText"));
            photoPath = savedInstanceState.getString("photoPath");
            if (savedInstanceState.containsKey("imageView")) {
                imageView.setImageDrawable(Drawable.createFromPath(savedInstanceState.getString("imageView")));
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        }

        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues values = new ContentValues();
                values.put("Name", getIntent().getSerializableExtra("personName").toString());
                values.put("Surname", getIntent().getSerializableExtra("personSurname").toString());
                values.put("Age", Integer.parseInt(getIntent().getSerializableExtra("personAge").toString()));
                values.put("Information", getIntent().getSerializableExtra("personInformation").toString());
                values.put("Generation", Integer.parseInt(getIntent().getSerializableExtra("personGeneration").toString()));
                database.insert("PeopleData", null, values);
                if (photoPath != null) {
                    Cursor cursor = database.query("PeopleData",
                            null, "Name = ? AND Surname = ? AND Age = ?",
                            new String[] {getIntent().getSerializableExtra("personName").toString(),
                                    getIntent().getSerializableExtra("personSurname").toString(),
                                    getIntent().getSerializableExtra("personAge").toString()}, null, null, null);
                    cursor.moveToFirst();
                    File photo = new File(AddingPhotoActivity.this.getFilesDir(), cursor.getInt(0) + "");
                    cursor.close();
                    newPhoto.renameTo(photo);
                    photoPath = photo.getAbsolutePath();
                    values.put("PhotoPath", photoPath);
                    database.update("PeopleData", values, "Name = ? AND Surname = ? AND Age = ?",
                            new String[] {getIntent().getSerializableExtra("personName").toString(),
                                    getIntent().getSerializableExtra("personSurname").toString(),
                                    getIntent().getSerializableExtra("personAge").toString()});
                }
                Intent intent = new Intent(AddingPhotoActivity.this, TreeActivity.class);
                startActivity(intent);
                finish();
            }
        });

        final Animation press = AnimationUtils.loadAnimation(this, R.anim.press);
        addPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.startAnimation(press);
                ActivityCompat.requestPermissions(AddingPhotoActivity.this, EXTERNAL_PERMISSIONS, 1);
                Intent selectPhotoIntent = new Intent(Intent.ACTION_PICK);
                selectPhotoIntent.setType("image/*");
                startActivityForResult(selectPhotoIntent, 1);
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
                imageView.setImageBitmap(bitmap);
                personName.setText(getIntent().getSerializableExtra("personName").toString() + " " +
                getIntent().getSerializableExtra("personSurname").toString());
                personName.setTextColor(Color.parseColor("#FFFFFF"));
                addPhoto.setText(R.string.change_photo);
                continueButton.setText(R.string.continue_button);

                newPhoto = new File(AddingPhotoActivity.this.getFilesDir(), "NewPhoto");
                OutputStream outputStream = null;
                try {
                    outputStream = new FileOutputStream(newPhoto);
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
                photoPath = newPhoto.getAbsolutePath();
            }
        }
    }


    @Override
    public void onSaveInstanceState(Bundle saveInstanceState) {
        saveInstanceState.putString("personNameText", personName.getText().toString());
        saveInstanceState.putInt("personNameTextColor", personName.getCurrentTextColor());
        saveInstanceState.putString("addPhotoText", addPhoto.getText().toString());
        saveInstanceState.putString("continueButtonText", continueButton.getText().toString());
        saveInstanceState.putString("photoPath", photoPath);
        if (photoPath != null) {
            saveInstanceState.putString("imageView", photoPath);
        }
        super.onSaveInstanceState(saveInstanceState);
    }
}