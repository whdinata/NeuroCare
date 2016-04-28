package universityofedinburgh.neurocare;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import universityofedinburgh.neurocare.entity.FamilyNote;
import universityofedinburgh.neurocare.entity.Patient;

public class MeetingRequestActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String PATIENT = "patient";
    private Button date;
    private Button time;
    private Calendar calendar;
    private int year, month, day, hourOfDay, minute;

    public static Intent getIntent(Context context, Patient patient){
        Intent intent = new Intent(context, MeetingRequestActivity.class);
        intent.putExtra(PATIENT, patient);

        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting_request);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        Patient patient= (Patient) intent.getSerializableExtra(PATIENT);

        setTitle("Request Meeting");

        initView(patient);
    }

    private void initView(Patient patient){
        date = (Button) findViewById(R.id.meeting_date);
        time = (Button) findViewById(R.id.meeting_time);

        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);
        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        hourOfDay = calendar.get(Calendar.HOUR_OF_DAY);
        minute = calendar.get(Calendar.MINUTE);
        showDate(year, month, day);
        showTime(hourOfDay, minute);
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
            case R.id.meeting_date:
                new DatePickerDialog(this, myDateListener, year, month, day).show();
                break;
            case R.id.meeting_time:
                new TimePickerDialog(this, myTimeListener, hourOfDay, minute, true).show();
                break;
            case R.id.save_meeting:
                new AlertDialog.Builder(this)
                        .setTitle("Info").setMessage("Meeting requested!")
                        .setCancelable(false)
                        .setNeutralButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                            }
                        }).show();
                break;
            default:
                break;
        }
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2, arg3);
        }
    };

    private TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            showTime(hourOfDay, minute);
        }
    };

    private void showDate(int year, int month, int day) {
        SimpleDateFormat format = new SimpleDateFormat("EE, MMM d, yyyy");
        calendar.set(year, month, day);
        date.setText(format.format(calendar.getTime()));
    }

    private void showTime(int hourOfDay, int minute) {
        SimpleDateFormat format = new SimpleDateFormat("hh:mm");
        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
        calendar.set(Calendar.MINUTE, minute);
        time.setText(format.format(calendar.getTime()));
    }
}
