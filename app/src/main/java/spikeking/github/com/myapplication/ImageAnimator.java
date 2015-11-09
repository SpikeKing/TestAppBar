package spikeking.github.com.myapplication;

import android.support.annotation.DrawableRes;
import android.view.View;
import android.widget.ImageView;

/**
 * 渐变的动画效果
 * <p/>
 * Created by wangchenlong on 15/11/9.
 */
public class ImageAnimator {

    private final SimpleAdapter mAdapter; // 适配器
    private final ImageView mTargetImage; // 原始图片
    private final ImageView mOutgoingImage; // 渐变图片

    private int mActualStart; // 实际起始位置

    public ImageAnimator(SimpleAdapter adapter, ImageView targetImage, ImageView outgoingImage) {
        mAdapter = adapter;
        mTargetImage = targetImage;
        mOutgoingImage = outgoingImage;
    }

    /**
     * 启动动画, 之后选择向前或向后滑动
     *
     * @param startPosition 起始位置
     * @param endPosition   终止位置
     */
    public void start(int startPosition, int endPosition) {
        mActualStart = startPosition;

        // 终止位置的图片
        @DrawableRes int incomeId = mAdapter.getDrawable(endPosition);

        // 原始图片
        mOutgoingImage.setImageDrawable(mTargetImage.getDrawable()); // 原始的图片
        mOutgoingImage.setVisibility(View.VISIBLE);
        mOutgoingImage.setAlpha(1.0f);

        // 目标图片
        mTargetImage.setImageResource(incomeId);
    }

    /**
     * 滑动结束的动画效果
     *
     * @param endPosition 滑动位置
     */
    public void end(int endPosition) {
        @DrawableRes int incomeId = mAdapter.getDrawable(endPosition);
        mTargetImage.setTranslationX(0f);

        // 设置原始图片
        if (endPosition == mActualStart) {
            mTargetImage.setImageDrawable(mOutgoingImage.getDrawable());
        } else {
            mTargetImage.setImageResource(incomeId);
            mTargetImage.setAlpha(1f);
            mOutgoingImage.setVisibility(View.GONE);
        }
    }

    // 向后滚动, 比如0->1, offset滚动的距离(0->1), 目标渐渐淡出
    public void forward(float positionOffset) {
        mTargetImage.setAlpha(positionOffset);
    }

    // 向前滚动, 比如1->0, offset滚动的距离(1->0), 目标渐渐淡出
    public void backwards(float positionOffset) {
        mTargetImage.setAlpha(1 - positionOffset);
    }
}
