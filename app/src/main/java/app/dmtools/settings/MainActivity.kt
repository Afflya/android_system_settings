package app.dmtools.settings

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Settings

class MainActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Open system settings
        val intent = Intent(Settings.ACTION_SETTINGS)
        startActivity(intent)

        // Close the app immediately after opening settings
        finish()
    }
}
