package app;

import domain.Experience;
import domain.ReorderingPriorityQueue;
import domain.Student;
import domain.Teacher;
import instruments.*;

public class School {

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
		
		Student jan = new Student("Jan", classicalGuitar);
		Student piet = new Student("Piet", steelString);
		Student fatima = new Student("Fatima", classicalGuitar);
		Student imane = new Student("Imane", steelString);
		Student mary = new Student("Mary", piano);
		
		Teacher<Instrument> bob = new Teacher<>("Bob", 6); // Make generic
		bob.addInstrument(fentrop);
		bob.addInstrument(steelString);
		
		Teacher<Instrument> alice = new Teacher<>("Alice", 12); // Make generic
		alice.addInstrument(garklein);
		alice.addInstrument(soprano);
		alice.addInstrument(tenor);

		ReorderingPriorityQueue<Student> waitList = new ReorderingPriorityQueue<>(jan.compareExperience2());
		jan.setExperience(Experience.HIGH);
		fatima.setExperience(Experience.EXTREME);
		piet.setExperience(Experience.LOW);
		imane.setExperience(Experience.MEDIUM);
		waitList.add(imane);
		waitList.add(jan);
		waitList.add(piet);
		waitList.add(fatima);
		System.out.println(fatima.compareTo(jan));
	    //No the order is still wrong I need to work on that, Idk
		System.out.println(waitList);
//		waitList.setComparator(jan.compareOffer());
//		System.out.println(waitList);
	}
}
