package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class BusinessCard extends Print {
    private BusinessCardType businessCardType;
    private BusinessCardSize size = BusinessCardSize.W9_H5_CM;;
    private BusinessCardSideType sideType;
    private ArrayList<Aperture> apertures = new ArrayList<Aperture>();

    public BusinessCard(BusinessCardType cardType, BusinessCardSideType type, BusinessCardColor color) {
        this.businessCardType = cardType;
        this.sideType = type;
        this.size = BusinessCardSize.W9_H5_CM;
        super.color = color.getValue();
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
