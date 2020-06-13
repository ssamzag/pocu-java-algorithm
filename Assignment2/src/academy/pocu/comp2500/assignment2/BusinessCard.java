package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class BusinessCard extends ProductOption {
    private BusinessCardType businessCardType;
    private BusinessCardSize size = BusinessCardSize.W9_H5_CM;;
    private BusinessCardSideType sideType;
    private BusinessCardColor businessCardColor;

    public BusinessCard(BusinessCardType businessCardType, BusinessCardSideType type, BusinessCardColor color, OrientationType orientation) {
        this.businessCardType = businessCardType;
        this.sideType = type;
        this.businessCardColor = color;
        super.color = color.getValue();
        super.price = getBusinessCardPrice();
        super.orientation = orientation;
    }

    public BusinessCardType getBusinessCardType() {
        return businessCardType;
    }

    public BusinessCardSize getSize() {
        return size;
    }

    public BusinessCardSideType getSideType() {
        return sideType;
    }

    public ArrayList<Aperture> getApertures() {
        return apertures;
    }

    public BusinessCardColor getBusinessCardColor() {
        return businessCardColor;
    }

    private int getBusinessCardPrice() {
        switch (businessCardType) {
            case LINEN:
                return sideType == BusinessCardSideType.SINGLE_SIDE ? 110 : 140;
            case LAID:
                return sideType == BusinessCardSideType.SINGLE_SIDE ? 120 : 150;
            case SNOW:
                return sideType == BusinessCardSideType.SINGLE_SIDE ? 100 : 130;
            default:
                assert false : "businessCardType is null";
                return -1;
        }
    }
}
