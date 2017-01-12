package com.maximbravo.calculator;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;

import java.util.ArrayList;

/**
 * Created by Maxim Bravo on 1/12/2017.
 */

public class SimpleAdapter extends BaseAdapter {
    Context context;
    ArrayList<String> data;
    private static LayoutInflater inflater = null;
    public SimpleAdapter(Context context, ArrayList<String> data){
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    public void changeItemAt(int postion, String newValue){
        data.set(postion, newValue);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View vi = convertView;
        if (vi == null)
            vi = inflater.inflate(R.layout.row, null);
        EditText text = (EditText) vi.findViewById(R.id.edit_field);
        text.setTag(""+position);
        text.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                int id = position;
                data.set(id, s.toString());
            }
        });

        text.setText(data.get(position));
        return vi;
    }
}
