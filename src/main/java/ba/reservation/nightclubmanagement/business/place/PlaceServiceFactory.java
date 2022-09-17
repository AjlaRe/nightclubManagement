package ba.reservation.nightclubmanagement.business.place;


public enum PlaceServiceFactory {

    SERVICE(new PlaceService()), PLACE_SERVICE(new PlaceService());

    private  PlaceService placeService;

    PlaceServiceFactory(PlaceService placeService){
        this.placeService = placeService;
    }

    public PlaceService getPlaceService() {
        return placeService;
    }
}