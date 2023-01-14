package instruments;

import java.util.Objects;

public abstract class Instrument {
	private String name;
	private int baseOctave;
	
	public Instrument(String name, int baseOctave) {
		super();
		setName(name);
		setBaseOctave(baseOctave);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if ((name == null) || (name.length() < 3)) {
			throw new IllegalArgumentException("Name must have a length of at least three characters");
		}
		this.name = name;
	}

	public int getBaseOctave() {
		return baseOctave;
	}

	public void setBaseOctave(int baseOctave) {
		if (baseOctave < 1) {
			throw new IllegalArgumentException("Base octave cannot be less than 1");
		}
		if (baseOctave > 6) {
			throw new IllegalArgumentException("Base octave cannot be more than 6");
		}
		this.baseOctave = baseOctave;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Instrument other = (Instrument) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Instrument [name=" + name + ", baseOctave=" + baseOctave + "]";
	}
	
	public abstract int getDifficulty();
}
