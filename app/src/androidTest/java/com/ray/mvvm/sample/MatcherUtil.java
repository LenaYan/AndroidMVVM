package com.ray.mvvm.sample;

import android.support.test.espresso.matcher.BoundedMatcher;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

interface MatcherUtil {

    static Matcher<View> withText(final String value) {
        return new BoundedMatcher<View, TextView>(TextView.class) {
            @Override
            public void describeTo(Description description) {
                description.appendText("with text: ");
            }

            @Override
            public boolean matchesSafely(TextView editText) {
                return TextUtils.equals(value, editText.getText() == null ? null : editText.getText());
            }
        };
    }
}
