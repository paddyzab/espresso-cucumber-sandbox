package com.paddy.cuespton.cuespton;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import java.util.ArrayList;
import java.util.List;

public class ActivityCountrySelect extends Activity {

    List<String> countries = new ArrayList<>();


    @InjectView(R.id.listViewCounties)
    protected ListView listViewCountries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_country_select);
        ButterKnife.inject(this);
        addDataToList();

        listViewCountries.setAdapter(new AdapterCountrySelect(countries));
    }

    @OnClick(R.id.buttonConfirm)
    protected void confirm() {
        //TODO start Result activity
    }

    private void addDataToList() {
        countries.add("Italy");
        countries.add("Germany");
        countries.add("Greece");
        countries.add("France");
    }
}
