package universityofedinburgh.neurocare;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import universityofedinburgh.neurocare.entity.Feedback;
import universityofedinburgh.neurocare.entity.NCParseFeedback;
import universityofedinburgh.neurocare.helper.API;
import universityofedinburgh.neurocare.view.AdmissionView;

public class FeedbackFormActivity extends AppCompatActivity {

    private static final String FEEDBACK = "feedback";
    private AdmissionView admission;
    private EditText etIssue;

    public static Intent getIntent(Context context, Feedback feedback){
        Intent intent = new Intent(context, FeedbackFormActivity.class);
        intent.putExtra(FEEDBACK, feedback);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback_form);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final Feedback feedback = (Feedback) getIntent().getSerializableExtra(FEEDBACK);

        etIssue = (EditText) findViewById(R.id.ongoing_issues);
        admission = (AdmissionView) findViewById(R.id.admission);

        etIssue.setText(feedback.getIssue());
        admission.setAdmission(feedback.getAdmission());

        findViewById(R.id.submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //NCParseFeedback fb = new NCParseFeedback(feedback);

                API.updateFeedback(feedback, FeedbackFormActivity.this);
            }
        });
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
}
