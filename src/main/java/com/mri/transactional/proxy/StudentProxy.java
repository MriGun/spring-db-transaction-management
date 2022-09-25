package com.mri.transactional.proxy;

public class StudentProxy extends Student{

    public StudentProxy(Attendence attendence) {
        super(attendence);
    }

    @Override
    public void attendClass() {
        if (super.getAttendence().isPresent()) {
            super.attendClass();
        }
        else {
            throw new RuntimeException("Student is not present and can't attend the class");
        }

    }
}
