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

    public SortOrder getSortOrderByCode(String code) throws ApplicationException {
        if (code.equals(ASCENDING.code)) {
            return ASCENDING;
        }
        if (code.equals(DESCENDING.code)) {
            return DESCENDING;
        }

        throw new ApplicationException("Sort mode code is incorrect");
    }
}
