package com.areeb.togglewidgets.ui

import android.content.Context
import android.hardware.camera2.CameraManager
import android.util.Log
import androidx.glance.GlanceId
import androidx.glance.action.ActionParameters
import androidx.glance.appwidget.action.ActionCallback
import androidx.glance.appwidget.state.updateAppWidgetState
import androidx.glance.state.PreferencesGlanceStateDefinition
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WifiAction : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters,
    ) {
        withContext(Dispatchers.Main) {
            updateAppWidgetState(context, PreferencesGlanceStateDefinition, glanceId) {
                it.toMutablePreferences().apply {
                    Log.e("widgetClick", "wifi")
                }
            }
            ToggleWidget().update(context, glanceId)
        }
    }
}

class FLashAction : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters,
    ) {
        updateAppWidgetState(context, PreferencesGlanceStateDefinition, glanceId) {
            it.toMutablePreferences().apply {
                Log.e("widgetClick", "flash")
                test(context)
            }
        }
        ToggleWidget().update(context, glanceId)
    }
}

class BluetoothAction : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters,
    ) {
        updateAppWidgetState(context, PreferencesGlanceStateDefinition, glanceId) {
            it.toMutablePreferences().apply {
                Log.e("widgetClick", "bluetooth")
            }
        }
        ToggleWidget().update(context, glanceId)
    }
}

class AeroplaneAction : ActionCallback {
    override suspend fun onAction(
        context: Context,
        glanceId: GlanceId,
        parameters: ActionParameters,
    ) {
        updateAppWidgetState(context, PreferencesGlanceStateDefinition, glanceId) {
            it.toMutablePreferences().apply {
                Log.e("widgetClick", "aeroplane")
            }
        }
        ToggleWidget().update(context, glanceId)
    }
}

fun test(context: Context) {
    var isFlashLightIsOn = false
    var cameraManager =
        context.applicationContext.getSystemService(Context.CAMERA_SERVICE) as CameraManager

    try {
        var cameraId = cameraManager.cameraIdList[0]
        isFlashLightIsOn = !isFlashLightIsOn
        cameraManager.setTorchMode(cameraId, isFlashLightIsOn)
    } catch (e: Exception) {
        e.printStackTrace()
    }
}
