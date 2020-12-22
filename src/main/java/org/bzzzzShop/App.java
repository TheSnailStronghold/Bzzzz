package org.bzzzzShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
        System.out.println("Hi, Zhenya. Hi, everyone. We are testing .gitignore! [2]");
    }

}


//
//import java.math.BigDecimal;
//import java.util.AbstractMap;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.stream.Collectors;
//import java.util.stream.Stream;
//
//public class App {
//    public static void main(String[] args) {
//        /*Тестовая шляпа для проверки работы*/
//
//
//        ComponentsOfTheBeehive roof = new RoofOfTheBeehive(
//                "1321",
//                "Крыша ППУ Нижегородец на 6 рамок",
//                new BigDecimal(600.99).setScale(2, BigDecimal.ROUND_FLOOR),
//                new String[][]{
//                        {"Описание",
//                                "Крышка ППУ цельнолитая, окрашенная," +
//                                        "в комплекте: вентиляционная сетка - 4 шт, заглушка для улья - 4 шт."},
//                        {"ВАЖНО",
//                                "Вся представленная на сайте информация," +
//                                        "касающаяся технических характеристик, наличия на складе, стоимости товаров," +
//                                        "внешнего вида (фотографии товара) , цвета носит ознакомительный характер."}
//                },
//                300,
//                520, 446, 100, Unit.MM,
//                1400
//        );
//
//        ComponentsOfTheBeehive bottom = new BottomOfTheBeehive(
//                "2000",
//                "Дно с сеткой ППУ (пенополиуретан)",
//                new BigDecimal(905),
//                new String[][]{
//                        {"Описание",
//                                "Дно с сеткой ППУ цельнолитое, окрашенное, в комплекте: летковый \n" +
//                                        "заградитель - 1 шт,заглушка для улья - 2 шт, задвижка из поликарбоната - 1 шт."},
//                        {"ВАЖНО",
//                                "Вся представленная на сайте информация," +
//                                        "касающаяся технических характеристик, наличия на складе, стоимости товаров," +
//                                        "внешнего вида (фотографии товара) , цвета носит ознакомительный характер."}
//                },
//                300,
//                540, 446, 110, Unit.MM,
//                1700
//        );
//        ComponentsOfTheBeehive body = new BodyOfTheBeehive(
//                "20012",
//                "Корпус 300 мм ППУ (пенополиуретан)",
//                new BigDecimal(1_066),
//                new String[][]{
//                        {"Описание",
//                                "Корпус 300 мм ППУ цельнолитой, окрашенный, с двумя заглушками в комплекте."},
//                        {"ВАЖНО",
//                                "Вся представленная на сайте информация," +
//                                        "касающаяся технических характеристик, наличия на складе, стоимости товаров," +
//                                        "внешнего вида (фотографии товара) , цвета носит ознакомительный характер."}
//                },
//                300,
//                520, 446, 320, Unit.MM,
//                2300
//        );
//        ComponentsOfTheBeehive feeder = new FeederOfTheBeehive(
//                "20024",
//                "Корпус 300 мм ППУ (пенополиуретан)",
//                new BigDecimal(675),
//                new String[][]{
//                        {"Описание",
//                                "Кормушка ППУ цельнолитая, окрашенная, с двумя сетками в комплекте."},
//                        {"ВАЖНО",
//                                "Вся представленная на сайте информация," +
//                                        "касающаяся технических характеристик, наличия на складе, стоимости товаров," +
//                                        "внешнего вида (фотографии товара) , цвета носит ознакомительный характер."}
//                },
//                300,
//                520, 446, 100, Unit.MM,
//                1600
//        );
//        ComponentsOfTheBeehive storage = new StorageOfTheBeehive(
//                "20024",
//                "Магазин 145 мм ППУ (пенополиуретан)",
//                new BigDecimal(699),
//                new String[][]{
//                        {"Описание",
//                                "Магазин 145 мм для ППУ улья цельнолитой, окрашенный."},
//                        {"ВАЖНО",
//                                "Вся представленная на сайте информация," +
//                                        "касающаяся технических характеристик, наличия на складе, стоимости товаров," +
//                                        "внешнего вида (фотографии товара) , цвета носит ознакомительный характер."}
//                },
//                300,
//                520, 446, 165, Unit.MM,
//                1300
//        );
//        List<Goods> goods = new LinkedList<>(); // Все товары
//        List<ComponentsOfTheBeehive> components = new LinkedList<>(); // все компоненты для улья
//
//        components.add(roof);
//        components.add(bottom);
//        components.add(body);
//        components.add(feeder);
//        components.add(storage);
//
//        goods.add(new Beehive(
//                        "1125",
//                        "УЛЕЙ ППУ НИЖЕГОРОДЕЦ КОМПЛЕКТ 12 РАМОК 2 КОРПУСА ДАДАН+ 2 МАГАЗИНА",
//                        new BigDecimal(6_010),
//                        new String[][]{
//                                {"Описание",
//                                        "Улей ППУ Нижегородец Комплект 12 рамок 2 корпуса Дадан+ 2 Магазина\n" +
//                                                "Комплект дадан двухкорпусный с двумя магазинами (Нижегородец)\n" +
//                                                "бла бла бла\n"}
//                        },
//                        100,
//                        Stream.of(
//                                new AbstractMap.SimpleEntry<>(roof, 1),
//                                new AbstractMap.SimpleEntry<>(bottom, 1),
//                                new AbstractMap.SimpleEntry<>(storage, 2),
//                                new AbstractMap.SimpleEntry<>(body, 2))
//                                .collect(Collectors.toList())
//                )
//        );
//        goods.addAll(components);
//        goods.forEach(e ->
//                System.out.println(
//                        e.toString() +
//                                "-----------------------------------------------------"
//                )
//        );
//        MaskOfTheBeekeeper maskOfTheBeekeeper = new MaskOfTheBeekeeper("233",
//                "Сетка лицевая Европейского образца",
//                new BigDecimal(400),
//                new String[][]{
//                        {"Описание",
//                                "Сетка лицевая Европейского образца ораньжевая\n" +
//                                        "с широкими полями и круговой сеткой из плотной\n" +
//                                        "красочной ткани\n"}
//                }
//                , 50, "XL", "bb", "ткань");
//        System.out.println(maskOfTheBeekeeper + "\n________________________________________");
//        /*!-Тестовая шляпа для проверки работы*/
//
//
//
//        /* проверка адреса */
//        Address myAddress = new Address("Россия", "Тверь",
//                                "Садовый переулок", "35", "304");
//        Address yourAddress = new Address("Россия", "Тверь",
//                "Колодкина", "8");
//
//        System.out.println(
//                         myAddress.toString() + "\n"
//                        + yourAddress.toString() + "\n" +
//                        "-----------------------------------------------------"
//        );
//
//        Customer chel = new Customer(
//                "Jhon",
//                "6-6-6",
//                "bubble@gmail.com",
//                "root",
//                null);
//
//        System.out.println(chel);
//        //проверка корзины
//        goods.add(roof);
//        Basket bask = new Basket();
//        goods.forEach(el -> bask.addGood(el));
//        System.out.println(bask);
//        goods.forEach((el)-> {
//            bask.deleteGood(el);
//            System.out.println(bask);
//        });
//
//    }
//}
