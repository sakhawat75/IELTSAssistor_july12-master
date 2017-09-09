package team_uganda.ieltsassistor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class IeltsCalculator extends AppCompatActivity {
    //ekano ekta data src+ view obj+ adapter lagbo as we're using spinner class!!!
    //view object
    private Spinner numberOfCorrectAnswerInWriting;
    private Spinner numberOfCorrectAnswerInSpeaking;

    //data src
    private static String[] numbers = {"Select", "2.0", "2.5", "3.0", "3.5", "4.0", "4.5", "5.0",
            "5.5", "6.0", "6.5", "7.0", "7.5", "8.0", "8.5", "9.0"};

    //to bind ACT and data src, need adapter
    ArrayAdapter<String> score_adapter;

    EditText listeningNum;
    EditText ReadingNum;
    //Button calculateListeningScore;
    //Button calculateReadingScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ielts_calculator);
        listeningNum = (EditText) findViewById(R.id.listeningScore);
        ReadingNum = (EditText) findViewById(R.id.readingScore);
        //calculateListeningScore = (Button) findViewById(R.id.getListeningScore);
        //calculateReadingScore = (Button) findViewById(R.id.getReadingScore);
        //initialize view object
        numberOfCorrectAnswerInWriting = (Spinner) findViewById(R.id.select_score);
        numberOfCorrectAnswerInSpeaking = (Spinner) findViewById(R.id.select_score_1);
        //initialize arrayAdapter
        score_adapter = new ArrayAdapter<String>(IeltsCalculator.this,
                android.R.layout.simple_spinner_item, numbers);

        //combine with adapter and ds
        numberOfCorrectAnswerInWriting.setAdapter(score_adapter);
        numberOfCorrectAnswerInWriting.setSelection(score_adapter.NO_SELECTION, false);
        numberOfCorrectAnswerInSpeaking.setAdapter(score_adapter);
        numberOfCorrectAnswerInSpeaking.setSelection(score_adapter.NO_SELECTION, false);

        //numberOfCorrectAnswer1.setOnItemSelectedListener(listener);
        // numberOfCorrectAnswer.setAdapter(arrayAdapter);
        numberOfCorrectAnswerInWriting.setOnItemSelectedListener(listener);
        numberOfCorrectAnswerInSpeaking.setOnItemSelectedListener(listener1);
    }

    AdapterView.OnItemSelectedListener listener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //int aNum = Integer.parseInt(numberOfCorrectAnswer.getSelectedItem().toString());
            String string = numberOfCorrectAnswerInWriting.getSelectedItem().toString();
            if (!string.equals("Select")) {
                Double aNum = Double.parseDouble(string);

                if (aNum.equals(2.0)) {
                    Toast.makeText(getApplicationContext(), "You scored  2 in writing",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(2.5)) {
                    Toast.makeText(getApplicationContext(), "You scored  2.5 in writing",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(3.0)) {
                    Toast.makeText(getApplicationContext(), "You scored  3 in writing",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(3.5)) {
                    Toast.makeText(getApplicationContext(), "You scored  3.5 in writing",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(4.0)) {
                    Toast.makeText(getApplicationContext(), "You scored  4 in writing",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(4.5)) {
                    Toast.makeText(getApplicationContext(), "You scored  4.5 in writing",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(5.0)) {
                    Toast.makeText(getApplicationContext(), "You scored  5 in writing",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(5.5)) {
                    Toast.makeText(getApplicationContext(), "You scored  5.5 in writing",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(6.0)) {
                    Toast.makeText(getApplicationContext(), "You scored  6 in writing",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(6.5)) {
                    Toast.makeText(getApplicationContext(), "You scored  6.5 in writing",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(7.0)) {
                    Toast.makeText(getApplicationContext(), "You scored  7 in writing",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(7.5)) {
                    Toast.makeText(getApplicationContext(), "You scored  7. 5 in writing",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(8.0)) {
                    Toast.makeText(getApplicationContext(), "You scored  8 in writing",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(8.5)) {
                    Toast.makeText(getApplicationContext(), "You scored  8. 5 in writing",
                            Toast.LENGTH_LONG).show();

                    Toast.makeText(getApplicationContext(), "You scored  9 in writing",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(9.0)) {
                    Toast.makeText(getApplicationContext(), "You scored  9 in writing",
                            Toast.LENGTH_LONG).show();

                }
            }

        }


        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    AdapterView.OnItemSelectedListener listener1 = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            //int aNum = Integer.parseInt(numberOfCorrectAnswer.getSelectedItem().toString());
            String string = numberOfCorrectAnswerInSpeaking.getSelectedItem().toString();
            if (!string.equals("Select")) {
                Double aNum = Double.parseDouble(string);

                if (aNum.equals(2.0)) {
                    Toast.makeText(getApplicationContext(), "You scored  2 in speaking",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(2.5)) {
                    Toast.makeText(getApplicationContext(), "You scored  2.5 in speaking",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(3.0)) {
                    Toast.makeText(getApplicationContext(), "You scored  3 in speaking",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(3.5)) {
                    Toast.makeText(getApplicationContext(), "You scored  3.5 in speaking",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(4.0)) {
                    Toast.makeText(getApplicationContext(), "You scored  4 in speaking",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(4.5)) {
                    Toast.makeText(getApplicationContext(), "You scored  4.5 in speaking",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(5.0)) {
                    Toast.makeText(getApplicationContext(), "You scored  5 in speaking",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(5.5)) {
                    Toast.makeText(getApplicationContext(), "You scored  5.5 in speaking",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(6.0)) {
                    Toast.makeText(getApplicationContext(), "You scored  6 in speaking",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(6.5)) {
                    Toast.makeText(getApplicationContext(), "You scored  6.5 in speaking",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(7.0)) {
                    Toast.makeText(getApplicationContext(), "You scored  7 in speaking",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(7.5)) {
                    Toast.makeText(getApplicationContext(), "You scored  7. 5 in speaking",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(8.0)) {
                    Toast.makeText(getApplicationContext(), "You scored  8 in speaking",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(8.5)) {
                    Toast.makeText(getApplicationContext(), "You scored  8. 5 in speaking",
                            Toast.LENGTH_LONG).show();

                    Toast.makeText(getApplicationContext(), "You scored  9 in speaking",
                            Toast.LENGTH_LONG).show();

                } else if (aNum.equals(9.0)) {
                    Toast.makeText(getApplicationContext(), "You scored  9 in speaking",
                            Toast.LENGTH_LONG).show();

                }
            }

        }


        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };


    //        @Override
//        public void onNothingSelected(AdapterView<?> adapterView) {
//
//        }
//    };
//    public void Calc(View v)
//    {
//        //String aString = (String)numberOfCorrectAnswer.toString();
//        //int aNum = Integer.parseInt(numberOfCorrectAnswer.toString());
//        int aNum = Integer.parseInt(numberOfCorrectAnswer.getSelectedItem().toString());
//        Toast.makeText(getApplicationContext(), "The number chosen: " + (aNum + 50), Toast.LENGTH_LONG).show();
//    }
        /*public void clickListeingScore(View v) {
            String string = listeningNum.getText().toString();
            if (!string.equals("")) {
                int listeningScore = Integer.parseInt(string);
                double foundListeningScore = calculateReadingScore(listeningScore);
                if(foundListeningScore >= 4 && foundListeningScore <= 40)
                {
                    Toast.makeText(getApplicationContext(),
                            "You scored "+ foundListeningScore+ " in listening",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "You entered wrong score," +
                                    "Please enter a score between 3-40",
                            Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "You cannot see score without entering a number!",
                        Toast.LENGTH_SHORT).show();
            }
        }*/

        /*public void clickReadingScore(View v) {
            String string = ReadingNum.getText().toString();
            if (!string.equals("")) {
                int readingScore = Integer.parseInt(string);
                double foundReadingScore = calculateReadingScore(readingScore);
                if(foundReadingScore >= 4 && foundReadingScore <= 40)
                {
                    Toast.makeText(getApplicationContext(),
                            "You scored "+ foundReadingScore+ " in reading",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "You entered wrong score," +
                                    "Please enter a score between 3-40",
                            Toast.LENGTH_SHORT).show();
                }
            } else {
                Toast.makeText(getApplicationContext(), "You cannot see score without entering a number!",
                        Toast.LENGTH_SHORT).show();
            }
        }*/


    public double calculateReadingScore(int readingScore) {
        double result = 0;
        switch (readingScore) {
            case 4:
            case 5:
                result = 2.5;
                break;

            case 6:
            case 7:
                result = 3;
                break;
            case 8:
            case 9:
                result = 3.5;
                break;
            case 10:
            case 11:
            case 12:
                result = 4;
                break;
            case 13:
            case 14:
                result = 4.5;
                break;
            case 15:
            case 16:
            case 17:
            case 18:
                result = 5;
                break;
            case 19:
            case 20:
            case 21:
            case 22:
                result = 5.5;
                break;
            case 23:
            case 24:
            case 25:
            case 26:
                result = 6;
                break;

            case 27:
            case 28:
            case 29:
                result = 6.5;
                break;
            case 30:
            case 31:
            case 32:
                result = 7;
                break;
            case 33:
            case 34:
                result = 7.5;
            case 35:
            case 36:
                result = 8;
                break;
            case 37:
            case 38:
                result = 8.5;
                break;
            case 39:
            case 40:
                result = 9;
                break;
            default:
                result = 0;

        }
        return result;
    }

    public double calculateListeningScore(int listeningScore) {
        double result = 0;
        switch (listeningScore) {
            case 3:
            case 4:
            case 5:
                result = 2.5;
                break;

            case 6:
            case 7:
                result = 3.0;
                break;
            case 8:
            case 9:
            case 10:
                result = 3.5;
                break;
            case 11:
            case 12:
                result = 4.0;
                break;
            case 13:
            case 14:
            case 15:
                result = 4.5;
                break;
            case 16:
            case 17:
                result = 5.0;
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                result = 5.5;
                break;
            case 23:
            case 24:
            case 25:
                result = 6;
                break;
            case 26:
            case 27:
            case 28:
            case 29:
                result = 6.5;
                break;
            case 30:
            case 31:
                result = 7.0;
                break;
            case 32:
            case 33:
            case 34:
                result = 7.5;
                break;
            case 35:
            case 36:
                result = 8.0;
                break;
            case 37:
            case 38:
                result = 8.5;
                break;
            case 39:
            case 40:
                result = 9;
                break;
            default:
                Toast.makeText(getApplicationContext(), "You entered wrong score," +
                                "Please enter a score between 3-40",
                        Toast.LENGTH_SHORT).show();

        }
        return result;
    }

    //main calculation
    public void calc(View v) {
        Double listeningScore;
        int correctListeningScore;
        int correctReadingScore;
        Double readingScore;
        Double writingScore;
        Double speakingScore;

        String string_listening = listeningNum.getText().toString();

        if (string_listening.equals("")) {
            Toast.makeText(this, "Please write Listening score  between 3-40", Toast.LENGTH_SHORT).show();
        } else {
            correctListeningScore = Integer.parseInt(string_listening);
            listeningScore = calculateListeningScore(correctListeningScore);

            //reading
            String string_reading = ReadingNum.getText().toString();
            if (string_reading.equals("")) {
                Toast.makeText(this, "Please write Reading score  between 3-40", Toast.LENGTH_SHORT).show();
            } else {
                correctReadingScore = Integer.parseInt(string_reading);
                readingScore = calculateReadingScore(correctReadingScore);

                //writing
                String string_writing = numberOfCorrectAnswerInWriting.getSelectedItem().toString();
                if (string_writing.equals("Select")) {
                    Toast.makeText(this, "Plz Select an Writing score", Toast.LENGTH_SHORT).show();
                } else {
                    writingScore = Double.parseDouble(string_writing);

                    //speaking
                    String string_speaking = numberOfCorrectAnswerInSpeaking.getSelectedItem().toString();
                    if (string_speaking.equals("Select")) {
                        Toast.makeText(this, "Plz Select an Speaking score", Toast.LENGTH_SHORT).show();
                    } else {
                        speakingScore = Double.parseDouble(string_speaking);

                        Double bandScore = (listeningScore + readingScore + writingScore + speakingScore) / 4;
                        long longBandScore = Math.round(bandScore);
                        Toast.makeText(getApplicationContext(), "Your BandScore is : " + longBandScore, Toast.LENGTH_SHORT).show();
                    }

                }
            }
        }







        /*if((!string_listening.equals("")) &&
            (!string_reading.equals(""))  &&
                (!string_writing.equals("Select"))&&
                (!string_speaking.equals("Select"))){

        Double bandScore = (listeningScore + readingScore + writingScore + speakingScore) / 4;
        Toast.makeText(getApplicationContext(), "Your BandScore is : " + bandScore, Toast.LENGTH_SHORT).show();
    }
        else {
                   Toast.makeText(getApplicationContext(), "Please assign your missing score to see the TOTAL BANDSCORE",
                           Toast.LENGTH_SHORT).show();
        }*/

    }
}




