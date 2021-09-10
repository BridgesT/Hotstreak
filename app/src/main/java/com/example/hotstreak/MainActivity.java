package com.example.hotstreak;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int bestStreak, madeStreak, attemptStreak, currentStreak= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null);
//            }
//        });

    }
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {

        View rootView = findViewById(android.R.id.content).getRootView();

        if(event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == 66){

            //Toast.makeText(MainActivity.this, "pressed enter", Toast.LENGTH_SHORT).show();
            UpdateAttemptStreak(rootView);

            return true;
        }
        else if(event.getAction() == KeyEvent.ACTION_DOWN && event.getKeyCode() == 24){

            //Toast.makeText(MainActivity.this, "pressed vol up", Toast.LENGTH_SHORT).show();
           UpdateMadeStreak(rootView);

            return true;
        }
        else return super.dispatchKeyEvent(event);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void UpdateMadeStreak(View view) {

        TextView CS = (TextView)findViewById(R.id.CurrentStreakText);
        TextView BS = (TextView)findViewById(R.id.BestStreakText);
        TextView currentS = (TextView)findViewById(R.id.currentStreak);
        madeStreak++;
        attemptStreak++;

        if(currentStreak >= bestStreak) {
            bestStreak++;
        }
        currentStreak++;
        CS.setText(String.valueOf(madeStreak + "/" + attemptStreak));
        BS.setText(String.valueOf("Best Streak: "+ bestStreak));
        currentS.setText(String.valueOf("Current Streak: " + currentStreak));

    }
    public void UpdateAttemptStreak(View view) {

        TextView CS = (TextView)findViewById(R.id.CurrentStreakText);
        attemptStreak++;
        currentStreak = 0;
        TextView CurrentStreak = (TextView)findViewById(R.id.currentStreak);
        CurrentStreak.setText(String.valueOf("Current Streak: 0"));
        CS.setText(String.valueOf(madeStreak + "/" + attemptStreak));

    }
}
