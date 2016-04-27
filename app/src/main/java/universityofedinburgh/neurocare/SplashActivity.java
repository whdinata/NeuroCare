package universityofedinburgh.neurocare;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;

import universityofedinburgh.neurocare.entity.NCParseFeedback;
import universityofedinburgh.neurocare.entity.NCParsePatient;

public class SplashActivity extends FragmentActivity {

    private static int SPLASH_TIME_OUT = 3000;
    private String quotes[] = new String[]{
        "Love is all around. I don’t need your leftovers, ma’am. Not unless you’re offering meatloaf.",
        "If you can't feed a hundred people, then feed just one.",
        "The West's thoughtlessness about waste could be overcome by learning from the developing world's frugality",
        "Liebe geht durch den Magen. \n (Love enters through the stomach)",
        "Throwing away food is like stealing from the table of those who are poor and hungry.",
        "Edible items constitute an estimated 60% of British household food and drink waste. \nThis costs the average UK household 470 pounds per year."
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        initParse();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);
    }

    @Override
    protected void onResume() {
        super.onResume();

        int idx = (int)(Math.random() * quotes.length);
        //((TextView)findViewById(R.id.quote)).setText(quotes[idx]);
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
}
