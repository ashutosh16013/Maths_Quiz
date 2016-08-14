package com.example.welcome.maths_quiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Button;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private String m_set_ques;
    private static final String m_key = "Set_question";
    private static final String m_scorekey = "Set_marks";;
    private int m_k;
    public static String TAG="MyAPP : ";
    private Button mTrueButton;
    private Button mFalseButton;
    private int mTotalScore = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTrueButton = (Button)findViewById(R.id.button);
        mFalseButton = (Button)findViewById(R.id.button2);
        mTrueButton.setOnClickListener(this);
        mFalseButton.setOnClickListener(this);
        if(savedInstanceState==null){
            Log.d(TAG,"Savedisnull");
        }
        Log.d(TAG,"Inside OnCreate");
    }

    @Override
    public void onClick(View v) {
        int result;
        TextView score_text = (TextView)findViewById(R.id.score);
        String p;
        switch(v.getId()){

            case R.id.button:
                result = Main_Logic.check_prime(m_k);
                if(result==1){
                    Toast.makeText(getApplicationContext(),"Correct",Toast.LENGTH_SHORT).show();
                    mTotalScore++;

                }

                else {
                    Toast.makeText(getApplicationContext(), "InCorrect", Toast.LENGTH_SHORT).show();
                    mTotalScore--;
                }
                p = String.valueOf(mTotalScore);
                score_text.setText("Your Score "+p);
                break;
            case R.id.button2:
                result = Main_Logic.check_prime(m_k);
                if(result==0) {
                    Toast.makeText(getApplicationContext(), "Correct", Toast.LENGTH_SHORT).show();
                    mTotalScore++;
                }
                else {
                    Toast.makeText(getApplicationContext(), "InCorrect", Toast.LENGTH_SHORT).show();
                    mTotalScore--;
                }
                p = String.valueOf(mTotalScore);
                score_text.setText("Your Score "+p);
                break;

        }

    }

    public void change_text(View view){
        TextView text;
        m_k = Main_Logic.generate_number();
        m_set_ques = "Is "+m_k+" a prime number ?";
        Log.d(TAG,m_set_ques);
        text = (TextView)findViewById(R.id.text);
        text.setText(m_set_ques);
    }


    public void start_check(){

        Main_Logic.check_prime(m_k);
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(TAG,"Inside onStart");
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"Inside onDestroy");
    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(TAG,"Inside onDestroy");
    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.d(TAG,"Inside Pause");
    }

    @Override
    public void onStop(){

        super.onStop();
        Log.d(TAG,"Inside OnStop");
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        // Save the user's current game state
        //super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putString(m_key, m_set_ques);
        savedInstanceState.putInt(m_scorekey,mTotalScore);
        super.onSaveInstanceState(savedInstanceState);

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){

        m_set_ques = savedInstanceState.getString(m_key);
        mTotalScore = savedInstanceState.getInt(m_scorekey);
        TextView text1,text2;
        text1 = (TextView)findViewById(R.id.text);
        text2 = (TextView)findViewById(R.id.score);
        text1.setText(m_set_ques);
        String score_to_text = String.valueOf(mTotalScore);
        text2.setText("Your Score "+score_to_text);
    }



}

