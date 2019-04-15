package sorter;

import exception.ApplicationException;

public enum ContentFileType {
    STRING_TYPE("String", "s"),
    INTEGER_TYPE("Integer", "i");

    private String type;
    private String code;

    ContentFileType(String type, String code) {
        this.type = type;
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public static ContentFileType getTypeByCode(String code) throws ApplicationException {
        if (STRING_TYPE.code.equals(code)) {
            return STRING_TYPE;
        }
        if (INTEGER_TYPE.code.equals(code)) {
            return INTEGER_TYPE;
        }
        throw new ApplicationException("Invalid content type in file: " + code);
    }
}
