package Calculator_5;

public class RecallMemoryOperation extends AbstractOperation implements Operation {
    @Override
    public void addOperand(int operand) {

    }

    @Override
    public int getResult() {
        return RecallMemory.popNumber();
    }

    @Override
    public boolean isCompleted() {
        return true;
    }

}
