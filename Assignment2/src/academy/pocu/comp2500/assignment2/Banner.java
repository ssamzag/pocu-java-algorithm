package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Banner extends ProductOption {
    private BannerType type;
    private BannerSize size;

    public Banner(BannerType type, BannerSize size, int color, OrientationType orientation) {
        super.orientation = OrientationType.LANDSCAPE;
        this.type = type;
        this.size = size;
        super.color = color;
        this.orientation = orientation;
        super.price = getBannerPrice();
    }

    private void setCustomColor(int color) {
        assert color >= 0 && color <= 0xFFFFFF : "Invalid RGB Color!!";
        super.color = color;
    }

    private boolean isValid() {
        return type != null && size != null;
    }

    private int getBannerPrice() {
        return super.apertures.size() * ADD_COST + getBannerSizePrice();
    }

    private int getBannerSizePrice() {
        if (type == BannerType.GLOSS) {
            switch (size) {
                case W100_H50_CM:
                    return 5000;
                case W200_H50_CM:
                    return 5200;
                case W100_H100_CM:
                    return 5300;
                case W300_H100_CM:
                    return 6000;
                default:
                    assert (false) : "No Gloss Size";
            }
        } else if (type == BannerType.SCRIM) {
            switch (size) {
                case W100_H50_CM:
                    return 5100;
                case W100_H100_CM:
                    return 5300;
                case W200_H50_CM:
                    return 5400;
                case W300_H100_CM:
                    return 6100;
                default:
                    assert (false) : "No Scrim Size";
            }
        } else if (type == BannerType.MESH) {
            switch (size) {
                case W100_H50_CM:
                    return 5100;
                case W100_H100_CM:
                    return 5300;
                case W200_H50_CM:
                    return 5400;
                case W300_H100_CM:
                    return 6100;
                default:
                    assert (false) : "No Mesh Size";
            }
        }
        return -1;
    }
}