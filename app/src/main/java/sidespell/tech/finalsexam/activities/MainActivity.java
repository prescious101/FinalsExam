package sidespell.tech.finalsexam.activities;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import sidespell.tech.finalsexam.R;
import sidespell.tech.finalsexam.fragments.MainFragment;
import sidespell.tech.finalsexam.fragments.PredictGenderFragment;

public class MainActivity extends AppCompatActivity implements MainFragment.OnTopicItemClickListener {

    private boolean mDualPane = true;
;

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


        if (mDualPane) {
            onItemClick(0);
        }
    }

    public void onItemClick(int position) {
        PredictGenderFragment predictGenderFragment = (PredictGenderFragment) getSupportFragmentManager()
                .findFragmentById(R.id.fragment_container);

        if (mDualPane ) {
            // TODO: If app to run is on a tablet, show the PredictGenderFragment on the right side

            PredictGenderFragment pgFragment = new PredictGenderFragment();
            Bundle args = new Bundle();
            args.putInt(PredictGenderFragment.KEY_POSITION,position);
            pgFragment.setArguments(args);
            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        } else {
            // TODO: If app to run is on a phone, launch a new activity to present the Predict Gender screen
            Intent intent = new Intent(this,PredictGenderActivity.class);
            startActivity(intent);
        }
    }
}
