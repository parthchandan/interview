package com.example.testinterview.repository;

import com.example.testinterview.model.ImageList;
import io.reactivex.Single;


import javax.inject.Inject;
import java.util.List;

public class RepoRepository {

    private final RepoService repoService;

    @Inject
    public RepoRepository(RepoService repoService) {
        this.repoService = repoService;
    }

    public Single<List<ImageList>> getRepositories() {
        return repoService.getRepositories();
    }

}
