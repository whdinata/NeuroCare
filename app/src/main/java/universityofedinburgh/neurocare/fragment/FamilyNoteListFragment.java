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
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import universityofedinburgh.neurocare.R;
import universityofedinburgh.neurocare.adapter.FamilyNoteListAdapter;
import universityofedinburgh.neurocare.adapter.FeedbackListAdapter;
import universityofedinburgh.neurocare.entity.FamilyNote;
import universityofedinburgh.neurocare.entity.Feedback;
import universityofedinburgh.neurocare.helper.API;

/**
 * Created by whdinata on 4/27/16.
 */
public class FamilyNoteListFragment extends Fragment{

    private FamilyNoteListAdapter adapter;
    private int mColumnCount = 1;

    public static FamilyNoteListFragment newInstance(){
        return new FamilyNoteListFragment();
    }

    @Override
    public void onResume() {
        super.onResume();

//        API.getAllFeedbacks(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_family_note_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            List<FamilyNote> familyNotes = new ArrayList<>();
            familyNotes.add(new FamilyNote("1", "Hi, John. Mary needs a companion to go to Botanic garden. Could you come?",
                    "Wed 27 APR 2016", "1", "2"));
            familyNotes.add(new FamilyNote("2", "Good morning! Our nurse staff will come to your place for general check up.",
                    "Mon 01 MAY 2016", "1", "3"));
            familyNotes.add(new FamilyNote("3", "Please make sure that Mary takes the medication!",
                    "Wed 03 MAY 2016", "1", "2"));
            adapter = new FamilyNoteListAdapter();
            adapter.setData(familyNotes);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }
}
