package team_uganda.ieltsassistor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ListOfHeadings extends AppCompatActivity {

    HeadingLibrary myHeadings = new HeadingLibrary();

    private TextView paragraphView;
    private TextView headingsView;

    private EditText paragraphA;
    private EditText paragraphB;
    private EditText paragraphC;
    private EditText paragraphD;
    private EditText paragraphE;
    private EditText paragraphF;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_headings);

        paragraphView = (TextView) findViewById(R.id.paragraphView);
        headingsView = (TextView) findViewById(R.id.headingsView);

        paragraphA = (EditText) findViewById(R.id.paragraphA);
        paragraphB = (EditText) findViewById(R.id.paragraphB);
        paragraphC = (EditText) findViewById(R.id.paragraphC);
        paragraphD = (EditText) findViewById(R.id.paragraphD);
        paragraphE = (EditText) findViewById(R.id.paragraphE);
        paragraphF = (EditText) findViewById(R.id.paragraphF);

        paragraphView.setText(myHeadings.getParragraph());
        headingsView.setText(myHeadings.getHeadings());


    }
}
