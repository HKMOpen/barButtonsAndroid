package com.hkm.jofullwidthbutton;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;



/**
 * Created by hesk on 10/5/16.
 */
public abstract class fusebasic extends RelativeLayout {
    @LayoutRes
    protected int reslayout() {
        return R.layout.seletionbar;
    }

    // @BindView(R.id.tpm_display)
    TextView title;
    // @BindView(R.id.tpm_displayvalue)
    TextView value;
    // @BindView(R.id.tpm_icon_place)
    ImageView imIcon;
    //  @BindView(R.id.tpm_arrow)
    ImageView imArrow;

    protected void bind(View hh) {
        //  ButterKnife.bind(this, hh);
        title = (TextView) hh.findViewById(R.id.tpm_display);
        value = (TextView) hh.findViewById(R.id.tpm_displayvalue);
        imIcon = (ImageView) hh.findViewById(R.id.tpm_icon_place);
        imArrow = (ImageView) hh.findViewById(R.id.tpm_arrow);
    }

    Context mContext;

    protected int def_icon, def_arrow, def_bg;

    protected TypedArray mAttr;

    private String font_name;

    private String mtitle;

    public fusebasic(Context context) {
        super(context);
        mContext = context;
        init(context);
    }

    public fusebasic(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        initAttributes(context, attrs);
        init(context);
    }

    public fusebasic(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;
        initAttributes(context, attrs);
        init(context);
    }

    protected TypedArray getTypedArray(Context context, AttributeSet attributeSet, int[] attr) {
        return context.obtainStyledAttributes(attributeSet, attr, 0, 0);
    }

    protected void getFont(Context context) {
        if (font_name != null) {
            try {
                Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + font_name);
                if (typeface != null) {
                    title.setTypeface(typeface);
                    value.setTypeface(typeface);
                }
            } catch (Exception e) {
                Log.d("fonrloading", e.getMessage());
            }
        }
    }

    private void initAttributes(Context context, AttributeSet attributeSet) {
        mAttr = getTypedArray(context, attributeSet, R.styleable.tpm_fun);
        if (mAttr == null) {
            return;
        }

        try {
            mtitle = mAttr.getString(R.styleable.tpm_fun_tpm_ext_title);
            def_arrow = mAttr.getResourceId(R.styleable.tpm_fun_tpm_arrow_drawable, R.drawable.ic_chevron_right_24dp);
            def_icon = mAttr.getResourceId(R.styleable.tpm_fun_tpm_icon_drawable, R.drawable.ic_correct_black_24dp);
            def_bg = mAttr.getResourceId(R.styleable.tpm_fun_tpm_decor_background, -1);
        } finally {
            mAttr.recycle();
        }
    }

    private void apply() {
        if (def_arrow > 0 && imArrow != null) {
            imArrow.setImageResource(def_arrow);
        }
        if (def_icon > 0 && imIcon != null) {
            imIcon.setImageResource(def_icon);
        }
        if (def_bg > 0) {
            setBackgroundResource(def_bg);
        }
        if (mtitle != null) {
            title.setText(mtitle);
        }
    }


    private void init(Context context) {
        setClickable(true);
        View mview = LayoutInflater.from(context).inflate(reslayout(), this, true);
        bind(mview);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setElevation(2f);
        }
        apply();
    }

    protected void noIcon() {
        imIcon.setVisibility(GONE);
    }

    protected void noArrow() {
        imArrow.setVisibility(GONE);
    }

    public void setTitle(@StringRes final int stringres) {
        title.setText(mContext.getString(stringres));
    }

    public void setTitle(final String pvalue) {
        title.setText(pvalue);
    }

    public void setValue(@StringRes final int pvalue) {
        value.setText(mContext.getString(pvalue));
    }

    public void setValue(final String pvalue) {
        value.setText(pvalue);
    }

    public void setTextColor(final @ColorInt int color) {
        title.setTextColor(color);
        value.setTextColor(color);
        title.setShadowLayer(2f, 2f, 3f, ContextCompat.getColor(getContext(), R.color.black));
    }

    private String theValueForTempStorage;

    public void setMemVal(String val) {
        theValueForTempStorage = val;
    }

    public String getMemVal() {
        return theValueForTempStorage;
    }

    public void setBoolVal(boolean bj) {
        internal_bool = bj;
    }

    private boolean internal_bool;

    public boolean getBoolVal() {
        return internal_bool;
    }

    public void BoolValLabbel() {

    }

}
