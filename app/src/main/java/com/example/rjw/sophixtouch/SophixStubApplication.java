package com.example.rjw.sophixtouch;

import android.content.Context;
import android.support.annotation.Keep;
import android.util.Log;

import com.taobao.sophix.PatchStatus;
import com.taobao.sophix.SophixApplication;
import com.taobao.sophix.SophixEntry;
import com.taobao.sophix.SophixManager;
import com.taobao.sophix.listener.PatchLoadStatusListener;

/**
 * Desc:
 * <p>
 * <p>
 * **
 * Sophix入口类，专门用于初始化Sophix，不应包含任何业务逻辑。
 * 此类必须继承自SophixApplication，onCreate方法不需要实现。
 * 此类不应与项目中的其他类有任何互相调用的逻辑，必须完全做到隔离。
 * <p>
 * AndroidManifest中设置application为此类，而SophixEntry中设为原先Application类。
 * <p>
 * 注意原先Application里不需要再重复初始化Sophix，并且需要避免混淆原先Application类。
 * 如有其它自定义改造，请咨询官方后妥善处理。
 * <p>
 * Created by renjiawen on 2018/11/14.
 */

public class SophixStubApplication extends SophixApplication {

    private static final String TAG = "SophixStubApplication";
    public static final String SOPHIX_IDSECRET_TEST = "25238372-1";
    public static final String SOPHIX_APPSECRET_TEST = "fa55f0fa3c1249b70354db7357f3ddeb";
    public static final String SOPHIX_RSASECRET_TEST = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDtk1zxuCZY7TI1xBNFQwqITUw04KoMxf3gZZkUHnW0plpB66KuQ7Hcw/iELXAYptGoPPmnCuIot2bE7b+FQl6L9V/ZT8wS/s1uDnedJs6peaX00LF9q8TKVGSGythwmkNt7KuQbQo9pvTYFHhpameB1qDzQ3y2IjNoYPv9hmMvodqhCsohPzjKg9L9AYe1Mm4G12KwyLSoNDaUKpxJcMX0cCLWVlLY+2Yga0y29jHuG8HlHdPhQX2SGiDkUyiuyuSObL2fN2P8sQ+7NHDYj/Fk4GRc2KSKo+oOzdeLduaGfdgdHO9genK4ykdmlUZoxQ5GN8MX+SucHS+YevDn/TLNAgMBAAECggEBAOLYb8n6bNtCeUvvUfszfW4SaK6gyp5xuu019YnJX9jDcrE4/tfomX9TvArxm/Rd7Rj4R+UhNjtsi3uEC/iBG+gFvqSwVgrZM2xf8gSjVndqSXVOg/ucNMaA+I/gRfSWx8XBUzwPcdTWgzmDqkn1qKnIN1ywVvdOBsomuNYmKLUDvqw/T1g+n9RGmGZo1PPUFRYFTOShEcGc/pX22rqgAJro5IfjJ4e+ZV9Dc2APmR3oRQ0KVSbD9LQ/xQ1fMe5mt1SxHdVx3dpeLSXn8viPV32aRq/kr1aZILQu67kGW3U865KbmUvXX9iB1KDAMuF1hy0PvM+3CUQrxbafmRX6g+ECgYEA/W2/dURQuDBnBW4JYAUdmmNmGDnFcoCrGn8mZ2CiNo+GwFNSfFwjTLz0n72lnW3bAEen4WBn0jj/p8aUGTVlJPbRp/okhOPv58v1qI1K1SWoWqSXRh3g2bIP9Rrl0e1IyQ+/6ueQVRpFwe5MArBdHjOIaN9jgHzeZYPG0W23AJkCgYEA7/xwS4RZqBSGSikxiZX8J4w2ZdRhgBKJpymiENh7H8Krmv0GauM9vRTdXDlz9DHU7lk0oVaZMJXwKcV9tMRafLH2RzAp2m+mhZBjRB37VGVGIlztX0+5/SqNIPyTTdD4Nvg5gy4I8T67tkKnh6oWAnaqDyqbQK/Lix2Dpn5KAFUCgYEAioOtnX6VT9bEuCcIYL7rCzNA3gTVclv5KSZN6zrZ7lBMKlpgPzBs6shsO9L/7ifZBzIjBAAZPsGAmkbjM1QH0EhHFzSVOT0MJvlHb7SqLg3DEqfbNqul9dZo+mKVMkQrABnnn5CpRppxfimsydtzScqIyCkwzU1ykLGRvW3mFCECgYBWKNKEOkMaFixUac+wLtn1tOA+1O4gVgd3rXnTBHXH5FNJ9LeeHnGm9du3ZaUcsdtZq0s69WVQTTSJOq8z/B7kj9v0mPUdyGIHp9wLs5vtI+L3KVfLlUsX+nPquOOF15WV3q5/S0LIohYwjGOrUERQpBvQECLnKXYxPupqFwModQKBgCpcyE4+DlPzf/hKar3Set7yklmXYCYMiGQkWYnOTDhu2VPtYN0OKzx/mn/jodTvRBvs4pQlU6i9YqhuKJdCF1Lm2K82cz7L4+slaPCQGWU3ELVUp7/mfe1vE9p8ZBikRuaW9j+xF10oHhSki66Gkxvd8IfMx+2uTjhGrvZKpMbE";
    private SophixManager sophixManager;

    @Keep
    @SophixEntry(MyApplication.class)
    static class RealApplicationStub {
    }
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
//         如果需要使用MultiDex，需要在此处调用。
//         MultiDex.install(this);
        initSophix();
    }

    private void initSophix() {
        String appVersion = "1.0";
        try {
            appVersion = this.getPackageManager()
                    .getPackageInfo(this.getPackageName(), 0)
                    .versionName;
        } catch (Exception e) {
        }

        if (sophixManager == null) {
            sophixManager = SophixManager.getInstance();
        }
        sophixManager.setContext(this)
                .setAppVersion(appVersion)
                .setSecretMetaData(null, null, null)
                .setEnableDebug(true)
                .setEnableFullLog()

                .setSecretMetaData(SOPHIX_IDSECRET_TEST, SOPHIX_APPSECRET_TEST, SOPHIX_RSASECRET_TEST)
                .setPatchLoadStatusStub(new PatchLoadStatusListener() {
                    @Override
                    public void onLoad(final int mode, final int code, final String info, final int handlePatchVersion) {
                        if (code == PatchStatus.CODE_LOAD_SUCCESS) {
                            Log.i(TAG, "sophix load patch success!");
                        } else if (code == PatchStatus.CODE_LOAD_RELAUNCH) {
                            // 如果需要在后台重启，建议此处用SharePreference保存状态。
                            Log.i(TAG, "sophix preload patch success. restart app to make effect.");
                        }
                    }
                }).initialize();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        if (sophixManager == null) {
            sophixManager = SophixManager.getInstance();
        }

        sophixManager.getInstance().queryAndLoadNewPatch();
    }
}
