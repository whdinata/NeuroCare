package universityofedinburgh.neurocare.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import universityofedinburgh.neurocare.R;

/**
 * Created by whdinata on 4/27/16.
 */
public class AdmissionView extends LinearLayout {
    private Spinner spSwallow;
    private Spinner spFeeding;
    private Spinner spGrooming;
    private Spinner spBathing;
    private Spinner spDress;
    private Spinner spToiletting;
    private Spinner spTransfer;
    private Spinner spBowel;
    private Spinner spWalk;
    private Spinner spStairs;
    private Spinner spComprehension;
    private Spinner spExpression;
    private Spinner spReading;
    private Spinner spWriting;
    private Spinner spSocialInteraction;
    private Spinner spProblemSolve;
    private Spinner spMemory;
    private Spinner spAttention;
    private Spinner spSpeech;
    private Spinner spEmotion;


    public AdmissionView(Context context){
        super(context);
        initView();
    }

    public AdmissionView(Context context, AttributeSet attrs){
        super(context, attrs);
        initView();
    }

    public AdmissionView(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        initView();
    }

    public void setAdmission(String admission){


    }

    public String getAdmission(){
        Map<String, String> map = new HashMap<>();

        map.put("swallow", spSwallow.getSelectedItem().toString());
        map.put("feeding", spFeeding.getSelectedItem().toString());
        map.put("grooming", spGrooming.getSelectedItem().toString());
        map.put("bathing", spBathing.getSelectedItem().toString());
        map.put("dress", spDress.getSelectedItem().toString());
        map.put("toiletting", spToiletting.getSelectedItem().toString());
        map.put("transfer", spTransfer.getSelectedItem().toString());
        map.put("bowel", spBowel.getSelectedItem().toString());
        map.put("walk", spWalk.getSelectedItem().toString());
        map.put("stairs", spStairs.getSelectedItem().toString());
        map.put("comprehension", spComprehension.getSelectedItem().toString());
        map.put("expression", spExpression.getSelectedItem().toString());
        map.put("reading", spReading.getSelectedItem().toString());
        map.put("writing", spWriting.getSelectedItem().toString());
        map.put("social interaction", spSocialInteraction.getSelectedItem().toString());
        map.put("problem solve", spProblemSolve.getSelectedItem().toString());
        map.put("memory", spMemory.getSelectedItem().toString());
        map.put("attention", spAttention.getSelectedItem().toString());
        map.put("speech", spSpeech.getSelectedItem().toString());
        map.put("emotion", spEmotion.getSelectedItem().toString());

        return new JSONObject(map).toString();
    }

    private void initView(){
        inflate(getContext(), R.layout.admission, this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getContext(),
                R.array.admission_value, R.layout.spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spSwallow = (Spinner) findViewById(R.id.spinner_swallow);
        spFeeding = (Spinner) findViewById(R.id.spinner_feeding);
        spGrooming = (Spinner) findViewById(R.id.spinner_grooming);
        spBathing = (Spinner) findViewById(R.id.spinner_bathing);
        spDress = (Spinner) findViewById(R.id.spinner_dress);
        spToiletting = (Spinner) findViewById(R.id.spinner_toiletting);
        spTransfer = (Spinner) findViewById(R.id.spinner_transfer);
        spBowel = (Spinner) findViewById(R.id.spinner_bowel);
        spWalk = (Spinner) findViewById(R.id.spinner_walk);
        spStairs = (Spinner) findViewById(R.id.spinner_stairs);
        spComprehension = (Spinner) findViewById(R.id.spinner_comprehension);
        spExpression = (Spinner) findViewById(R.id.spinner_expression);
        spReading = (Spinner) findViewById(R.id.spinner_reading);
        spWriting = (Spinner) findViewById(R.id.spinner_writing);
        spSocialInteraction = (Spinner) findViewById(R.id.spinner_social_interaction);
        spProblemSolve = (Spinner) findViewById(R.id.spinner_problem_solve);
        spMemory = (Spinner) findViewById(R.id.spinner_memory);
        spAttention = (Spinner) findViewById(R.id.spinner_attention);
        spSpeech = (Spinner) findViewById(R.id.spinner_speech);
        spEmotion = (Spinner) findViewById(R.id.spinner_emotion);

        spSwallow.setAdapter(adapter);
        spFeeding.setAdapter(adapter);
        spGrooming.setAdapter(adapter);
        spBathing.setAdapter(adapter);
        spDress.setAdapter(adapter);
        spToiletting.setAdapter(adapter);
        spTransfer.setAdapter(adapter);
        spBowel.setAdapter(adapter);
        spWalk.setAdapter(adapter);
        spStairs.setAdapter(adapter);
        spComprehension.setAdapter(adapter);
        spExpression.setAdapter(adapter);
        spReading.setAdapter(adapter);
        spWriting.setAdapter(adapter);
        spSocialInteraction.setAdapter(adapter);
        spProblemSolve.setAdapter(adapter);
        spMemory.setAdapter(adapter);
        spAttention.setAdapter(adapter);
        spSpeech.setAdapter(adapter);
        spEmotion.setAdapter(adapter);
    }
}
