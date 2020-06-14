package academy.pocu.comp2500.assignment2;

public class BusinessCard extends ProductOption {
    private PaperMaterialType paperMaterial;
    private BusinessCardSize size = BusinessCardSize.W9_H5_CM;;
    private CardSidesType cardSides;
    private BusinessCardColor paperColor;

    public BusinessCard(PaperMaterialType paperMaterial, CardSidesType cardSides, BusinessCardColor paperColor, OrientationType orientation) {
        this.paperMaterial = paperMaterial;
        this.cardSides = cardSides;
        this.paperColor = paperColor;
        super.color = paperColor.getValue();
        super.price = getBusinessCardPrice();
        super.orientation = orientation;
        super.width = this.size.getValue().width;
        super.height = this.size.getValue().height;
    }

    public PaperMaterialType getBusinessCardType() {
        return paperMaterial;
    }

    public BusinessCardSize getSize() {
        return size;
    }

    public CardSidesType getCardSides() {
        return cardSides;
    }

    public BusinessCardColor getPaperColor() {
        return paperColor;
    }

    private int getBusinessCardPrice() {
        switch (paperMaterial) {
            case LINEN:
                return cardSides == CardSidesType.SINGLE_SIDE ? 110 : cardSides == CardSidesType.DOUBLE_SIDE ? 140 : 0;
            case LAID:
                return cardSides == CardSidesType.SINGLE_SIDE ? 120 : cardSides == CardSidesType.DOUBLE_SIDE ? 150 : 0;
            case SNOW:
                return cardSides == CardSidesType.SINGLE_SIDE ? 100 : cardSides == CardSidesType.DOUBLE_SIDE ? 130 : 0;
            default:
                assert false : "cardSides is null";
                return 0;
        }
    }
}
