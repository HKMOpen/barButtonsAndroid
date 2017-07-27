package com.hkm.jofullwidthbutton;

import android.content.Context;
import android.util.AttributeSet;


/**
 * Created by hesk on 17年1月6日.
 */

public class SimpleSelectionBar extends fusebasic {
    public SimpleSelectionBar(Context context) {
        super(context);
        init();
    }

    public SimpleSelectionBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SimpleSelectionBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        noIcon();
        noArrow();
    }
}
