package Word_4;

import Word_4.transforms.CutTransform;
import Word_4.transforms.PasteTransform;
import Word_4.transforms.TextTransform;
import Word_4.transforms.ToUpperTransform;

import java.util.HashMap;
import java.util.Map;

public class CommandImpl implements CommandInterface {
    private Map<String, TextTransform> commandTransforms;
    private StringBuilder text;

    public CommandImpl(StringBuilder text) {
        this.commandTransforms = new HashMap<>();
        this.text = text;
    }

    @Override
    public void init() {
        this.commandTransforms.put("uppercase", new ToUpperTransform());
        this.commandTransforms.put("cut", new CutTransform());
        this.commandTransforms.put("paste", new PasteTransform());
    }

    @Override
    public void handleInput(String input) {
        String[] tokens = input.split("\\s+");

        String commandName = tokens[0];
        int startInd = Integer.parseInt(tokens[1]);
        int endInd = Integer.parseInt(tokens[2]);

        this.commandTransforms.get(commandName).invokeOn(this.text, startInd, endInd);
    }
}
