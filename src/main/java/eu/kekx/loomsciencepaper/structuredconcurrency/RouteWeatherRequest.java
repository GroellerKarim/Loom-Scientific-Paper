package eu.kekx.loomsciencepaper.structuredconcurrency;

public class RouteWeatherRequest {

    public static void main(String[] args) {
        System.out.println("Test");
        new RouteWeatherRequest().getRouteAndWeatherPage();
    }

    //tag::baseRW[]
    Page getRouteAndWeatherPage() {
        Route route = getRoute();
        Weather weather = getWeather();
        return page(route, weather);
    }
    //end::baseRW[]

    public Route getRoute() {
        return null;
    }

    public Weather getWeather() {
        return null;
    }
    public Page page(Route route, Weather weather) {
        return null;
    }

}
