package team_uganda.ieltsassistor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ClassificationSelection extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classification_selection);
    }
    public void info(View view)
    {
        Intent i = new Intent(ClassificationSelection.this, UsefulInfoOfClassificationSelection.class);
        startActivity(i);
    }
    public void practice(View view)
    {
        Intent i = new Intent(ClassificationSelection.this, PracticeClassificationSelection.class);
        startActivity(i);
    }
}
