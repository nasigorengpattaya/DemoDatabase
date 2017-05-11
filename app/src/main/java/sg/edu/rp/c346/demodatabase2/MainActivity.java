package sg.edu.rp.c346.demodatabase2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnInsert;
    Button btnGetTasks;
    TextView tvTasks;
    ListView lvTasks;
    ArrayAdapter aa;
    ArrayList<Task> tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnInsert = (Button)findViewById(R.id.btnInsert);
        btnGetTasks = (Button)findViewById(R.id.btnGetTask);
        tvTasks = (TextView)findViewById(R.id.textViewTask);
        lvTasks = (ListView)findViewById(R.id.listViewTasks);


        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);
                db.insertTask("Submit RJ", "25 April 2017");
                db.close();
            }
        });

        btnGetTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DBHelper db = new DBHelper(MainActivity.this);

                ArrayList<String> data = db.getTaskContent();
                db.close();

                String text = "";

                ArrayList<Task> al = db.getTasks();

                for (int i=0; i<data.size(); i++) {
                    Log.d("Database content", i + ". " + data.get(i));
                    text += i + ". " + data.get(i) + "\n";
                    aa = new customAdapter(MainActivity.this,R.layout.row,al);
                    lvTasks.setAdapter(aa);
                }

                tvTasks.setText(text);
            }
        });
    }
}
