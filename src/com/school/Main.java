package com.school;

import java.security.NoSuchAlgorithmException;

public class Main {

    public static void main(String[] args) throws NoSuchAlgorithmException {
	    Teacher ron = new Teacher("Ron", "Masters", 22, true);
	    Teacher Chris = new Teacher("Chris", "James", 40, false);
	    Student Rab = new Student("Rabbo", "Campbello", 25);
	    Admin Jack = new Admin("Wacko", "Jacko", 18);
		Rab.setPassword();
		System.out.println(Rab.checkPass());
		System.out.println(SchoolMember.getNumberOfSchoolMembers());
		System.out.println(Admin.getAdminNumbers());
    }
}
