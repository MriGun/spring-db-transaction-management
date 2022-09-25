package com.mri.transactional.proxy;

public class Student implements DailySession{

    private Attendence attendence;

    public Student() {

    }

    public Student(Attendence attendence) {
        this.attendence = attendence;
    }

    @Override
    public void attendClass() {
        System.out.println("attending the class");
    }

    public void attendClass(Integer id) {
        System.out.println("Student with id " + id + " attending the class");
    }

    public Attendence getAttendence() {
        return attendence;
    }

    public void setAttendence(Attendence attendence) {
        this.attendence = attendence;
    }
}
