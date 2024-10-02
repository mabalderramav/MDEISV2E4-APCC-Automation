package bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.helpers;

import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.core.ui.environment.EnvironmentManager;
import bo.edu.uagrm.soe.mdeisv2e4.apcc.automation.mdeisv2e4.apcc.ui.utils.PageTransporter;

public final class HomeHelper {

    private HomeHelper() {
        // Default constructor.
    }

    public static void goToHomePage() {
        var environmentManager = EnvironmentManager.getInstance();
        environmentManager.setPortalWeb("MDEISV2E4-APCC-FRONTEND");
        PageTransporter.navigateToUrl(environmentManager.getBaseUrl());
    }
}
