package universityofedinburgh.neurocare.view;

import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import universityofedinburgh.neurocare.FeedbackFormActivity;
import universityofedinburgh.neurocare.R;
import universityofedinburgh.neurocare.entity.Feedback;

/**
 * Created by whdinata on 4/27/16.
 */
public class NCFeedbackRightSideView extends RelativeLayout {
    private TextView tvTitle;
    private TextView tvWeek;
    private TextView tvShortDescription;
    private View btEdit;
    private Feedback feedback;

    public NCFeedbackRightSideView(Context context){
        super(context);
        initView();
    }

    public NCFeedbackRightSideView(Context context, AttributeSet attrs){
        super(context, attrs);
        initView();
    }

    public NCFeedbackRightSideView(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        initView();
    }

    public void setFeedback(Feedback feedback){
        this.feedback = feedback;

        if(feedback.isMdt()){
            tvTitle.setText("MDT FEEDBACK");
            tvWeek.setVisibility(View.VISIBLE);
            tvWeek.setText("Week " + feedback.getWeek());
            btEdit.setVisibility(View.VISIBLE);

            tvShortDescription.setVisibility(View.GONE);
        } else{
            tvTitle.setText("FAMILY NOTE");
            tvWeek.setVisibility(View.GONE);
            btEdit.setVisibility(View.GONE);

            tvShortDescription.setVisibility(View.VISIBLE);
            //tvShortDescription.setText(feedback.get);
        }
    }

    private void initView(){
        inflate(getContext(), R.layout.feedback_right_side, this);
        tvTitle = (TextView) findViewById(R.id.title);
        tvWeek = (TextView) findViewById(R.id.week);
        tvShortDescription = (TextView) findViewById(R.id.shortDescription);
        btEdit = findViewById(R.id.button_edit);

        btEdit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = FeedbackFormActivity.getIntent(v.getContext(), feedback);
                v.getContext().startActivity(intent);
            }
        });
    }
}

