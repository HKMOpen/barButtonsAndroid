package com.hkm.jofullwidthbutton;

import android.content.Context;
import android.graphics.PorterDuff;
import android.support.annotation.LayoutRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;

/**
 * Created by hesk on 17年1月13日.
 */

public class BannerTao extends fusebasic {
    @LayoutRes
    protected int reslayout() {
        return R.layout.selectionbar2;
    }

    public BannerTao(Context context) {
        super(context);
        init();
    }

    public BannerTao(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BannerTao(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        noIcon();
        hightenArrow();
    }

    private void hightenArrow() {
        imArrow.setColorFilter(ContextCompat.getColor(getContext(), R.color.white), PorterDuff.Mode.SRC_IN);
    }

    public final void removeArrow() {
        noArrow();
    }
}
