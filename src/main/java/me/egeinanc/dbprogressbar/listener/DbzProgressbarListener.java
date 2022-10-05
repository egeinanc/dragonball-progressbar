package me.egeinanc.dbprogressbar.listener;

import com.intellij.ide.ui.LafManager;
import com.intellij.ide.ui.LafManagerListener;
import me.egeinanc.dbprogressbar.ui.DbzProgressBarUi;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;


public class DbzProgressbarListener implements LafManagerListener {
    public DbzProgressbarListener() {
        updateUi();
    }

    private void updateUi() {
        UIManager.put("ProgressBarUI", DbzProgressBarUi.class.getName());
        UIManager.getDefaults().put(DbzProgressBarUi.class.getName(), DbzProgressBarUi.class);
    }

    @Override
    public void lookAndFeelChanged(@NotNull final LafManager source) {
        updateUi();
    }

}
