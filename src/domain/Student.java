package domain;

import instruments.Instrument;

import java.math.BigDecimal;
import java.util.Comparator;

import static domain.Experience.NONE;

public class Student implements Comparable<Student>{
	private String name;
	private Instrument instrument;
	private BigDecimal offer;
	private Experience experience;
	
	public Student(String name, Instrument instrument) {
		super();
		this.name = name;
		this.instrument = instrument;
		this.offer = BigDecimal.ZERO;
		this.experience = NONE;
	}
	
	public Student(String name, Instrument instrument, BigDecimal offer) {
		super();
		this.name = name;
		this.instrument = instrument;
		this.offer = offer;
		this.experience = NONE;
	}
	
	public Student(String name, Instrument instrument, Experience experience) {
		super();
		this.name = name;
		this.instrument = instrument;
		this.offer = BigDecimal.ZERO;
		this.experience = NONE;
		this.experience = experience;
	}
	
	public Student(String name, Instrument instrument, BigDecimal offer, Experience experience) {
		super();
		this.name = name;
		this.instrument = instrument;
		this.offer = offer;
		this.experience = NONE;
		this.experience = experience;
	}

	public Comparator<Student> compareOffer() {
		return Comparator.comparing(o -> o.offer);
	}

	public Comparator<Student> compareExperience() {
		return Comparator.comparing(o -> o.experience);
	}

	public Comparator<Student> compareExperience2() {
		return new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.compareTo(o2);
			}
		};
	}


	public Instrument getInstrument() {
		return instrument;
	}

	public void setInstrument(Instrument instrument) {
		this.instrument = instrument;
	}

	public BigDecimal getOffer() {
		return offer;
	}

	public void setOffer(BigDecimal offer) {
		this.offer = offer;
	}

	public Experience getExperience() {
		return experience;
	}

	public void setExperience(Experience experience) {
		this.experience = experience;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", instrument=" + instrument + "]";
	}

	@Override
	public int compareTo(Student o) {
		return -Integer.compare(this.experience.ordinal(),o.experience.ordinal());
	}



}
