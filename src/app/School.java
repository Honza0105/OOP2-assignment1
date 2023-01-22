package app;

import domain.*;
import instruments.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;

public class School {
//	private static ReorderingPriorityQueue<Student> waitList = new ReorderingPriorityQueue<>(new ExperienceComparator());
	private static ArrayList<Student> students = new ArrayList<>();
	private static ArrayList<Teacher<Instrument>> teachers = new ArrayList<>();
	public static void addStudentToWaitList(Student student){
		students.add(student);
	}
	public static void addTeachersToList(Teacher<Instrument> teacher){
		teachers.add(teacher);
	}

	public static Schedule createSchedule(int year){
		Schedule schedule = new Schedule(year);
		for (Student student: students
			 ) {
			schedule.addToList(student);
		}
		addTeachersToSchedule(schedule);
		System.out.println();
		schedule.matching();

		return schedule;
	}

	public static Schedule createSchedule(int year, Comparator<Student> studentComparator){
		Schedule schedule = new Schedule(year, studentComparator);
		for (Student student: students
		) {
			schedule.addToList(student);
		}
		addTeachersToSchedule(schedule);
		System.out.println();
		schedule.matching();

		return schedule;
	}

	public static void addTeachersToSchedule(Schedule schedule){
		for (Teacher<Instrument> teacher: teachers
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
		Student mary = new Student("Mary", classicalGuitar);
		Student lory = new Student("Lory", bass, Experience.LOW);

		//Students who offer
		Student piet = new Student("Piet", steelString,new BigDecimal("12"), Experience.HIGH);
		Student rory = new Student("Rory", bass,new BigDecimal("10"),Experience.NONE);
		Student alex = new Student("Alex", garklein, new BigDecimal("50"),Experience.LOW);
		Student erik = new Student("Erik", classicalGuitar, new BigDecimal("10"),Experience.HIGH);

		
		Teacher<Instrument> bob = new Teacher<>("Bob", 6); // Make generic
		bob.addInstrument(fentrop);
		bob.addInstrument(steelString);
		bob.addInstrument(classicalGuitar);
		
		Teacher<Instrument> alice = new Teacher<>("Alice", 12); // Make generic
		alice.addInstrument(garklein);
		alice.addInstrument(soprano);
		alice.addInstrument(tenor);

		Teacher<Instrument> frank = new Teacher<>("Frank", 1);
		frank.addInstrument(bass);


		addStudentToWaitList(mary);
		addStudentToWaitList(piet);
		addStudentToWaitList(jan);
		addStudentToWaitList(fatima);
		addStudentToWaitList(imane);
		addStudentToWaitList(lory);
		addStudentToWaitList(rory);
		addStudentToWaitList(alex);
		addStudentToWaitList(erik);
		addTeachersToList(bob);
		addTeachersToList(alice);
		addTeachersToList(frank);
		System.out.println(teachers);
		Schedule schedule = createSchedule(2023);
		System.out.println(schedule);
		System.out.println(createSchedule(2023,new OfferComparator()));


	}

}
