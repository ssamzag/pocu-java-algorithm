package academy.pocu.comp2500.assignment2;

import academy.pocu.comp2500.assignment2.registry.Interface;
import academy.pocu.comp2500.assignment2.registry.InterfaceKey;
import academy.pocu.comp2500.assignment2.registry.Registry;

public class App {
    public App(Registry registry) {
        //스탬프
        registry.registerRedStampCreator("Stamp");
        registry.registerBlueStampCreator("Stamp");
        registry.registerGreenStampCreator("Stamp");

        //달력
        registry.registerWallCalendarCreator("Calendar", "setWallCalendar");
        registry.registerMagnetCalendarCreator("Calendar", "setMagnetCalendar");
        registry.registerDeskCalendarCreator("Calendar", "setDeskCalendar");


        ///배너 출력 방향
        registry.registerLandscapeBannerCreator("Banner", "setOrientation");
        registry.registerPortraitBannerCreator("Banner", "setOrientation");

        //배너
        registry.registerGlossBannerCreator("Banner");
        registry.registerScrimBannerCreator("Banner");
        registry.registerMeshBannerCreator("Banner");

        //명함 출력 방향
        registry.registerLandscapeBusinessCardCreator("BusinessCard", "setOrientation");
        registry.registerPortraitBusinessCardCreator("BusinessCard", "setOrientation");
        //명함 종이색
        registry.registerIvoryBusinessCardCreator("BusinessCard", "setPaperColor");
        registry.registerGrayBusinessCardCreator("BusinessCard", "setPaperColor");
        registry.registerWhiteBusinessCardCreator("BusinessCard", "setPaperColor");

        //명함
        registry.registerLaidBusinessCardCreator("BusinessCard");
        registry.registerLinenBusinessCardCreator("BusinessCard");
        registry.registerSmoothBusinessCardCreator("BusinessCard");

        registry.registerSingleSidedBusinessCardCreator("BusinessCard");
        registry.registerDoubleSidedBusinessCardCreator("BusinessCard");

        //장바구니
        registry.registerCartCreator("Cart");
        registry.registerProductAdder("Cart", "addProduct");
        registry.registerProductRemover("Cart", "removeProduct");
        registry.registerTotalPriceGetter("Cart", "getTotalPrice");

        //가로세로 배너 텍스트 이미지 추가
        registry.registerLandscapeBannerTextApertureAdder("Banner", "addAperture");
        registry.registerLandscapeBannerImageApertureAdder("Banner", "addAperture");
        registry.registerPortraitBannerTextApertureAdder("Banner", "addAperture");
        registry.registerPortraitBannerImageApertureAdder("Banner", "addAperture");

        // 각배너 텍스트 이미지 추가
        registry.registerGlossBannerTextApertureAdder("Banner", "addAperture");
        registry.registerGlossBannerImageApertureAdder("Banner", "addAperture");
        registry.registerScrimBannerTextApertureAdder("Banner", "addAperture");
        registry.registerScrimBannerImageApertureAdder("Banner", "addAperture");
        registry.registerMeshBannerTextApertureAdder("Banner", "addAperture");
        registry.registerMeshBannerImageApertureAdder("Banner", "addAperture");

        // 가로새로 명함 텍스트 이미지 추가
        registry.registerLandscapeBusinnessCardTextApertureAdder("BusinessCard", "addAperture");
        registry.registerLandscapeBusinnessCardImageApertureAdder("BusinessCard", "addAperture");
        registry.registerPortraitBusinnessCardTextApertureAdder("BusinessCard", "addAperture");
        registry.registerPortraitBusinnessCardImageApertureAdder("BusinessCard", "addAperture");

        // 색상지정 명함 텍스트 이미지 추가
        registry.registerIvoryBusinnessCardTextApertureAdder("BusinessCard", "addAperture");
        registry.registerIvoryBusinnessCardImageApertureAdder("BusinessCard", "addAperture");
        registry.registerGrayBusinnessCardTextApertureAdder("BusinessCard", "addAperture");
        registry.registerGrayBusinnessCardImageApertureAdder("BusinessCard", "addAperture");
        registry.registerWhiteBusinnessCardTextApertureAdder("BusinessCard", "addAperture");
        registry.registerWhiteBusinnessCardImageApertureAdder("BusinessCard", "addAperture");

        // 각 명함에 텍스트 이미지 추가
        registry.registerLaidBusinnessCardTextApertureAdder("BusinessCard", "addAperture");
        registry.registerLaidBusinnessCardImageApertureAdder("BusinessCard", "addAperture");
        registry.registerLinenBusinnessCardTextApertureAdder("BusinessCard", "addAperture");
        registry.registerLinenBusinnessCardImageApertureAdder("BusinessCard", "addAperture");
        registry.registerSmoothBusinnessCardTextApertureAdder("BusinessCard", "addAperture");
        registry.registerSmoothBusinnessCardImageApertureAdder("BusinessCard", "addAperture");

        // 단/양면 명함에 이미지 텍스트 추가
        registry.registerSingleSidedBusinnessCardTextApertureAdder("BusinessCard", "addAperture");
        registry.registerSingleSidedBusinnessCardImageApertureAdder("BusinessCard", "addAperture");
        registry.registerDoubleSidedBusinnessCardTextApertureAdder("BusinessCard", "addAperture");
        registry.registerDoubleSidedBusinnessCardImageApertureAdder("BusinessCard", "addAperture");
    }
}
