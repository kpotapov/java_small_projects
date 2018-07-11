package serviceconsumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import org.springframework.web.bind.annotation.GetMapping;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class CombinedController {

    public static final String MOON_URL = "http://localhost:8080/";
    public static final String VENUS_URL = "http://localhost:9092/";

    @GetMapping("/combined")
    Observable<List<String>> stringList() {
        Observable<List<String>> moonListObservable = getMoonListObservable(MOON_URL);
        Observable<List<String>> venusListObservable = getVenusListObservable(VENUS_URL);

        return moonListObservable.mergeWith(venusListObservable);
    }

    private Retrofit createRetrofit(String baseUrl) {
        RxJava2CallAdapterFactory rxAdapter = RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()); //async
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(rxAdapter)
                .build();
    }

    private Observable<List<String>> getMoonListObservable(String baseUrl) {
        Retrofit retrofit = createRetrofit(baseUrl);
        MoonAPI apiService =
                retrofit.create(MoonAPI.class);
        return apiService.loadMoonList();
    }

    private Observable<List<String>> getVenusListObservable(String baseUrl) {
        Retrofit retrofit = createRetrofit(baseUrl);
        VenusAPI apiService =
                retrofit.create(VenusAPI.class);
        return apiService.loadVenusList();
    }

}
