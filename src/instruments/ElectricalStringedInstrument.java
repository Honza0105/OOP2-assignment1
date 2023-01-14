package instruments;

public class ElectricalStringedInstrument extends StringedInstrument {
	private int power;
	private int maxVolume;
	
	public ElectricalStringedInstrument(String name, int baseOctave, int numberOfStrings, int power, int maxVolume) {
		super(name, baseOctave, numberOfStrings);
		setPower(power);
		setMaxVolume(maxVolume);
	}
	public int getPower() {
		return power;
	}
	public void setPower(int power) {
		if (power <= 0) {
			throw new IllegalArgumentException("Power consumption cannot be negative.");
		}
		if (power < 10) {
			throw new IllegalArgumentException("With a power of less than 10W this hardly is an electrical instrument.");
		}
		if (power > 3300 ) {
			throw new IllegalArgumentException("This instrument will blow the fuse!");
		}
		this.power = power;
	}
	public int getMaxVolume() {
		if (maxVolume < 20) {
			throw new IllegalArgumentException("This volume is so low it cannot be used for music. Please select a value of at least 20 dB.");
		}
		if (maxVolume > 120) {
			throw new IllegalArgumentException("This volume will cause permanent hearing damage. Please select a value of at most 120 dB.");
		}
		return maxVolume;
	}
	public void setMaxVolume(int maxVolume) {
		this.maxVolume = maxVolume;
	}
	@Override
	public String toString() {
		return "ElectricalStringedInstrument [power=" + power + ", maxVolume=" + maxVolume + ", getNumberOfStrings()="
				+ getNumberOfStrings() + ", getName()=" + getName() + ", getBaseOctave()=" + getBaseOctave() + "]";
	}
	
	@Override
	public int getDifficulty() {
		return super.getDifficulty() + 1;
	}
}
