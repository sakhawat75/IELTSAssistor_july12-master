package team_uganda.ieltsassistor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TrainYourself extends AppCompatActivity implements View.OnClickListener {

    private Button buttonReading;
    private Button buttonWriting;
    private Button buttonListening;
    private Button buttonSpeaking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_yourself);

        buttonReading = (Button) findViewById(R.id.buttonReading);
        buttonWriting = (Button) findViewById(R.id.buttonWriting);
        buttonListening = (Button) findViewById(R.id.buttonListening);
        buttonSpeaking = (Button) findViewById(R.id.buttonSpeaking);

        buttonReading.setOnClickListener(this);
        buttonWriting.setOnClickListener(this);
        buttonListening.setOnClickListener(this);
        buttonSpeaking.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if( v.getId() == R.id.buttonReading) {
            Intent intent = new Intent(getApplicationContext(), TrainReading.class);
            startActivity(intent);
            //finish();
        } else if(v.getId() == R.id.buttonWriting) {

        } else if (v.getId() == R.id.buttonListening) {

        } else if(v.getId() == R.id.buttonSpeaking){

        }
    }
}
