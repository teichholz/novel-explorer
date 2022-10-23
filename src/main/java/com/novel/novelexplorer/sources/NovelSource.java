package com.novel.novelexplorer.sources;

import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Value;

@RequiredArgsConstructor
@Getter
public enum NovelSource {
    RoyalRoad("RoyalRoad", "royalroad.com", "fictions/best-rated");

    private final String name;
    private final String domain;
    private final String linkToOverviewPage;
}
