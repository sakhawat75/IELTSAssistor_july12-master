package team_uganda.ieltsassistor;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BookOne extends AppCompatActivity {
    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_one);

        pdfView = (PDFView) findViewById(R.id.pdfView);

        new RetrievePDFStream()
                .execute("https://firebasestorage.googleapis.com/v0/b/ieltsassistor.appspot.com/o/IELTS_Target%20band_7_2.pdf?alt=media&token=0f6ea2fc-fa83-4535-a611-d28df0690c8b");
    }

    class RetrievePDFStream extends AsyncTask<String, Void, InputStream> {

        @Override
        protected InputStream doInBackground(String... strings) {
            InputStream inputStream = null;
            try {
                URL url = new URL(strings[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                if(httpURLConnection.getResponseCode() == 200) {
                    inputStream = new BufferedInputStream(httpURLConnection.getInputStream());
                }
            } catch (IOException e) {
                return null;
            }

            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pdfView.fromStream(inputStream).load();
        }
    }
}
