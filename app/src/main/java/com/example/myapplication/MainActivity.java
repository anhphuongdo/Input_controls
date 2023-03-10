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
        RadioGroup rgMusic;
        RadioButton rbRock, rbPop, rbRap;
        Button btnRegister, btnCancel;
        TextView tvGender, tvStandard, tvAge;
        Boolean sport;
        int age;
        String music = "";

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
            tvGender = findViewById(R.id.tv_gender);
            tvAge = findViewById(R.id.tv_Age);

            swGender = (Switch) findViewById(R.id.sw_gender);
            spStandard = (Spinner) findViewById(R.id.spin_Standard);
            sbAge = (SeekBar) findViewById(R.id.sb_Age);
            cbSport = (CheckBox) findViewById(R.id.cb_Sport);

            rgMusic = (RadioGroup) findViewById(R.id.rg_Music);
            rbRock = findViewById(R.id.rb_Rock_Music);
            rbPop= findViewById(R.id.rb_Pop_Music);
            rbRap= findViewById(R.id.rb_Rap_Music);

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
                int progress = 15;
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

            //radiobutton
            rbRock.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    music = "Rock";
                }
            });
            rbPop.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    music = "Pop";
                }
            });
            rbRap.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    music = "Rap";
                }
            });
        }


        @Override
        public void onClick(View v) {
            Button btn = (Button) v;
            int btnid = btn.getId();
            if(btnid == R.id.btn_Register){
                String name = editName.getText().toString();
                String phone_number = editPhonenum.getText().toString();
                String standard = tvStandard.getText().toString();
                String gender = tvGender.getText().toString();

                String result = "Người dùng { \n" +
                        "Họ tên = " + name +
                        ", \n Số điện thoại = " + phone_number +
                        ", \n Giới tính = " + gender +
                        ", \n Trình độ học vấn = " + standard +
                        ", \n Tuổi = " + age +
                        ", \n Thể thao = " + sport +
                        ", \n Thể loại âm nhạc = " + music +
                        '}';

                Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
                intent.putExtra("Register", result);
                startActivity(intent);
                return;
            }
            if(btnid == R.id.btn_Cancel){
                editName.setText("");
                editPhonenum.setText("");
                swGender.setChecked(false);
                tvStandard.setText("Cao đẳng");
                sbAge.setProgress(15);
                cbSport.setChecked(false);
                rbRock.setChecked(false);
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

