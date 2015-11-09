package spikeking.github.com.myapplication;

import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * ViewPager的适配器
 * <p/>
 * Created by wangchenlong on 15/11/9.
 */
public class SimpleAdapter extends FragmentPagerAdapter {

    private static final Section[] SECTIONS = {
            new Section("Tiffany", R.drawable.tiffany),
            new Section("Taeyeon", R.drawable.taeyeon),
            new Section("Yoona", R.drawable.yoona)
    };

    public SimpleAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override public Fragment getItem(int position) {
        return SimpleFragment.newInstance(position);
    }

    @Override public int getCount() {
        return SECTIONS.length;
    }

    @Override public CharSequence getPageTitle(int position) {
        if (position >= 0 && position < SECTIONS.length) {
            return SECTIONS[position].getTitle();
        }
        return null;
    }

    @DrawableRes
    public int getDrawable(int position) {
        if (position >= 0 && position < SECTIONS.length) {
            return SECTIONS[position].getDrawable();
        }
        return -1;
    }

    private static final class Section {
        private final String mTitle; // 标题
        @DrawableRes private final int mDrawable; // 图片

        public Section(String title, int drawable) {
            mTitle = title;
            mDrawable = drawable;
        }

        public String getTitle() {
            return mTitle;
        }

        public int getDrawable() {
            return mDrawable;
        }
    }
}
