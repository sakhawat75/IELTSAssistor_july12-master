package team_uganda.ieltsassistor;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class TrainReading extends Activity implements View.OnClickListener {

    private Button buttonMCQ;
    private Button buttonListOfHeadings;
    private Button buttonSentenceCompletion;
    private Button buttonClassification;
    private Button buttonTrueFalseNG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train_reading);

        buttonMCQ = (Button) findViewById(R.id.buttonMCQ);
        buttonListOfHeadings = (Button)findViewById(R.id.buttonListOfHeadings);
        buttonSentenceCompletion = (Button)findViewById(R.id.buttonSentenceCompletion);
        buttonClassification = (Button)findViewById(R.id.buttonClassification);
        buttonTrueFalseNG = (Button)findViewById(R.id.buttonTrueFalseNG);

        buttonMCQ.setOnClickListener(this);
        buttonListOfHeadings.setOnClickListener(this);
        buttonSentenceCompletion.setOnClickListener(this);
        buttonClassification.setOnClickListener(this);
        buttonTrueFalseNG.setOnClickListener(this);
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
        else if(v.getId() == R.id.buttonSentenceCompletion){
            Intent intent = new Intent(getApplicationContext(), SentenceCompletion.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Going to Sentence Completion activity", Toast.LENGTH_SHORT).show();
        }
        else if(v.getId() == R.id.buttonClassification){
            Intent intent = new Intent(getApplicationContext(), ClassificationSelection.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Going to Classification selection activity", Toast.LENGTH_SHORT).show();
        }
        else if(v.getId() == R.id.buttonTrueFalseNG){
            Intent intent = new Intent(getApplicationContext(), TrueFalseNGSelection.class);
            startActivity(intent);
            Toast.makeText(getApplicationContext(),"Going to True False NG activity", Toast.LENGTH_SHORT).show();
        }



    }
}
