package com.rba

import android.content.Intent

private const val PACKAGE_NAME = "com.rba"

fun intentTo(intentActivity: IntentActivity): Intent? =
    Intent(Intent.ACTION_VIEW).setClassName(PACKAGE_NAME, intentActivity.className)

interface IntentActivity {
    /**
     * The activity class name.
     */
    val className: String
}

object Activity {

    object Main : IntentActivity {
        override val className = "$PACKAGE_NAME.component.dynamicfeature.MainActivity"
    }

}