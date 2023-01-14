package instruments;

public class Flute extends WindInstrument {
	private Note baseNote;
	private int length;

	public Flute(String name, int baseOactave, int neededAirFlow, int length, Note baseNote) {
		super(name, baseOactave, neededAirFlow);
		this.baseNote = baseNote;
		setLength(length);
	}

	public Note getBaseNote() {
		return baseNote;
	}

	public void setBaseNote(Note baseNote) {
		this.baseNote = baseNote;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		if (length < 10) {
			throw new IllegalArgumentException("We do not work with flutes less than 10 cm long.");
		}
		if (length > 200) {
			throw new IllegalArgumentException("It's more than two meters. That's not a flute anymore.");
		}
		this.length = length;
	}

	@Override
	public String toString() {
		return "Flute [baseNote=" + baseNote + ", length=" + length + ", getName()=" + getName() + ", getBaseOctave()="
				+ getBaseOctave() + "]";
	}
	
	@Override
	public int getDifficulty() {
		return (length / 100 )+ 1;
	}
}
