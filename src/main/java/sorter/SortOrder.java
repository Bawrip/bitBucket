package sorter;

import exception.ApplicationException;

public enum SortOrder {
    ASCENDING("Ascending", "a"),
    DESCENDING("Descending", "d");

    private String order;
    private String code;

    SortOrder(String order, String code) {
        this.order = order;
        this.code = code;
    }

    public static SortOrder getSortOrderByCode(String code) throws ApplicationException {
        if (ASCENDING.code.equals(code)) {
            return ASCENDING;
        }
        if (DESCENDING.code.equals(code)) {
            return DESCENDING;
        }

        throw new ApplicationException("Sort mode code is incorrect");
    }
}
