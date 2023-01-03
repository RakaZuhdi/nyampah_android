package com.example.nyampahv3.util;


import com.example.nyampahv3.Models.ErrorMessage;
import com.example.nyampahv3.Models.User;
import com.example.nyampahv3.model.ErrorMessage;
import com.google.gson.Gson;
import com.google.gson.JsonArray;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public final class ApiUtil {
//    private static final OkHttpClient client = new OkHttpClient();
    private static Gson gson = new Gson();
    private static String base_url = "http://10.0.2.2:3000";

    public static <T> T GET(String requestUrl, Map<String ,String> param, Type T) throws Exception {
        final OkHttpClient client = new OkHttpClient();

        String url = base_url + '/' + requestUrl;

        System.out.println(url.toString());
        HttpUrl.Builder queryUrlBuilder = HttpUrl.parse(url).newBuilder();


        if(param != null)
            for(Map.Entry<String, String> e : param.entrySet())
        {
            queryUrlBuilder.addQueryParameter(e.getKey(), e.getValue());
        }

        Request request = new Request.Builder()
                .url(String.valueOf(queryUrlBuilder.build()))
                .get()
                .build();


        CompletableFuture<Response> future = new CompletableFuture<>();

        client.newCall(request).enqueue(toCallback(future));
        Response response = future.get();

        String strespon = response.body().string();

        T json = strespon.startsWith("[")
                ? (T) new JSONArray(strespon)
                : (T) new JSONObject(strespon);



        if(json instanceof JSONObject &&
                ((JSONObject) json).has("http_code")){
            ErrorMessage err = gson.fromJson(json.toString(), ErrorMessage.class);
            AlertUtil.alert(err.code, err.error_message);
            return null;

        }


        return  gson.fromJson( json.toString(), T);
    }

    public static <T> T POST(String requestUrl, Map<String ,String> param, String body ,Type T) throws Exception {
        final OkHttpClient client = new OkHttpClient();

        String url = base_url + '/' + requestUrl;
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        //val body = jsonObject.toString().toRequestBody(mediaType)
        RequestBody reqbody = RequestBody.create(body, mediaType);
        String bearer_token = SystemUtil.getCurrentUserBearerToken();

        System.out.println(url.toString());
        HttpUrl.Builder queryUrlBuilder = HttpUrl.parse(url).newBuilder();


        if(param != null)
            for(Map.Entry<String, String> e : param.entrySet())
            {
                queryUrlBuilder.addQueryParameter(e.getKey(), e.getValue());
            }

        Request request = new Request.Builder()
                .url(String.valueOf(queryUrlBuilder.build()))
                .headers(Headers.of("Authorization", "Bearer " + bearer_token))
                .post(reqbody)
                .build();


        CompletableFuture<Response> future = new CompletableFuture<>();

        client.newCall(request).enqueue(toCallback(future));
        Response response = future.get();

        String strespon = response.body().string();

        T json = strespon.startsWith("[")
                ? (T) new JSONArray(strespon)
                : (T) new JSONObject(strespon);



        if(json instanceof JSONObject &&
                ((JSONObject) json).has("http_code")){
            ErrorMessage err = gson.fromJson(json.toString(), ErrorMessage.class);
            System.err.println(err.code);

            AlertUtil.alert(err.code, err.error_message);
            return (T) err.toString();

        }


        return  gson.fromJson( json.toString(), T);
    }

    public static <T> T PUT(String requestUrl, Map<String ,String> param, String body ,Type T) throws Exception {
        final OkHttpClient client = new OkHttpClient();

        String url = base_url + '/' + requestUrl;
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        //val body = jsonObject.toString().toRequestBody(mediaType)
        RequestBody reqbody = RequestBody.create(body, mediaType);

        System.out.println(url.toString());
        HttpUrl.Builder queryUrlBuilder = HttpUrl.parse(url).newBuilder();


        if(param != null)
            for(Map.Entry<String, String> e : param.entrySet())
            {
                queryUrlBuilder.addQueryParameter(e.getKey(), e.getValue());
            }

        Request request = new Request.Builder()
                .url(String.valueOf(queryUrlBuilder.build()))
                .put(reqbody)
                .build();


        CompletableFuture<Response> future = new CompletableFuture<>();

        client.newCall(request).enqueue(toCallback(future));
        Response response = future.get();

        String strespon = response.body().string();

        T json = strespon.startsWith("[")
                ? (T) new JSONArray(strespon)
                : (T) new JSONObject(strespon);



        if(json instanceof JSONObject &&
                ((JSONObject) json).has("http_code")){
            ErrorMessage err = gson.fromJson(json.toString(), ErrorMessage.class);
            AlertUtil.alert(err.code, err.error_message);
            return null;

        }


        return  gson.fromJson( json.toString(), T);
    }

    public static <T> T DELETE(String requestUrl, Map<String ,String> param, String body ,Type T) throws Exception {
        final OkHttpClient client = new OkHttpClient();

        String url = base_url + '/' + requestUrl;
        MediaType mediaType = MediaType.parse("application/json; charset=utf-8");
        //val body = jsonObject.toString().toRequestBody(mediaType)
        RequestBody reqbody = RequestBody.create(body, mediaType);

        System.out.println(url.toString());
        HttpUrl.Builder queryUrlBuilder = HttpUrl.parse(url).newBuilder();


        if(param != null)
            for(Map.Entry<String, String> e : param.entrySet())
            {
                queryUrlBuilder.addQueryParameter(e.getKey(), e.getValue());
            }

        Request request = new Request.Builder()
                .url(String.valueOf(queryUrlBuilder.build()))
                .delete(reqbody)
                .build();


        CompletableFuture<Response> future = new CompletableFuture<>();

        client.newCall(request).enqueue(toCallback(future));
        Response response = future.get();

        String strespon = response.body().string();

        T json = strespon.startsWith("[")
                ? (T) new JSONArray(strespon)
                : (T) new JSONObject(strespon);



        if(json instanceof JSONObject &&
                ((JSONObject) json).has("http_code")){
            ErrorMessage err = gson.fromJson(json.toString(), ErrorMessage.class);
            AlertUtil.alert(err.code, err.error_message);
            return null;

        }


        return  gson.fromJson( json.toString(), T);
    }

    public static Callback toCallback(CompletableFuture<Response> future) {
        return new Callback() {

            @Override public void onFailure(Call call, IOException e) {
                future.completeExceptionally(e);
            }

            @Override public void onResponse(Call call, Response response) {
                future.complete(response);
            }
        };
    }
}