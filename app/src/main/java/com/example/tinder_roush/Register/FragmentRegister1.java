package com.example.tinder_roush.Register;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.Gravity;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.Locale;

public class FragmentRegister1 extends Fragment implements RegisterInterfaces.fragment1{

    Button next1;
    EditText name, lastname, username, email, password, confirm_password;
    LinearLayout layout_date_calendar;
    Register1Data register1Data;
    SpinnerCustom spinnerCities, spinnerGender;
    Context context;
    RegisterPresenters presenter;
    String date_select, city;
    EditText date_birth;

    public FragmentRegister1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View view = inflater.inflate(R.layout.fragment_register_1, container, false);
            context = view.getContext();
            initObjets(view);
            listeners();
            addSpinnerBefore();
            presenter.citiesPresenter();

            return view;
        }

        public void initObjets(View view){
            next1 = view.findViewById(R.id.next_r1_button);
            name = view.findViewById(R.id.name_field);
            lastname = view.findViewById(R.id.lastname_field);
            date_birth = view.findViewById(R.id.date_birth_field);
            username = view.findViewById(R.id.nickname_field);
            email = view.findViewById(R.id.email_register);
            password = view.findViewById(R.id.password_register);
            spinnerCities = view.findViewById(R.id.spinner_city_register);
            layout_date_calendar = view.findViewById(R.id.layout_date_calendar);
            confirm_password = view.findViewById(R.id.confirm_password_register);
            date_select = "";
            presenter = new RegisterPresenters(this);
            city = "";
        }

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
                    performSecondRegister();
                }
            });
            layout_date_calendar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    date_birth.setError(null);
                    calendario();
                }
            });
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
                    calendar_button.setText("Nací el "+dayOfMonth+" del mes "+(month+1)+" del "+year);
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

        public void addItemsSpinnerCity(List<KeyPairBoolDataCustom> cities){
            spinnerCities.setSearchEnabled(true);
            spinnerCities.setSearchHint("Seleccione un origen");
            spinnerCities.setItems(cities, new SpinnerListener() {
                @Override
                public void onItemsSelected(KeyPairBoolDataCustom selectedItem) {
                    city=selectedItem.getId();
                }
                @Override
                public void onClear() {

                }
            });
        }

    @Override
    public void register1() {

    }

    public void performSecondRegister(){
            FragmentRegister2 Register2 = new FragmentRegister2();
            FragmentTransaction transaction = getFragmentManager().beginTransaction();
            transaction.replace(R.id.login_view, Register2);
            transaction.commit();
        }
}