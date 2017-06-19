package com.swayam.kotlintestapp.ui.activity

import com.swayam.kotlintestapp.R

/**
 * Created by rajesh on 12/6/17.
 */

class AppWidgetActivity : android.appwidget.AppWidgetProvider() {

    override fun onUpdate(context: android.content.Context?, appWidgetManager: android.appwidget.AppWidgetManager?, appWidgetIds: IntArray?) {
        super.onUpdate(context, appWidgetManager, appWidgetIds)

        for (i in appWidgetIds?.indices!!) {

            var currentWidgetId = appWidgetIds[i]
            var url = "http://www.tutorialspoint.com"

            var intent = android.content.Intent(context, XmlParserActivity().javaClass)
            intent.addFlags(android.content.Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.setData(android.net.Uri.parse(url))

            var pendingIntent = android.app.PendingIntent.getActivity(context, 0, intent, 0)
            var remortViews = android.widget.RemoteViews(context?.packageName, R.layout.activity_widget)

            remortViews.setOnClickPendingIntent(com.swayam.kotlintestapp.R.id.button, pendingIntent)

            appWidgetManager?.updateAppWidget(currentWidgetId, remortViews)

            android.widget.Toast.makeText(context, "Widget Added", android.widget.Toast.LENGTH_LONG).show()
        }
    }
}
