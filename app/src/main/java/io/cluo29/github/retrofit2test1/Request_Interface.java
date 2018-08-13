package io.cluo29.github.retrofit2test1;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by CLUO29 on 13/08/18.
 */

public interface Request_Interface {

    // put the request string inside annotation
    @GET("ajax.php?a=fy&f=auto&t=auto&w=too%20simple")
    Call<MainActivity.Translation> getCall();

}
