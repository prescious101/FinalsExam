package sidespell.tech.finalsexam.fragments;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import sidespell.tech.finalsexam.R;
import sidespell.tech.finalsexam.api.GenderApi;

public class PredictGenderFragment extends Fragment implements View.OnClickListener {

    private EditText             mEtName;
    private TextView             mTvGender;
    private ListView             mListView;
    private FloatingActionButton mFabGetGender;
    private ArrayAdapter<String> mAdapter;

    public static PredictGenderFragment newInstance() {
        return new PredictGenderFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_predict_gender, container, false);

        // Find all views
        mEtName = (EditText) view.findViewById(R.id.etName);
        mTvGender = (TextView) view.findViewById(R.id.tvGender);
        mListView = (ListView) view.findViewById(R.id.listView);
        mFabGetGender = (FloatingActionButton) view.findViewById(R.id.fabGetGender);

        // Set button listener
        mFabGetGender.setOnClickListener(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mEtName.requestFocus();
        mAdapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1, new ArrayList<String>());
        mListView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        String name = mEtName.getText().toString();

        // TODO: Appropriately execute getting the gender info task in a background thread
        if (TextUtils.isEmpty(name)) {
            mEtName.setError(getContext().getString(R.string.txt_enter_name));
        } else {
            mEtName.setError(null);
        }
    }

    private class GetGenderTask extends AsyncTask<String, Void, String> {

        private String mName;


        @Override
        protected void onPreExecute() {
            mTvGender.setText(R.string.text_analyzing);
        }

        @Override
        protected String doInBackground(String... params) {
            if (params.length != 1) {
                throw new RuntimeException("There has to be at least one parameter passed and should " +
                        "be a name");
            }

            // TODO: Implement the logic to get the gender given a specified name
            GenderApi.getGender(mName);

            return null;
        }

        @Override
        protected void onPostExecute(String gender) {
            if (gender.equals("null")) {
                gender = "Unidentified";
            }

            mTvGender.setText(gender);
            mAdapter.add(mName + " is a " + gender);
        }
    }
}
