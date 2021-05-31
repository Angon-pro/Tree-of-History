package com.angon.tree_of_history;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;

/* Нужен для проверки заполненности полей и деактивации кнопки если те пусты */

public class EnterFieldsWatcher implements TextWatcher {

    Button button;
    EditText[] editTexts;

    public EnterFieldsWatcher(EditText[] editTexts, Button button) {
        this.editTexts = editTexts;
        this.button = button;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        for (EditText editText : editTexts) {
            if (editText.getText().toString().trim().equals("")) {
                button.setEnabled(false);
                button.setTextColor(Color.parseColor("#2300D0"));
                break;
            } else {
                button.setEnabled(true);
                button.setTextColor(Color.parseColor("#FFFFFF"));
            }
        }
    }
}