package com.drdisagree.iconify.ui.fragments;

import static com.drdisagree.iconify.common.Const.SWITCH_ANIMATION_DELAY;
import static com.drdisagree.iconify.common.Preferences.EASTER_EGG;
import static com.drdisagree.iconify.common.Preferences.FIRST_INSTALL;
import static com.drdisagree.iconify.common.Preferences.FORCE_APPLY_XPOSED_CHOICE;
import static com.drdisagree.iconify.common.Preferences.RESTART_SYSUI_AFTER_BOOT;
import static com.drdisagree.iconify.common.Preferences.SHOW_XPOSED_WARN;
import static com.drdisagree.iconify.common.Preferences.USE_LIGHT_ACCENT;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.text.LineBreaker;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.drdisagree.iconify.Iconify;
import com.drdisagree.iconify.R;
import com.drdisagree.iconify.config.Prefs;
import com.drdisagree.iconify.config.RPrefs;
import com.drdisagree.iconify.ui.activities.AppUpdates;
import com.drdisagree.iconify.ui.activities.Changelog;
import com.drdisagree.iconify.ui.activities.Experimental;
import com.drdisagree.iconify.ui.activities.Info;
import com.drdisagree.iconify.ui.views.LoadingDialog;
import com.drdisagree.iconify.ui.views.RadioDialog;
import com.drdisagree.iconify.utils.FabricatedUtil;
import com.drdisagree.iconify.utils.OverlayUtil;
import com.drdisagree.iconify.utils.SystemUtil;
import com.google.android.material.appbar.CollapsingToolbarLayout;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Settings extends Fragment implements RadioDialog.RadioDialogListener {

    public static List<String> EnabledOverlays = OverlayUtil.getEnabledOverlayList();
    LoadingDialog loadingDialog;
    RadioDialog rd_force_apply_method;

    public static void disableEverything() {
        SharedPreferences prefs = Iconify.getAppContext().getSharedPreferences(Iconify.getAppContext().getPackageName(), Context.MODE_PRIVATE);
        Map<String, ?> map = prefs.getAll();

        for (Map.Entry<String, ?> item : map.entrySet()) {
            if (item.getValue() instanceof Boolean && ((Boolean) item.getValue()) && item.getKey().contains("fabricated")) {
                Prefs.putBoolean(item.getKey(), (Boolean) item.getValue());
                FabricatedUtil.disableOverlay(item.getKey().replace("fabricated", ""));
            }
        }

        for (String overlay : EnabledOverlays) {
            OverlayUtil.disableOverlay(overlay);
        }

        Prefs.clearAllPrefs();
        SystemUtil.getBootId();
        SystemUtil.getVersionCode();
        Prefs.putBoolean(FIRST_INSTALL, false);

        RPrefs.clearAllPrefs();

        SystemUtil.restartSystemUI();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);

        // Header
        CollapsingToolbarLayout collapsing_toolbar = view.findViewById(R.id.collapsing_toolbar);
        collapsing_toolbar.setTitle(getResources().getString(R.string.activity_title_settings));
        Toolbar toolbar = view.findViewById(R.id.toolbar);
        ((AppCompatActivity) requireActivity()).setSupportActionBar(toolbar);
        setHasOptionsMenu(true);

        // Show loading dialog
        loadingDialog = new LoadingDialog(requireActivity());

        // Use light accent
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch use_light_accent = view.findViewById(R.id.use_light_accent);
        boolean useLightAccent = Prefs.getBoolean(USE_LIGHT_ACCENT, false) || Prefs.getBoolean("IconifyComponentAMACL.overlay") || Prefs.getBoolean("IconifyComponentAMGCL.overlay");

        Prefs.putBoolean(USE_LIGHT_ACCENT, useLightAccent);
        use_light_accent.setChecked(useLightAccent);

        use_light_accent.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Prefs.putBoolean(USE_LIGHT_ACCENT, isChecked);
            new Handler().postDelayed(() -> {
                if (isChecked) {
                    if (Prefs.getBoolean("IconifyComponentAMAC.overlay")) {
                        OverlayUtil.disableOverlay("IconifyComponentAMAC.overlay");
                        OverlayUtil.enableOverlay("IconifyComponentAMACL.overlay");
                    } else if (Prefs.getBoolean("IconifyComponentAMGC.overlay")) {
                        OverlayUtil.disableOverlay("IconifyComponentAMGC.overlay");
                        OverlayUtil.enableOverlay("IconifyComponentAMGCL.overlay");
                    }
                } else {
                    if (Prefs.getBoolean("IconifyComponentAMACL.overlay")) {
                        OverlayUtil.disableOverlay("IconifyComponentAMACL.overlay");
                        OverlayUtil.enableOverlay("IconifyComponentAMAC.overlay");
                    } else if (Prefs.getBoolean("IconifyComponentAMGCL.overlay")) {
                        OverlayUtil.disableOverlay("IconifyComponentAMGCL.overlay");
                        OverlayUtil.enableOverlay("IconifyComponentAMGC.overlay");
                    }
                }
            }, SWITCH_ANIMATION_DELAY);
        });

        // Restart sysui after boot
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch restart_sysui_after_boot = view.findViewById(R.id.restart_sysui_after_boot);
        restart_sysui_after_boot.setChecked(Prefs.getBoolean(RESTART_SYSUI_AFTER_BOOT, false));
        restart_sysui_after_boot.setOnCheckedChangeListener((buttonView, isChecked) -> {
            Prefs.putBoolean(RESTART_SYSUI_AFTER_BOOT, isChecked);
            if (isChecked)
                SystemUtil.enableRestartSystemuiAfterBoot();
            else
                SystemUtil.disableRestartSystemuiAfterBoot();
        });

        // Show xposed warn
        @SuppressLint("UseSwitchCompatOrMaterialCode") Switch hide_warn_message = view.findViewById(R.id.hide_warn_message);
        hide_warn_message.setChecked(Prefs.getBoolean(SHOW_XPOSED_WARN, true));
        hide_warn_message.setOnCheckedChangeListener((buttonView, isChecked) -> Prefs.putBoolean(SHOW_XPOSED_WARN, isChecked));

        // Force apply method
        LinearLayout force_apply_method = view.findViewById(R.id.force_apply_method);
        TextView selected_force_apply_method = view.findViewById(R.id.selected_force_apply_method);
        rd_force_apply_method = new RadioDialog(requireActivity(), 0, Prefs.getInt(FORCE_APPLY_XPOSED_CHOICE, 0) == -1 ? 2 : Prefs.getInt(FORCE_APPLY_XPOSED_CHOICE, 0));
        rd_force_apply_method.setRadioDialogListener(this);
        force_apply_method.setOnClickListener(v -> rd_force_apply_method.show(R.string.list_title_force_apply_method, R.array.xposed_force_apply_method, selected_force_apply_method));
        selected_force_apply_method.setText(Arrays.asList(getResources().getStringArray(R.array.xposed_force_apply_method)).get(rd_force_apply_method.getSelectedIndex() == -1 ? 2 : rd_force_apply_method.getSelectedIndex()));

        // Disable Everything
        TextView list_title_disableEverything = view.findViewById(R.id.list_title_disableEverything);
        TextView list_desc_disableEverything = view.findViewById(R.id.list_desc_disableEverything);
        Button button_disableEverything = view.findViewById(R.id.button_disableEverything);

        list_title_disableEverything.setText(getResources().getString(R.string.disable_everything_title));
        list_desc_disableEverything.setText(getResources().getString(R.string.disable_everything_desc));
        list_desc_disableEverything.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);

        button_disableEverything.setOnClickListener(v -> Toast.makeText(Iconify.getAppContext(), getResources().getString(R.string.toast_disable_everything), Toast.LENGTH_SHORT).show());

        button_disableEverything.setOnLongClickListener(v -> {
            // Show loading dialog
            loadingDialog.show(getResources().getString(R.string.loading_dialog_wait));

            Runnable runnable = () -> {
                disableEverything();

                requireActivity().runOnUiThread(() -> new Handler().postDelayed(() -> {
                    // Hide loading dialog
                    loadingDialog.hide();

                    Toast.makeText(Iconify.getAppContext(), getResources().getString(R.string.toast_disabled_everything), Toast.LENGTH_SHORT).show();
                }, 3000));
            };
            Thread thread = new Thread(runnable);
            thread.start();

            return true;
        });

        // Restart SystemUI
        TextView list_title_restartSysui = view.findViewById(R.id.list_title_restartSysui);
        TextView list_desc_restartSysui = view.findViewById(R.id.list_desc_restartSysui);
        Button button_restartSysui = view.findViewById(R.id.button_restartSysui);

        list_title_restartSysui.setText(getResources().getString(R.string.restart_sysui_title));
        list_desc_restartSysui.setText(getResources().getString(R.string.restart_sysui_desc));
        list_desc_restartSysui.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);

        button_restartSysui.setOnClickListener(v -> Toast.makeText(Iconify.getAppContext(), getResources().getString(R.string.toast_restart_sysui), Toast.LENGTH_SHORT).show());

        button_restartSysui.setOnLongClickListener(v -> {
            // Show loading dialog
            loadingDialog.show(getResources().getString(R.string.loading_dialog_wait));

            new Handler().postDelayed(() -> {
                // Hide loading dialog
                loadingDialog.hide();

                // Restart SystemUI
                SystemUtil.restartSystemUI();
            }, 1000);

            return true;
        });

        return view;
    }

    @Override
    public void onDestroy() {
        if (loadingDialog != null)
            loadingDialog.hide();
        if (rd_force_apply_method != null)
            rd_force_apply_method.dismiss();
        super.onDestroy();
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        menu.clear();
        inflater.inflate(R.menu.settings_menu, menu);
        menu.findItem(R.id.menu_experimental_features).setVisible(Prefs.getBoolean(EASTER_EGG));

        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemID = item.getItemId();

        if (itemID == R.id.menu_updates) {
            Intent intent = new Intent(requireActivity(), AppUpdates.class);
            startActivity(intent);
        } else if (itemID == R.id.menu_changelog) {
            Intent intent = new Intent(requireActivity(), Changelog.class);
            startActivity(intent);
        } else if (itemID == R.id.menu_experimental_features) {
            Intent intent = new Intent(requireActivity(), Experimental.class);
            startActivity(intent);
        } else if (itemID == R.id.menu_info) {
            Intent intent = new Intent(requireActivity(), Info.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemSelected(int dialogId, int selectedIndex) {
        switch (dialogId) {
            case 0:
                Prefs.putInt(FORCE_APPLY_XPOSED_CHOICE, selectedIndex == 2 ? -1 : selectedIndex);
                break;
        }
    }
}