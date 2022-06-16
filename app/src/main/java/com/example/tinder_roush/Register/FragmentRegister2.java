package com.example.tinder_roush.Register;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.tinder_roush.Objects.Register1Data;
import com.example.tinder_roush.Objects.Register2Data;
import com.example.tinder_roush.R;
import com.example.tinder_roush.Utils.BaseContext;
import com.example.tinder_roush.databinding.FragmentRegister1Binding;
import com.example.tinder_roush.databinding.FragmentRegister2Binding;

import java.util.ArrayList;

public class FragmentRegister2 extends Fragment implements RegisterInterfaces.fragment2 {

    Button back_to_r1, next_r3;
    EditText job, description;
    Spinner spinnerLookingFor;
    ArrayList<String> search_list;
    Context context;
    RegisterPresenters presenter;
    Register2Data register2Data;
    String search_select;
    public FragmentRegister2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register_2, container, false);
        context = view.getContext();
        initObjets(view);

        search_list.add("MAN");
        search_list.add("WOMAN");
        search_list.add("BOTH");
        search_list.add("OTHER");
        ArrayAdapter<String> searchArrayAdapter = new ArrayAdapter<>(getContext(), R.layout.spinner_custom_textview_gender, search_list);
        searchArrayAdapter.setDropDownViewResource(R.layout.spinner_custom_textview_gender);
        spinnerLookingFor.setAdapter(searchArrayAdapter);

        listener();
        return view;
    }

    private void initObjets(View view) {
        back_to_r1 = view.findViewById(R.id.back_r2_button);
        next_r3 = view.findViewById(R.id.next_r2_button);
        job = view.findViewById(R.id.your_job);
        description = view.findViewById(R.id.describe_you_field);
        spinnerLookingFor = view.findViewById(R.id.spinner_looking_for_register);
        presenter=new RegisterPresenters(null, this, null, null);
        search_list = new ArrayList<>();
        search_select = "";
    }

    public void listener(){
        back_to_r1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performRegister1();
            }
        });
        next_r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (job.getText().toString().isEmpty()){
                    job.setError(BaseContext.getContext().getString(R.string.message_empty_field));
                    job.requestFocus();
                    return;
                }if (description.getText().toString().isEmpty()){
                    description.setError(BaseContext.getContext().getString(R.string.message_empty_field));
                    description.requestFocus();
                    return;
                }
                register2();
              //  performRegister3();
            }
        });
        spinnerLookingFor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                search_select = spinnerLookingFor.getSelectedItem().toString();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public void performRegister1(){
        FragmentRegister1 Register1 = new FragmentRegister1();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.login_view, Register1);
        transaction.commit();
    }

    public void performRegister3(){
        FragmentRegister3 Register3 = new FragmentRegister3();
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.login_view, Register3);
        transaction.commit();
    }

    @Override
    public void register2() {
        register2Data = new Register2Data(job.getText().toString(),description.getText().toString(),search_select);
        presenter.register2Presenters(register2Data);
    }
}