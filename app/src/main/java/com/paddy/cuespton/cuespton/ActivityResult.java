package com.paddy.cuespton.cuespton;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class ActivityResult extends ActionBarActivity {

    @InjectView(R.id.textViewResult)
    protected TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ButterKnife.inject(this);
    }
}
