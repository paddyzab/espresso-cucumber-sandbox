package com.paddy.cuespton.cuespton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import java.util.ArrayList;
import java.util.List;

public class ActivityCountrySelect extends Activity implements AdapterView.OnItemClickListener {

    private List<String> countries = new ArrayList<>();
    private AdapterCountrySelect adapterCountrySelect;

    private FormData formData;

    @InjectView(R.id.listViewCounties)
    protected ListView listViewCountries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_country_select);
        ButterKnife.inject(this);
        addDataToList();

        adapterCountrySelect = new AdapterCountrySelect(countries);
        listViewCountries.setAdapter(adapterCountrySelect);
        listViewCountries.setOnItemClickListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (formData != null) {
            adapterCountrySelect.setSelectedIndex(countries.indexOf(formData.getCountry()));
            adapterCountrySelect.notifyDataSetInvalidated();
        }
    }

    @OnClick(R.id.buttonConfirm)
    protected void confirm() {
        //TODO: validation is still missing
        formData = new FormData();
        formData.setCountry(adapterCountrySelect.getSelectedCountry());

        final Intent resultIntent = new Intent(this, ActivityForm.class);
        resultIntent.putExtra("FORM_DATA", formData);
        startActivity(resultIntent);
    }

    private void addDataToList() {
        countries.add("Italy");
        countries.add("Germany");
        countries.add("Greece");
        countries.add("France");
    }

    @Override
    public void onItemClick(AdapterView<?> parentView, View view, int position, long id) {
        adapterCountrySelect.setSelectedIndex(position);
        adapterCountrySelect.notifyDataSetInvalidated();
    }
}
