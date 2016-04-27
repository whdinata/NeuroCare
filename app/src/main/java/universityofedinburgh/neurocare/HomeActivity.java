package universityofedinburgh.neurocare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.SaveCallback;

import universityofedinburgh.neurocare.entity.NCParseFeedback;
import universityofedinburgh.neurocare.entity.NCParsePatient;
import universityofedinburgh.neurocare.fragment.ActionFragment;
import universityofedinburgh.neurocare.fragment.NotificationFragment;
import universityofedinburgh.neurocare.fragment.PatientFragment;
import universityofedinburgh.neurocare.fragment.ScheduleFragment;
import universityofedinburgh.neurocare.helper.FragmentUtils;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private View menuPatients;
    private View menuSchedules;
    private View menuActions;
    private View menuNotifications;

    private final Fragment[] fragment = {
            PatientFragment.newInstance(),
            ActionFragment.newInstance(),
            NotificationFragment.newInstance()
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initParse();
        initView();
    }

    private void initParse(){
        try {
            Parse.enableLocalDatastore(this);
            ParseObject.registerSubclass(NCParsePatient.class);
            ParseObject.registerSubclass(NCParseFeedback.class);
            Parse.initialize(this);
            ParseInstallation.getCurrentInstallation().saveInBackground();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private void initView(){
        menuPatients = findViewById(R.id.menu_patients);
        //menuSchedules = findViewById(R.id.menu_schedules);
        menuActions = findViewById(R.id.menu_actions);
        menuNotifications = findViewById(R.id.menu_notifications);

        menuNotifications.setOnClickListener(this);
        menuActions.setOnClickListener(this);
        //menuSchedules.setOnClickListener(this);
        menuPatients.setOnClickListener(this);

        FragmentUtils.changeFragment(this, R.id.content, fragment[0]);
        changeBackgroundColor(R.id.menu_patients);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.menu_patients:
                FragmentUtils.changeFragment(this, R.id.content, fragment[0]);
                changeBackgroundColor(R.id.menu_patients);
                break;
//            case R.id.menu_schedules:
//                changeBackgroundColor(R.id.menu_schedules);
//                break;
            case R.id.menu_actions:
                changeBackgroundColor(R.id.menu_actions);
                break;
            case R.id.menu_notifications:
                changeBackgroundColor(R.id.menu_notifications);
                break;
        }
    }

    public void changeBackgroundColor(int id){
        int primary = ContextCompat.getColor(this, R.color.primary);
        menuPatients.setBackgroundColor(primary);
        menuActions.setBackgroundColor(primary);
        //menuSchedules.setBackgroundColor(primary);
        menuNotifications.setBackgroundColor(primary);

        findViewById(id).setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimary));
    }
}
