package com.londonappbrewery.destini;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private int story;
    private Button btnAnswer1, btnAnswer2;
    private TextView txtStory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:

        txtStory = findViewById(R.id.txtStory);
        btnAnswer1 = findViewById(R.id.btnAnswer1);
        btnAnswer2 = findViewById(R.id.btnAnswer2);
        story = R.string.T1_Story;
        refresh(R.string.T1_Ans1, R.string.T1_Ans2);

        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
        btnAnswer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (endStory())
                    return;
                //
                int answ1, answ2;
                answ1 = answ2 = R.string.empty;
                if (story == R.string.T1_Story || story == R.string.T2_Story) {
                    story = R.string.T3_Story;
                    answ1 = R.string.T3_Ans1;
                    answ2 = R.string.T3_Ans2;
                } else {
                    story = R.string.T6_End;
                }
                refresh(answ1, answ2);
            }
        });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
        btnAnswer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (endStory())
                    return;
                //
                int answ1, answ2;
                answ1 = answ2 =  R.string.empty;
                if (story == R.string.T1_Story){
                    story = R.string.T2_Story;
                    answ1 = R.string.T2_Ans1;
                    answ2 = R.string.T2_Ans2;
                }else if (story == R.string.T2_Story) {
                    story = R.string.T4_End;
                } else {
                    story = R.string.T5_End;
                }
                refresh(answ1, answ2);
            }
        });

    }

    private boolean endStory(){
        switch (story){
            case R.string.T4_End:
            case R.string.T5_End:
            case R.string.T6_End:
                AlertDialog.Builder alert = new AlertDialog.Builder(this);
                alert.setMessage("end of story");
                alert.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                finish();
                            }
                        }
                ).show();
                return true;
            default:
                return false;
        }
    }
    private void refresh(int ans1, int ans2) {
        txtStory.setText(story);
        btnAnswer1.setText(ans1);
        btnAnswer2.setText(ans2);
    }
}
