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

	private int level;
	
	public Student(String name, Instrument instrument) {
		super();
		this.name = name;
		this.instrument = instrument;
		this.offer = BigDecimal.ZERO;
		this.experience = NONE;
		this.level = this.experience.getLevel();
	}
	
	public Student(String name, Instrument instrument, BigDecimal offer) {
		super();
		this.name = name;
		this.instrument = instrument;
		this.offer = offer;
		this.experience = NONE;
		this.level = this.experience.getLevel();
	}

	public String getName() {
		return name;
	}

	public Student(String name, Instrument instrument, Experience experience) {
		super();
		this.name = name;
		this.instrument = instrument;
		this.offer = BigDecimal.ZERO;
		this.experience = experience;
		this.level = this.experience.getLevel();
	}
	
	public Student(String name, Instrument instrument, BigDecimal offer, Experience experience) {
		super();
		this.name = name;
		this.instrument = instrument;
		this.offer = offer;
		this.experience = experience;
	}

	public Comparator<Student> compareOffer() {
		return Comparator.comparing(o -> o.offer);
	}

	public Comparator<Student> compareExperience() {
		return Comparator.comparing(o -> o.experience);
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
		this.level = experience.getLevel();
	}

	@Override
	public String toString() {
		return
				"{name='" + name + '\'' +
				", experience=" + experience.ordinal() +
				'}';
	}


	@Override
	public int compareTo(Student o) {
		return o.experience.ordinal() - this.experience.ordinal();
	}

	public int getLevel() {
		return level;
	}

}
