package com.panaceasoft.psbuyandsell.ui.item.history;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;

import androidx.databinding.DataBindingUtil;

import com.panaceasoft.psbuyandsell.Config;
import com.panaceasoft.psbuyandsell.R;
import com.panaceasoft.psbuyandsell.databinding.ActivityUserHistoryListBinding;
import com.panaceasoft.psbuyandsell.ui.common.PSAppCompactActivity;
import com.panaceasoft.psbuyandsell.utils.Constants;
import com.panaceasoft.psbuyandsell.utils.MyContextWrapper;

public class UserHistoryListActivity extends PSAppCompactActivity {


    //region Override Methods
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityUserHistoryListBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_user_history_list);

        // Init all UI
        initUI(binding);

    }

    @Override
    protected void attachBaseContext(Context newBase) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(newBase);
        String LANG_CURRENT = preferences.getString(Constants.LANGUAGE, Config.DEFAULT_LANGUAGE);

        super.attachBaseContext(MyContextWrapper.wrap(newBase, LANG_CURRENT, true));
    }

    //endregion


    //region Private Methods

    private void initUI(ActivityUserHistoryListBinding binding) {

        // Toolbar
        initToolbar(binding.toolbar, getString(R.string.history__title));

        // setup Fragment
        setupFragment(new HistoryFragment());
        // Or you can call like this
        //setupFragment(new NewsListFragment(), R.id.content_frame);

    }

}
