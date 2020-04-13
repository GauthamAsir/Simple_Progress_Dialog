package a.gautham.progress_dialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import a.gautham.simpleprogressdialog.ProgressDialog;

public class MainActivity extends AppCompatActivity {

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Mandatory
        final ProgressDialog progressDialog = new ProgressDialog(this,"Loading...");

        //Optional
        progressDialog.setTheme(R.style.ProgressBarStyle);      //ProgressBar Color

        Button showDialog = findViewById(R.id.showDialog);
        showDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // To Show Progress Dialog
                progressDialog.showDialog();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        progressDialog.updateText("About to Finish");  // Update the Progress Text
                        
                        if (progressDialog.isDialogShowing()){      //To Check if dialog is showing

                            progressDialog.hideDialog();        //To Hide Progress Dialog

                        }
                    }
                },2000);


            }
        });





    }
}
