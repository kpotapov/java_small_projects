package serviceconsumer;

import io.reactivex.Observable;
import retrofit2.http.GET;

import java.util.List;

public interface VenusAPI {

    @GET("vlist")
    Observable<List<String>> loadVenusList();


}
