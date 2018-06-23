package stepDefinition;


import java.util.HashMap;

public class TestValidator {
    private HashMap<String, String> parse;

    public TestValidator(HashMap<String, String> parse) {
        this.parse = parse;
    }

    //проверка значения первого поля в фильтре поиска (выбор действия)
    private boolean val_Action() {
        Boolean bool = false;
        for (String x : TestEnum.get_ar_action()) {
            if (parse.get(TestEnum.CommonEnum.ACTION.toString()).equals(x)) {
                bool = true;
            }
        }
        if (!bool) {
            System.err.println("Ошибка! Неверно заполнен файл: значение для ACTION");
        }
        return bool;
    }

    //проверка значения второго поля в фильтре поиска (выбор недвижимости)
    private boolean val_Reality() {
        Boolean bool = false;
        if (parse.get(TestEnum.CommonEnum.ACTION.toString()).equals(TestEnum.get_ar_action()[0])) {
            for (String x : TestEnum.get_ar_reality1()) {
                if (parse.get(TestEnum.CommonEnum.REALITY.toString()).equals(x)) {
                    bool = true;
                }
            }
        } else if (parse.get(TestEnum.CommonEnum.ACTION.toString()).equals(TestEnum.get_ar_action()[1])) {
            for (String x : TestEnum.get_ar_reality2()) {
                if (parse.get(TestEnum.CommonEnum.REALITY.toString()).equals(x)) {
                    bool = true;
                }
            }
        } else if (parse.get(TestEnum.CommonEnum.ACTION.toString()).equals(TestEnum.get_ar_action()[2])) {
            for (String x : TestEnum.get_ar_reality3()) {
                if (parse.get(TestEnum.CommonEnum.REALITY.toString()).equals(x)) {
                    bool = true;
                }
            }
        }
        if (!bool) {
            System.err.println("Ошибка! Неверно заполнен файл: значение для REALITY не корректно либо не совместимо со значением ACTION");
        }
        return bool;
    }

    //проверка значений количества комнат при видимости
    private boolean val_Room() {
        Boolean bool = false;
        if ((parse.get(TestEnum.CommonEnum.REALITY.toString()).equals(TestEnum.get_ar_reality1()[0]) ||
                parse.get(TestEnum.CommonEnum.REALITY.toString()).equals(TestEnum.get_ar_reality1()[1]) ||
                parse.get(TestEnum.CommonEnum.REALITY.toString()).equals(TestEnum.get_ar_reality1()[2])) &&
                (parse.get(TestEnum.CommonEnum.SELECTROOM.toString()).equals("true"))) {
            if (TestValidator.yes_no(parse.get(TestEnum.RoomEnum.ROOM0.toString())) &&
                    TestValidator.yes_no(parse.get(TestEnum.RoomEnum.ROOM1.toString())) &&
                    TestValidator.yes_no(parse.get(TestEnum.RoomEnum.ROOM2.toString())) &&
                    TestValidator.yes_no(parse.get(TestEnum.RoomEnum.ROOM3.toString())) &&
                    TestValidator.yes_no(parse.get(TestEnum.RoomEnum.ROOM4.toString())) &&
                    TestValidator.yes_no(parse.get(TestEnum.RoomEnum.ROOM5.toString())) &&
                    TestValidator.yes_no(parse.get(TestEnum.RoomEnum.ROOM6.toString()))) {
                bool = true;
            } else System.out.println("Ошибка! Неверно заполнен файл: значения ROOM0-6");
        } else if (parse.get(TestEnum.CommonEnum.SELECTROOM.toString()).equals("false")) {
            bool = true;
        } else
            System.err.println("Ошибка! Неверно заполнен файл: значение для SELECTROOM некорректно либо не совместимо со значением REALITY");
        return bool;
    }

    //проверка значений количества спален при видимости
    private boolean val_BedRoom() {
        Boolean bool = false;
        if (parse.get(TestEnum.CommonEnum.ACTION.toString()).equals(TestEnum.get_ar_action()[2]) &&
                parse.get(TestEnum.CommonEnum.REALITY.toString()).equals(TestEnum.get_ar_reality3()[3]) &&
                parse.get(TestEnum.CommonEnum.SELECTBEDROOM.toString()).equals("true")) {
            for (String x : TestEnum.get_ar_countbedroom()) {
                if (parse.get(TestEnum.BedRoomEnum.COUNTBEDROOM.toString()).equals(x)) {
                    bool = true;
                }
            }
        } else if (parse.get(TestEnum.CommonEnum.SELECTBEDROOM.toString()).equals("false")) {
            bool = true;
        } else
            System.err.println("Ошибка! Неверно заполнен файл: значения для SELECTBEDROOM некорректно либо не совместимо со значениями ACTION и REALITY");
        return bool;
    }

    //проверка значений цены
    private boolean val_Prise() {
        Boolean bool = false;
        String str1 = parse.get(TestEnum.CommonEnum.PRISEFIRST.toString());
        String str2 = parse.get(TestEnum.CommonEnum.PRISELAST.toString());
        if (null_int(str1) && null_int(str2)) {
            bool = true;
        } else System.err.println("Ошибка! Неверно заполнен файл: значения для PRISEFIRST или PRISELAST некорректно");
        return bool;
    }

    private boolean val_Area() {
        Boolean bool = false;
        String str1 = parse.get(TestEnum.AreaEnum.AREAFIRST.toString());
        String str2 = parse.get(TestEnum.AreaEnum.AREALAST.toString());
        if ((parse.get(TestEnum.CommonEnum.REALITY.toString()).equals(TestEnum.get_ar_reality1()[8]) ||
                parse.get(TestEnum.CommonEnum.REALITY.toString()).equals(TestEnum.get_ar_reality2()[17])) &&
                parse.get(TestEnum.CommonEnum.SELECTAREA.toString()).equals("true") &&
                null_int(str1) && null_int(str2)) {
            bool = true;
        } else if (parse.get(TestEnum.CommonEnum.SELECTAREA.toString()).equals("false")) {
            bool = true;
        } else {
            System.err.println("Ошибка! Неверно заполнен файл: значения для AREAFIRST или AREALAST некорректно");
        }
        return bool;
    }

    private boolean val_Valuta() {
        Boolean bool = false;
        Boolean bool1 = false;
        Boolean bool2 = false;
        if (parse.get(TestEnum.CommonEnum.SELECTVALUTA.toString()).equals("true")) {
            for (String x : TestEnum.get_ar_currency()) {
                if (parse.get(TestEnum.CurrencyEnum.CURRENCY.toString()).equals(x)) {
                    bool1 = true;
                }
            }
            for (String x : TestEnum.get_ar_currency0()) {
                if (parse.get(TestEnum.CurrencyEnum.AREACURRENCY.toString()).equals(x)) {
                    bool2 = true;
                }
            }
            if (bool1 && bool2) {
                bool = true;
            } else
                System.err.println("Ошибка! Неверно заполнен файл: значения для CURRENCY или AREACURRENCY некорректно");
        } else if (parse.get(TestEnum.CommonEnum.SELECTVALUTA.toString()).equals("false")) {
            bool = true;
        } else {
            System.err.println("Ошибка! Неверно заполнен файл: значения для SELECTVALUTA некорректно");
        }
        return bool;
    }

    private static boolean null_int(String str) {
        Boolean bool = false;
        if (str == null || str.matches("\\d+\\.?\\d")) {
            bool = true;
        }
        return bool;
    }

    private static boolean yes_no(String str) {
        Boolean bool = false;
        if (str.equals("true") || str.equals("false")) {
            bool = true;
        }
        return bool;
    }

    public boolean validator() {
        Boolean result = false;
        Boolean q = val_Action();
        Boolean qq = val_Reality();
        Boolean qqq = val_Room();
        Boolean qqqq = val_BedRoom();
        Boolean qqqqq = val_Prise();
        Boolean qqqqqq = val_Area();
        Boolean w = val_Valuta();
        if (q && qq && qqq && qqqq && qqqqq && qqqqqq) {
            result = true;
        }
        //else throw new Exception("Файл заполнен неверно!");

        System.out.println("Итого " + q + " " + qq + " " + qqq + " " + qqqq + " " + qqqqq + " " + qqqqqq + " " + w);
        return result;
    }


}