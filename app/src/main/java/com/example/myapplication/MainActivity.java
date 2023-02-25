package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.datepicker.OnSelectionChangedListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editName, editPhonenum;
    Switch swGender;
    Spinner spStandard;
    SeekBar sbAge;
    CheckBox cbSport;
    RadioButton rbRock, rbPop, rbRap;
    Button btnRegister, btnCancel;
    TextView tvGender, tvStandard, tvAge;
    Boolean sport;
    int age;

    void assignId(Button btn, int id){
        btn = (Button) findViewById(id);
        btn.setOnClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] standards = new String[]{"Cao đẳng", "Đại học", "Cao học"};

        editName = (EditText) findViewById(R.id.edit_Name);
        editPhonenum = (EditText) findViewById(R.id.edit_Phonenum);
        tvStandard = findViewById(R.id.edit_Standard);
        tvGender = findViewById(R.id.tv_swgender);
        tvAge = findViewById(R.id.tv_Age);

        swGender = (Switch) findViewById(R.id.sw_gender);
        spStandard = (Spinner) findViewById(R.id.spin_Standard);
        sbAge = (SeekBar) findViewById(R.id.sb_Age);
        cbSport = (CheckBox) findViewById(R.id.cb_Sport);
        rbRock = (RadioButton) findViewById(R.id.rb_Rock_Music);
        rbPop = (RadioButton) findViewById(R.id.rb_Pop_Music);
        rbRap = (RadioButton) findViewById(R.id.rb_Rap_Music);

        cbSport.setOnClickListener(this);
        rbRock.setOnClickListener(this);
        rbRap.setOnClickListener(this);
        rbPop.setOnClickListener(this);

        assignId(btnRegister, R.id.btn_Register);
        assignId(btnCancel, R.id.btn_Cancel);

        //Switch
        swGender.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                tvGender.setText(swGender.isChecked() ? "Nữ" : "Nam");
            }}
        );

        //spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, standards);
        spStandard.setAdapter(adapter);
        spStandard.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = (String) parent.getItemAtPosition(position);
                tvStandard.setText(selectedItem);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        //seekbar
        sbAge.setProgress(15);
            sbAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                int progress = 0;
                @Override
                public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                    progress = i;
                    tvAge.setText(i + "/" + sbAge.getMax());
                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {
                    tvAge.setText(progress + "/" + seekBar.getMax());
                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {
                    tvAge.setText(progress + "/" + sbAge.getMax());
                    age = progress;
                }
            });

        //checkbox
        cbSport.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                sport = cbSport.isChecked() ? true : false;
            }
        });

    }


    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        int btnid = btn.getId();

        if(btnid == R.id.rb_Rock_Music){

        }
        if(btnid == R.id.rb_Rap_Music){

        }
        if(btnid == R.id.rb_Pop_Music){

        }
        if(btnid == R.id.btn_Register){
            String name = editName.getText().toString();
            String phone_number = editPhonenum.getText().toString();
            String standard = tvStandard.getText().toString();
            String gender = tvGender.getText().toString();
            String music = "Rock";

            String result = "user{ \n" +
                    "name=" + name + '\'' +
                    ", \n phone_number=" + phone_number + '\'' +
                    ", \n gender=" + gender +
                    ", \n academic_standard=" + standard + '\'' +
                    ", \n age= '" + age +
                    ", \n sport= '" + sport +
                    ", \n music= '" + music + '\'' +
                    '}';

            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);

            intent.putExtra("Register", result);
            startActivity(intent);
            return;
        }
        if(btnid == R.id.btn_Cancel){
            return;
            //các giá trị trở về mặc định
        }
    }

    /*@Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.getString("editname", editName.getText().toString());
        outState.getString("editphonenum", editPhonenum.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        editName.setText(savedInstanceState.getString("editname"));
        editPhonenum.setText(savedInstanceState.getString("editphonenum"));
    }*/
}