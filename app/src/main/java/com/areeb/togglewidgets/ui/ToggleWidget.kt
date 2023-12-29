package com.areeb.togglewidgets.ui

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.Image
import androidx.glance.ImageProvider
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.background
import androidx.glance.appwidget.provideContent
import androidx.glance.background
import androidx.glance.layout.Alignment
import androidx.glance.layout.ContentScale
import androidx.glance.layout.Row
import androidx.glance.layout.Spacer
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.height
import androidx.glance.layout.padding
import androidx.glance.layout.width
import androidx.glance.layout.wrapContentHeight
import com.areeb.togglewidgets.R

class ToggleWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            Content()
        }
    }
}

@Composable
private fun Content() {
    Row(
        modifier = GlanceModifier.fillMaxSize().background(R.color.white).wrapContentHeight()
            .padding(10.dp).background(R.color.black),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            provider = ImageProvider(R.drawable.ic_wifi),
            contentDescription = "image",
            modifier = GlanceModifier.width(80.dp).height(80.dp).padding(10.dp),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = GlanceModifier.padding(start = 8.dp, end = 8.dp))
        Image(
            provider = ImageProvider(R.drawable.ic_flash_unslected),
            contentDescription = "image",
            modifier = GlanceModifier.width(80.dp).height(80.dp).padding(10.dp),
            contentScale = ContentScale.Crop,
        )

        Image(
            provider = ImageProvider(R.drawable.ic_bluetooth_unselected),
            contentDescription = "image",
            modifier = GlanceModifier.width(80.dp).height(80.dp).padding(10.dp),
            contentScale = ContentScale.Crop,
        )

        Image(
            provider = ImageProvider(R.drawable.ic_airplane_unslected),
            contentDescription = "image",
            modifier = GlanceModifier.width(80.dp).height(80.dp).padding(10.dp),
            contentScale = ContentScale.Crop,
        )
    }
}
