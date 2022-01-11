package Word_4.transforms;

public class CutTransform extends LastCut implements TextTransform {
    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        if (startIndex != endIndex) {
            super.setLastCut(text.substring(startIndex, endIndex));
            text.replace(startIndex, endIndex, "");
        }
    }
}
