package universityofedinburgh.neurocare.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import universityofedinburgh.neurocare.FeedbackFormActivity;
import universityofedinburgh.neurocare.PatientDetailActivity;
import universityofedinburgh.neurocare.R;
import universityofedinburgh.neurocare.entity.Feedback;
import universityofedinburgh.neurocare.view.NCFeedbackRightSideView;

/**
 * Created by whdinata on 1/18/16.
 */
public class FeedbackListAdapter extends RecyclerView.Adapter<FeedbackListAdapter.ViewHolder>{
    private List<Feedback> feedbackList = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View container;
        public TextView tvDate;
        public NCFeedbackRightSideView detail;

        public ViewHolder(View view) {
            super(view);

            container = view;
            tvDate = (TextView) view.findViewById(R.id.date);
            detail = (NCFeedbackRightSideView) view.findViewById(R.id.detail);
        }
    }

    public FeedbackListAdapter(){}

    public void setData(List<Feedback> patients){
        feedbackList = patients;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final FeedbackListAdapter.ViewHolder holder, int position) {
        final Feedback feedback = feedbackList.get(position);

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = FeedbackFormActivity.getIntent(v.getContext(), feedback);
                v.getContext().startActivity(intent);
            }
        });

        Context context = holder.tvDate.getContext();

        if(feedback.isMdt()){
            holder.tvDate.setBackgroundColor(ContextCompat.getColor(context, R.color.date_mdt));
            holder.container.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.bg_feedback_mdt));
        } else{
            holder.tvDate.setBackgroundColor(ContextCompat.getColor(holder.tvDate.getContext(), R.color.date_family));
            holder.container.setBackgroundDrawable(ContextCompat.getDrawable(context, R.drawable.bg_feedback_family));
        }

        holder.tvDate.setText(feedback.getCreatedDate());
        holder.detail.setFeedback(feedback);
    }

    @Override
    public FeedbackListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.feedback_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return feedbackList.size();
    }
}
