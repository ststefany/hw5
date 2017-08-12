package models;

public abstract class ElectricalAppliance {
    protected boolean turnedOn;
    protected int power;
    protected String name;

    protected ElectricalAppliance(String name, int power) {
        this.power = power;
        this.name = name;
        this.turnedOn = false;
    }

    public boolean isTurnedOn() {
        return this.turnedOn;
    }

    public void switchOff() {
        this.turnedOn = false;
    }

    public void switchOn() {
        this.turnedOn = true;
    }

    public final int getCurrentPower() {
        int result = 0;
        if (this.turnedOn) result = this.power;
        return result;
    }

    public int getPower() {
        return power;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ElectricalAppliance)) return false;

        ElectricalAppliance that = (ElectricalAppliance) o;

        if (getPower() != that.getPower()) return false;
        return name != null ? name.equals(that.name) : that.name == null;
    }

    @Override
    public int hashCode() {
        int result = getPower();
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name + ", power - " + power;
    }
}
