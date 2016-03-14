package sidespell.tech.finalsexam.activities;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import sidespell.tech.finalsexam.R;
import sidespell.tech.finalsexam.fragments.MainFragment;
import sidespell.tech.finalsexam.fragments.PredictGenderFragment;

public class MainActivity extends AppCompatActivity {

    private boolean mDualPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment = (MainFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_main);

        if (mDualPane) {
            onItemClick(0);
        }
    }

    public void onItemClick(int position) {
        if (mDualPane) {
            // TODO: If app to run is on a tablet, show the PredictGenderFragment on the right side
        } else {
            // TODO: If app to run is on a phone, launch a new activity to present the Predict Gender screen
        }
    }
}
