package com.ray.mvvm.sample;

import android.app.Activity;
import android.support.test.runner.lifecycle.ActivityLifecycleMonitorRegistry;

import java.util.Collection;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.runner.lifecycle.Stage.RESUMED;

public interface ActivityUtil {

    static Activity getCurrentActivity() {
        final Activity[] currentActivity = {null};
        getInstrumentation().runOnMainSync(() -> {
            Collection<Activity> resumedActivities = ActivityLifecycleMonitorRegistry.getInstance().getActivitiesInStage(RESUMED);
            if (resumedActivities.iterator().hasNext()) {
                currentActivity[0] = resumedActivities.iterator().next();
            }
        });

        return currentActivity[0];
    }

}
