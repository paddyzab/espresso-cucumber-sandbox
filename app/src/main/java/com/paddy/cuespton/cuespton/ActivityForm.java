package com.paddy.cuespton.cuespton;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import com.mobsandgeeks.saripaar.Rule;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NumberRule;
import com.mobsandgeeks.saripaar.annotation.Required;
import static com.mobsandgeeks.saripaar.annotation.NumberRule.NumberType.INTEGER;

public class ActivityForm extends ActionBarActivity implements Validator.ValidationListener {

    @Required(order = 0, message = "This field is required.")
    @InjectView(R.id.editTextName)
    protected EditText editTextName;

    @Required(order = 1, message = "This field is required.")
    @InjectView(R.id.editTextLastName)
    protected EditText editTextLastName;

    @Required(order = 2, message = "This field is required.")
    @InjectView(R.id.editTextStreet)
    protected EditText editTextStreet;

    @Required(order = 3, message = "This field is required.")
    @NumberRule(order = 4, type = INTEGER, message = "Street number must be number.")
    @InjectView(R.id.editTextStreetNumber)
    protected EditText editTextStreetNumber;

    @Required(order = 5, message = "This field is required.")
    @InjectView(R.id.editTextCity)
    protected EditText editTextCity;

    @NumberRule(order = 6, type = INTEGER, message = "Postal number must be number.")
    @InjectView(R.id.editTextPostalNumber)
    protected EditText editTextPostalNumber;

    @InjectView(R.id.buttonSubmit)
    protected Button buttonSubmit;

    private Validator validator;
    private EditText currentEditTextWithError;
    private FormData formData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_form);
        ButterKnife.inject(this);

        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (formData != null) {
            editTextName.setText(formData.getName());
            editTextLastName.setText(formData.getLastName());
            editTextCity.setText(formData.getCity());
            editTextStreet.setText(formData.getStreetName());
            editTextStreetNumber.setText(String.valueOf(formData.getStreetNumber()));
            editTextPostalNumber.setText(String.valueOf(formData.getPostalNumber()));
        }

        buttonSubmit.setEnabled(true);
    }

    @OnClick(R.id.buttonSubmit)
    protected void submitForm() {
        validator.validate();
    }

    @Override
    public void onValidationSucceeded() {
        buttonSubmit.setEnabled(false);
        if (currentEditTextWithError != null) {
            currentEditTextWithError.setError(null);
        }

        startResultActivity();
    }

    @Override
    public void onValidationFailed(View failedView, Rule<?> failedRule) {
        if (currentEditTextWithError != null) {
            currentEditTextWithError.setError(null);
        }

        currentEditTextWithError = (EditText) failedView;
        currentEditTextWithError.setError(failedRule.getFailureMessage());
        currentEditTextWithError.requestFocus();
    }

    private void startResultActivity() {
        formData = new FormData();
        formData.setName(editTextName.getText().toString());
        formData.setLastName(editTextLastName.getText().toString());
        formData.setStreetName(editTextStreet.getText().toString());
        formData.setCity(editTextCity.getText().toString());
        formData.setStreetNumber(Integer.valueOf(editTextStreetNumber.getText().toString()));
        formData.setPostalNumber(Integer.valueOf(editTextPostalNumber.getText().toString()));

        final Intent resultIntent = new Intent(this, ActivityResult.class);
        resultIntent.putExtra("FORM_DATA", formData);
        startActivity(resultIntent);
    }
}
