package team_uganda.ieltsassistor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TrueFalseNGSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_true_false_ngselection);
    }
    public void info(View view)
    {
        Intent i = new Intent(TrueFalseNGSelection.this, UsefulInfoOfTrueFalseType.class);
        startActivity(i);
    }
    public void practice(View view)
    {
        Intent i = new Intent(TrueFalseNGSelection.this, PracticeTrueFalseType.class);
        startActivity(i);
    }
}
