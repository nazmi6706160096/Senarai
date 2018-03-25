package org.d3ifcool.aplikasi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nazmi on 16/03/2018.
 */

public class todayAdapter extends ArrayAdapter<addNew> {
    public todayAdapter(@NonNull Context context, @NonNull List<addNew> objects) {
        super(context, 0, objects);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.today_list, parent, false);
        }
        //get the object located at position
        addNew currentPosition = getItem(position);
        //find the textview in today list with id item
        TextView judul = (TextView) listItemView.findViewById(R.id.judul_agenda);
        //gets the default Translation and set it to the text of this textView
        judul.setText(currentPosition.getJudul());

        return listItemView;
    }
}

