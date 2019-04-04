package com.markfrain.mtime.http;

import com.markfrain.mtime.response.LocalMovieResponse;
import com.markfrain.mtime.response.NewMovieResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HttpContact {

    //获取正在热映的列表
    @GET("/Service/callback.mi/Showtime/LocationMovies.api")
    Observable<LocalMovieResponse> liveData(@Query("locationId") String locationId);

    //获取即将上映的列表
    @GET("/Service/callback.mi/Movie/MovieComingNew.api")
    Observable<NewMovieResponse> newData(@Query("locationId") String locationId);
}
