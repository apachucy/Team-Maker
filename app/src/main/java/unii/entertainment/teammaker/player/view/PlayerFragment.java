package unii.entertainment.teammaker.player.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import unii.entertainment.teammaker.R;
import unii.entertainment.teammaker.base.BaseFragment;
import unii.entertainment.teammaker.player.viewmodel.PlayerViewModel;

public class PlayerFragment extends BaseFragment {
    PlayerViewModel playerViewModel;
    View root;
    @BindView(R.id.playerName_editText)
    EditText playerName;

    @BindView(R.id.gender_radioGroup)
    RadioGroup genderRadioGroup;

    @BindView(R.id.player_ratingBar)
    RatingBar gameLevel;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_player, container, false);
        ButterKnife.bind(this, view);
        injectDependencies();
        root = view;
        return view;
    }


    @OnClick(R.id.clear_button)
    public void onClearUserData() {
        clearView();
        showInformationSnackBar(root, getString(R.string.clear_player), Snackbar.LENGTH_SHORT);

    }

    @OnClick(R.id.add_player_button)
    public void onAddNewPlayer() {
        if (!areCredentialValid()) {
            showValidationProblemSnackBar();
            return;
        }

        String playerNickName = playerName.getText().toString();
        boolean success = playerViewModel.checkPlayerName(playerNickName);

        if (!success) {
            showChangeNameWarningSnackBar();
            return;
        }
        success = playerViewModel.addPlayer(playerNickName, genderRadioGroup.getCheckedRadioButtonId(), gameLevel.getNumStars());

        if (success) {
            showAddNextPlayerSnackBar();
        }
    }

    private void clearView() {
        playerName.setText("");
        genderRadioGroup.clearCheck();
        gameLevel.setRating(0);
    }


    private void showChangeNameWarningSnackBar() {
        showInformationSnackBar(root, getString(R.string.warning_provided_player_exist), Snackbar.LENGTH_SHORT);

    }

    private void showValidationProblemSnackBar() {
        showInformationSnackBar(root, getString(R.string.warning_validation_player), Snackbar.LENGTH_SHORT);
    }

    private void showAddNextPlayerSnackBar() {
        showActionSnackBar(root, getString(R.string.player_add_next_title), Snackbar.LENGTH_LONG, getString(R.string.player_add_next_action), addNextPlayerListener);
    }

    private boolean areCredentialValid() {
        if (playerName.getText() == null || playerName.getText().toString().isEmpty()) {
            return false;
        }
        if (!genderRadioGroup.isSelected()) {
            return false;
        }
        if (!gameLevel.isSelected() || gameLevel.getRating() == 0) {
            return false;
        }
        return true;
    }

    private View.OnClickListener addNextPlayerListener = view -> clearView();

    @Override
    protected void injectDependencies() {
        getActivityComponent().inject(this);

    }
}
