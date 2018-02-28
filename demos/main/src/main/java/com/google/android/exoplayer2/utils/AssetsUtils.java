package com.google.android.exoplayer2.utils;


import android.content.Context;
import android.content.res.AssetManager;
import android.support.annotation.NonNull;
import android.widget.Toast;

import com.google.android.exoplayer2.demo.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class AssetsUtils {

    @NonNull
    public static String[] getUrlsFromAssets(Context context, String dataUri) {
        String[] uris;
        if (dataUri != null) {
            uris = new String[] {dataUri};
        } else {
            ArrayList<String> uriList = new ArrayList<>();
            AssetManager assetManager = context.getAssets();

            try {
                for (String asset : assetManager.list("")) {
                    if (asset.endsWith(".exolist.json")) {
                        uriList.add("asset:///" + asset);
                    }
                }
            } catch (IOException e) {
                Toast.makeText(context.getApplicationContext(), R.string.sample_list_load_error, Toast.LENGTH_LONG)
                     .show();
            }

            uris = new String[uriList.size()];
            uriList.toArray(uris);
            Arrays.sort(uris);
        }
        return uris;
    }
}
