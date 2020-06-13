package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Interface;
import academy.pocu.comp2500.assignment2.registry.InterfaceKey;
import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        //스탬프
        registry.registerRedStampCreator("Stamp", "setRedStamp");
        registry.registerBlueStampCreator("Stamp", "setBedStamp");
        registry.registerGreenStampCreator("Stamp", "setGreenStamp");

        //달력
        registry.registerWallCalendarCreator("Calendar", "setWallCalendar");
        registry.registerMagnetCalendarCreator("Calendar", "setMagnetCalendar");
        registry.registerDeskCalendarCreator("Calendar", "setDeskCalendar");


        ///배너 출력 방향
        registry.registerLandscapeBannerCreator("");
        registry.registerLandscapeBannerCreator("", "");
        registry.registerPortraitBannerCreator("");
        registry.registerPortraitBannerCreator("", "");

        //배너
        registry.registerGlossBannerCreator("");
        registry.registerGlossBannerCreator("", "");
        registry.registerScrimBannerCreator("");
        registry.registerScrimBannerCreator("", "");
        registry.registerMeshBannerCreator("");
        registry.registerMeshBannerCreator("", "");

        //명함 출력 방향
        registry.registerLandscapeBusinessCardCreator("");
        registry.registerLandscapeBusinessCardCreator("", "");
        registry.registerPortraitBusinessCardCreator("");
        registry.registerPortraitBusinessCardCreator("", "");
        //명함 종이색
        registry.registerIvoryBusinessCardCreator("");
        registry.registerIvoryBusinessCardCreator("", "");
        registry.registerGrayBusinessCardCreator("");
        registry.registerGrayBusinessCardCreator("", "");
        registry.registerWhiteBusinessCardCreator("");
        registry.registerWhiteBusinessCardCreator("", "");
        //명함
        registry.registerLaidBusinessCardCreator("");
        registry.registerLaidBusinessCardCreator("", "");
        registry.registerLinenBusinessCardCreator("");
        registry.registerLinenBusinessCardCreator("", "");
        registry.registerSmoothBusinessCardCreator("");
        registry.registerSmoothBusinessCardCreator("", "");
        registry.registerSingleSidedBusinessCardCreator("");
        registry.registerSingleSidedBusinessCardCreator("", "");
        registry.registerDoubleSidedBusinessCardCreator("");
        registry.registerDoubleSidedBusinessCardCreator("", "");

        //장바구니
        registry.registerCartCreator("Cart");
        registry.registerProductAdder("Cart", "addProduct");
        registry.registerProductRemover("Cart", "removeProduct");
        registry.registerTotalPriceGetter("", "getTotalPrice");

        //ㄱㄱㄱ
        registry.registerLandscapeBannerTextApertureAdder("", "");
        registry.registerLandscapeBannerImageApertureAdder("", "");
        registry.registerPortraitBannerTextApertureAdder("", "");
        registry.registerPortraitBannerImageApertureAdder("", "");
        registry.registerGlossBannerTextApertureAdder("", "");
        registry.registerGlossBannerImageApertureAdder("", "");
        registry.registerScrimBannerTextApertureAdder("", "");
        registry.registerScrimBannerImageApertureAdder("", "");
        registry.registerMeshBannerTextApertureAdder("", "");
        registry.registerMeshBannerImageApertureAdder("", "");
        registry.registerLandscapeBusinnessCardTextApertureAdder("", "");
        registry.registerLandscapeBusinnessCardImageApertureAdder("", "");
        registry.registerPortraitBusinnessCardTextApertureAdder("", "");
        registry.registerPortraitBusinnessCardImageApertureAdder("", "");
        registry.registerIvoryBusinnessCardTextApertureAdder("", "");
        registry.registerIvoryBusinnessCardImageApertureAdder("", "");
        registry.registerGrayBusinnessCardTextApertureAdder("", "");
        registry.registerGrayBusinnessCardImageApertureAdder("", "");
        registry.registerWhiteBusinnessCardTextApertureAdder("", "");
        registry.registerWhiteBusinnessCardImageApertureAdder("", "");
        registry.registerLaidBusinnessCardTextApertureAdder("", "");
        registry.registerLaidBusinnessCardImageApertureAdder("", "");
        registry.registerLinenBusinnessCardTextApertureAdder("", "");
        registry.registerLinenBusinnessCardImageApertureAdder("", "");
        registry.registerSmoothBusinnessCardTextApertureAdder("", "");
        registry.registerSmoothBusinnessCardImageApertureAdder("", "");
        registry.registerSingleSidedBusinnessCardTextApertureAdder("", "");
        registry.registerSingleSidedBusinnessCardImageApertureAdder("", "");
        registry.registerDoubleSidedBusinnessCardTextApertureAdder("", "");
        registry.registerDoubleSidedBusinnessCardImageApertureAdder("", "");
    }
}
