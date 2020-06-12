package academy.pocu.comp2500.assignment2;

import java.util.HashMap;
import java.util.Map;

public class Banner extends Product {
    private Map<String, Position> Words = new HashMap<String, Position>();
    private PrintLayout printLayout;

    public Banner(PrintSize size) {
        super(size);
    }

    public int gerPrice(EBanner.BannerType type, EBanner.Size size) {
        if (type == EBanner.BannerType.GLASS) {
            switch (size) {
                case SIZE_1X1_M:
                    return 5000;
                case SIZE_3X1_M:
                    return 5200;
                case SIZE_1X05_M:
                    return 5300;
                case SIZE_2X05_M:
                    return 6000;
                default:
                    assert (false);
            }
        } else if (type == EBanner.BannerType.SCRIM) {
            switch (size) {
                case SIZE_1X1_M:
                    return 5100;
                case SIZE_3X1_M:
                    return 5300;
                case SIZE_1X05_M:
                    return 5400;
                case SIZE_2X05_M:
                    return 6100;
                default:
                    assert (false);
            }
        } else if (type == EBanner.BannerType.MESH) {
            switch (size) {
                case SIZE_1X1_M:
                    return 5100;
                case SIZE_3X1_M:
                    return 5300;
                case SIZE_1X05_M:
                    return 5400;
                case SIZE_2X05_M:
                    return 6100;
                default:
                    assert (false);
            }
        }
        return -1;
    }
}
