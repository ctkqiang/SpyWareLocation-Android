package com.johnmelodyme.spywarelocation.util;

import android.util.Log;

public class logger {
    private String application = "SpyWare says";

    public void tell(String input) {
        Log.d(application, input.toString());
    }

    public void dev(String dev) {
        Log.e(application, dev);
    }

    public void show(String output) {
        Log.i(application, output.toString());
    }
}
