package com.srp.carwash.ui.home;

import com.srp.carwash.data.model.api.MatchesModel;

public interface HomeFragmentCallback {

    void onDateChange(String date);

    void onMatch(MatchesModel matchesModel);
}
