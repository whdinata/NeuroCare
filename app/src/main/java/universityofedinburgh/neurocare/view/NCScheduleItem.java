package universityofedinburgh.neurocare.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v7.widget.CardView;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.List;

import universityofedinburgh.neurocare.R;

/**
 * Created by whdinata on 4/27/16.
 */
public class NCScheduleItem extends CardView {
    private TextView tvDate;
    private LinearLayout llContainer;
    private List<String> scheduleItems;

    public NCScheduleItem(Context context){
        super(context);
        initView();
    }

    public NCScheduleItem(Context context, AttributeSet attrs){
        super(context, attrs);
        initView();
        applyAttributes(attrs, 0);
    }

    public NCScheduleItem(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        initView();
        applyAttributes(attrs, defStyleAttr);
    }

    public void setScheduleItems(List<String> scheduleItems){
        this.scheduleItems = scheduleItems;

        for(String schedule : scheduleItems){
            TextView tvTodo = (TextView) inflate(getContext(), R.layout.todo_item, null);
            tvTodo.setText(schedule);
            llContainer.addView(tvTodo);
        }
    }

    public void setText(@StringRes int stringId){
        tvDate.setText(stringId);
    }

    private void applyAttributes(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.NCMenuItem, defStyleAttr, 0);

        try {
            setText(a.getResourceId(R.styleable.NCMenuItem_android_text, 0));
        } finally {
            a.recycle();
        }
    }

    private void initView(){
        inflate(getContext(), R.layout.menu_item, this);
        tvDate = (TextView) findViewById(R.id.label);
        llContainer = (LinearLayout) findViewById(R.id.schedule_item_container);
    }
}

