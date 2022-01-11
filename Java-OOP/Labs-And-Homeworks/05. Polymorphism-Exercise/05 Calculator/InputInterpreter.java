package Calculator_5;

public class InputInterpreter {
    private CalculationEngine engine;
    private RecallMemory memory;

    public InputInterpreter(CalculationEngine engine) {
        this.engine = engine;
        this.memory = new RecallMemory();
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        } catch (Exception ex) {
            if (this.getOperation(input) != null) {
                engine.pushOperation(this.getOperation(input));
            }
        }
        return true;
    }

    public Operation getOperation(String operation) {
        if (operation.equals("*")) {
            return new MultiplicationOperation();
        } else if (operation.equals("/")) {
            return new DivisionOperation();
        } else if (operation.equals("ms")) {
            return new MemorySaveOperation();
        } else if (operation.equals("mr")) {
            return new RecallMemoryOperation();
        }

        return null;
    }
}
