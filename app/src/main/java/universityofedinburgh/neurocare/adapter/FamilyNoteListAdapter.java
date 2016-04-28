package universityofedinburgh.neurocare.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import universityofedinburgh.neurocare.FamilyNoteActivity;
import universityofedinburgh.neurocare.FeedbackFormActivity;
import universityofedinburgh.neurocare.R;
import universityofedinburgh.neurocare.entity.FamilyNote;
import universityofedinburgh.neurocare.entity.Feedback;
import universityofedinburgh.neurocare.view.NCFeedbackRightSideView;

/**
 * Created by aliakbars on 1/18/16.
 */
public class FamilyNoteListAdapter extends RecyclerView.Adapter<FamilyNoteListAdapter.ViewHolder>{
    private List<FamilyNote> familyNotes = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View container;
        public TextView tvDate;
        public TextView description;
        public TextView creator;

        public ViewHolder(View view) {
            super(view);

            container = view;
            tvDate = (TextView) view.findViewById(R.id.note_date);
            description = (TextView) view.findViewById(R.id.note_description);
            creator = (TextView) view.findViewById(R.id.note_creator);
        }
    }

    public FamilyNoteListAdapter(){}

    public void setData(List<FamilyNote> notes){
        familyNotes = notes;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final FamilyNoteListAdapter.ViewHolder holder, int position) {
        final FamilyNote note = familyNotes.get(position);

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = FamilyNoteActivity.getIntent(v.getContext(), note);
                v.getContext().startActivity(intent);
            }
        });

        Context context = holder.tvDate.getContext();

        holder.tvDate.setBackgroundColor(ContextCompat.getColor(holder.tvDate.getContext(), R.color.date_family));
        holder.container.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.bg_feedback_family));

        holder.tvDate.setText(note.getCreatedDate());
        holder.description.setText(note.getDescription());
        holder.creator.setText(note.getCreator());
    }

    @Override
    public FamilyNoteListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.family_note_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return familyNotes.size();
    }
}
