package com.januzza.archweather.util;

import android.arch.lifecycle.MutableLiveData;

/**
 * Created by jpsja_000 on 24/05/2017.
 */

public class AbsentLiveData extends MutableLiveData {
    private AbsentLiveData() {
        postValue(null);
    }
    public static <T> MutableLiveData<T> create() {
        //noinspection unchecked
        return new AbsentLiveData();
    }
}
