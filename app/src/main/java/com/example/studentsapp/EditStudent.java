package com.example.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;

public class EditStudent extends AppCompatActivity {
    Student st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_student);
        Bundle b = getIntent().getExtras();
        int pos = b.getInt("pos");
        st = Model.instance().getStudent(pos);
        EditText nameEt = findViewById(R.id.editStudent_name_pt);
        EditText idEt = findViewById(R.id.editStudent_id_pt);
        EditText phoneEt = findViewById(R.id.editStudent_phone_pt);
        EditText addressEt = findViewById(R.id.editStudent_address_pt);
        CheckBox cb = findViewById(R.id.editStudent_cb);
        Button saveBtn = findViewById(R.id.editStudent_save_btn);
        Button cancelBtn = findViewById(R.id.editStudent_cancel_btn);
        Button deleteBtn = findViewById(R.id.editStudent_delete_btn);

        nameEt.setText(st.name);
        idEt.setText(String.valueOf(st.id));
        phoneEt.setText(String.valueOf(st.phone));
        addressEt.setText(st.address);
        cb.setChecked(st.cb);

        deleteBtn.setOnClickListener(view -> {
            Model.instance().removeStudent(st);
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        });

        cancelBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        });

        saveBtn.setOnClickListener(view -> {
            st.name = String.valueOf(nameEt.getText());
            st.id = Integer.parseInt(String.valueOf(idEt.getText()));
            st.phone = Integer.parseInt(String.valueOf(phoneEt.getText()));
            st.address = String.valueOf(addressEt.getText());
            st.cb = cb.isChecked();
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
        });

    }
}