package com.hkm.jofullwidthbutton;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;

/**
 * Created by hesk on 24/4/2017.
 */

public class ArrowBarStatus extends fusebasic {

    public static final  int CODE_NOT_READY = 0;
    public static final  int CODE_READY = 1;
    public static final  int CODE_PENDING = 2;

    public ArrowBarStatus(Context context) {
        super(context);

    }

    public ArrowBarStatus(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public ArrowBarStatus(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setArrowColor(@ColorInt int color) {
        imArrow.setColorFilter(color, PorterDuff.Mode.SRC_IN);
    }

    public void setTineIcon(@ColorInt int color) {
        imIcon.setColorFilter(color, PorterDuff.Mode.SRC_IN);
    }

    public void setStatus(int status_code) {

    }
}
