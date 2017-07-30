package team_uganda.ieltsassistor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Admin extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    EditText editTextTipsTitle;
    EditText editTextTipsBody;
    Button buttonUploadTips;
    Button buttonLogout;
    ListView listViewAllTips;

    List<Tips> tipsList;

    DatabaseReference tipsReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        firebaseAuth = FirebaseAuth.getInstance();
        tipsReference = FirebaseDatabase.getInstance().getReference("Tips");

        tipsList = new ArrayList<>();

        editTextTipsTitle = (EditText) findViewById(R.id.editTextTipsTitle);
        editTextTipsBody = (EditText) findViewById(R.id.editTextTipsBody);

        listViewAllTips = (ListView) findViewById(R.id.listViewAllTips);

        buttonUploadTips = (Button) findViewById(R.id.buttonUploadTips);
        buttonLogout = (Button) findViewById(R.id.buttonLogout);

        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firebaseAuth.signOut();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });


        buttonUploadTips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                uploadTips();
            }
        });
    }

    private void uploadTips() {
        String title = editTextTipsTitle.getText().toString().trim();
        String body = editTextTipsBody.getText().toString().trim();

        if (!TextUtils.isEmpty(title)) {
            if(!TextUtils.isEmpty(body)) {

                String id = tipsReference.push().getKey();
                Tips tip = new Tips(id, title, body);

                tipsReference.child(id).setValue(tip).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()) {
                            Toast.makeText(getApplicationContext(), "Tip Added Successfully", Toast.LENGTH_SHORT).show();
                            editTextTipsTitle.setText(null);
                            editTextTipsBody.setText(null);
                        } else {
                            Toast.makeText(getApplicationContext(), "Error Adding Tip", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            } else {
                Toast.makeText(this, "Please Write Some Tip in Details", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Please Insert a Title of the Tip", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();

        tipsReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                tipsList.clear();

                for(DataSnapshot allTipsSnapshot : dataSnapshot.getChildren()) {
                    Tips tip = allTipsSnapshot.getValue(Tips.class);
                    tipsList.add(tip);
                }

                TipsArrayAdapter adapter = new TipsArrayAdapter(Admin.this, tipsList);
                listViewAllTips.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
               // Toast.makeText(Admin.this, "Retrieving From Database Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
