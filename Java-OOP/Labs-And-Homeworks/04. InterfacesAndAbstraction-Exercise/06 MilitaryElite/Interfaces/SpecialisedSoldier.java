package MilitaryElite_6.Interfaces;

import MilitaryElite_6.Interfaces.Private;

public interface SpecialisedSoldier extends Private {
    public enum Corps {
        Airforces,
        Marines;
    }
    Corps getCorps();
}