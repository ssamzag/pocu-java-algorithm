package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Registry;

public class Program {
    public static void main(String[] args) {
        Registry registry = new Registry();
        App app = new App(registry);
        registry.validate();
        {
            //3.1 빨강 잉크 4 x 3 cm 스탬프 만들기
            Stamp redStamp = new Stamp(StampSize.W4_H3_CM, StampColor.RED, "히히");
            assert redStamp.price == 2300 : "2300 원 아님";
            assert redStamp.color == StampColor.RED.getValue() : "RED 아님";

            //3.2 빨강 잉크 4 x 3 cm 스탬프의 배송 방법 바꾸기
            Cart cart = new Cart();
            cart.addProduct(redStamp);
            redStamp.setShipmentType(ShipmentType.PICK_UP);

            assert redStamp.shipmentType == ShipmentType.PICK_UP;
            assert cart.getProducts().get(0) == redStamp;

            //3.3 하얀색 40 x 40 cm 벽걸이 달력 만들기
            Calendar whiteCalendar = new Calendar(CalendarType.WALL);

            assert whiteCalendar.price == 1000;
            assert whiteCalendar.getSize() == CalendarSize.W40_H40_CM;
            assert whiteCalendar.color == 0xFFFFFF;

            //3.4 하얀색 40 x 40 cm 벽걸이 달력의 배송 방법 바꾸기
            cart.addProduct(whiteCalendar);
            whiteCalendar.setShipmentType(ShipmentType.SHIP);

            assert cart.getProducts().get(1) == whiteCalendar : "같은 달력이니";
            assert whiteCalendar.shipmentType == ShipmentType.SHIP;
            assert cart.getTotalPrice() == 3300 : cart.getTotalPrice();

            // 3.5 1 x 0.5 m 반사 배너 만들기
            Banner glossBanner = new Banner(BannerType.GLOSS, BannerSize.W100_H50_CM, 0x34FF22, OrientationType.PORTRAIT);
            TextAperture textAperture1 = new TextAperture(10,20, "안녕???");
            TextAperture textAperture2 = new TextAperture(20,20, "흠냠");
            ImageAperture imageAperture1 = new ImageAperture(2,3, "../img/gg.jpg");
            glossBanner.addAperture(textAperture1);
            glossBanner.addAperture(textAperture2);
            glossBanner.addAperture(imageAperture1);

            assert glossBanner.getType() == BannerType.GLOSS;
            assert glossBanner.getSize() == BannerSize.W100_H50_CM;
            assert glossBanner.color == 0x34FF22;
            assert glossBanner.orientation == OrientationType.PORTRAIT;
            assert glossBanner.getApertures().get(0) == textAperture1;
            assert glossBanner.getApertures().get(1) == textAperture2;
            assert glossBanner.getApertures().get(2) == imageAperture1;
            assert glossBanner.price == 5015 : glossBanner.price;




        }

    }
}
