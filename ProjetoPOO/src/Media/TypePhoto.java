
package Media;

public enum TypePhoto {
    HORIZONTAL, VERTICAL;

    @Override
    public String toString() {
        switch (this) {
             case HORIZONTAL:
                return "Type Photo: Horizontal  ";
            case VERTICAL:
                return "Type Photo: Vertical   ";
            default:
                return "indefinido";
        }
    }
}
