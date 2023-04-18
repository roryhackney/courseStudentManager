/**
 * Helper methods
 */
public class Utility {
    /**
     * No instantiating, use static methods
     */
    private Utility() {}

    /**
     * Verifies item is not null or blank and throws appropriate exception message
     * @param context  context for the item, used as a label, usually the variable name
     * @param item  the item to be checked
     */
    public static void verifyNotNullOrBlank(String context, String item) {
        if (item == null) {
            throw new IllegalArgumentException(context + " cannot be null");
        }
        if (item.isBlank()) {
            throw new IllegalArgumentException(context + " cannot be blank");
        }
    }

    public static void verifyIndexInRange(String context, int index, int maxIndex) {
        if (index < 0 || index > maxIndex) {
            throw new IllegalArgumentException(context + " must be 0 through " + maxIndex);
        }
    }
}
