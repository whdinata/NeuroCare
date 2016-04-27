package universityofedinburgh.neurocare.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import universityofedinburgh.neurocare.R;

/**
 * Created by whdinata on 4/27/16.
 */
public class NCMenuItem extends RelativeLayout {
    private TextView tvLabel;
    private ImageView imageView;

    public NCMenuItem(Context context){
        super(context);
        initView();
    }

    public NCMenuItem(Context context, AttributeSet attrs){
        super(context, attrs);
        initView();
        applyAttributes(attrs, 0);
    }

    public NCMenuItem(Context context, AttributeSet attrs, int defStyleAttr){
        super(context, attrs, defStyleAttr);
        initView();
        applyAttributes(attrs, defStyleAttr);
    }

    public void setDrawableResourceId(@DrawableRes int drawableResourceId) {
        if (drawableResourceId != 0) {
            imageView.setImageResource(drawableResourceId);
        }
    }

    public void setText(@StringRes int stringId){
        tvLabel.setText(stringId);
    }

    private void applyAttributes(AttributeSet attrs, int defStyleAttr) {
        TypedArray a = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.NCMenuItem, defStyleAttr, 0);

        try {
            setDrawableResourceId(a.getResourceId(R.styleable.NCMenuItem_android_src, 0));
            setText(a.getResourceId(R.styleable.NCMenuItem_android_text, 0));
        } finally {
            a.recycle();
        }
    }

    private void initView(){
        inflate(getContext(), R.layout.menu_item, this);
        tvLabel = (TextView) findViewById(R.id.label);
        imageView = (ImageView) findViewById(R.id.image);
    }
}

