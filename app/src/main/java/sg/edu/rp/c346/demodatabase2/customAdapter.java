package sg.edu.rp.c346.demodatabase2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by 15017420 on 11/5/2017.
 */

public class customAdapter extends ArrayAdapter<Task> {
    private ArrayList<Task> task;
    private Context context;
    private TextView tvId;
    private TextView tvDesc;
    private TextView tvDate;
    public customAdapter(Context context, int resource, ArrayList<Task> objects) {
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        task = objects;
        // Store Context object as we would need to use it later
        this.context = context;

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.row, parent, false);

        // Get the TextView object
        tvId = (TextView) rowView.findViewById(R.id.textViewId);
        tvDesc= (TextView) rowView.findViewById(R.id.textViewDesc);
        tvDate= (TextView) rowView.findViewById(R.id.textViewDate);

        Task currentTask = task.get(position);
        // Set the TextView to show the food

        tvId.setText(currentTask.getId()+"");
        tvDesc.setText(currentTask.getDescription());
        tvDate.setText(currentTask.getDate());
        // Set the image to star or nostar accordingly

        // Return the nicely done up View to the ListView
        return rowView;
    }
}
