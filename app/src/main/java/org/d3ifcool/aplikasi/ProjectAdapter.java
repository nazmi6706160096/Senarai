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
 * Created by Nazmi on 16/03/2018.
 */

public class ProjectAdapter extends ArrayAdapter<addNew> {
    public ProjectAdapter(@NonNull Context context, @NonNull List<addNew> objects) {
        super(context, 0, objects);
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_view_project, parent, false);
        }

        addNew currentPosition = getItem(position);

        TextView judul = (TextView) listItemView.findViewById(R.id.judul_textview_project);
        judul.setText(currentPosition.getJudul());

        TextView tanggal = (TextView) listItemView.findViewById(R.id.tanggal_projek);
        tanggal.setText(currentPosition.getmDate());

        TextView jam = (TextView) listItemView.findViewById(R.id.jam_projek);
        jam.setText("23:01");

        ImageView img_star = (ImageView) listItemView.findViewById(R.id.star_prio_projek);

        if (currentPosition.ismPrioritas()) {
            img_star.setVisibility(View.VISIBLE);
        } else {
            img_star.setVisibility(View.INVISIBLE);
        }

        ImageView img_projek = (ImageView) listItemView.findViewById(R.id.img_projek);
        img_projek.setImageResource(currentPosition.getmImage());

        return listItemView;
    }
}
