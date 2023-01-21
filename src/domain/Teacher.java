package domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import instruments.Instrument;
import util.NotYetImplementedException;

public class Teacher<T extends Instrument> {
	private String name;
	private int maxStudents;
	private Set<T> instruments;
	
	public Teacher(String name, int maxStudents) {
		super();
		this.name = name;
		this.maxStudents = maxStudents;
		this.instruments = new HashSet<>();
	}

	@Override
	public String toString() {
		return "Teacher{" +
				"name='" + name + '\'' +
				", maxStudents=" + maxStudents +

				'}';
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMaxStudents() {
		return maxStudents;
	}

	public void setMaxStudents(int maxStudents) {
		this.maxStudents = maxStudents;
	}

	public Set<T> getInstruments() {
		return instruments;
	}

	public boolean addInstrument(T instrument) {
		return instruments.add(instrument);
	}
	
	public boolean removeInstrument(T instrument) {
		return instruments.remove(instrument);
	}
	
	public boolean teaches(T instrument) {
		for (T in: instruments) {
			if (in.equals(instrument)) {
				return true;
			}
		}
		return false;
	}
	
	public BigDecimal getHourlyWage() {
		throw new NotYetImplementedException();
	}
}
