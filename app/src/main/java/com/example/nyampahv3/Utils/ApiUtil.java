package com.example.nyampahv3.Utils;/*
 * Copyright (C) 2014 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import com.example.nyampahv3.Models.ErrorMessage;
import com.example.nyampahv3.Models.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.squareup.okhttp.HttpUrl;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public final class ApiUtil {
//    private static final OkHttpClient client = new OkHttpClient();
    private static Gson gson = new Gson();
    private static String base_url = "http://10.0.2.2:3000";

    public static <T> T get(String requestUrl, Map<String ,String> param, Type T) throws Exception {
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



        if(json instanceof JSONObject && ((JSONObject) json).getString("http_code").equals("403")){
            ErrorMessage err = gson.fromJson(json.toString(), ErrorMessage.class);
            System.err.println(err.code);
            System.err.println(err.error_message);
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