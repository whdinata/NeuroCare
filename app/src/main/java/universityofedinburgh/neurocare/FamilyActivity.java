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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import universityofedinburgh.neurocare.entity.Patient;
import universityofedinburgh.neurocare.fragment.CurrentConditionFragment;
import universityofedinburgh.neurocare.fragment.FamilyNoteListFragment;
import universityofedinburgh.neurocare.helper.FragmentUtils;

public class FamilyActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String PATIENT = "patient";
    private TextView tvCurrentCondition;
    private TextView tvNotes;
    private Button requestMeetingButton;
    private View menuPatients;
    private View menuNotifications;
    private Patient patient;

    private final Fragment[] fragment = {
            CurrentConditionFragment.newInstance(),
            FamilyNoteListFragment.newInstance()
    };

    public static Intent getIntent(Context context, Patient patient){
        Intent intent = new Intent(context, FamilyActivity.class);
        intent.putExtra(PATIENT, patient);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);

        Intent intent = getIntent();
        patient = (Patient)intent.getSerializableExtra(PATIENT);

        setTitle(patient.getName());

        initView(patient);
    }

    private void initView(Patient patient){
        menuPatients = findViewById(R.id.menu_patients);
        menuNotifications = findViewById(R.id.menu_notifications);

        requestMeetingButton = (Button) findViewById(R.id.request_meeting);

//        menuPatients.setOnClickListener(this);
//        menuNotifications.setOnClickListener(this);

        tvCurrentCondition = (TextView) findViewById(R.id.current_condition);
        tvNotes = (TextView) findViewById(R.id.notes);

        ((TextView)findViewById(R.id.patient_name)).setText(patient.getName());
        ((TextView)findViewById(R.id.patient_id)).setText(patient.getId());
        ((TextView)findViewById(R.id.patient_birthdate)).setText(patient.getBirthdate());
        ((TextView)findViewById(R.id.patient_disease)).setText(patient.getDisease());
        tvCurrentCondition.setOnClickListener(this);
        tvNotes.setOnClickListener(this);

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
//            case R.id.menu_patients:
//                changeBackgroundColor(R.id.menu_patients);
//                break;
//            case R.id.menu_notifications:
//                changeBackgroundColor(R.id.menu_notifications);
//                break;
            case R.id.current_condition:
                FragmentUtils.changeFragment(this, R.id.content, fragment[0]);
                changeBackgroundColor(R.id.current_condition);
                break;
            case R.id.notes:
                FragmentUtils.changeFragment(this, R.id.content, fragment[1]);
                changeBackgroundColor(R.id.notes);
                break;
            case R.id.request_meeting:
                Intent intent = MeetingRequestActivity.getIntent(v.getContext(), patient);
                v.getContext().startActivity(intent);
                break;
        }
    }

    public void changeBackgroundColor(int id){
        final int primary = ContextCompat.getColor(this, R.color.patient_id_text);
        final int white = ContextCompat.getColor(this, android.R.color.white);
        final int topMenuColor = ContextCompat.getColor(this, R.color.primary);

//        menuPatients.setBackgroundColor(topMenuColor);
//        menuNotifications.setBackgroundColor(topMenuColor);
//
//        findViewById(id).setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));

        if (id == R.id.current_condition) {
            tvNotes.setTextColor(white);
            tvNotes.setBackgroundColor(primary);

            tvCurrentCondition.setTextColor(primary);
            tvCurrentCondition.setBackgroundColor(white);
        } else {
            tvCurrentCondition.setTextColor(white);
            tvCurrentCondition.setBackgroundColor(primary);

            tvNotes.setTextColor(primary);
            tvNotes.setBackgroundColor(white);
        }
    }
}
