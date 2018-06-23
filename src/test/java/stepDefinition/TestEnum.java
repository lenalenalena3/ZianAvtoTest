package stepDefinition;

public class TestEnum {
    //основные значения фильтра
    public enum CommonEnum {
        ACTION,
        REALITY,
        SELECTROOM,
        SELECTBEDROOM,
        PRISEFIRST,
        PRISELAST,
        SELECTVALUTA,
        SELECTAREA,
        CITY
    }

    //выбор количества комнат
    public enum RoomEnum {
        ROOM0,
        ROOM1,
        ROOM2,
        ROOM3,
        ROOM4,
        ROOM5,
        ROOM6
    }

    //количество спален
    public enum BedRoomEnum {
        COUNTBEDROOM
    }

    //валюта
    public enum CurrencyEnum {
        CURRENCY,
        AREACURRENCY
    }

    //площадь
    public enum AreaEnum {
        AREAFIRST,
        AREALAST
    }

    private static String[] ar_action = {"Купить", "Снять", "Посуточно"};
    private static String[] ar_reality1 = {"Квартира", "Квартира во вторичке", "Квартира в новостройке", "Комната", "Доля", "Дом", "Часть дома", "Танхаус", "Участок",
            "Офис", "Торговая площадь", "Склад", "ПСН", "Общепит", "Гараж", "Производство", "Автосервис", "Готовый бизнес", "Здание", "Бытовые услуги"};
    private static String[] ar_reality2 = {"Квартира", "Комната", "Дом", "Койко-место", "Часть дома", "Таунхаус",
            "Офис", "Торговая площадь", "Склад", "ПСН", "Общепит", "Гараж", "Производство", "Автосервис", "Готовый бизнес", "Здание", "Бытовые услуги", "Коммерческая земля"};
    private static String[] ar_reality3 = {"Квартира", "Комната", "Койко - место", "Дом"};
    private static String[] ar_countbedroom = {"Не важно", "от 1", "от 2", "от 3", "от 4", "от 5", "от 6"};
    private static String[] ar_currency = {"рубли", "доллары", "евро"};
    private static String[] ar_currency0 = {"за все", "за м2", "месяц"};

    public static String[] get_ar_action() {
        return ar_action;
    }

    public static String[] get_ar_reality1() {
        return ar_reality1;
    }

    public static String[] get_ar_reality2() {
        return ar_reality2;
    }

    public static String[] get_ar_reality3() {
        return ar_reality3;
    }

    public static String[] get_ar_countbedroom() {
        return ar_countbedroom;
    }

    public static String[] get_ar_currency() {
        return ar_currency;
    }

    public static String[] get_ar_currency0() {
        return ar_currency0;
    }
}
