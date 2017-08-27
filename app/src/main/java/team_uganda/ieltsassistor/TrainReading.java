package team_uganda.ieltsassistor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrainReading extends Activity implements View.OnClickListener {

    private Button buttonMCQ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_reading);

        buttonMCQ = (Button) findViewById(R.id.buttonMCQ);

        buttonMCQ.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.buttonMCQ) {
            Intent intent = new Intent(getApplicationContext(), MCQ.class);
            startActivity(intent);
            //finish();
        }
    }
}
