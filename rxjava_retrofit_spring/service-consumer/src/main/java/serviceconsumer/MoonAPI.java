package serviceconsumer;

import io.reactivex.Observable;
import retrofit2.http.GET;

import java.util.List;

public interface MoonAPI {

    @GET("list/")
    Observable<List<String>> loadMoonList();


}
