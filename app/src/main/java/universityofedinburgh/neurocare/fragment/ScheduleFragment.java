package universityofedinburgh.neurocare.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by whdinata on 4/27/16.
 */
public class ScheduleFragment extends Fragment{
    public static ScheduleFragment newInstance(){
        return new ScheduleFragment();
    }

    @Override
    public void onResume() {
        super.onResume();

//        loadNotification(false);
    }
}
