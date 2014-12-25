package com.paddy.cuespton.cuespton;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public class AdapterCountrySelect extends BaseAdapter {

    private List<String> countries;

    public AdapterCountrySelect(List<String> countries) {
        this.countries = countries;
    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public Object getItem(int position) {
        return countries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {

        final ViewCountrySelect listItem;

        if (view == null) {
            listItem = new ViewCountrySelect(parent.getContext());
        } else {
            listItem = (ViewCountrySelect) view;
        }

        listItem.updateWithCountry(countries.get(position));

        return listItem;
    }
}
