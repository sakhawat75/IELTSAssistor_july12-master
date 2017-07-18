package team_uganda.ieltsassistor;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class BookStorage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_storage);
    }
    public void readBook1(View v)
    {
        Intent intent = new Intent(BookStorage.this, BookOne.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(),"Opening Target Band-7", Toast.LENGTH_LONG).show();
    }
    public void readBook2(View v)
    {
        Intent intent = new Intent(BookStorage.this, BookTwo.class);
        startActivity(intent);
        Toast.makeText(getApplicationContext(),"Opening PAST IELTS ESSAY", Toast.LENGTH_LONG).show();
    }
}
