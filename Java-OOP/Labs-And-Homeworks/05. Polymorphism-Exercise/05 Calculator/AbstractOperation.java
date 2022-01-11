package Calculator_5;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractOperation implements Operation {
    protected List<Integer> operands;
    protected int result;

    public AbstractOperation() {
        operands = new ArrayList<>();
    }
}
