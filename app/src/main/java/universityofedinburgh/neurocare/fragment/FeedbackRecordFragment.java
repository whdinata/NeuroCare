package universityofedinburgh.neurocare.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import universityofedinburgh.neurocare.R;
import universityofedinburgh.neurocare.adapter.FeedbackListAdapter;
import universityofedinburgh.neurocare.adapter.PatientListAdapter;
import universityofedinburgh.neurocare.entity.Feedback;
import universityofedinburgh.neurocare.entity.Patient;
import universityofedinburgh.neurocare.helper.API;

/**
 * Created by whdinata on 4/27/16.
 */
public class FeedbackRecordFragment extends Fragment{

    private FeedbackListAdapter adapter;
    private int mColumnCount = 1;

    public static FeedbackRecordFragment newInstance(){
        return new FeedbackRecordFragment();
    }

    @Override
    public void onResume() {
        super.onResume();

        API.getAllFeedbacks(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_patient_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            adapter = new FeedbackListAdapter();
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

    public void attachData(List<Feedback> feedbacks){
        adapter.setData(feedbacks);
    }
}
