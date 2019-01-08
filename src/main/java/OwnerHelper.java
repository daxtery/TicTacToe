/**
 * OwnerHelper
 */
public final class OwnerHelper {

    public static String GetText(OwnerType ownerType) {
        switch (ownerType) {
        case X:
            return "X";
        case O:
            return "O";
        default:
            return " ";
        }
    }

    private OwnerHelper() {

    }

}