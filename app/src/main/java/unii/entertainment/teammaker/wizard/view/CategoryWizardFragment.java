package unii.entertainment.teammaker.wizard.view;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Switch;

import butterknife.BindView;
import butterknife.ButterKnife;
import unii.entertainment.teammaker.R;
import unii.entertainment.teammaker.base.BaseFragment;
import unii.entertainment.teammaker.dagger.ActivityComponent;

public class CategoryWizardFragment extends BaseFragment {
    // private WizardViewModel wizardViewModel;

    @BindView(R.id.team_number)
    EditText teamNumberView;

    @BindView(R.id.diverse_teams)
    Switch diverseTeams;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_wizard_category, container, false);
        ButterKnife.bind(this, view);
        injectDependencies();
        initData(getActivityComponent());
        initView();
        return view;
    }

    @Override
    protected void injectDependencies() {
        getActivityComponent().inject(this);

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData(ActivityComponent component) {

    }

    @Override
    public void onPause() {
        super.onPause();
        //      saveIsDiverseTeam();
        //      saveTeamNumber();
    }
/*
    @Override
    public void onResume() {
        super.onResume();
        if (wizardViewModel.getNumberOfTeams() > 0) {
            teamNumberView.setText(String.valueOf(wizardViewModel.getNumberOfTeams()));
        }
        diverseTeams.setChecked(wizardViewModel.isCreateMixedTeams());
    }

    private void saveIsDiverseTeam() {
        wizardViewModel.setCreateMixedTeams(diverseTeams.isChecked());
    }

    private void saveTeamNumber() {
        if (teamNumberView.getText() == null || teamNumberView.getText().toString().isEmpty()) {
            return;
        }
        String teamNumberValue = teamNumberView.getText().toString();
        try {
            int teamNumber = Integer.parseInt(teamNumberValue);
            if (teamNumber > 0) {
                wizardViewModel.setNumberOfTeams(teamNumber);
            }
        } catch (NumberFormatException e) {
            //display an error?
        }
    }*/
}
