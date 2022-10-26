/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.io.Serializable;


/**
 *
 * @author PC
 */
public class Student implements Serializable{
    private String studentId;
    private String studentName;
    int code;

    public Student() {
    }

    public Student(String studentId, String studentName, int code) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.code = code;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return studentId+","+studentName+","+code;
    }

    
    
}
