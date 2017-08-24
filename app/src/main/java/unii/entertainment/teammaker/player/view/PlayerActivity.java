package unii.entertainment.teammaker.player.view;

import android.os.Bundle;

import unii.entertainment.teammaker.R;
import unii.entertainment.teammaker.base.BaseActivity;

public class PlayerActivity extends BaseActivity {

    public static String BUNDLE_CATEGORY_ID = "category_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);
    }
}
