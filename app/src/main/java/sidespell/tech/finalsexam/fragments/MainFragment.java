package sidespell.tech.finalsexam.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;

import sidespell.tech.finalsexam.R;

public class MainFragment extends ListFragment {

    public interface OnTopicItemClickListener {
        void onItemClick(int position);
    }

    private String[] topics = {"Predict Thy Gender"};

    private OnTopicItemClickListener mOnTopicItemClickListener;

    public static MainFragment newInstance() {
        return new MainFragment();
    }

    public void setOnTopicItemClickListener(OnTopicItemClickListener onTopicItemClickListener) {
        mOnTopicItemClickListener = onTopicItemClickListener;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (!(getActivity() instanceof OnTopicItemClickListener)) {
            throw new RuntimeException("The Activity holding MainFragment should implement " +
                    "OnTopicItemClickListener");
        }
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_list_item_1, new ArrayList<>(Arrays.asList(topics)));
        setListAdapter(adapter);

        getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (mOnTopicItemClickListener != null) {
                    mOnTopicItemClickListener.onItemClick(position);
                }
            }
        });
    }
}
