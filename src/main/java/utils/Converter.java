package utils;

import exception.ApplicationException;

import java.util.ArrayList;

public class Converter {
    public ArrayList<Integer> convertFromStringToInteger(ArrayList<String> stringArray) throws ApplicationException {
        ArrayList<Integer> integerArray = new ArrayList<>(stringArray.size());

        try {
            for (String str : stringArray) {
                integerArray.add(Integer.valueOf(str));
            }
        } catch (NumberFormatException exc) {
            throw new ApplicationException("Некорректные данные в файле.");
        }

        return integerArray;
    }
}
