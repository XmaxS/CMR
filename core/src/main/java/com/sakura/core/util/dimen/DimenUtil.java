package com.sakura.core.util.dimen;

import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.sakura.core.app.Cmr;


/**
 * 计算屏幕宽高工具类
 */
public final class DimenUtil {

    public static int getScreenWidth() {
        final Resources resources = Cmr.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }

    public static int getScreenHeight() {
        final Resources resources = Cmr.getApplicationContext().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}
