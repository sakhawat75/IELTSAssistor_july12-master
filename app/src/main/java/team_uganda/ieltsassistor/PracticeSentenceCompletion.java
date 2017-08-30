package team_uganda.ieltsassistor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class PracticeSentenceCompletion extends AppCompatActivity {
    private String passage = "Congenital heart experts from Spectrum Health Helen DeVos Children's Hospital have \n" +
            "successfully integrated two common imaging techniques to produce\n" +
            "a three-dimensional anatomic model of a patient's heart.\n" +
            "\n" +
            " The 3D model printing of patients' hearts has become more common in recent years as part of an emerging, \n" +
            "experimental field devoted to enhanced visualization of individual cardiac structures and characteristics.\n" +
            "But this is the first time the integration of computed tomography (CT) and three-dimensional transesophageal\n" +
            " echocardiography (3DTEE) has successfully been used for printing a hybrid 3D model of a patient's heart. \n" +
            "A proof-of-concept study authored by the Spectrum Health experts also opens the way for these techniques\n" +
            "to be used in combination with a third tool\n" +
            "\n" +
            " - magnetic resonance imaging (MRI).\n" +
            "\n" +
            " \"Hybrid 3D printing integrates the best aspects of two or more imaging modalities,\n" +
            " which can potentially enhance diagnosis, as well as interventional and surgical planning,\n" +
            "\" said Jordan Gosnell, Helen DeVos Children's Hospital cardiac sonographer,\n" +
            " and lead author of the study. \"Previous methods of 3D printing utilize only one imaging modality, \n" +
            "which may not be as accurate as merging two or more datasets.\"";

    private String questionSet = "1. A three-dimensional __________ of a patient's heart was created by integrating two imaging techniques.\n" +
            "2.Spectrum Health scientists have found a way to combine and use three techniques: computed tomography,\n" +
            " three-dimensional transesophageal echocardiography and _______.\n" +
            "3.The new method of 3D printing is more efficient than previous methods because it merges two and more _______.\n" +
            "4.With more accurate 3D renderings and ______, \n" +
            "physicians will be able to better diagnose and treat heart disease.\n\n";


    private TextView stringPassage;
    private TextView questions;

    private EditText questionOneSentenceCompletion;
    private EditText questionTwoSentenceCompletion;
    private EditText questionThreeSentenceCompletion;
    private EditText questionFourSentenceCompletion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practice_sentence_completion);
        stringPassage = (TextView)findViewById(R.id.stringPassage);
        questions = (TextView)findViewById(R.id.questions);
        questionOneSentenceCompletion = (EditText)findViewById(R.id.questionOneSentenceCompletion);
        questionTwoSentenceCompletion = (EditText)findViewById(R.id.questionTwoSentenceCompletion);
        questionThreeSentenceCompletion = (EditText)findViewById(R.id.questionThreeSentenceCompletion);
        questionFourSentenceCompletion = (EditText)findViewById(R.id.questionFourSentenceCompletion);


        stringPassage.setText(passage);
        questions.setText(questionSet);
    }
}
