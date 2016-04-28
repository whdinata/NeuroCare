package universityofedinburgh.neurocare.adapter;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import universityofedinburgh.neurocare.FamilyActivity;
import universityofedinburgh.neurocare.FeedbackFormActivity;
import universityofedinburgh.neurocare.PatientDetailActivity;
import universityofedinburgh.neurocare.R;
import universityofedinburgh.neurocare.entity.Patient;

/**
 * Created by whdinata on 1/18/16.
 */
public class PatientListAdapter extends RecyclerView.Adapter<PatientListAdapter.ViewHolder>{
    private List<Patient> patientList = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View container;
        public ImageView imageView;
        public TextView tvName;
        public TextView tvId;

        public ViewHolder(View view) {
            super(view);

            container = view;
            imageView = (ImageView) view.findViewById(R.id.image);
            tvName = (TextView) view.findViewById(R.id.patient_name);
            tvId = (TextView) view.findViewById(R.id.patient_id);
        }
    }

    public PatientListAdapter(){}

    public void setData(List<Patient> patients){
        patientList = patients;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final PatientListAdapter.ViewHolder holder, int position) {
        final Patient patient = patientList.get(position);

        holder.container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = FamilyActivity.getIntent(v.getContext(), patient);
                v.getContext().startActivity(intent);
                //v.getContext().startActivity(new Intent(v.getContext(), FeedbackFormActivity.class));
            }
        });

        System.out.println("Patient ID 2: " + patient.getId());
        holder.tvId.setText(patient.getId());
        holder.tvName.setText(patient.getName());

        if(patient.isInpatient() && patient.getGender().equals("Male")) {
            holder.imageView.setImageResource(R.drawable.ic_male_plus);
        } else if(patient.isInpatient() && patient.getGender().equals("Female")) {
            holder.imageView.setImageResource(R.drawable.ic_female_inpatient);
        } else if(!patient.isInpatient() && patient.getGender().equals("Male")) {
            holder.imageView.setImageResource(R.drawable.ic_male_home);
        } else {
            holder.imageView.setImageResource(R.drawable.ic_female_home);
        }
    }

    @Override
    public PatientListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patient_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public int getItemCount() {
        return patientList.size();
    }
}
