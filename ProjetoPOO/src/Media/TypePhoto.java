package Media;

/**
 * @author Andre Ribeiro n_170221006
 * @author Eugenio Silva n_170221069
 * @version 1.00 Enum com as opções para as fotografias
 *
 */
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
