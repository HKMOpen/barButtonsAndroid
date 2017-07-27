package com.hkm.jofullwidthbutton;

import android.content.Context;

import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


/**
 * Created by hesk on 16年12月14日.
 */

public class GearButton extends FrameLayout {

    public GearButton(Context context) {
        super(context);
        init();
    }

    public GearButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public GearButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    @DrawableRes
    private int face_active;
    @DrawableRes
    private int face_normal;
    @DrawableRes
    private int face_disabled;

    // @BindView(R.id.outline)
    RelativeLayout mFrame;
    // @BindView(R.id.progress_bar_save)
    RelativeLayout mProgressBarSave;
    //  @BindView(R.id.button_gear_action)
    Button mButtonAction;
    //   @BindView(R.id.error_tpm_lyo)
    RelativeLayout mErrorView;
    //  @BindView(R.id.error_issue)
    TextView mErrorIssue;
    //  @BindView(R.id.error_image_target)
    ImageView mErrorLogo;

    protected void init() {
        View hh = LayoutInflater.from(getContext()).inflate(R.layout.gear_button, this, true);
        // ButterKnife.bind(this, f);
        mFrame = (RelativeLayout) hh.findViewById(R.id.outline);
        mProgressBarSave = (RelativeLayout) hh.findViewById(R.id.progress_bar_save);
        mErrorView = (RelativeLayout) hh.findViewById(R.id.error_tpm_lyo);
        mButtonAction = (Button) hh.findViewById(R.id.button_gear_action);
        mErrorIssue = (TextView) hh.findViewById(R.id.error_issue);
        mErrorLogo = (ImageView) hh.findViewById(R.id.error_image_target);
    }

    public void setLabel(@StringRes int stringres) {
        mButtonAction.setText(getContext().getString(stringres));
    }

    public void setLabel(String string) {
        mButtonAction.setText(string);
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (enabled) {
            setBackground(face_normal == 0 ? R.drawable.button_sel : face_normal);
        } else {
            setBackground(face_disabled == 0 ? R.drawable.button_disabled : face_disabled);
        }
        mButtonAction.setEnabled(enabled);
    }

    public void setNormal(@DrawableRes int res) {
        face_normal = res;
    }

    public void setActiveNormal(@DrawableRes int res) {
        setNormal(res);
        setEnabled(true);
    }

    /**
     * display the disabled image or logo
     * instantly set the status to disable to see the effect
     *
     * @param res the drawable of disabled image
     */
    public void setActiveDisabled(@DrawableRes int res) {
        setDisabled(res);
        setEnabled(false);
    }

    public void setDisabled(@DrawableRes int res) {
        face_disabled = res;
    }

    public void setProgressEnabled(boolean bn) {
        mProgressBarSave.setVisibility(bn ? View.VISIBLE : GONE);
        mButtonAction.setVisibility(bn ? View.GONE : VISIBLE);
        mErrorView.setVisibility(View.GONE);
    }

    public void setErrorResult(String message, @ColorRes int color) {
        mErrorIssue.setTextColor(ContextCompat.getColor(getContext(), color));
        setErrorResult(message);
    }

    public void setErrorResult(String message) {
        mErrorIssue.setText(message);
        mErrorView.setVisibility(VISIBLE);
        mProgressBarSave.setVisibility(GONE);
        mButtonAction.setVisibility(View.GONE);
    }

    public void setActionClick(OnClickListener item) {
        mButtonAction.setOnClickListener(item);
    }

    /**
     * internal use only
     *
     * @param drawable DrawableRes
     */
    private void setBackground(@DrawableRes int drawable) {
        mButtonAction.setBackground(ContextCompat.getDrawable(getContext(), drawable));
    }

}
