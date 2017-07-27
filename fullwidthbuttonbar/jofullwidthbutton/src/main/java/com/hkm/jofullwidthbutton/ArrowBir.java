package com.hkm.jofullwidthbutton;

import android.content.Context;
import android.util.AttributeSet;

/**
 * Created by hesk on 17年1月6日.
 */
public class ArrowBir extends fusebasic {
    public ArrowBir(Context context) {
        super(context);
        init();
    }

    public ArrowBir(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ArrowBir(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        noIcon();
    }
}
