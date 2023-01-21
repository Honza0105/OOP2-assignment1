package app;

import domain.*;
import instruments.*;

import java.math.BigDecimal;

public class School {
	private static void studentToWaitlist(Student student){

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

		ReorderingPriorityQueue<Student> waitList = new ReorderingPriorityQueue<>(new ExperienceComparator());
		jan.setExperience(Experience.EXTREME);
		fatima.setExperience(Experience.LOW);
		piet.setExperience(Experience.PRO);
		imane.setExperience(Experience.MEDIUM);
		mary.setExperience(Experience.HIGH);
		waitList.offer(mary);
		waitList.offer(imane);
		waitList.offer(jan);
		waitList.offer(fatima);
		waitList.offer(piet);
		System.out.println(waitList);
		waitList.setComparator(new OfferComparator());
		System.out.println(waitList);
		piet.setOffer(new BigDecimal("12"));
		System.out.println(waitList);
		waitList.setComparator(new ExperienceComparator());
		System.out.println(waitList);
	}

}
