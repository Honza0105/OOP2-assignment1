package instruments;

public class WindInstrument extends Instrument {
	private int neededAirFlow;

	public WindInstrument(String name, int baseOactave, int neededAirFlow) {
		super(name, baseOactave);
		setNeededAirFlow(neededAirFlow);
	}

	public int getNeededAirFlow() {
		return neededAirFlow;
	}

	public void setNeededAirFlow(int neededAirFlow) {
		if (neededAirFlow < 2) {
			throw new IllegalArgumentException("Needed air flow cannot be less that 2 liters per minute.");
		}
		this.neededAirFlow = neededAirFlow;
	}

	@Override
	public String toString() {
		return "WindInstrument [neededAirFlow=" + neededAirFlow + ", getName()=" + getName() + ", getBaseOctave()="
				+ getBaseOctave() + "]";
	}
	
	@Override
	public int getDifficulty() {
		return 5;
	}
}
