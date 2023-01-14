package domain;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import instruments.Instrument;

public class Schedule {
	private static BigDecimal basePrice = new BigDecimal("10.0");
	private int year;
	private Queue<Student> waitList;
	private Map<Teacher,Student> students;

	public Schedule(int year) {
		this.year = year;
		this.waitList = new ConcurrentLinkedQueue<>();
		this.students = new HashMap<>();
	}

	public static BigDecimal getBasePrice() {
		return basePrice;
	}

	public static void setBasePrice(BigDecimal basePrice) {
		Schedule.basePrice = basePrice;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public void addToList(Student student) {
		waitList.add(student);
	}
	
	public void withdrawFromList(Student student) { // Implement
		waitList.remove(student);
	}

	public void addStudent(Teacher<Instrument> teacher, Student student) { // Make generic and implement
		this.students.put(teacher,student);
	}
	
	public void addTeacher(Teacher<Instrument> teacher) { // Make generic and implement
		this.students.put(teacher, null);
	}
	
	public void removeTeacher(Teacher<Instrument> teacher) { // Make generic and implement
		this.students.remove(teacher);
	}
	
	public void endOfYear() { // Implement
		this.students.clear();
	}
}
