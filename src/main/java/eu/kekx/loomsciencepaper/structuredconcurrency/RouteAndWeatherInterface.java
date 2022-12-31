package eu.kekx.loomsciencepaper.structuredconcurrency;

public interface RouteAndWeatherInterface {

     Weather getWeather();

    Route getRoute();

    Page page(Route route, Weather weather);
}
