package Calculator_5;

import java.util.ArrayList;
import java.util.List;

public class MultiplicationOperation extends AbstractOperation implements Operation {
    @Override
    public void addOperand(int operand) {
        this.operands.add(operand);

        if (this.isCompleted()) {
            this.result = this.operands.get(0) * this.operands.get(1);
        }
    }

    @Override
    public int getResult() {
        return this.result;
    }

    @Override
    public boolean isCompleted() {
        return operands.size() == 2;
    }
}
