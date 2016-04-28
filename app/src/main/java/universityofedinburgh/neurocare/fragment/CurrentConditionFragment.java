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
        View view = inflater.inflate(R.layout.fragment_current_condition, container, false);
        return view;
    }
}
