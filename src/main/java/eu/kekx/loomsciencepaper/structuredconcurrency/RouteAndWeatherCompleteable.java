package eu.kekx.loomsciencepaper.structuredconcurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class RouteAndWeatherCompleteable implements RouteAndWeatherInterface {


    //tag::compRW[]
    Page getRouteAndWeather() throws ExecutionException, InterruptedException {
        var routeCf = CompletableFuture.supplyAsync(() -> getRoute());
        var weatherCf = CompletableFuture.supplyAsync(() -> getWeather());
        CompletableFuture<Page> page =
                routeCf.thenCompose(route ->
                        weatherCf.thenApply(weather -> page(route, weather)));
        return page.get();
    }
    //end::compRW[]

    @Override
    public Weather getWeather() {
        return null;
    }

    @Override
    public Route getRoute() {
        return null;
    }

    @Override
    public Page page(Route route, Weather weather) {
        return null;
    }
}
