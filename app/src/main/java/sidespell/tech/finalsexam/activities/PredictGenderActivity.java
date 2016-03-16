package sidespell.tech.finalsexam.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import sidespell.tech.finalsexam.R;
import sidespell.tech.finalsexam.fragments.PredictGenderFragment;

public class PredictGenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_predict_gender);

        // TODO: Attach and show the PredictGender Fragment on this activity
        PredictGenderFragment predictGenderFragment = (PredictGenderFragment)
                getSupportFragmentManager().findFragmentById(R.id.fragment_container);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container,predictGenderFragment)
                .commit();

    }
}
