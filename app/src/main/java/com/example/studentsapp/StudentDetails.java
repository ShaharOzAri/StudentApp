package com.example.studentsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.studentsapp.model.Model;
import com.example.studentsapp.model.Student;

import java.util.List;

public class StudentDetails extends AppCompatActivity {
    Student st;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_details);
        Bundle b = getIntent().getExtras();
        int pos = b.getInt("pos");
        st = Model.instance().getStudent(pos);
        TextView nameTv = findViewById(R.id.StudentDetails_name_tv);
        TextView idTv = findViewById(R.id.StudentDetails_id_tv);
        TextView phoneTv = findViewById(R.id.StudentDetails_phone_tv);
        TextView addressTv = findViewById(R.id.StudentDetails_address_tv);
        CheckBox cb = findViewById(R.id.StudentDetails_cb);
        Button editBtn = findViewById(R.id.StudentDetails_edit_btn);

        nameTv.setText(st.name);
        idTv.setText(String.valueOf(st.id));
        phoneTv.setText(String.valueOf(st.phone));
        addressTv.setText(st.address);
        cb.setChecked(st.cb);

        editBtn.setOnClickListener(view -> {
            Intent intent = new Intent(this,EditStudent.class);
            intent.putExtra("pos",pos);
            startActivity(intent);
        });

    }
}