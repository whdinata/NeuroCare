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
import universityofedinburgh.neurocare.adapter.PatientListAdapter;
import universityofedinburgh.neurocare.entity.Patient;
import universityofedinburgh.neurocare.helper.API;

/**
 * Created by whdinata on 4/27/16.
 */
public class CurrentConditionFragment extends Fragment{

    private PatientListAdapter adapter;
    private int mColumnCount = 1;

    public static CurrentConditionFragment newInstance(){
        return new CurrentConditionFragment();
    }

    @Override
    public void onResume() {
        super.onResume();

        //API.getAllPatient(this);
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

            adapter = new PatientListAdapter();
            recyclerView.setAdapter(adapter);
        }
        return view;
    }

    public void attachData(List<Patient> patients){
        adapter.setData(patients);
    }
}
