package org.d3ifcool.aplikasi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Nazmi on 11/03/2018.
 */

public class addNewAdapter extends ArrayAdapter<addNew> {
    public addNewAdapter(@NonNull Context context, @NonNull List<addNew> objects) {
        super(context, 0, objects);

    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_list, parent, false);
        }
        //get the object located at position
        addNew currentPosition = getItem(position);
        //find the textview in activity_list with id item
        TextView judul = (TextView) listItemView.findViewById(R.id.item);
        //gets the default Translation and set it to the text of this textView
        judul.setText(currentPosition.getJudul());
        //find the Image View in activity_list with id item
        ImageView img_star = (ImageView) listItemView.findViewById(R.id.star_prio);

        if (currentPosition.ismPrioritas()){
            //if priority of list is True, Then img_star in activity list will set to VISIBLE
            img_star.setVisibility(View.VISIBLE);
        } else {
            //if priority of list is False, Then img_star in activity list will set to INVISIBLE
            img_star.setVisibility(View.INVISIBLE);
        }
        return listItemView;
    }
}