package universityofedinburgh.neurocare.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by whdinata on 4/27/16.
 */
public class NotificationFragment extends Fragment{
    public static NotificationFragment newInstance(){
        return new NotificationFragment();
    }

    @Override
    public void onResume() {
        super.onResume();

//        loadNotification(false);
    }
}
