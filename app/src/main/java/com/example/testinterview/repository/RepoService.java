package com.example.testinterview.repository;

import com.example.testinterview.model.ImageList;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface RepoService {

    @GET("orgs/Google/repos")
    Single<List<ImageList>> getRepositories();

    @GET("repos/{owner}/{name}")
    Single<ImageList> getRepo(@Path("owner") String owner, @Path("name") String name);
}
