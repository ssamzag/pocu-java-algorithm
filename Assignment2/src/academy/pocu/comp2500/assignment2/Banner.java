package academy.pocu.comp2500.assignment2;

import java.util.ArrayList;

public class Banner extends Product {
    private BannerType type;
    private BannerSize size;
    private Orientation bannerOrientation;

    protected static final int ADD_COST = 5;

    private ArrayList<Position> words = new ArrayList<>();
    private ArrayList<Position> pictures = new ArrayList<>();

    public Banner() {
        this.bannerOrientation = Orientation.LANDSCAPE;
    }

    public void setGlossBanner(BannerSize size, int color, Orientation orientation) {
        this.type = BannerType.GLOSS;
        this.size = size;
        setColor(color);
        this.bannerOrientation = orientation;
    }

    public void setScrimBanner(BannerSize size, int color, Orientation orientation) {
        this.type = BannerType.SCRIM;
        this.size = size;
        setColor(color);
        this.bannerOrientation = orientation;
    }

    public void setMeshBanner(BannerSize size, int color, Orientation orientation) {
        this.type = BannerType.MESH;
        this.size = size;
        setColor(color);
        this.bannerOrientation = orientation;
    }

    public void addWord(Position position) {
        this.words.add(position);
    }

    public void addPicture(Position position) {
        this.pictures.add(position);
    }

    protected void setColor(int color) {
        assert color >= 0 && color <= 0xFFFFFF : "Invalid RGB Color!!";
        super.color = color;
    }

    private boolean isValid() {
        return type != null && size != null;
    }

    public int getPrice() {
        return getBannerSizePrice() + pictures.size() * ADD_COST + words.size() * ADD_COST;
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
                    assert (false);
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
                    assert (false);
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
                    assert (false);
            }
        }
        return -1;
    }
}
