package universityofedinburgh.neurocare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import universityofedinburgh.neurocare.entity.Patient;
import universityofedinburgh.neurocare.fragment.ActionFragment;
import universityofedinburgh.neurocare.fragment.CurrentConditionFragment;
import universityofedinburgh.neurocare.fragment.FeedbackRecordFragment;
import universityofedinburgh.neurocare.fragment.NotificationFragment;
import universityofedinburgh.neurocare.fragment.PatientFragment;
import universityofedinburgh.neurocare.helper.FragmentUtils;

public class PatientDetailActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String PATIENT = "patient";
    private TextView tvCurrentCondition;
    private TextView tvFeedbackReport;

    private final Fragment[] fragment = {
            CurrentConditionFragment.newInstance(),
            FeedbackRecordFragment.newInstance()
    };

    public static Intent getIntent(Context context, Patient patient){
        Intent intent = new Intent(context, PatientDetailActivity.class);
        intent.putExtra(PATIENT, patient);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_detail);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent intent = getIntent();
        Patient patient = (Patient)intent.getSerializableExtra(PATIENT);

        setTitle(patient.getName());

        initView(patient);
    }

    private void initView(Patient patient){
        tvCurrentCondition = (TextView) findViewById(R.id.current_condition);
        tvFeedbackReport = (TextView) findViewById(R.id.feedback_record);

        ((TextView)findViewById(R.id.patient_name)).setText(patient.getName());
        ((TextView)findViewById(R.id.patient_id)).setText(patient.getId());
        ((TextView)findViewById(R.id.patient_birthdate)).setText(patient.getBirthdate());
        ((TextView)findViewById(R.id.patient_disease)).setText(patient.getDisease());
        tvCurrentCondition.setOnClickListener(this);
        tvFeedbackReport.setOnClickListener(this);

        FragmentUtils.changeFragment(this, R.id.content, fragment[0]);
        changeBackgroundColor(R.id.current_condition);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.current_condition:
                FragmentUtils.changeFragment(this, R.id.content, fragment[0]);
                changeBackgroundColor(R.id.current_condition);
                break;
            default:
                FragmentUtils.changeFragment(this, R.id.content, fragment[1]);
                changeBackgroundColor(R.id.feedback_record);
                break;
        }
    }

    public void changeBackgroundColor(int id){
        int primary = ContextCompat.getColor(this, R.color.patient_id_text);
        int white = ContextCompat.getColor(this, android.R.color.white);

        if(id == R.id.current_condition){
            tvFeedbackReport.setTextColor(white);
            tvFeedbackReport.setBackgroundColor(primary);

            tvCurrentCondition.setTextColor(primary);
            tvCurrentCondition.setBackgroundColor(white);
        } else{
            tvCurrentCondition.setTextColor(white);
            tvCurrentCondition.setBackgroundColor(primary);

            tvFeedbackReport.setTextColor(primary);
            tvFeedbackReport.setBackgroundColor(white);
        }
    }
}
