package com.song.frame.interfaces;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

/**
 * Song Wenjun
 * Created by dell on 2019/2/23 11:00
 * Created prepare
 * package is com.example.frame.http
 * <p>
 * This class is used to do:
 */
public interface INetService {
    @GET
    Observable<String> getData(@Url String url, @QueryMap Map<String, Object> map, @HeaderMap Map<String, String> header);

    @POST
    @FormUrlEncoded
    Observable<String> postData(@Url String url, @FieldMap Map<String, Object> map, @HeaderMap Map<String, String> header);

    @POST
    Observable<String> jsonData(@Url String url, @Body RequestBody body);

    @POST
    Observable<String> fileCommit(@Url String url, @Body RequestBody body);

    @POST
    Observable<String> postQMap(@Url String url, @QueryMap Map<String, Object> map);

    @POST
    @FormUrlEncoded
    Observable<String> postMap(@Url String url, @FieldMap Map<String, Object> map);

    @Multipart
    @POST
    Observable<String> updateOneFile(@Url String url, @PartMap Map<String, RequestBody> data, @Part MultipartBody.Part file, @HeaderMap Map<String, String> map);

    @POST
    @FormUrlEncoded
    Observable<String> fileCommit(@Url String url, @Body MultipartBody multipartBody);

    @POST
    Observable<String> fileCommit(@Url String url, @Part("file") List<MultipartBody.Part> parts);

    /**
     * 多文件上传：通过 List<MultipartBody.Part> 传入多个part实现
     *
     * @param parts 每一个part代表一个文件
     * @return 状态信息String
     */
    @Multipart
    @POST("auth/check_idcard")
    Observable<String> uploadFilesMultipartBodyParts(@Part() List<MultipartBody.Part> parts);

    @POST
    Observable<String> uploadImg(Object urlUploadImg, MultipartBody.Part body);

    @POST("auth/check_idcard")
    @Multipart
    Observable<String> uploadImage(@Part("file") RequestBody file1, @Part("file") RequestBody file2,
                                   @Part("file") RequestBody file3, @Part("file") RequestBody file4,
                                   @Part("v") String v, @Part("timestamp") String time,
                                   @Part("choice") String choice, @Part("username") String name,
                                   @Part("idnum") String idnum, @Part("type") String type,
                                   @Part("uid") String uid);

    @POST("auth/check_idcard")
    @Multipart
    Observable<String> uploadImage(@PartMap Map<String, RequestBody> map,
                                   @QueryMap Map<String, Object> maps);

    @Multipart
    @POST("auth/check_idcard")
    Observable<String> uploadImg(@PartMap Map<String, RequestBody> map);

    @Multipart
    @POST("auth/check_idcard")
    Observable<Object> uploadImag(@PartMap Map<String, RequestBody> files);
}
