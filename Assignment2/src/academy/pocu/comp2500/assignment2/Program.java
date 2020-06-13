package academy.pocu.comp2500.assignment2;

public class Program {
    public static void main(String[] args) {

        {
            //3.1 빨강 잉크 4 x 3 cm 스탬프 만들기
            Stamp redStamp = new Stamp(StampSize.W4_H3_CM, StampColor.RED);
            assert redStamp.price == 2300 : "2300 원 아님";
            assert redStamp.color == StampColor.RED.getValue() : "RED 아님";

            //3.2 빨강 잉크 4 x 3 cm 스탬프의 배송 방법 바꾸기
            Cart cart = new Cart();
            cart.addProduct(redStamp);
            redStamp.setShipmentType(ShipmentType.PICK_UP);

            assert redStamp.shipmentType == ShipmentType.PICK_UP;
            assert cart.getProducts().get(0) == redStamp;

            //3.3 하얀색 40 x 40 cm 벽걸이 달력 만들기
            Calendar whiteCalendar = new Calendar();
            whiteCalendar.setWallCalendar();
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

        }

    }
}
