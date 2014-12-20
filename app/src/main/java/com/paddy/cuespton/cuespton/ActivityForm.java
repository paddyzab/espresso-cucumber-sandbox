package com.paddy.cuespton.cuespton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.Button;
import android.widget.EditText;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

public class ActivityForm extends ActionBarActivity {


    @InjectView(R.id.editTextName)
    protected EditText editTextName;

    @InjectView(R.id.editTextLastName)
    protected EditText editTextLastName;

    @InjectView(R.id.editTextStreet)
    protected EditText editTextStreet;

    @InjectView(R.id.editTextStreetNumber)
    protected EditText editTextStreetNumber;

    @InjectView(R.id.editTextCity)
    protected EditText editTextCity;

    @InjectView(R.id.editTextPostalNumber)
    protected EditText editTextPostalNumber;

    @InjectView(R.id.buttonSubmit)
    protected Button buttonSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_form);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.buttonSubmit)
    protected void submitForm() {
        startResultActivity();
    }

    private void startResultActivity() {
        Intent resultIntent = new Intent(this, ActivityResult.class);
        startActivity(resultIntent);
    }
}
