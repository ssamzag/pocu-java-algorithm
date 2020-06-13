package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class BusinessCard extends Print {
    private BusinessCardType businessCardType;
    private BusinessCardSize cardSize = BusinessCardSize.W9_H5_CM;;
    private BusinessCardSideType sideType;
    private ArrayList<Aperture> apertures = new ArrayList<Aperture>();

    public BusinessCard(BusinessCardType cardType, BusinessCardSize cardSize, BusinessCardSideType type, BusinessCardColor cardColor) {
        this.sideType = BusinessCardSideType.SINGLE_SIDE;
        this.businessCardType = cardType;
        this.sideType = type;
        this.cardSize = cardSize;
        super.color = cardColor.getValue();
        super.price = getBusinessCardPrice();
    }

    public void setPaperColor(BusinessCardColor color) {
        super.color = color.getValue();
    }

    public void setOrientation(OrientationType orientation) {
        this.orientation = orientation;
    }

    public void addAperture(Aperture aperture) {
        this.apertures.add(aperture);
    }

    private int getBusinessCardPrice() {
        int price;
        switch (businessCardType) {
            case LINEN:
                price = sideType == BusinessCardSideType.SINGLE_SIDE ? 110 : 140;
                break;
            case LAID:
                price = sideType == BusinessCardSideType.SINGLE_SIDE ? 120 : 150;
                break;
            case SNOW:
                price = sideType == BusinessCardSideType.SINGLE_SIDE ? 100 : 130;
                break;
            default:
                assert false : "businessCardType is null";
                price = -1;
                break;
        }

        return price;
    }
}
