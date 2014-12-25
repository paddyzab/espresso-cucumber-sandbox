package com.paddy.cuespton.cuespton;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckBox;
import android.widget.Checkable;
import android.widget.FrameLayout;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class ViewCountrySelect extends FrameLayout implements Checkable {

    @InjectView(R.id.textViewCountry)
    protected TextView textViewCountry;

    @InjectView(R.id.checkboxSelectCountry)
    protected CheckBox checkboxSelectCountry;

    public ViewCountrySelect(Context context) {
        this(context, null);
    }

    public ViewCountrySelect(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ViewCountrySelect(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(context, R.layout.view_country_select, this);
        ButterKnife.inject(this);
    }

    public void updateWithCountry(final String country) {
        textViewCountry.setText(country);
    }

    @Override
    public void setChecked(boolean isChecked) {
        checkboxSelectCountry.setChecked(isChecked);
    }

    @Override
    public boolean isChecked() {
        return checkboxSelectCountry.isChecked();
    }

    @Override
    public void toggle() {
        checkboxSelectCountry.toggle();
    }
}
