package com.google.android.exoplayer2.model;


import android.content.Context;
import android.content.Intent;

import com.google.android.exoplayer2.demo.PlayerActivity;
import com.google.android.exoplayer2.demo.SampleChooserActivity;

public class Sample {
    public final String name;
    public final boolean preferExtensionDecoders;
    public final DrmInfo drmInfo;

    public Sample(String name, boolean preferExtensionDecoders, DrmInfo drmInfo) {
        this.name = name;
        this.preferExtensionDecoders = preferExtensionDecoders;
        this.drmInfo = drmInfo;
    }

    public Intent buildIntent(Context context) {
        Intent intent = new Intent(context, PlayerActivity.class);
        intent.putExtra(PlayerActivity.PREFER_EXTENSION_DECODERS, preferExtensionDecoders);
        if (drmInfo != null) {
            drmInfo.updateIntent(intent);
        }

        return intent;
    }
}
