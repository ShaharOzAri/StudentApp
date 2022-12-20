package com.example.studentsapp.model;

import android.media.audiofx.DynamicsProcessing;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class Model {
    private static final Model _instance = new Model();
    List<Student> data = new LinkedList<>();
     public static Model instance(){
        return _instance;
    }

//    private Model(){
//        addStudent(new Student(null,"fn","fbhvb","fbhv","bvhf",false));
//         for(int i=0;i<20;i++){
//         }
//    }
    public List<Student> getAllStudents(){
        return data;
    }

    public Student getStudent(int i){
        return data.get(i);
    }

    public void addStudent(Student st){
        data.add(st);
    }

    public void removeStudent(Student st){
        data.remove(st);
    }




}
