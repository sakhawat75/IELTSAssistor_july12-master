package team_uganda.ieltsassistor;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.github.barteksc.pdfviewer.PDFView;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class BookOne extends AppCompatActivity {

    PDFView pdfView;
    private ProgressDialog pDialog;
    private static String file_url = "https://firebasestorage.googleapis.com/v0/b/ieltsassistor.appspot.com/o/book1." +
            "pdf?alt=media&token=82c741a4-67a1-48e5-a28b-fb6061a84149";
    String filepath = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Ielts_Assistor";
    File bookFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_one);

        File dir = new File(filepath);
        if(!dir.exists()) {
            dir.mkdirs();
        }

        pdfView = (PDFView) findViewById(R.id.pdfView);
        bookFile = new File(filepath, "BookOne.pdf");

        if(!bookFile.exists()) {
            Toast.makeText(this, "File Does not Exists, Downloading for the first time", Toast.LENGTH_SHORT).show();
            new RetrievePDFStream().execute(file_url);
        } else {
            Toast.makeText(this, "File Exists. Loading From internal storage", Toast.LENGTH_SHORT).show();
            pdfView.fromFile(bookFile).load();
        }

    }



    class RetrievePDFStream extends AsyncTask<String, String, InputStream> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pDialog = new ProgressDialog(BookOne.this);
            pDialog.setMessage("Downloading for the first time. File Size: 2.1mb");
           // pDialog.setTitle("Downloading File");
            pDialog.setIndeterminate(false);
            pDialog.setMax(100);
            pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            pDialog.setCancelable(true);
            pDialog.show();
        }

        @Override
        protected InputStream doInBackground(String... strings) {

            InputStream inputStream = null;
            int count = 0;

            try {
                URL url = new URL(strings[0]);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.connect();

                int lenghtOfFile = httpURLConnection.getContentLength();

                if(httpURLConnection.getResponseCode() == 200) {
                    inputStream = new BufferedInputStream(url.openStream());
                    OutputStream output = new FileOutputStream(bookFile);

                    byte data[] = new byte[1024];
                    long total = 0;

                    while ((count = inputStream.read(data)) != -1) {
                        total += count;
                        // publishing the progress....
                        // After this onProgressUpdate will be called
                        publishProgress(""+(int)((total*100)/lenghtOfFile));

                        // writing data to file
                        output.write(data, 0, count);
                    }

                    output.flush();
                    output.close();
                    inputStream.close();
                }

            } catch (IOException e) {
                Toast.makeText(BookOne.this, "IO Exception occured", Toast.LENGTH_SHORT).show();
                return null;
            } catch (Exception e) {
                Toast.makeText(BookOne.this, "Exception occured", Toast.LENGTH_SHORT).show();
            }

            return inputStream;
        }

        @Override
        protected void onPostExecute(InputStream inputStream) {
            pDialog.dismiss();
            Toast.makeText(BookOne.this, "Download Complete", Toast.LENGTH_SHORT).show();
            pdfView.fromFile(bookFile).load();
        }

        @Override
        protected void onProgressUpdate(String... progress) {
            // setting progress percentage
            pDialog.setProgress(Integer.parseInt(progress[0]));
        }
    }

}
