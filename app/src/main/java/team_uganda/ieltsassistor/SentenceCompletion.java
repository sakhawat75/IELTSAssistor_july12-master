package team_uganda.ieltsassistor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class SentenceCompletion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sentence_completion);
    }
    public void info(View view)
    {
        Intent i = new Intent(SentenceCompletion.this, UsefulInfoOfSentenceCompletion.class);
        startActivity(i);
    }
    public void practice(View view)
    {
        Intent i = new Intent(SentenceCompletion.this, PracticeSentenceCompletion.class);
        startActivity(i);
    }
}
