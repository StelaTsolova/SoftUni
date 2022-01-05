package MilitaryElite_6.Classes;

import MilitaryElite_6.Classes.SoldierImpl;
import MilitaryElite_6.Interfaces.Spy;

public class SpyImpl extends SoldierImpl implements Spy {
    private String codeNumber;

    public SpyImpl(int id, String firstName, String lastName, String codeNumber) {
        super(id, firstName, lastName);
        this.codeNumber = codeNumber;
    }

    @Override
    public String gatCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d%nCode Number: %s",
                super.getFirstName(), super.getLastName(), super.getId(), this.codeNumber);
    }
}