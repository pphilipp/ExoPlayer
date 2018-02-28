package com.google.android.exoplayer2.model;


import android.content.Intent;

import com.google.android.exoplayer2.demo.PlayerActivity;
import com.google.android.exoplayer2.util.Assertions;

import java.util.UUID;

public class DrmInfo {
    public final UUID drmSchemeUuid;
    public final String drmLicenseUrl;
    public final String[] drmKeyRequestProperties;
    public final boolean drmMultiSession;

    public DrmInfo(UUID drmSchemeUuid, String drmLicenseUrl,
                   String[] drmKeyRequestProperties, boolean drmMultiSession) {
        this.drmSchemeUuid = drmSchemeUuid;
        this.drmLicenseUrl = drmLicenseUrl;
        this.drmKeyRequestProperties = drmKeyRequestProperties;
        this.drmMultiSession = drmMultiSession;
    }

    public void updateIntent(Intent intent) {
        Assertions.checkNotNull(intent);
        intent.putExtra(PlayerActivity.DRM_SCHEME_EXTRA, drmSchemeUuid.toString());
        intent.putExtra(PlayerActivity.DRM_LICENSE_URL, drmLicenseUrl);
        intent.putExtra(PlayerActivity.DRM_KEY_REQUEST_PROPERTIES, drmKeyRequestProperties);
        intent.putExtra(PlayerActivity.DRM_MULTI_SESSION, drmMultiSession);
    }
}