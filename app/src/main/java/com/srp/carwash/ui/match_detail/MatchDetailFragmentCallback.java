package com.srp.carwash.ui.match_detail;

public interface MatchDetailFragmentCallback {

    void onBack();

    void onForecasts();

    void onNews(int matchId);

    void onComposition(int matchId);

    void onStatistics(int matchId);
}
