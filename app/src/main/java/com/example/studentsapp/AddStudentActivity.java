package com.example.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;

public class AddStudentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        EditText nameEt = findViewById(R.id.editStudent_name_pt);
        EditText idEt = findViewById(R.id.editStudent_id_pt);
        EditText phoneEt = findViewById(R.id.editStudent_phone_pt);
        EditText addressEt = findViewById(R.id.editStudent_address_pt);
        TextView messageTv = findViewById(R.id.addStudent_message);
        CheckBox cb = findViewById(R.id.editStudent_cb);
        Button saveBtn = findViewById(R.id.addStudent_save_btn);
        Button cancelBtn = findViewById(R.id.addStudent_cancel_btn);

        saveBtn.setOnClickListener(view -> {
            String name = nameEt.getText().toString();
            int id = Integer.parseInt(idEt.getText().toString());
            int phone = Integer.parseInt(phoneEt.getText().toString());
            String address = addressEt.getText().toString();
            Boolean checked = cb.isChecked();
            if(name.length() != 0 && id > 0 && phone > 0 && address.length() != 0){
                Model.instance().addStudent(new Student(null,id,name,phone,address,checked));
                Intent intent = new Intent(this,MainActivity.class);
                startActivity(intent);
            }else{
                messageTv.setText("Please Enter all Fields");
            }
        });

        cancelBtn.setOnClickListener(view -> finish());
    }

}