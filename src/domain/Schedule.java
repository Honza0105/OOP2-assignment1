package domain;

import instruments.Instrument;

import java.math.BigDecimal;
import java.util.*;


public class Schedule {
	private static BigDecimal basePrice = new BigDecimal("10.0");
	private int year;
	private ReorderingPriorityQueue<Student> waitList;
	private Map<Teacher<Instrument>, Set<Student>> students;

	public Schedule(int year) {
		this.year = year;
		this.waitList = new ReorderingPriorityQueue<>(new ExperienceComparator());
		this.students = new HashMap<>();
	}


	@Override
	public String toString() {
		return "Schedule{" +
				"year=" + year +
				", waitList=" + waitList +
				", students=" + students +
				'}';
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
		waitList.offer(student);
	}
	
	public void withdrawFromList(Student student) { // Implement
		waitList.remove(student);
	}

	public boolean addStudent(Teacher<Instrument> teacher, Student student) {
		Set<Student> studentSet = students.get(teacher);
		if (studentSet==null){
			studentSet = new HashSet<>();
		}

		if (studentSet.size()<teacher.getMaxStudents() && teacher.teaches(student.getInstrument())) {
			studentSet.add(student);
			this.students.put(teacher, studentSet);
			return true;
		}
		return false;
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
	public void changeComparator(Comparator<Student> studentComparator){
		waitList.setComparator(studentComparator);
	}

	public void matching(){
		for (Student student: new HashSet<>(waitList)
			 ) {
			inner:
			for (Teacher teacher: students.keySet()
				 ) {
				if (addStudent(teacher,student)){
					withdrawFromList(student);
					break inner;
				}
			}
		}
	}
}
