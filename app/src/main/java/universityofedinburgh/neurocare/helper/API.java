package universityofedinburgh.neurocare.helper;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.SaveCallback;

import java.util.ArrayList;
import java.util.List;

import universityofedinburgh.neurocare.FeedbackFormActivity;
import universityofedinburgh.neurocare.entity.Feedback;
import universityofedinburgh.neurocare.entity.NCParseFeedback;
import universityofedinburgh.neurocare.entity.NCParsePatient;
import universityofedinburgh.neurocare.entity.Patient;
import universityofedinburgh.neurocare.fragment.FeedbackRecordFragment;
import universityofedinburgh.neurocare.fragment.PatientFragment;

/**
 * Created by whdinata on 1/11/16.
 */
public class API {
    private static final String TAG = API.class.getName();
    private static ProgressDialog dialog;

    public static void login(final Activity activity, final String username, String password) {
        showLoadingDialog(activity);
        ParseUser.logInInBackground(username, password, new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if (user != null) {
                    Log.i(TAG, "Logged In Success!");
                    //Holder.login = true;
                    FSSharedPreferenceHelper.putString(activity, FSSharedPreferenceHelper.EMAIL, username);
                    activity.setResult(Activity.RESULT_OK);
                    activity.finish();
                } else {
                    Log.e(TAG, "Logged In Error!");
                }
            }
        });
    }

//    public static void register(final FSParseUser user, final RegisterActivity activity){
//        showLoadingDialog(activity);
//        user.signUpInBackground(new SignUpCallback() {
//            @Override
//            public void done(ParseException e) {
//                if (e == null) {
//                    Log.i(TAG, "Sign up Success!");
//                    Intent intent = new Intent(activity, MainActivity.class);
//                    Holder.login = true;
//                    FSSharedPreferenceHelper.putString(activity, FSSharedPreferenceHelper.EMAIL, user.getEmail())
//                    ;activity.startActivity(intent);
//                    activity.finish();
//                } else {
//                    Log.e(TAG, "Sign up Error!");
//                }
//
//                dialog.dismiss();
//            }
//        });
//    }

//    public static void addFood(final ParseFile image, final Food food, final AddFoodActivity activity){
//        showLoadingDialog(activity);
//        image.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if (e == null) {
//                    Log.i(TAG, "Save Image Success!");
//                    food.setImage(image);
//                    saveFood(food, activity);
//                } else {
//                    Log.e(TAG, "Save Image failed!");
//                }
//
//                dialog.dismiss();
//            }
//        });
//    }
//

    public static void getAllFeedbacks(final FeedbackRecordFragment activity){
        showLoadingDialog(activity.getContext());
        ParseQuery<NCParseFeedback> query = ParseQuery.getQuery("Feedback");
        query.findInBackground(new FindCallback<NCParseFeedback>() {
            @Override
            public void done(List<NCParseFeedback> feedbackList, ParseException e) {
                if (e == null) {
                    Log.i(TAG, "Get Patients Success!");
                    List<Feedback> feedbacks = new ArrayList<>();

                    for(NCParseFeedback feedback : feedbackList){
                        Feedback fb = new Feedback(feedback);

                        feedbacks.add(fb);
                    }
                    activity.attachData(feedbacks);
                } else {
                    Log.e(TAG, "Get Patients Failed!");
                    e.printStackTrace();
                }
                dialog.dismiss();
            }
        });
    }

    public static void getAllPatient(final PatientFragment activity){
        showLoadingDialog(activity.getContext());
        ParseQuery<NCParsePatient> query = ParseQuery.getQuery("Patient");
        query.findInBackground(new FindCallback<NCParsePatient>() {
            @Override
            public void done(List<NCParsePatient> patientList, ParseException e) {
                if (e == null) {
                    Log.i(TAG, "Get Patients Success!");
                    List<Patient> patients = new ArrayList<>();

                    for(NCParsePatient patient : patientList){
                        Patient ptn = new Patient(patient.getName(), patient.getId(), patient.getGender(), patient.isInpatient());
                        ptn.setBirthdate(patient.getBirthdate());
                        ptn.setDisease(patient.getDisease());

                        patients.add(ptn);
                    }
                    activity.attachData(patients);
                } else {
                    Log.e(TAG, "Get Patients Failed!");
                    e.printStackTrace();
                }
                dialog.dismiss();
            }
        });
    }

    public static void updateFeedback(final Feedback feedback, final FeedbackFormActivity activity){
        showLoadingDialog(activity);
        ParseQuery<NCParseFeedback> query = ParseQuery.getQuery("Feedback");

        System.out.println("Feedback ID: " + feedback.getId());

        query.getInBackground(feedback.getId(), new GetCallback<NCParseFeedback>() {
            @Override
            public void done(NCParseFeedback object, ParseException e) {
                if (e == null) {
                    Log.i(TAG, "Save Success!");
                    object.setIssue(feedback.getIssue());
                    object.setAdmission(feedback.getAdmission());
                    object.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            activity.finish();
                            dialog.dismiss();
                        }
                    });
                } else {
                    Log.e(TAG, "Save failed!");
                    e.printStackTrace();
                }
            }
        });

//        feedback.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if (e == null) {
//                    Log.i(TAG, "Save Success!");
//                    activity.finish();
//                } else {
//                    Log.e(TAG, "Save failed!");
//                }
//            }
//        });
    }

    private static void showLoadingDialog(Context context){

        //if(dialog == null) {
            dialog = ProgressDialog.show(context, "", "Loading. Please wait...", true);
        //}

        dialog.show();
    }
}
