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
import com.mobsandgeeks.saripaar.annotation.Email;
import com.mobsandgeeks.saripaar.annotation.Required;
import com.mobsandgeeks.saripaar.annotation.TextRule;


public class ActivityLogin extends ActionBarActivity implements Validator.ValidationListener {

    @Required(order = 0, message = "This field is required.")
    @Email(order = 1, message = "Enter valid email.")
    @InjectView(R.id.editTextLogin)
    protected EditText editTextLogin;

    @Required(order = 3, message = "This field is required.")
    @TextRule(order = 4, minLength = 8, message = "Enter valid password. At least 8 characters.")
    @InjectView(R.id.editTextPassword)
    protected EditText editTextPassword;

    @InjectView(R.id.buttonLogin)
    protected Button buttonLogin;

    private Validator validator;
    private EditText currentEditTextWithError;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_login);

        ButterKnife.inject(this);

        validator = new Validator(this);
        validator.setValidationListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        buttonLogin.setEnabled(true);
    }

    @OnClick(R.id.buttonLogin)
    protected void submit() {
        validator.validate();
    }

    @Override
    public void onValidationSucceeded() {
        buttonLogin.setEnabled(false);
        if (currentEditTextWithError != null) {
            currentEditTextWithError.setError(null);
        }

        startFormActivity();
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

    private void startFormActivity() {
        Intent formActivityIntent = new Intent(this, ActivityForm.class);
        startActivity(formActivityIntent);
    }
}
