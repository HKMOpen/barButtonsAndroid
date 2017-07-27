package com.hkm.jofullwidthbutton;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;

/**
 * Created by hesk on 10/5/16.
 */
public class ArrowBar extends fusebasic {

    public ArrowBar(Context context) {
        super(context);

    }

    public ArrowBar(Context context, AttributeSet attrs) {
        super(context, attrs);

    }

    public ArrowBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setArrowColor(@ColorInt int color) {
        imArrow.setColorFilter(color, PorterDuff.Mode.SRC_IN);
    }

    public void setTineIcon(@ColorInt int color) {
        imIcon.setColorFilter(color, PorterDuff.Mode.SRC_IN);
    }
}
