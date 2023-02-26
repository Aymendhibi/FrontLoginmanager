package tn.esprit.login;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface LoginApi {
    @POST("login")
    Call<LoginResult> login(@Body LoginResult loginResult);
    @POST("mail")
    Call<LoginResult>  restPassword(@Body LoginResult loginResult);


    @POST("age/{age}")
    Call<String> postAge(@Path("age")  int age);
}
