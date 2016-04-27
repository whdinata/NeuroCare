package universityofedinburgh.neurocare.helper;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by whdinata on 4/27/16.
 */
public final class FragmentUtils {

    public static void changeFragment(AppCompatActivity host, int containerViewId, Fragment fragment) {
        if (host == null || fragment == null) return;

        host.getSupportFragmentManager()
                .beginTransaction()
                .replace(containerViewId, fragment)
                .commit();
    }

    public static void changeFragment(Fragment host, int containerViewId, Fragment fragment) {
        if (host == null || fragment == null) return;

        host.getChildFragmentManager()
                .beginTransaction()
                .replace(containerViewId, fragment)
                .commit();
    }

    private FragmentUtils() {}

}
