package com.example.amit.employeeapp;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.amit.employeeapp.adapterfile.SpinnerAdapterfile;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BasicComponentsReuse {
    public Context context_obj,otp_context;
    private int mYear, mDay, mMonth;
    EditText editTextfield_obj;
    TextView textView_obj,otpTimetext_view,otpgetTimetext_view,sendotpsmstext_view;
    CheckBox checkbox_obj;
   // Retrofitinterface retrofitinterfacefile;
    String outsideTokenno = "_KDHudbjadguaigwebbHAY3844", str_alluserLogindata, fragshow_status, str_userdetaillist, fragnamevisible;
    ArrayList<String> districtspinnerlist_obj = new ArrayList<>(),districtspinneridlist_obj=new ArrayList<>(),
            statespinnerlist_obj = new ArrayList<>(),statespinneridlist_obj=new ArrayList<>(),
            countryspinnerlist_obj = new ArrayList<>(), qualifctnspinnerlist_obj = new ArrayList<>(),
            qualifctnspinneridlist_obj=new ArrayList<>(), spclzationspinnerlist_obj = new ArrayList<>(),spclzationspinneridlist_obj=new ArrayList<>(),
            highqualifctnspinnerlist_obj=new ArrayList<>(),
            highqualifctnspinneridlist_obj=new ArrayList<>(),
            skillspinnerlist_obj = new ArrayList<>(),
            skillspinneridlist_obj = new ArrayList<>();
   // LoginPOJO2[] allUserLogindatalist_obj;
    //ArrayList<FetchUserDataPOJO2> getUserdetailslist_obj = new ArrayList<>();
    Spinner countryspinner_obj, statespinner_obj, districtspinner_obj,skillspinner_obj,
            highqualifctnspinner_obj,qualifctnspinner_obj, spclzationspinner_obj,validate_spinnerobj;
    SharedPreferences.Editor loginsession_preference, preference_name;
    SharedPreferences alluserSessiondata_preference;
    Gson alldatagson, getvalue_gson;
    ProgressDialog progressbar;
    Boolean exprTimeCount_obj=false;
    CountDownTimer countDownTimer_obj;
    Button otpsubmitbtn,otpgetsubmitbtn;
    String username = "dogrpunjab-mgov",password="mgov@pb2",message="null",
            number="null",senderid="PBGOVT",deptSecureKey="40278444-599b-4fcd-b253-fe928070b94e"
            ,hashValue="null",otpValue="null",userEmailID="null";
    LinearLayout snackshow_layout;
    int validEmailStatus=0;

    public void printToast_method(Context context, String var) {
        context_obj = context;
        Toast.makeText(context_obj, "" + var, Toast.LENGTH_SHORT).show();
    }//end of print toast method

    public void printSnackBar_method(LinearLayout Layout_obj, String snackstring){
        Snackbar snackbar = Snackbar.make(Layout_obj,""+snackstring, Snackbar.LENGTH_LONG);
        snackbar.show();
    }//end of snackbar method

    public void sharedclear_method(Context context, String var) {
        context_obj = context;
        preference_name = context_obj.getSharedPreferences(var, Context.MODE_PRIVATE).edit();
        preference_name.clear();
        preference_name.commit();

    }//end of shared preference method

    public String getfragValueFromSession_method(Context applicationContext, String fragmentsname, String fragshowkey) {
        context_obj = applicationContext;
        SharedPreferences about_frag_preference = context_obj.getSharedPreferences(fragmentsname, Context.MODE_PRIVATE);
        fragshow_status = about_frag_preference.getString(fragshowkey, "0");
        return fragshow_status;
    }//end of get String value from session method

//    public void backPressfragtoLogin_method(Context activity, String fragname) {
//        context_obj = activity;
//        SharedPreferences.Editor aboutus_preference = context_obj.getSharedPreferences(fragname, Context.MODE_PRIVATE).edit();
//        aboutus_preference.clear();
//        aboutus_preference.commit();
//        Intent intent_employerreg1 = new Intent(context_obj, Login.class);
//        context_obj.startActivity(intent_employerreg1);
//    }//end of back press to login activity method
//
//    public void backPressfragtoMainAct_method(Context activity, String fragname) {
//        context_obj = activity;
//        SharedPreferences.Editor aboutus_preference = context_obj.getSharedPreferences(fragname, Context.MODE_PRIVATE).edit();
//        aboutus_preference.clear();
//        aboutus_preference.commit();
//        Intent intent_employerreg1 = new Intent(context_obj, Jobseeker_main.class);
//        context_obj.startActivity(intent_employerreg1);
//    }//end of back press to login activity method

//    public void signupToolbarShow_method(Context context, Toolbar jobseekerreg1tool_obj, String toolbarname, String regfragmentsshow) {
//        context_obj = context;
//        fragnamevisible = regfragmentsshow;
//        jobseekerreg1tool_obj.setTitle(toolbarname);
//        jobseekerreg1tool_obj.setTitleTextColor(Color.WHITE);
//        jobseekerreg1tool_obj.setNavigationIcon(R.drawable.leftarrow);
//        jobseekerreg1tool_obj.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                backPressfragtoLogin_method(context_obj, fragnamevisible);
//                ((AppCompatActivity) context_obj).finish();
//            }
//        });
//    }//end of sign up Toolbar show method
//
//    public void innerfragToolbarShow_method(Context context, Toolbar jobseekerreg1tool_obj, String toolbarname, String regfragmentsshow) {
//        context_obj = context;
//        fragnamevisible = regfragmentsshow;
//        jobseekerreg1tool_obj.setTitle(toolbarname);
//        jobseekerreg1tool_obj.setTitleTextColor(Color.WHITE);
//        jobseekerreg1tool_obj.setNavigationIcon(R.drawable.leftarrow);
//        jobseekerreg1tool_obj.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                backPressfragtoMainAct_method(context_obj, fragnamevisible);
//                ((AppCompatActivity) context_obj).finish();
//            }
//        });
//    }//end of sign up Toolbar show method


    public void mainAppSessioncreate_method(Context context, String appSession, String loginAppSession, String loginAuthKey, String userdetaillist, ArrayList<String> login_arraylist) {
        alldatagson = new Gson();
        str_userdetaillist = alldatagson.toJson(login_arraylist);
        loginsession_preference = context.getSharedPreferences(appSession, Context.MODE_PRIVATE).edit();
        loginsession_preference.putString(loginAppSession, loginAuthKey);
        loginsession_preference.putString(userdetaillist, str_userdetaillist);
        loginsession_preference.commit();
    }//end of mainoptionmenu session create method

//    public  LoginPOJO2[]  AppSessionValueGet_method(Context context) {
//        alluserSessiondata_preference = context.getSharedPreferences("LoginAppSession", Context.MODE_PRIVATE);
//        str_alluserLogindata = alluserSessiondata_preference.getString("Loginuserdetaillist", "null");
//        getvalue_gson = new Gson();
//        allUserLogindatalist_obj = getvalue_gson.fromJson(str_alluserLogindata,  LoginPOJO2[].class);
//        return allUserLogindatalist_obj;
//    }//end of AppSessionValueGet method

        public void intentmoveAnimateCode_method(Context applicationContext, Intent common_intent){
        context_obj=applicationContext;
        ((AppCompatActivity)context_obj).startActivity(common_intent);
        ((AppCompatActivity)context_obj).finish();
        ((AppCompatActivity)context_obj).overridePendingTransition(R.anim.push_left_in,R.anim.push_left_out);
    }//end of onClick method

    //TOTAL PROGRESS BAR WORK
    public ProgressDialog showProgressBar_method(Context context, ProgressDialog commonprogressbarinti) {
        context_obj = context;
        progressbar=commonprogressbarinti;
        progressbar = new ProgressDialog(context_obj, android.R.style.Theme_DeviceDefault_Light_Dialog);
        progressbar.setMessage("Please wait");
        progressbar.setCancelable(false);
        progressbar.setCanceledOnTouchOutside(false);
        progressbar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        return progressbar;
    }//end of show ProgressBar method

    public void editTextfieldvalidate_method(EditText edittextobj, String s) {
        editTextfield_obj = edittextobj;
        editTextfield_obj.setError(s);
        editTextfield_obj.requestFocus();
    }//end of field enter require method

    public void textviewfieldvalidate_method(TextView textviewobj, String s) {
        textView_obj = textviewobj;
        textView_obj.setError(s);
        textView_obj.requestFocus();
    }//end of field enter require method

    public void checkboxfieldvalidate_method(CheckBox checkboxobj, String s) {
        checkbox_obj = checkboxobj;
        checkbox_obj.setError(s);
        checkbox_obj.requestFocus();
    }//end of field enter require method

    public void cleartxtviewerrormsg_method(TextView textviewobj) {
        textView_obj = textviewobj;
        textviewobj.setError(null);
        textView_obj.requestFocus();
    }//end of clear error msg method

    public void clearcheckboxerrormsg_method(CheckBox checkBoxobj) {
        checkbox_obj = checkBoxobj;
        checkbox_obj.setError(null);
        checkbox_obj.requestFocus();
    }//end of clear error msg method


    public void fragmentbackpresspreference_method(FragmentActivity activity, String fragmentsshowname, String fragstringname, String fragstringvalue) {
        context_obj = activity;
        SharedPreferences.Editor fragmentback = context_obj.getSharedPreferences(fragmentsshowname, Context.MODE_PRIVATE).edit();
        fragmentback.putString(fragstringname, fragstringvalue);
        fragmentback.commit();
    }//end of fragment show preference method

    public void datetextviewcalender_method(FragmentActivity activity, TextView textviewobj) {
        context_obj = activity;
        textView_obj = textviewobj;
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(context_obj, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                textView_obj.setText(year+"-"+(month + 1) + "-" + day );
            }
        },mYear, mMonth, mDay );
        datePickerDialog.show();
    }//end of datesetcalender_method

    public void showStaticSpinner_method(FragmentActivity activity, String[] spinnerarraylist, Spinner spinnername, int indexforSpinnerItem) {
        context_obj = activity;
        SpinnerAdapterfile spinnerAdapterfile_obj1 = new SpinnerAdapterfile(context_obj, spinnerarraylist);
        spinnername.setAdapter(spinnerAdapterfile_obj1);
        spinnername.setSelection(indexforSpinnerItem);
    }//end of show Static Spinner method
//
//    public ArrayList<String> showSkillIsectorSpinner_method(FragmentActivity activity, Spinner skillspinnername, final int skillspin_value){
//        context_obj = activity;
//        skillspinner_obj = skillspinnername;
//        retrofitinterfacefile = Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
//        Call<SkillSectorPOJO1> skillsectorData = retrofitinterfacefile.getSkillSectors_method(outsideTokenno);
//        skillsectorData.enqueue(new Callback<SkillSectorPOJO1>() {
//            @Override
//            public void onResponse(Call<SkillSectorPOJO1> call, Response<SkillSectorPOJO1> response) {
//                if (response.body() != null) {
//                    if (response.body().getStatus().equals(1)) {
//                        skillspinnerlist_obj.clear();
//                        skillspinneridlist_obj.clear();
//                        skillspinnerlist_obj.add("Select");
//                        skillspinneridlist_obj.add("0");
//                        for (int skillval = 0; skillval < response.body().getData().size(); skillval++) {
//                            skillspinnerlist_obj.add(response.body().getData().get(skillval).getSectorName());
//                            skillspinneridlist_obj.add(response.body().getData().get(skillval).getId());
//                        }//end of for loop
//                        SpinnerAdapterfile spinnerAdapterfile_obj1 = new SpinnerAdapterfile((FragmentActivity) context_obj, skillspinnerlist_obj, 1);
//                        skillspinner_obj.setAdapter(spinnerAdapterfile_obj1);
//                        skillspinner_obj.setSelection(skillspin_value);
//                    }//end of inner if condition
//                    else printToast_method(context_obj, "Something went wrong. Please try again");
//                }//end of if condition
//                else printToast_method(context_obj, "Something went wrong. Please try again");
//            }//end of onResponse method
//            @Override
//            public void onFailure(Call<SkillSectorPOJO1> call, Throwable t) {
//                printToast_method(context_obj, "Check internet connection or Server Problem");
//            }//end of onFailure method
//        });
//        return skillspinneridlist_obj;
//    }//end of show skills Items Spinner method
//
//    public ArrayList<String> showDistrictSpinner_method(FragmentActivity activity, Spinner spinnername, final int distrct_value) {
//        context_obj = activity;
//        districtspinner_obj = spinnername;
//        retrofitinterfacefile = Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
//        Call<DistrictPojo1> districtData = retrofitinterfacefile.getDistrict_method(outsideTokenno);
//        districtData.enqueue(new Callback<DistrictPojo1>() {
//            @Override
//            public void onResponse(Call<DistrictPojo1> call, Response<DistrictPojo1> response) {
//                if (response.body() != null) {
//                    if (response.body().getStatus().equals(1)) {
//                        districtspinnerlist_obj.clear();
//                        districtspinneridlist_obj.clear();
//                        districtspinnerlist_obj.add("Select");
//                        districtspinneridlist_obj.add("0");
//                        for (int distval = 0; distval < response.body().getData().size(); distval++) {
//                            districtspinnerlist_obj.add(response.body().getData().get(distval).getDistrictName());
//                            districtspinneridlist_obj.add(response.body().getData().get(distval).getId());
//                        }
//                        SpinnerAdapterfile spinnerAdapterfile_obj1 = new SpinnerAdapterfile((FragmentActivity) context_obj, districtspinnerlist_obj, 1);
//                        districtspinner_obj.setAdapter(spinnerAdapterfile_obj1);
//                        districtspinner_obj.setSelection(distrct_value);
//                    }//end of inner if condition
//                    else printToast_method(context_obj, "Something went wrong. Please try again");
//                }//end of if condition
//                else printToast_method(context_obj, "Something went wrong. Please try again");
//            }//end of onResponse method
//
//            @Override
//            public void onFailure(Call<DistrictPojo1> call, Throwable t) {
//                printToast_method(context_obj, "Check internet connection or Server Problem");
//            }//end of onFailure method
//        });
//        return districtspinneridlist_obj;
//    }//end of show DistrictSpinner_method
//
//    public ArrayList<String> showCountrySpinner_method(FragmentActivity activity, Spinner spinnername, final int country_value) {
//        context_obj = activity;
//        countryspinner_obj = spinnername;
//        countryspinnerlist_obj.add("Select");
//        retrofitinterfacefile = Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
//        Call<CountryPOJO1> countryData = retrofitinterfacefile.getCountry_method(outsideTokenno);
//        countryData.enqueue(new Callback<CountryPOJO1>() {
//            @Override
//            public void onResponse(Call<CountryPOJO1> call, Response<CountryPOJO1> response) {
//                if (response.body() != null) {
//                    if (response.body().getStatus().equals(1)) {
//                        for (int countval = 0; countval < response.body().getData().size(); countval++) {
//                            countryspinnerlist_obj.add(response.body().getData().get(countval).getCountryName());
//                        }
//                        SpinnerAdapterfile spinnerAdapterfile_obj1 = new SpinnerAdapterfile((FragmentActivity) context_obj, countryspinnerlist_obj, 1);
//                        countryspinner_obj.setAdapter(spinnerAdapterfile_obj1);
//                        countryspinner_obj.setSelection(country_value);
//
//                    }//end of inner if condition
//                    else printToast_method(context_obj, "Something went wrong. Please try again");
//                }//end of if condition
//                else printToast_method(context_obj, "Something went wrong. Please try again");
//            }//end of onResponse method
//
//            @Override
//            public void onFailure(Call<CountryPOJO1> call, Throwable t) {
//                printToast_method(context_obj, "Check internet connection or Server Problem");
//            }//end of onFailure method
//        });
//        return countryspinnerlist_obj;
//    }//end of show Country spinner method
//
//    //Show State spinner method
//    public ArrayList<String> showStateSpinner_method(FragmentActivity activity, Spinner spinnername, final int state_value) {
//        context_obj = activity;
//        statespinner_obj = spinnername;
//        retrofitinterfacefile = Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
//        Call<StatePOJO1> stateData = retrofitinterfacefile.getState_method(outsideTokenno);
//        stateData.enqueue(new Callback<StatePOJO1>() {
//            @Override
//            public void onResponse(Call<StatePOJO1> call, Response<StatePOJO1> response) {
//                if (response.body() != null) {
//                    if (response.body().getStatus().equals(1)) {
//                        statespinnerlist_obj.clear();
//                        statespinneridlist_obj.clear();
//                        statespinnerlist_obj.add("Select");
//                        statespinneridlist_obj.add("0");
//                        for (int distval = 0; distval < response.body().getData().size(); distval++) {
//                            statespinnerlist_obj.add(response.body().getData().get(distval).getStateName());
//                            statespinneridlist_obj.add(response.body().getData().get(distval).getId());
//                        }
//                        SpinnerAdapterfile spinnerAdapterfile_obj1 = new SpinnerAdapterfile((FragmentActivity) context_obj, statespinnerlist_obj, 1);
//                        statespinner_obj.setAdapter(spinnerAdapterfile_obj1);
//                        statespinner_obj.setSelection(state_value);
//                    }//end of inner if condition
//                    else printToast_method(context_obj, "Something went wrong. Please try again");
//                }//end of if condition
//                else printToast_method(context_obj, "Something went wrong. Please try again");
//            }//end of onResponse method
//            @Override
//            public void onFailure(Call<StatePOJO1> call, Throwable t) {
//                printToast_method(context_obj, "Check internet connection or Server Problem");
//            }//end of onFailure method
//        });
//        return statespinneridlist_obj;
//    }//end of show state spinner method
//
//    //Show High Qualification spinner method
//    public ArrayList<String> showHighQualificationSpinner_method(FragmentActivity activity, Spinner spinnername, final int qualfct_value) {
//        context_obj = activity;
//        highqualifctnspinner_obj = spinnername;
//        retrofitinterfacefile = Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
//        Call<HighQualfctnPOJO1> highqualificationData = retrofitinterfacefile.getHighQualification_method(outsideTokenno);
//        highqualificationData.enqueue(new Callback<HighQualfctnPOJO1>() {
//            @Override
//            public void onResponse(Call<HighQualfctnPOJO1> call, Response<HighQualfctnPOJO1> response) {
//                if (response.body() != null) {
//                    if (response.body().getStatus().equals(1)) {
//                        highqualifctnspinnerlist_obj.clear();
//                        highqualifctnspinnerlist_obj.add("Select");
//                        highqualifctnspinneridlist_obj.clear();
//                        highqualifctnspinneridlist_obj.add("0");
//                        for (int qualval = 0; qualval < response.body().getData().size(); qualval++) {
//                            highqualifctnspinnerlist_obj.add(response.body().getData().get(qualval).getName());
//                            highqualifctnspinneridlist_obj.add(response.body().getData().get(qualval).getId());
//                        }
//                        SpinnerAdapterfile spinnerAdapterfile_obj1 = new SpinnerAdapterfile((FragmentActivity) context_obj, highqualifctnspinnerlist_obj, 1);
//                        highqualifctnspinner_obj.setAdapter(spinnerAdapterfile_obj1);
//                        highqualifctnspinner_obj.setSelection(qualfct_value);
//                    }//end of inner if condition
//                    else printToast_method(context_obj, "Something went wrong. Please try again");
//                }//end of if condition
//                else printToast_method(context_obj, "Something went wrong. Please try again");
//            }//end of onResponse method
//
//            @Override
//            public void onFailure(Call<HighQualfctnPOJO1> call, Throwable t) {
//                printToast_method(context_obj, "Check internet connection or Server Problem");
//            }//end of onFailure method
//        });
//        return highqualifctnspinneridlist_obj;
//    }//end of Qualification spinner method
//
//
//    //Show Qualification spinner method
//    public ArrayList<String> showQualificationSpinner_method(FragmentActivity activity, Spinner spinnername, final int qualfct_value,int highQualID) {
//        context_obj = activity;
//        qualifctnspinner_obj = spinnername;
//        retrofitinterfacefile = Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
//        Call<QualificationPOJO1> qualificationData = retrofitinterfacefile.getQualification_method(outsideTokenno,highQualID);
//        qualificationData.enqueue(new Callback<QualificationPOJO1>() {
//            @Override
//            public void onResponse(Call<QualificationPOJO1> call, Response<QualificationPOJO1> response) {
//                if (response.body() != null) {
//                    if (response.body().getStatus().equals(1)) {
//                        qualifctnspinnerlist_obj.clear();
//                        qualifctnspinnerlist_obj.add("Select");
//                        qualifctnspinneridlist_obj.clear();
//                        qualifctnspinneridlist_obj.add("0");
//                        for (int qualval = 0; qualval < response.body().getData().size(); qualval++) {
//                            qualifctnspinnerlist_obj.add(response.body().getData().get(qualval).getQualificationName());
//                            qualifctnspinneridlist_obj.add(response.body().getData().get(qualval).getId());
//                        }
//                        SpinnerAdapterfile spinnerAdapterfile_obj1 = new SpinnerAdapterfile((FragmentActivity) context_obj, qualifctnspinnerlist_obj, 1);
//                        qualifctnspinner_obj.setAdapter(spinnerAdapterfile_obj1);
//                        qualifctnspinner_obj.setSelection(qualfct_value);
//                    }//end of inner if condition
//                    else printToast_method(context_obj, "Something went wrong. Please try again");
//                }//end of if condition
//                else printToast_method(context_obj, "Something went wrong. Please try again");
//            }//end of onResponse method
//
//            @Override
//            public void onFailure(Call<QualificationPOJO1> call, Throwable t) {
//                printToast_method(context_obj, "Check internet connection or Server Problem");
//            }//end of onFailure method
//        });
//        return qualifctnspinneridlist_obj;
//    }//end of Qualification spinner method
//
//    //Show Qualification spinner method
//    public ArrayList<String> setQualificationdata_method(FragmentActivity activity,int highQualID) {
//        context_obj = activity;
//        retrofitinterfacefile = Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
//        Call<QualificationPOJO1> qualificationData = retrofitinterfacefile.getQualification_method(outsideTokenno,highQualID);
//        qualificationData.enqueue(new Callback<QualificationPOJO1>() {
//            @Override
//            public void onResponse(Call<QualificationPOJO1> call, Response<QualificationPOJO1> response) {
//                if (response.body() != null) {
//                    if (response.body().getStatus().equals(1)) {
//                        for (int qualval = 0; qualval < response.body().getData().size(); qualval++) {
//                            qualifctnspinnerlist_obj.add(response.body().getData().get(qualval).getQualificationName());
//                            qualifctnspinneridlist_obj.add(response.body().getData().get(qualval).getId());
//                        }
//                    }//end of inner if condition
//                    else printToast_method(context_obj, "Something went wrong. Please try again");
//                }//end of if condition
//                else printToast_method(context_obj, "Something went wrong. Please try again");
//            }//end of onResponse method
//            @Override
//            public void onFailure(Call<QualificationPOJO1> call, Throwable t) {
//                printToast_method(context_obj, "Check internet connection or Server Problem");
//            }//end of onFailure method
//        });
//        return qualifctnspinneridlist_obj;
//    }//end of Qualification spinner method
//
//    //Show Specialization spinner method
//    public ArrayList<String> showSpecializationSpinner_method(FragmentActivity activity, Spinner spinnername, final int specilztn_value,int qualID) {
//        context_obj = activity;
//        spclzationspinner_obj = spinnername;
//        retrofitinterfacefile = Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
//        Call<SpecializationPOJO1> speclztnData = retrofitinterfacefile.getSpecialization_method(outsideTokenno,qualID);
//        speclztnData.enqueue(new Callback<SpecializationPOJO1>() {
//            @Override
//            public void onResponse(Call<SpecializationPOJO1> call, Response<SpecializationPOJO1> response) {
//                if (response.body() != null) {
//                    if (response.body().getStatus().equals(1)) {
//                        spclzationspinnerlist_obj.clear();
//                        spclzationspinnerlist_obj.add("Select");
//                        spclzationspinneridlist_obj.clear();
//                        spclzationspinneridlist_obj.add("0");
//                        for (int splztnval = 0; splztnval < response.body().getData().size(); splztnval++) {
//                            spclzationspinnerlist_obj.add(response.body().getData().get(splztnval).getSpecializationName());
//                            spclzationspinneridlist_obj.add(response.body().getData().get(splztnval).getId());
//                        }
//                        SpinnerAdapterfile spinnerAdapterfile_obj1 = new SpinnerAdapterfile((FragmentActivity) context_obj, spclzationspinnerlist_obj, 1);
//                        spclzationspinner_obj.setAdapter(spinnerAdapterfile_obj1);
//                        spclzationspinner_obj.setSelection(specilztn_value);
//                    }//end of inner if condition
//                    else printToast_method(context_obj, "Something went wrong. Please try again");
//                }//end of if condition
//                else printToast_method(context_obj, "Something went wrong. Please try again");
//            }//end of onResponse method
//
//            @Override
//            public void onFailure(Call<SpecializationPOJO1> call, Throwable t) {
//                printToast_method(context_obj, "Check internet connection or Server Problem");
//            }//end of onFailure method
//        });
//        return spclzationspinneridlist_obj;
//    }//end of Specialization spinner method
//
//    public void signupToolbarShow_method(Context context, Toolbar jobseekerreg1tool_obj, String toolbarname, String regfragmentsshow) {
//        context_obj = context;
//        fragnamevisible = regfragmentsshow;
//        jobseekerreg1tool_obj.setTitle(toolbarname);
//        jobseekerreg1tool_obj.setTitleTextColor(Color.WHITE);
//        jobseekerreg1tool_obj.setNavigationIcon(R.drawable.leftarrow);
//        jobseekerreg1tool_obj.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                backPressfragtoLogin_method(context_obj, fragnamevisible);
//                ((AppCompatActivity) context_obj).finish();
//            }
//        });
//    }//end of sign up Toolbar show method
//
//    public void innerfragToolbarShow_method(Context context, Toolbar jobseekerreg1tool_obj, String toolbarname, String regfragmentsshow) {
//        context_obj = context;
//        fragnamevisible = regfragmentsshow;
//        jobseekerreg1tool_obj.setTitle(toolbarname);
//        jobseekerreg1tool_obj.setTitleTextColor(Color.WHITE);
//        jobseekerreg1tool_obj.setNavigationIcon(R.drawable.leftarrow);
//        jobseekerreg1tool_obj.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                backPressfragtoMainAct_method(context_obj, fragnamevisible);
//                ((AppCompatActivity) context_obj).finish();
//            }
//        });
//    }//end of sign up Toolbar show method
//
//    public int getIndexforSpinnerItem(String spinnerlist[], String myString) {
//        int index = 0;
//        for (int i = 0; i < spinnerlist.length; i++) {
//            if (spinnerlist[i].contains(myString)) {
//                index = i;
//            }//end of if condition
//        }//end of for loop
//        return index;
//    }//end of getIndex method
//
////    public void UpdateUserAllData_method(Context context){
////        retrofitinterfacefile= Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
////        Call<UpdatePOJO1> updateAllData=retrofitinterfacefile.updateUserdata_method(outsideTokenno);
////        updateAllData.enqueue(new Callback<UpdatePOJO1>() {
////            @Override
////            public void onResponse(Call<UpdatePOJO1> call, Response<UpdatePOJO1> response) {
////                if (response.body()!=null){
////                    if (response.body().getStatus().equals(1)){
////                        printToast_method(context_obj,response.body().getMessage());
////                    }//end of inner if condition
////                    else printToast_method(context_obj,"Already Update");
////                }//end of if condition
////                else printToast_method(context_obj,"Something went wrong. Please try again");
////            }//end of onResponse method
////            @Override
////            public void onFailure(Call<UpdatePOJO1> call, Throwable t) {
////                printToast_method(context_obj,"Check internet connection or Server Problem");
////            }//end of onFailure method
////        });
////    }//end of user All data method
//
//
//    //TOTAL PROGRESS BAR WORK
//    public ProgressDialog showProgressBar_method(Context context, ProgressDialog loginprogressbarinti) {
//        context_obj = context;
//        progressbar=loginprogressbarinti;
//        progressbar = new ProgressDialog(context_obj, android.R.style.Theme_DeviceDefault_Light_Dialog);
//        progressbar.setMessage("Please wait");
//        progressbar.setCancelable(false);
//        progressbar.setCanceledOnTouchOutside(false);
//        progressbar.setProgressStyle(ProgressDialog.STYLE_SPINNER);
//        return progressbar;
//    }//end of show ProgressBar method
//
//    public void loadWebView_method(Context activity, WebView frag_webview, ProgressDialog fragprogressbar, String webviewurl){
//        context_obj = activity;
//        progressbar=fragprogressbar;
//        progressbar = ProgressDialog.show(context_obj, "Loading","Please wait...", true);
//        progressbar.setCancelable(false);
//        frag_webview.loadUrl(webviewurl);
//        frag_webview.getSettings().setJavaScriptEnabled(true);
//        frag_webview.getSettings().setLoadsImagesAutomatically(true);
//        frag_webview.getSettings().setLoadWithOverviewMode(true);
//        frag_webview.setInitialScale(1);
//        frag_webview.getSettings().setPluginState(WebSettings.PluginState.ON);
//        frag_webview.getSettings().setJavaScriptCanOpenWindowsAutomatically(false);
//        frag_webview.getSettings().setSupportMultipleWindows(false);
//        frag_webview.getSettings().setSupportZoom(false);
//        frag_webview.getSettings().setBuiltInZoomControls(true);
//        frag_webview.getSettings().setUseWideViewPort(true);
//        frag_webview.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                progressbar.show();
//                view.loadUrl(url);
//                return true;
//            }
//            @Override
//            public void onPageFinished(WebView view, final String url) {
//                progressbar.dismiss();
//            }
//        });
//    }//end of web view method

    // Random OTP Send to MOBILE Module WORK
    public String sendDataforOTP_method(Context activity, Button otp_Submit_btn, TextView exptimetxt_otp, String otp_msg,String otp_number) {
        context_obj = activity;
        otpgetsubmitbtn = otp_Submit_btn;
        otpgetTimetext_view = exptimetxt_otp;
        number = otp_number;
        otpValue = randomOTPGenerate_method();
        if (!otpValue.equals("null"))
            message = otp_msg + "  " + otpValue;
        if ( !otpValue.equals("null"))
            sendOtpSMS(context_obj, otpgetsubmitbtn, otpgetTimetext_view, username, password,senderid,number, message );
        return otpValue;
    }//end of send data for OTP method

    public void sendOtpSMS(Context context_obj, final Button otpsubmitbtn,
                           final TextView otpTimetext_view, final String method_username, final String method_password,
                           final String method_sender, final String method_number, final String method_msg){
        otp_context=context_obj;
//        retrofitinterfacefile = Retrofitinstancefile.otp_retrofit_method().create(Retrofitinterface.class);
//        Call<ResponseBody> userProfileData=retrofitinterfacefile.otpsendintfc_method(method_username,method_password,
//                method_sender,method_number,method_msg);
//        userProfileData.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (response.body()!=null)
//                    otpTimeCountDown_method(otpsubmitbtn,otpTimetext_view);
//            }//end of onResponse method
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//            }//end of onFailure method
//        });
    }//end of send  OTP msg

    public void otpTimeCountDown_method(final Button otp_Submit_btn, final TextView otpTimetextview){
        if(exprTimeCount_obj==true){
            countDownTimer_obj.cancel();
            countDownTimer_obj.start();
        }else {
            countDownTimer_obj = new CountDownTimer(120000, 1000) {
                public void onTick(long millisUntilFinished) {
                    otp_Submit_btn.setEnabled(true);
                    exprTimeCount_obj = true;
                    otpTimetextview.setText("" + String.format("%d min : %d sec", TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished), TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished))));
                }//end of onTick method
                public void onFinish() {
                    otpTimetextview.setText("Your OTP is expired");
                    otp_Submit_btn.setEnabled(false);
                }//end of onFinish method
            }.start();
        }
    }//end of otp TIme Count method

    //Random generate password for OTP
    public static String randomOTPGenerate_method() {
        Random r = new Random();
        int numbers = 100000 + (int)(r.nextFloat() * 899900);
        return String.valueOf(numbers);
    }//end of otp gemerate method

//    public int isEmailValidApi_method(LinearLayout layout, String email){
//        snackshow_layout=layout;
//        userEmailID=email;
//        retrofitinterfacefile = Retrofitinstancefile.retrofit_method().create(Retrofitinterfacefile.class);
//        Call<ResponseBody> emailData=retrofitinterfacefile.emailValidate_method(userEmailID);
//        emailData.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (response.body()!=null) {
//                    try {
//                        JSONObject jsonObject = new JSONObject(response.body().string());
//                        if (jsonObject.getInt("status") == 1) {
//                            validEmailStatus=jsonObject.getInt("status");
//                        }//end of inner if condition
//                        else printSnackBar_method(snackshow_layout,"Email Already Exist");
//                    } catch (JSONException e) {
//                        e.printStackTrace();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }//end of outer if condition
//                else printSnackBar_method(snackshow_layout,"something went wrong to validate your Email. Try after some time");
//            }//end of onResponse method
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//                printSnackBar_method(snackshow_layout,"Check your internet connection or server problem");
//            }//end of onFailure method
//        });
//        return validEmailStatus;
//    }//end of is Email Valid API method
//


}//end of mainoptionmenu class