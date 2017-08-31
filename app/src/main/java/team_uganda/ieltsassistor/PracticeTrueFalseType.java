package team_uganda.ieltsassistor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class PracticeTrueFalseType extends AppCompatActivity {
    private String passage = " More than ten years ago, while taking the temperature of the universe,\n" +
            " astronomers found something odd.\n" +
            " They discovered that a patch of sky, spanning the width of 20 moons, was unusually cold.\n" +
            " The astronomers were measuring the thermal radiation that bathes the entire universe,\n" +
            " a glowing relic of the big bang.To gaze at this cosmic microwave background,\n" +
            " or CMB, is to glimpse the primordial1 universe, a time when it was less than 400,000 years old.\n" +
            " The CMB blankets the sky, and looks pretty much the same everywhere, \n" +
            " existing at a feebly cold temperature of 2.725 kelvins -\n" +
            " just a couple degrees warmer than absolute zero.\n" +
            " But armed with the newly launched WMAP satellite,\n" +
            " the astronomers had set out to probe temperature variations as tiny as one part in 100,000.\n" +
            " Born from the quantum froth that was the universe a half-moment after the big bang, \n" +
            "those random fluctuations help scientists understand what the cosmos is made of and how it all came to be.";
    private String questionSet = "Do the following statements agree with the information given in Reading Passage?\n" +
            "\n" +
            "In boxes 1–5, choose\n" +
            "\n" +
            "TRUE : if the statement agrees with the information\n" +
            "\n" +
            "FALSE: if the statement contradicts the information\n" +
            "\n" +
            "NOT GIVEN : if there is no information on this\n" +
            "\n" +
            "1. Astronomers often find something odd on the sky.\n" +
            "2.The CMB is the thermal radiation across the entire universe.\n" +
            "3.The CMB varies from extremely low to very high temperatures.\n" +
            "4.Investigation of fluctuations of temperature in the space help\n" +
            "  scientists to understand what the cosmos is made of.\n" +
            "5. The cosmic supervoid is the largest structure in the universe. ";

    private TextView stringPassageTF;
    private TextView questionsOfTF;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_true_false_type);
        stringPassageTF = (TextView)findViewById(R.id.stringPassageTF);
        questionsOfTF = (TextView)findViewById(R.id.questionsOfTF);
        stringPassageTF.setText(passage);
        questionsOfTF.setText(questionSet);

    }
}
