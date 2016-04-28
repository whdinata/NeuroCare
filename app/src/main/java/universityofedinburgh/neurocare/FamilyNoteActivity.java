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

import universityofedinburgh.neurocare.entity.FamilyNote;
import universityofedinburgh.neurocare.entity.Patient;
import universityofedinburgh.neurocare.fragment.CurrentConditionFragment;
import universityofedinburgh.neurocare.fragment.FeedbackRecordFragment;
import universityofedinburgh.neurocare.helper.FragmentUtils;

public class FamilyNoteActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String FAMILY_NOTE = "familynote";
    private TextView creator;
    private TextView date;
    private TextView description;

    public static Intent getIntent(Context context, FamilyNote familyNote){
        Intent intent = new Intent(context, FamilyNoteActivity.class);
        intent.putExtra(FAMILY_NOTE, familyNote);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_note);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        FamilyNote familyNote = (FamilyNote) intent.getSerializableExtra(FAMILY_NOTE);

        setTitle("Note Detail");

        initView(familyNote);
    }

    private void initView(FamilyNote familyNote){
        creator = (TextView) findViewById(R.id.creator);
        date = (TextView) findViewById(R.id.date);
        description = (TextView) findViewById(R.id.description);

        creator.setText("by " + familyNote.getCreator());
        date.setText(familyNote.getCreatedDate());
        description.setText(familyNote.getDescription());
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
            default:
                break;
        }
    }
}
