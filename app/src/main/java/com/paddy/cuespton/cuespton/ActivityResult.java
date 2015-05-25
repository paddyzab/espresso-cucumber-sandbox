package com.paddy.cuespton.cuespton;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class ActivityResult extends Activity {

    @InjectView(R.id.textViewResult)
    protected TextView textViewResult;

    private FormData formData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ButterKnife.inject(this);

        formData = getIntent().getParcelableExtra("FORM_DATA");

        textViewResult.setText("Hi and Welcome " + formData.getName() + " " + formData.getLastName());
    }
}
