package sidespell.tech.finalsexam.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import sidespell.tech.finalsexam.R;
import sidespell.tech.finalsexam.fragments.MainFragment;
import sidespell.tech.finalsexam.fragments.PredictGenderFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.OnTopicItemClickListener {

    private boolean mDualPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MainFragment mainFragment = (MainFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_main);


        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_main,mainFragment)
                .commit();



//        mDualPane = mainFragment != null ;

        if (mDualPane) {
            onItemClick(0);
        }
    }

    public void onItemClick(int position) {
        PredictGenderFragment predictGenderFragment = (PredictGenderFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container);

        if (mDualPane ) {
            // TODO: If app to run is on a tablet, show the PredictGenderFragment on the right side


        } else {
            // TODO: If app to run is on a phone, launch a new activity to present the Predict Gender screen
        }
    }
}
