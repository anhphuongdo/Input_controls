package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editName, editPhonenum, editStandard;
    Switch swGender;
    Spinner spStandard;
    SeekBar sbAge;
    CheckBox cbSport;
    RadioButton rbRock, rbPop, rbRap;
    Button btnRegister, btnCancel;

    void assignId(Button btn, int id){
        btn = (Button) findViewById(id);
        btn.setOnClickListener(this);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignId(btnRegister, R.id.btn_Register);
        assignId(btnCancel, R.id.btn_Cancel);
    }

    @Override
    public void onClick(View v) {
        Button btn = (Button) v;
        int btnid = btn.getId();
        if(btnid == R.id.btn_Register){
            Intent intent = new Intent(getApplicationContext(), RegisterActivity.class);
            //sửa lại value là các giá trị của đối tượng
            intent.putExtra("Register", "abc");
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