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
        registry.registerWallCalendarCreator("Calendar");
        registry.registerMagnetCalendarCreator("Calendar");
        registry.registerDeskCalendarCreator("Calendar");


        ///배너 출력 방향
        registry.registerLandscapeBannerCreator("Banner");
        registry.registerPortraitBannerCreator("Banner");

        //배너
        registry.registerGlossBannerCreator("Banner");
        registry.registerScrimBannerCreator("Banner");
        registry.registerMeshBannerCreator("Banner");

        //명함 출력 방향
        registry.registerLandscapeBusinessCardCreator("BusinessCard");
        registry.registerPortraitBusinessCardCreator("BusinessCard");
        //명함 종이색
        registry.registerIvoryBusinessCardCreator("BusinessCard");
        registry.registerGrayBusinessCardCreator("BusinessCard");
        registry.registerWhiteBusinessCardCreator("BusinessCard");

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
        registry.registerLandscapeBannerTextApertureAdder("ProductOption", "addAperture");
        registry.registerLandscapeBannerImageApertureAdder("ProductOption", "addAperture");
        registry.registerPortraitBannerTextApertureAdder("ProductOption", "addAperture");
        registry.registerPortraitBannerImageApertureAdder("ProductOption", "addAperture");

        // 각배너 텍스트 이미지 추가
        registry.registerGlossBannerTextApertureAdder("ProductOption", "addAperture");
        registry.registerGlossBannerImageApertureAdder("ProductOption", "addAperture");
        registry.registerScrimBannerTextApertureAdder("ProductOption", "addAperture");
        registry.registerScrimBannerImageApertureAdder("ProductOption", "addAperture");
        registry.registerMeshBannerTextApertureAdder("ProductOption", "addAperture");
        registry.registerMeshBannerImageApertureAdder("ProductOption", "addAperture");

        // 가로새로 명함 텍스트 이미지 추가
        registry.registerLandscapeBusinnessCardTextApertureAdder("ProductOption", "addAperture");
        registry.registerLandscapeBusinnessCardImageApertureAdder("ProductOption", "addAperture");
        registry.registerPortraitBusinnessCardTextApertureAdder("ProductOption", "addAperture");
        registry.registerPortraitBusinnessCardImageApertureAdder("ProductOption", "addAperture");

        // 색상지정 명함 텍스트 이미지 추가
        registry.registerIvoryBusinnessCardTextApertureAdder("ProductOption", "addAperture");
        registry.registerIvoryBusinnessCardImageApertureAdder("ProductOption", "addAperture");
        registry.registerGrayBusinnessCardTextApertureAdder("ProductOption", "addAperture");
        registry.registerGrayBusinnessCardImageApertureAdder("ProductOption", "addAperture");
        registry.registerWhiteBusinnessCardTextApertureAdder("ProductOption", "addAperture");
        registry.registerWhiteBusinnessCardImageApertureAdder("ProductOption", "addAperture");

        // 각 명함에 텍스트 이미지 추가
        registry.registerLaidBusinnessCardTextApertureAdder("ProductOption", "addAperture");
        registry.registerLaidBusinnessCardImageApertureAdder("ProductOption", "addAperture");
        registry.registerLinenBusinnessCardTextApertureAdder("ProductOption", "addAperture");
        registry.registerLinenBusinnessCardImageApertureAdder("ProductOption", "addAperture");
        registry.registerSmoothBusinnessCardTextApertureAdder("ProductOption", "addAperture");
        registry.registerSmoothBusinnessCardImageApertureAdder("ProductOption", "addAperture");

        // 단/양면 명함에 이미지 텍스트 추가
        registry.registerSingleSidedBusinnessCardTextApertureAdder("ProductOption", "addAperture");
        registry.registerSingleSidedBusinnessCardImageApertureAdder("ProductOption", "addAperture");
        registry.registerDoubleSidedBusinnessCardTextApertureAdder("ProductOption", "addAperture");
        registry.registerDoubleSidedBusinnessCardImageApertureAdder("ProductOption", "addAperture");
    }
}
