package com.example.tinder_roush.Register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.tinder_roush.LocalData.LocalData;
import com.example.tinder_roush.Login.LoginActivities;
import com.example.tinder_roush.Objects.Register1Data;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;
import com.example.tinder_roush.Utils.KeyPairBoolDataCustom;
import com.example.tinder_roush.Utils.SpinnerCustom;
import com.example.tinder_roush.Utils.SpinnerListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class FragmentRegister1 extends Fragment implements RegisterInterfaces.fragment1{

    Button next1;
    ImageButton back_to_login;
    EditText name, lastname, username, email, password, confirm_password;
    LinearLayout layout_date_calendar;
    Register1Data register1Data;
   // UserData userData;
    SpinnerCustom spinnerCities;
    Spinner spinnerGender;
    ArrayList<String> gender_list;
    Context context;
    RegisterPresenters presenter;
    String date_select, city, gender_select;
    TextView date_birth;
    LocalData localData;

    public FragmentRegister1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_register_1, container, false);
            context = view.getContext();
            initObjets(view);

            //Add gender List
            gender_list.add(0,"??C??mo te identificas?");
            gender_list.add("Hombre");
            gender_list.add("Mujer");
            gender_list.add("Trans");
            gender_list.add("No binario");
            gender_list.add("Otr@");
            ArrayAdapter<String> genderArrayAdapter = new ArrayAdapter<>(getContext(), R.layout.spinner_custom_textview_gender, gender_list);
            genderArrayAdapter.setDropDownViewResource(R.layout.spinner_custom_textview_gender);
            spinnerGender.setAdapter(genderArrayAdapter);

            addSpinnerBefore();
            listeners();
            presenter.citiesPresenter();

            return view;
        }

        public void initObjets(View view){
            next1 = view.findViewById(R.id.next_r1_button);
            back_to_login = view.findViewById(R.id.back_to_login);
            name = view.findViewById(R.id.name_field);
            lastname = view.findViewById(R.id.lastname_field);
            date_birth = view.findViewById(R.id.date_birth_field);
            username = view.findViewById(R.id.nickname_field);
            email = view.findViewById(R.id.email_register);
            password = view.findViewById(R.id.password_register);
            spinnerGender = view.findViewById(R.id.spinner_identity_register);
            spinnerCities = view.findViewById(R.id.spinner_city_register);
            layout_date_calendar = view.findViewById(R.id.layout_date_calendar);
            confirm_password = view.findViewById(R.id.confirm_password_register);
            date_select = "";
            localData = new LocalData();
            presenter=new RegisterPresenters(this, null, null, null);
            city = "";
            gender_list = new ArrayList<>();
            gender_select = "";
        }

        //Listeners objets
        public void listeners(){
            next1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (name.getText().toString().isEmpty()){
                        name.setError(BaseContext.getContext().getString(R.string.message_empty_field));
                        name.requestFocus();
                        return;
                    }
                    if (lastname.getText().toString().isEmpty()){
                        lastname.setError(BaseContext.getContext().getString(R.string.message_empty_field));
                        lastname.requestFocus();
                        return;
                    }
                    if (date_birth.getText().toString().isEmpty()){
                        date_birth.setError(BaseContext.getContext().getString(R.string.message_empty_field));
                        date_birth.requestFocus();
                        return;
                    }
                    if (spinnerCities.getSelectedIdsCustom().isEmpty()){
                        Toast.makeText(BaseContext.getContext(), R.string.message_empty_field_city, Toast.LENGTH_SHORT).show();
                        spinnerCities.requestFocus();
                        return;
                    }
                    if (gender_select.isEmpty()){
                        Toast.makeText(BaseContext.getContext(), R.string.message_empty_field, Toast.LENGTH_SHORT).show();
                        spinnerGender.requestFocus();
                        return;
                    }
                    if (username.getText().toString().isEmpty()){
                        username.setError(BaseContext.getContext().getString(R.string.message_empty_field));
                        username.requestFocus();
                        return;
                    }
                    if (email.getText().toString().isEmpty()){
                        email.setError(BaseContext.getContext().getString(R.string.message_empty_field));
                        email.requestFocus();
                        return;
                    }
                    if (!validarEmail(email.getText().toString())){
                        email.setError("Email no v??lido");
                        return;
                    }
                    if (date_birth.getText().toString().isEmpty()){
                        date_birth.setError(BaseContext.getContext().getString(R.string.message_empty_field));
                        date_birth.requestFocus();
                        return;
                    }
                    if (password.getText().toString().isEmpty()){
                        password.setError(BaseContext.getContext().getString(R.string.message_empty_field));
                        password.requestFocus();
                        return;
                    }
                    if (confirm_password.getText().toString().isEmpty()){
                        confirm_password.setError(BaseContext.getContext().getString(R.string.message_empty_field));
                        confirm_password.requestFocus();
                        return;
                    }
                    if (!password.getText().toString().equals(confirm_password.getText().toString())){
                        Toast.makeText(getContext(), R.string.password_dont_match, Toast.LENGTH_SHORT).show();
                        confirm_password.requestFocus();
                        return;
                    }
                  //  performSecondRegister();
                    register1();
                }
            });
            back_to_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    performBackToLogin();
                }
            });
            layout_date_calendar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    date_birth.setError(null);
                    calendario();
                }
            });
            spinnerGender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                    gender_select = spinnerGender.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> adapterView) {

                }
            });

            spinnerCities.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                    city = spinnerCities.getSelectedItem().toString();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });
        }


        //Methods
        private void performBackToLogin() {
            Intent intent = new Intent(context, LoginActivities.class);
            startActivity(intent);
        }

        public void calendario(){
                Button calendar_button;
                LayoutInflater inflater = (LayoutInflater)getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                LinearLayout ll= (LinearLayout)inflater.inflate(R.layout.dialog_calendar, null, false);

                CalendarView cv = (CalendarView) ll.getChildAt(0);
                calendar_button = ll.findViewById(R.id.calendar_button);
                SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
                String datenow = new String("yyyy-MM-dd");
                calendar_button.setText(datenow);
                date_select = datenow;
                long milliseconds = 0;
                try {
                    Date d = dateFormat.parse(datenow);
                    milliseconds = d.getTime();
                }catch (ParseException e){
                    e.printStackTrace();
                }
                cv.setMinDate(milliseconds);
                cv.setShowWeekNumber(true);
                cv.setSelectedWeekBackgroundColor(getResources().getColor(R.color.red));
                cv.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                        String day="";
                        String month1="";
                        // TODO Auto-generated method stub
                        if (dayOfMonth<10){
                            day = ("0"+String.valueOf(dayOfMonth));
                        }else {
                            day = String.valueOf(dayOfMonth);
                        }
                        if (month+1<10){
                            month1 = ("0"+String.valueOf(month+1));
                        }else {
                            month1 = String.valueOf(month+1);
                        }
                        date_select =String.valueOf(year)+"-"+(month1)+"-"+day;
                        calendar_button.setText("Nac?? el "+dayOfMonth+" del mes "+(month+1)+" del "+year);
                    }
                });
                AlertDialog dialog = new AlertDialog.Builder(getContext()).setView(ll).show();
                calendar_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        date_birth.setText(date_select);
                        dialog.dismiss();
                    }
                });
                WindowManager.LayoutParams wmlp = dialog.getWindow().getAttributes();
                wmlp.gravity = Gravity.BOTTOM | Gravity.BOTTOM;
                dialog.getWindow().setAttributes(wmlp);
            }

        private boolean validarEmail(String email) {
            Pattern pattern = Patterns.EMAIL_ADDRESS;
            return pattern.matcher(email).matches();
        }

        public void addSpinnerBefore(){
            List<KeyPairBoolDataCustom> listArray1 = new ArrayList<>();
            KeyPairBoolDataCustom h = new KeyPairBoolDataCustom();
            h.setId("0");
            h.setExtra("--");
            h.setName("cargando");
            h.setSelected(false);
            listArray1.add(h);
            addItemsSpinnerCity(listArray1);
        }

        //Spinner Ciudades
        public void addItemsSpinnerCity(List<KeyPairBoolDataCustom> cities){

            spinnerCities.setSearchEnabled(true);
            spinnerCities.setSearchHint("Selecciona tu ciudad");
            spinnerCities.setItems(cities, new SpinnerListener() {
                @Override
                public void onItemsSelected(KeyPairBoolDataCustom selectedItem) {
                    city=selectedItem.getId();
                    localData.register(city,"CITY_ID");
                    String city_sel_nom = selectedItem.getName();
                    localData.register(city_sel_nom,"CITY_SELECT");
                }
                @Override
                public void onClear() {

                }
            });
        }

        @Override
        public void register1() {
            register1Data = new Register1Data(name.getText().toString(),lastname.getText().toString(),username.getText().toString(),date_birth.getText().toString(),city,gender_select,email.getText().toString(),password.getText().toString());
            presenter.register1Presenters(register1Data);
        }

        public void performSecondRegister(){
                FragmentRegister2 Register2 = new FragmentRegister2();
                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.login_view, Register2);
                transaction.commit();
            }
}