package universityofedinburgh.neurocare.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by whdinata on 4/27/16.
 */
public class ActionFragment extends Fragment{
    public static ActionFragment newInstance(){
        return new ActionFragment();
    }

    @Override
    public void onResume() {
        super.onResume();

//        loadNotification(false);
    }
}
