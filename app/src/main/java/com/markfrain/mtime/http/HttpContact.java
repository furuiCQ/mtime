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

    //详情接口/api/proxy/apim/Movie/Detail.api
    @GET("/api/proxy/apim/Movie/Detail.api")
    Observable<Object> detail(@Query("movieId") String movieId);

    //日期列表/api/proxy/ticket/Showtime/LocationMovieShowtimeDates.api
    @GET("/api/proxy/ticket/Showtime/LocationMovieShowtimeDates.api")
    Observable<Object> timeList(@Query("movieId") String movieId, @Query("locationId") String locationId);

    //当前城市影院列表/api/proxy/ticket/Showtime/LocationMovieShowtimes.api
    @GET("/api/proxy/ticket/Showtime/LocationMovieShowtimes.api")
    Observable<Object> cityList(@Query("movieId") String movieId, @Query("locationId") String locationId, @Query("date") String date);

    //城市区县表 /api/proxy/ticket/cinema/screening.api?locationId=291
    @GET("/api/proxy/ticket/cinema/screening.api")
    Observable<Object> cinemaList(@Query("locationId") String locationId);

}
