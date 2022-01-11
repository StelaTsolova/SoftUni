package Calculator_5;

public class MemorySaveOperation extends AbstractOperation implements Operation {
    @Override
    public void addOperand(int operand) {
        result = operand;
        RecallMemory.pushNumber(operand);
    }

    @Override
    public int getResult() {
        return result;
    }

    @Override
    public boolean isCompleted() {
        return operands.size() == 1;
    }

}
