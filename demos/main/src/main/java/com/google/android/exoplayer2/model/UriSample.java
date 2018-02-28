package com.google.android.exoplayer2.model;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.google.android.exoplayer2.demo.PlayerActivity;


public class UriSample extends Sample {

    public final String uri;
    public final String extension;
    public final String adTagUri;

    public UriSample(String name, boolean preferExtensionDecoders, DrmInfo drmInfo, String uri,
                     String extension, String adTagUri) {
        super(name, preferExtensionDecoders, drmInfo);
        this.uri = uri;
        this.extension = extension;
        this.adTagUri = adTagUri;
    }

    @Override
    public Intent buildIntent(Context context) {
        return super.buildIntent(context)
                    .setData(Uri.parse(uri))
                    .putExtra(PlayerActivity.EXTENSION_EXTRA, extension)
                    .putExtra(PlayerActivity.AD_TAG_URI_EXTRA, adTagUri)
                    .setAction(PlayerActivity.ACTION_VIEW);
    }

}
