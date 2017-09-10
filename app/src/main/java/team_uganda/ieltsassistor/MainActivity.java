package team_uganda.ieltsassistor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    //button class taki object nilam 5 tar laagi
    Button calculateScore;
    Button locationFinder;
    Button trainner;
    Button bookStorage;
    Button tipOfTheDay;
    Button signinOrUp;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //object gula findViewByid di initialize/ assign korlam
        calculateScore = (Button) findViewById(R.id.ielts_calculator);
        locationFinder = (Button) findViewById(R.id.ielts_location_finder);
        trainner = (Button) findViewById(R.id.ielts_trainning);
        bookStorage = (Button) findViewById(R.id.ielts_rareBooks);
        tipOfTheDay = (Button) findViewById(R.id.ielts_tipOfTheDay);
        signinOrUp = (Button) findViewById(R.id.button_signinOrSignup);

        toolbar=(Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);


    }

    public void calculate(View v)
    {
        Toast.makeText(getApplicationContext(), "Going to IeltsCalculator activity", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, IeltsCalculator.class);
        startActivity(intent);
    }
    public void findLoc(View v)
    {
        Toast.makeText(getApplicationContext(), "Going to Exam centre activity", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, ExamCentre.class);
        startActivity(intent);
    }
    public void doTrainning (View v)
    {
        Toast.makeText(getApplicationContext(), "Going to Train Yourself activity", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, TrainYourself.class);
        startActivity(intent);
    }
    public void bookStore(View v)
    {
        Toast.makeText(getApplicationContext(), "Going to BookStorage activity", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, BookStorage.class);
        startActivity(intent);
    }
    public void findTips(View v)
    {
        Intent intent = new Intent(this, PopupTips.class);
        startActivity(intent);

    }

    public void doSigninOrUp(View v)
    {
        Intent intent = new Intent(this, SignInOrUp.class);
        startActivity(intent);
    }
}
