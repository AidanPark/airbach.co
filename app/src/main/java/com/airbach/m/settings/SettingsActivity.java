package com.airbach.m.settings;

import android.annotation.TargetApi;
import android.app.WallpaperManager;
import android.content.Intent;
import android.os.Build;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.view.MenuItem;

import com.airbach.m.R;
import com.airbach.m.app.AppCompatPreferenceActivity;
import com.airbach.m.util.log.Log;
import com.airbach.m.util.log.LogTag;

/**
 * @author : Aidan(airbach.co@gmail.com)
 * @version : 1.0
 * @date : 2016-04-27.
 */
public class SettingsActivity extends AppCompatPreferenceActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setupActionBar();
        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsPreferenceFragment()).commit();
    }

    @Override
    protected void onTestScriptClosed() { }

    /**
     * Set up the {@link android.app.ActionBar}, if the API is available.
     */
    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // Show the Up button in the action bar.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    /**
     * This fragment shows general preferences only. It is used when the
     * activity is showing a two-pane settings UI.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static class SettingsPreferenceFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_settings);
            setHasOptionsMenu(true);

            // Bind the summaries of EditText/List/Dialog/Ringtone preferences
            // to their values. When their values change, their summaries are
            // updated to reflect the new value, per the Android Design
            // guidelines.
            bindPreferenceSummaryToValue(findPreference("airbach_wallpaper_chart"));
            bindPreferenceSummaryToValue(findPreference("airbach_wallpaper_chart_sync_frequency"));

            Preference enable_airbach_wallpaper = findPreference("enable_airbach_wallpaper");
            if(enable_airbach_wallpaper != null) {
                enable_airbach_wallpaper.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
                    @Override
                    public boolean onPreferenceChange(Preference preference, Object newValue) {
                        boolean check = (Boolean) newValue;

                        if(check) {
                            Intent intent = new Intent();
                            intent.setAction(WallpaperManager.ACTION_LIVE_WALLPAPER_CHOOSER);
                            startActivity(intent);
                        }
                        return true;
                    }
                });
            }
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            if (id == android.R.id.home) {
                //   startActivity(new Intent(getActivity(), Settings2Activity.class));
                return true;
            }
            return super.onOptionsItemSelected(item);
        }
    }


    /**
     * Binds a preference's summary to its value. More specifically, when the
     * preference's value is changed, its summary (line of text below the
     * preference title) is updated to reflect the value. The summary is also
     * immediately updated upon calling this method. The exact display format is
     * dependent on the type of preference.
     *
     * @see #onPreferenceChangeListener
     */
    private static void bindPreferenceSummaryToValue(Preference preference) {
        // Set the listener to watch for value changes.
        preference.setOnPreferenceChangeListener(onPreferenceChangeListener);

        // Trigger the listener immediately with the preference's current value.
        onPreferenceChangeListener.onPreferenceChange(preference, PreferenceManager.getDefaultSharedPreferences(preference.getContext()).getString(preference.getKey(), ""));
    }

   static  LogTag TAG = new LogTag(SettingsActivity.class.getName(), SettingsActivity.class.getSimpleName(), Thread.currentThread());
    /**
     * A preference value change listener that updates the preference's summary
     * to reflect its new value.
     */
    private static Preference.OnPreferenceChangeListener onPreferenceChangeListener = new Preference.OnPreferenceChangeListener() {
        @Override
        public boolean onPreferenceChange(Preference preference, Object value) {
            if (preference instanceof ListPreference) {
                // For list preferences, look up the correct display value in
                // the preference's 'entries' list.
                ListPreference listPreference = (ListPreference) preference;
                String stringValue = value.toString();
                int index = listPreference.findIndexOfValue(stringValue);

                // Set the summary to reflect the new value.
                preference.setSummary(index >= 0 ? listPreference.getEntries()[index] : null);
            }

            else {
                // For all other preferences, set the summary to the value's
                // simple string representation.
                String stringValue = value.toString();
                Log.d(TAG, "-------------------------- stringValue : "+stringValue);
                preference.setSummary(stringValue);
            }
            return true;
        }
    };
}
