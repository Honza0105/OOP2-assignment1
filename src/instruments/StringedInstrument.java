package instruments;

import java.math.BigDecimal;
import java.time.LocalDate;

public class StringedInstrument extends Instrument {
	private int numberOfStrings;
	private int parallelStrings;
	private LocalDate dateLastTuned;
	
	public StringedInstrument(String name, int baseOctave, int numberOfStrings, int parallelStrings) {
		super(name, baseOctave);
		setNumberOfStrings(numberOfStrings);
		setParallelStrings(parallelStrings);
		this.dateLastTuned = LocalDate.now();
	}
	
	public StringedInstrument(String name, int baseOctave, int numberOfStrings) {
		this(name, baseOctave, numberOfStrings, 1);
	}

	public int getNumberOfStrings() {
		return numberOfStrings;
	}

	public void setNumberOfStrings(int numberOfStrings) {
		if (numberOfStrings < 3) {
			throw new IllegalArgumentException("Number of strings cannot be less than 3.");
		}
		this.numberOfStrings = numberOfStrings;
	}

	public int getParallelStrings() {
		return parallelStrings;
	}

	public void setParallelStrings(int parallelStrings) {
		if (parallelStrings < 1) {
			throw new IllegalArgumentException("Number of parallel strings cannot be negative.");
		}
		this.parallelStrings = parallelStrings;
	}
	
	public LocalDate getDateLastTuned() {
		return dateLastTuned;
	}

	public void setDateLastTuned(LocalDate dateLastTuned) {
		if (this.dateLastTuned.isAfter(dateLastTuned)) {
			throw new IllegalArgumentException("You cannot anti-date the date the instrument was last tuned. Last date was " + this.dateLastTuned + ", you tried changing that to " + dateLastTuned);
		}
		if (this.dateLastTuned.isAfter(LocalDate.now())) {
			throw new IllegalArgumentException("You cannot set the date last tuned in the future.");
		}
		this.dateLastTuned = dateLastTuned;
	}

	public BigDecimal tune(LocalDate date) {
		if (numberOfStrings <= 12) {
			return BigDecimal.ZERO;
		}
		BigDecimal factor = BigDecimal.ONE;
		BigDecimal price = new BigDecimal("85.0");
		if (numberOfStrings > 96) {
			factor = new BigDecimal((double) parallelStrings / 3d);
		}
		if (parallelStrings >= 3) {
			factor = factor.multiply(new BigDecimal((double) numberOfStrings / 144d));
		}
		if (LocalDate.now().getYear() - dateLastTuned.getYear() > 1) {
			factor = factor.multiply(new BigDecimal("2.0"));
		}
		price = price.multiply(factor);
		return price;
	}

	@Override
	public String toString() {
		return "StringedInstrument [numberOfStrings=" + numberOfStrings + ", getName()=" + getName()
				+ ", getBaseOctave()=" + getBaseOctave() + "]";
	}
	
	@Override
	public int getDifficulty() {
		return numberOfStrings / parallelStrings;
	}
}
