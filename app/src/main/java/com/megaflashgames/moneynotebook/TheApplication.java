package com.megaflashgames.moneynotebook;

import android.app.Application;

import com.megaflashgames.moneynotebook.service.ContextService;
import com.raizlabs.android.dbflow.config.FlowManager;

import org.acra.ReportField;
import org.acra.annotation.ReportsCrashes;
import org.acra.sender.HttpSender;

/**
 * Created by vanyamihova on 04/05/2015.
 */
@ReportsCrashes(
        formUri = "https://vmihova.cloudant.com/acra-testtt/_design/acra-storage/_update/report",
        reportType = HttpSender.Type.JSON,
        httpMethod = HttpSender.Method.POST,
        formUriBasicAuthLogin = "mettillesedidauldiveldim",
        formUriBasicAuthPassword = "kM3QNYOeFpLurfHUHYt7nwrr",
        //formKey = "", // This is required for backward compatibility but not used
        customReportContent = {
                ReportField.APP_VERSION_CODE,
                ReportField.APP_VERSION_NAME,
                ReportField.ANDROID_VERSION,
                ReportField.PACKAGE_NAME,
                ReportField.REPORT_ID,
                ReportField.BUILD,
                ReportField.STACK_TRACE
        }
)
public class TheApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        ContextService.Create(getApplicationContext());
        FlowManager.init(this);

    }
}
