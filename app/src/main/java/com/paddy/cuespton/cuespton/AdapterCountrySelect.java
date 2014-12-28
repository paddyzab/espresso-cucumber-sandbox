package com.paddy.cuespton.cuespton;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public class AdapterCountrySelect extends BaseAdapter {

    private List<String> countries;
    private int selectedIndex = -1;

    public AdapterCountrySelect(List<String> countries) {
        this.countries = countries;
    }

    @Override
    public int getCount() {
        return countries.size();
    }

    @Override
    public String getItem(int position) {
        return countries.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void setSelectedIndex(int index){
        selectedIndex = index;
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
        listItem.updateSelection(selectedIndex == position);

        return listItem;
    }
}
