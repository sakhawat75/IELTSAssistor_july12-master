package team_uganda.ieltsassistor;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MCQ extends Activity {

    private McqLibrary myMcq= new McqLibrary();

    private TextView textViewPassage;
    private TextView textViewQuestion;
    private TextView textViewResult;
    private TextView textViewExplanation;
    private TextView textViewExplanationTittle;

    private RadioGroup radioGroup;

    private RadioButton choice1;
    private RadioButton choice2;
    private RadioButton choice3;
    private RadioButton choice4;

    private Button buttonNextQuestion;

    private int correctAnswer = 0;
    private int questonNumber = 0;
    private int passageNumber = 0;
    private int totalQuestion = myMcq.getTotalQuestionCount();
    private int totalPassage = myMcq.getTotalPassageCount();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mcq);

        textViewPassage = (TextView) findViewById(R.id.textViewPassage);
        textViewQuestion = (TextView) findViewById(R.id.textViewQuestion);
        textViewResult = (TextView) findViewById(R.id.textViewResult);
        textViewExplanation = (TextView) findViewById(R.id.textViewExplanation);
        textViewExplanationTittle = (TextView) findViewById(R.id.textViewExplanationTittle);

        textViewExplanationTittle.setVisibility(View.GONE);
        textViewExplanation.setVisibility(View.GONE);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);

        choice1 = (RadioButton) findViewById(R.id.choice1);
        choice2 = (RadioButton) findViewById(R.id.choice2);
        choice3 = (RadioButton) findViewById(R.id.choice3);
        choice4 = (RadioButton) findViewById(R.id.choice4);

        buttonNextQuestion = (Button) findViewById(R.id.buttonNextQuestion);


        if(passageNumber < totalPassage) {
            textViewPassage.setText(myMcq.getPassage(passageNumber));
            updateQuestion();
        }




        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {

                choice1.setTextColor(Color.BLACK);
                choice2.setTextColor(Color.BLACK);
                choice3.setTextColor(Color.BLACK);
                choice4.setTextColor(Color.BLACK);

                switch (checkedId) {
                    case R.id.choice1:
                        if(correctAnswer == 0) {
                            updateResultTextView(true);
                        } else {
                            choice1.setTextColor(Color.RED);
                            updateResultTextView(false);
                        }
                        break;

                    case R.id.choice2:
                        if(correctAnswer == 1) {
                            updateResultTextView(true);
                        } else {
                            choice2.setTextColor(Color.RED);
                            updateResultTextView(false);
                        }
                        break;

                    case R.id.choice3:
                        if(correctAnswer == 2) {
                            updateResultTextView(true);
                        } else {
                            choice3.setTextColor(Color.RED);
                            updateResultTextView(false);
                        }
                        break;

                    case R.id.choice4:
                        if(correctAnswer == 3) {

                            updateResultTextView(true);
                        } else {
                            choice4.setTextColor(Color.RED);
                            updateResultTextView(false);
                        }
                        break;
                }

                setCorrectButtonColor();
            }
        });

        buttonNextQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(radioGroup.getCheckedRadioButtonId() == -1){
                    Toast.makeText(MCQ.this, "Please Select an Item", Toast.LENGTH_SHORT).show();
                } else {

                    if(questonNumber < totalQuestion-1) {
                        questonNumber++;
                        updateQuestion();
                        radioGroup.clearCheck();
                        textViewResult.setText("Please select an answer");
                        choice1.setTextColor(Color.BLACK);
                        choice2.setTextColor(Color.BLACK);
                        choice3.setTextColor(Color.BLACK);
                        choice4.setTextColor(Color.BLACK);
                        textViewExplanationTittle.setVisibility(View.GONE);
                        textViewExplanation.setVisibility(View.GONE);

                    } else {
                        Toast.makeText(MCQ.this, "No more question", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }


            }
        });
    }

    private void setCorrectButtonColor() {

        switch (correctAnswer) {
            case 0:
                choice1.setTextColor(Color.GREEN);
                break;
            case 1:
                choice2.setTextColor(Color.GREEN);
                break;
            case 2:
                choice3.setTextColor(Color.GREEN);
                break;
            case 3:
                choice4.setTextColor(Color.GREEN);
                break;

        }
    }


    public void updateQuestion() {
        textViewQuestion.setText(myMcq.getQuestion(questonNumber));

        choice1.setText(myMcq.getChoice1(questonNumber));
        choice2.setText(myMcq.getChoice2(questonNumber));
        choice3.setText(myMcq.getChoice3(questonNumber));
        choice4.setText(myMcq.getChoice4(questonNumber));

       correctAnswer = myMcq.getCorrectAnswer(questonNumber);
    }

    public void updateResultTextView(boolean correct) {
        if(correct) {
            textViewResult.setText("Correct");
        } else {
            textViewResult.setText("Incorrect");
        }
        textViewExplanation.setText(myMcq.getExplanation(questonNumber));
        textViewExplanationTittle.setVisibility(View.VISIBLE);
        textViewExplanation.setVisibility(View.VISIBLE);
    }

}
