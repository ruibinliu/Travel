package com.singou.travel;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;

public class DeviceEraser {
    private static final String ACTION_FACTORY_RESET = "com.android.internal.os.storage.FORMAT_AND_FACTORY_RESET";
    private static final String PACKAGE = "android";
    private static final String CLASS = "com.android.internal.os.storage.ExternalStorageFormatter";

    private static final String ACTION_MASTER_CLEAR = "android.intent.action.MASTER_CLEAR";

    public static void factoryReset(Context context, boolean isEraseSdCard) {
        if (isEraseSdCard) {
            Intent intent = new Intent(ACTION_FACTORY_RESET);
            intent.setComponent(new ComponentName(PACKAGE, CLASS));
            context.startService(intent);
        } else {
            context.sendBroadcast(new Intent(ACTION_MASTER_CLEAR));
            // Intent handling is asynchronous -- assume it will happen soon.
        }
    }
}
