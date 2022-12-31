package eu.kekx.loomsciencepaper.structuredconcurrency;

import java.util.concurrent.*;

public class RouteAndWeatherExecutor implements RouteAndWeatherInterface {

    ExecutorService service = new ThreadPoolExecutor(2, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>(1));

    //tag::execRW[]
    Page getRouteAndWeatherPage() throws ExecutionException, InterruptedException {
        Future<Route> route =
                service.submit(() -> getRoute());
        Future<Weather> weather =
                service.submit(() -> getWeather());
        return page(route.get(), weather.get());
    }
    //end::execRW[]

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
