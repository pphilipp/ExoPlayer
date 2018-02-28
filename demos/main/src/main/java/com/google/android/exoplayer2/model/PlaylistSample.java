package com.google.android.exoplayer2.model;


import android.content.Context;
import android.content.Intent;

import com.google.android.exoplayer2.demo.PlayerActivity;

public class PlaylistSample extends Sample {
    public final UriSample[] children;

    public PlaylistSample(String name, boolean preferExtensionDecoders, DrmInfo drmInfo, UriSample... children) {
        super(name, preferExtensionDecoders, drmInfo);
        this.children = children;
    }

    @Override
    public Intent buildIntent(Context context) {
        String[] uris = new String[children.length];
        String[] extensions = new String[children.length];
        for (int i = 0; i < children.length; i++) {
            uris[i] = children[i].uri;
            extensions[i] = children[i].extension;
        }
        return super.buildIntent(context)
                    .putExtra(PlayerActivity.URI_LIST_EXTRA, uris)
                    .putExtra(PlayerActivity.EXTENSION_LIST_EXTRA, extensions)
                    .setAction(PlayerActivity.ACTION_VIEW_LIST);
    }

}
