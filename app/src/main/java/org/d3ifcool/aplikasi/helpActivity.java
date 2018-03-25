package org.d3ifcool.aplikasi;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Nazmi on 11/03/2018.
 */

public class helpActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView textView = new TextView(this);
        textView.setText("Help Layout");
        setContentView(textView);
    }
}

