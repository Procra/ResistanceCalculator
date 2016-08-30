package info.androidhive.tabsswipe.adapter;

import info.androidhive.tabsswipe.resistance;
import info.androidhive.tabsswipe.resistanceInverse;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class TabsPagerAdapter extends FragmentPagerAdapter {

	public TabsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int index) {

		switch (index) {
		case 0:
			return new resistanceInverse();
		case 1:
			return new resistance();
		}

		return null;
	}

	@Override
	public int getCount() {
		return 2;
	}

}
