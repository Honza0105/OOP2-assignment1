package app;

import domain.*;
import instruments.*;

import java.math.BigDecimal;
import java.util.ArrayList;

public class School {
	private static ReorderingPriorityQueue<Student> waitList = new ReorderingPriorityQueue<>(new ExperienceComparator());
	private static ArrayList<Teacher<Instrument>> teacherArrayList = new ArrayList<>();
	private static Schedule schedule = new Schedule(2000);
	public static boolean addStudentToWaitList(Student student){
		return waitList.offer(student);
	}
	public static boolean addTeachersToList(Teacher<Instrument> teacher){
		return teacherArrayList.add(teacher);
	}

	public static void createSchedule(int year){
		schedule.endOfYear();
		schedule.setYear(year);
	}

	public static void addTeachersToSchedule(){
		for (Teacher<Instrument> teacher: teacherArrayList
			 ) {
			schedule.addTeacher(teacher);
		}
	}

	public static void main(String[] args) {	
		StringedInstrument piano = new StringedInstrument("Piano", 2, 164, 3);
		
		StringedInstrument classicalGuitar = new StringedInstrument("Classical Guitar", 4, 6);
		StringedInstrument steelString = new StringedInstrument("Steelstring Guitar", 4, 6);
		StringedInstrument fentrop = new ElectricalStringedInstrument("Fentrop electrical guitar", 4, 6, 60, 100);
		
		Flute garklein = new Flute("Garklein", 5, 2, 17, Note.C);
		Flute soprano = new Flute("Soprano flute", 5, 6, 32, Note.C);
		Flute tenor = new Flute("Tenor flute", 5, 12, 62, Note.C);
		Flute bass = new Flute("Bass flute", 5, 22, 93, Note.F);
		Flute contrabass = new Flute("Contrabass flute", 5, 40, 200, Note.F);

		//Students who don't offer
		Student jan = new Student("Jan", classicalGuitar, Experience.LOW);
		Student fatima = new Student("Fatima", classicalGuitar, Experience.EXTREME);
		Student imane = new Student("Imane", steelString, Experience.MEDIUM);
		Student mary = new Student("Mary", piano);
		Student lory = new Student("Lory", bass, Experience.NONE);

		//Students who offer
		Student piet = new Student("Piet", steelString,new BigDecimal("12"), Experience.HIGH);
		Student rory = new Student("Rory", bass,new BigDecimal("10"),Experience.MEDIUM);
		Student alex = new Student("Alex", contrabass, new BigDecimal("50"),Experience.LOW);
		Student erik = new Student("Erik", classicalGuitar, new BigDecimal("10"),Experience.HIGH);

		
		Teacher<Instrument> bob = new Teacher<>("Bob", 6); // Make generic
		bob.addInstrument(fentrop);
		bob.addInstrument(steelString);
		
		Teacher<Instrument> alice = new Teacher<>("Alice", 12); // Make generic
		alice.addInstrument(garklein);
		alice.addInstrument(soprano);
		alice.addInstrument(tenor);

//		jan.setExperience(Experience.EXTREME);
//		fatima.setExperience(Experience.LOW);
//		piet.setExperience(Experience.PRO);
//		imane.setExperience(Experience.MEDIUM);
//		mary.setExperience(Experience.HIGH);
		addStudentToWaitList(mary);
		addStudentToWaitList(piet);
		addStudentToWaitList(jan);
		addStudentToWaitList(fatima);
		addStudentToWaitList(imane);
		addStudentToWaitList(lory);
		addStudentToWaitList(rory);
		addStudentToWaitList(alex);
		addStudentToWaitList(erik);
//
//		System.out.println(waitList);
//		waitList.setComparator(new OfferComparator());
//		System.out.println(waitList);
////		piet.setOffer(new BigDecimal("12"));
//		System.out.println(waitList);
//		waitList.setComparator(new ExperienceComparator());
//		System.out.println(waitList);
		addTeachersToList(bob);
		addTeachersToList(alice);
		System.out.println(teacherArrayList);
		createSchedule(2023);
		System.out.println(schedule);
	}

}
