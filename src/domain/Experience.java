package domain;

public enum Experience { NONE(0), LOW(1), MEDIUM(2), HIGH(3), PRO(4), EXTREME(5);
    private final int level;
    Experience(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
