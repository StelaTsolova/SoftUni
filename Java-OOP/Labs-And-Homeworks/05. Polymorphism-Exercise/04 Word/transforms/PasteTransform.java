package Word_4.transforms;

public class PasteTransform extends LastCut implements TextTransform {
    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        text.replace(startIndex, endIndex, super.getLastCut());
    }
}
