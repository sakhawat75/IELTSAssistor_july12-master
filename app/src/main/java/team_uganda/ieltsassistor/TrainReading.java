package team_uganda.ieltsassistor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrainReading extends Activity implements View.OnClickListener {

    private Button buttonMCQ;
    private Button buttonListOfHeadings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_reading);

        buttonMCQ = (Button) findViewById(R.id.buttonMCQ);
        buttonListOfHeadings = (Button)findViewById(R.id.buttonListOfHeadings);

        buttonMCQ.setOnClickListener(this);
        buttonListOfHeadings.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.buttonMCQ) {
            Intent intent = new Intent(getApplicationContext(), MCQ.class);
            startActivity(intent);

            //finish();
        }
        else if(v.getId() == R.id.buttonListOfHeadings){
            Intent intent = new Intent(getApplicationContext(), ListOfHeadings.class);
            startActivity(intent);
        }


    }
}
