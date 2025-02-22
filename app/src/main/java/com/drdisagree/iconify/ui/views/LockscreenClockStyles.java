package com.drdisagree.iconify.ui.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.InputFilter;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.AnalogClock;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextClock;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import com.drdisagree.iconify.R;

public class LockscreenClockStyles {

    static Typeface typeface = null;
    static int topMargin = 0;
    static int bottomMargin = 0;
    static int lineHeight = 0;
    static float textScaling = 0.6f;
    static boolean forceWhiteText = false;
    static boolean customColorEnabled = false;
    static int customColorCode = Color.WHITE;

    @SuppressLint("SetTextI18n")
    public static LinearLayout initLockscreenClockStyle(Context mContext, int style) {
        LinearLayout container = new LinearLayout(mContext);
        container.setGravity(Gravity.START | Gravity.CENTER);
        customColorCode = ResourcesCompat.getColor(mContext.getResources(), R.color.textColorPrimary, mContext.getTheme());

        switch (style) {
            case 0:
                final TextView textView0 = new TextView(mContext);
                textView0.setText("NONE");
                textView0.setTextColor(mContext.getResources().getColor(forceWhiteText ? R.color.white : R.color.textColorPrimary, mContext.getTheme()));
                textView0.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 80 * textScaling);
                textView0.setLetterSpacing(0.2f);
                textView0.setTypeface(typeface != null ? typeface : textView0.getTypeface(), Typeface.BOLD);
                textView0.setGravity(Gravity.CENTER);

                final LinearLayout blank0 = new LinearLayout(mContext);
                LinearLayout.LayoutParams blankParams0 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
                blankParams0.setMargins(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, topMargin, mContext.getResources().getDisplayMetrics()), 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottomMargin, mContext.getResources().getDisplayMetrics()));
                blank0.setLayoutParams(blankParams0);
                blank0.setOrientation(LinearLayout.VERTICAL);
                blank0.setGravity(Gravity.CENTER);
                blank0.addView(textView0);

                container = blank0;
                break;
            case 1:
                final TextClock date1 = new TextClock(mContext);
                date1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                date1.setFormat12Hour("EEEE d MMMM");
                date1.setFormat24Hour("EEEE d MMMM");
                date1.setTextColor(mContext.getResources().getColor(forceWhiteText ? R.color.white : R.color.holo_blue_light, mContext.getTheme()));
                date1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 22 * textScaling);
                date1.setTypeface(typeface != null ? typeface : date1.getTypeface(), Typeface.BOLD);
                ViewGroup.MarginLayoutParams dateParams1 = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                dateParams1.setMargins(0, 0, 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -16, mContext.getResources().getDisplayMetrics()));
                date1.setLayoutParams(dateParams1);

                final TextClock clock1 = new TextClock(mContext);
                clock1.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                clock1.setFormat12Hour("hh:mm");
                clock1.setFormat24Hour("HH:mm");
                clock1.setTextColor(mContext.getResources().getColor(forceWhiteText ? R.color.white : R.color.holo_blue_light, mContext.getTheme()));
                clock1.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 100 * textScaling);
                clock1.setTypeface(typeface != null ? typeface : clock1.getTypeface(), Typeface.BOLD);
                ViewGroup.MarginLayoutParams clockParams1 = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                clockParams1.setMargins(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -4 + lineHeight, mContext.getResources().getDisplayMetrics()), 0, 0);
                clock1.setLayoutParams(clockParams1);

                final LinearLayout clockContainer1 = new LinearLayout(mContext);
                LinearLayout.LayoutParams layoutParams1 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams1.gravity = Gravity.CENTER_HORIZONTAL;
                layoutParams1.setMargins(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, topMargin, mContext.getResources().getDisplayMetrics()), 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottomMargin, mContext.getResources().getDisplayMetrics()));
                clockContainer1.setLayoutParams(layoutParams1);
                clockContainer1.setGravity(Gravity.CENTER);
                clockContainer1.setOrientation(LinearLayout.VERTICAL);

                clockContainer1.addView(date1);
                clockContainer1.addView(clock1);

                container = clockContainer1;
                break;
            case 2:
                final TextClock day2 = new TextClock(mContext);
                day2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                day2.setFormat12Hour("EEEE");
                day2.setFormat24Hour("EEEE");
                day2.setTextColor(mContext.getResources().getColor(forceWhiteText ? R.color.white : R.color.textColorPrimary, mContext.getTheme()));
                day2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 50 * textScaling);
                day2.setTypeface(typeface != null ? typeface : day2.getTypeface());

                final TextClock clock2 = new TextClock(mContext);
                clock2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                clock2.setFormat12Hour("hh:mm");
                clock2.setFormat24Hour("HH:mm");
                clock2.setTextColor(mContext.getResources().getColor(forceWhiteText ? R.color.white : R.color.textColorPrimary, mContext.getTheme()));
                clock2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 50 * textScaling);
                clock2.setTypeface(typeface != null ? typeface : clock2.getTypeface());

                final TextClock clockOverlay2 = new TextClock(mContext);
                clockOverlay2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                clockOverlay2.setFormat12Hour("hh");
                clockOverlay2.setFormat24Hour("HH");
                clockOverlay2.setTextColor(mContext.getResources().getColor(forceWhiteText ? R.color.white : R.color.holo_blue_light, mContext.getTheme()));
                clockOverlay2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 50 * textScaling);
                clockOverlay2.setMaxLines(1);
                clockOverlay2.setTypeface(typeface != null ? typeface : clockOverlay2.getTypeface());
                int maxLength2 = 1;
                InputFilter[] fArray2 = new InputFilter[1];
                fArray2[0] = new InputFilter.LengthFilter(maxLength2);
                clockOverlay2.setFilters(fArray2);

                final FrameLayout clockContainer2 = new FrameLayout(mContext);
                clockContainer2.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                ((FrameLayout.LayoutParams) clockContainer2.getLayoutParams()).setMargins(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -12 + lineHeight, mContext.getResources().getDisplayMetrics()), 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -8 + lineHeight, mContext.getResources().getDisplayMetrics()));

                clockContainer2.addView(clock2);
                clockContainer2.addView(clockOverlay2);

                final TextClock month2 = new TextClock(mContext);
                month2.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                month2.setFormat12Hour("MMMM d");
                month2.setFormat24Hour("MMMM d");
                month2.setTextColor(mContext.getResources().getColor(forceWhiteText ? R.color.white : R.color.textColorPrimary, mContext.getTheme()));
                month2.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 22 * textScaling);
                month2.setTypeface(typeface != null ? typeface : month2.getTypeface());
                ViewGroup.MarginLayoutParams monthParams2 = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                monthParams2.setMargins((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 2, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, mContext.getResources().getDisplayMetrics()), 0, 0);
                month2.setLayoutParams(monthParams2);

                final LinearLayout wholeContainer2 = new LinearLayout(mContext);
                LinearLayout.LayoutParams layoutparams2 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutparams2.gravity = Gravity.START;
                layoutparams2.setMargins((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, topMargin, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottomMargin, mContext.getResources().getDisplayMetrics()));
                wholeContainer2.setLayoutParams(layoutparams2);
                wholeContainer2.setGravity(Gravity.START);
                wholeContainer2.setOrientation(LinearLayout.VERTICAL);

                wholeContainer2.addView(day2);
                wholeContainer2.addView(clockContainer2);
                wholeContainer2.addView(month2);

                container = wholeContainer2;
                break;
            case 3:
                final TextClock date3 = new TextClock(mContext);
                date3.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                date3.setFormat12Hour("EEE, MMM dd");
                date3.setFormat24Hour("EEE, MMM dd");
                date3.setTextColor(mContext.getResources().getColor(forceWhiteText ? R.color.white : R.color.holo_blue_light, mContext.getTheme()));
                date3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 24 * textScaling);
                date3.setTypeface(typeface != null ? typeface : date3.getTypeface(), Typeface.BOLD);

                final TextClock clockHour3 = new TextClock(mContext);
                clockHour3.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                clockHour3.setFormat12Hour("hh");
                clockHour3.setFormat24Hour("HH");
                clockHour3.setTextColor(mContext.getResources().getColor(forceWhiteText ? R.color.white : R.color.holo_blue_light, mContext.getTheme()));
                clockHour3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 160 * textScaling);
                clockHour3.setTypeface(typeface != null ? typeface : clockHour3.getTypeface(), Typeface.BOLD);
                ViewGroup.MarginLayoutParams clockHourParams3 = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                clockHourParams3.setMargins(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -34 + lineHeight, mContext.getResources().getDisplayMetrics()), 0, 0);
                clockHour3.setLayoutParams(clockHourParams3);

                final TextClock clockMinute3 = new TextClock(mContext);
                clockMinute3.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                clockMinute3.setFormat12Hour("mm");
                clockMinute3.setFormat24Hour("mm");
                clockMinute3.setTextColor(mContext.getResources().getColor(forceWhiteText ? R.color.white : R.color.holo_blue_light, mContext.getTheme()));
                clockMinute3.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 160 * textScaling);
                clockMinute3.setTypeface(typeface != null ? typeface : clockMinute3.getTypeface(), Typeface.BOLD);
                ViewGroup.MarginLayoutParams clockMinuteParams3 = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                clockMinuteParams3.setMargins(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -60 + lineHeight, mContext.getResources().getDisplayMetrics()), 0, 0);
                clockMinute3.setLayoutParams(clockMinuteParams3);

                final LinearLayout clockContainer3 = new LinearLayout(mContext);
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams3.gravity = Gravity.CENTER_HORIZONTAL;
                layoutParams3.setMargins(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, topMargin, mContext.getResources().getDisplayMetrics()), 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottomMargin, mContext.getResources().getDisplayMetrics()));
                clockContainer3.setLayoutParams(layoutParams3);
                clockContainer3.setGravity(Gravity.CENTER_HORIZONTAL);
                clockContainer3.setOrientation(LinearLayout.VERTICAL);

                clockContainer3.addView(date3);
                clockContainer3.addView(clockHour3);
                clockContainer3.addView(clockMinute3);

                container = clockContainer3;
                break;
            case 4:
                final AnalogClock analogClock4 = new AnalogClock(mContext);
                analogClock4.setLayoutParams(new LinearLayout.LayoutParams((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180 * textScaling, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 180 * textScaling, mContext.getResources().getDisplayMetrics())));
                ((LinearLayout.LayoutParams) analogClock4.getLayoutParams()).gravity = Gravity.CENTER_HORIZONTAL;

                final TextClock day4 = new TextClock(mContext);
                day4.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                day4.setFormat12Hour("EEE dd MMM");
                day4.setFormat24Hour("EEE dd MMM");
                day4.setTextColor(mContext.getResources().getColor(android.R.color.system_neutral1_200, mContext.getTheme()));
                day4.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 28 * textScaling);
                day4.setTypeface(typeface != null ? typeface : day4.getTypeface(), Typeface.BOLD);
                ViewGroup.MarginLayoutParams dayParams4 = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                dayParams4.setMargins(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 6 + lineHeight, mContext.getResources().getDisplayMetrics()), 0, 0);
                day4.setLayoutParams(dayParams4);

                final LinearLayout clockContainer4 = new LinearLayout(mContext);
                LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams4.gravity = Gravity.CENTER_HORIZONTAL;
                layoutParams4.setMargins(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, topMargin, mContext.getResources().getDisplayMetrics()), 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottomMargin, mContext.getResources().getDisplayMetrics()));
                clockContainer4.setLayoutParams(layoutParams4);
                clockContainer4.setGravity(Gravity.CENTER_HORIZONTAL);
                clockContainer4.setOrientation(LinearLayout.VERTICAL);

                clockContainer4.addView(analogClock4);
                clockContainer4.addView(day4);

                container = clockContainer4;
                break;
            case 5:
                final TextClock hour5 = new TextClock(mContext);
                hour5.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                hour5.setFormat12Hour("hh");
                hour5.setFormat24Hour("HH");
                hour5.setTextColor(mContext.getResources().getColor(R.color.white, mContext.getTheme()));
                hour5.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40 * textScaling);
                hour5.setTypeface(typeface != null ? typeface : hour5.getTypeface(), Typeface.BOLD);

                final TextClock minute5 = new TextClock(mContext);
                minute5.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                minute5.setFormat12Hour("mm");
                minute5.setFormat24Hour("mm");
                minute5.setTextColor(mContext.getResources().getColor(R.color.white, mContext.getTheme()));
                minute5.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 40 * textScaling);
                minute5.setTypeface(typeface != null ? typeface : minute5.getTypeface(), Typeface.BOLD);
                ViewGroup.MarginLayoutParams minuteParams5 = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                minuteParams5.setMargins(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4 + lineHeight, mContext.getResources().getDisplayMetrics()), 0, 0);
                minute5.setLayoutParams(minuteParams5);

                final LinearLayout time5 = new LinearLayout(mContext);
                LinearLayout.LayoutParams timeLayoutParams5 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
                timeLayoutParams5.gravity = Gravity.CENTER;
                time5.setLayoutParams(timeLayoutParams5);
                time5.setOrientation(LinearLayout.VERTICAL);
                time5.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, mContext.getResources().getDisplayMetrics()));
                GradientDrawable timeDrawable5 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{mContext.getResources().getColor(R.color.black, mContext.getTheme()), mContext.getResources().getColor(R.color.black, mContext.getTheme())});
                timeDrawable5.setCornerRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, mContext.getResources().getDisplayMetrics()));
                time5.setBackground(timeDrawable5);
                time5.setGravity(Gravity.CENTER);

                time5.addView(hour5);
                time5.addView(minute5);

                final TextClock day5 = new TextClock(mContext);
                day5.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                day5.setFormat12Hour("EEE");
                day5.setFormat24Hour("EEE");
                day5.setAllCaps(true);
                day5.setTextColor(mContext.getResources().getColor(forceWhiteText ? R.color.white : R.color.textColorPrimary, mContext.getTheme()));
                day5.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 28 * textScaling);
                day5.setTypeface(typeface != null ? typeface : day5.getTypeface(), Typeface.BOLD);
                day5.setLetterSpacing(0.2f);

                final TextClock date5 = new TextClock(mContext);
                date5.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                date5.setFormat12Hour("dd");
                date5.setFormat24Hour("dd");
                date5.setTextColor(mContext.getResources().getColor(forceWhiteText ? R.color.white : R.color.textColorPrimary, mContext.getTheme()));
                date5.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 28 * textScaling);
                date5.setTypeface(typeface != null ? typeface : date5.getTypeface(), Typeface.BOLD);
                date5.setLetterSpacing(0.2f);
                ViewGroup.MarginLayoutParams dateParams5 = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                dateParams5.setMargins(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -2 + lineHeight, mContext.getResources().getDisplayMetrics()), 0, 0);
                date5.setLayoutParams(dateParams5);

                final TextClock month5 = new TextClock(mContext);
                month5.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                month5.setFormat12Hour("MMM");
                month5.setFormat24Hour("MMM");
                month5.setAllCaps(true);
                month5.setTextColor(mContext.getResources().getColor(forceWhiteText ? R.color.white : R.color.textColorPrimary, mContext.getTheme()));
                month5.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 28 * textScaling);
                month5.setTypeface(typeface != null ? typeface : month5.getTypeface(), Typeface.BOLD);
                month5.setLetterSpacing(0.2f);
                ViewGroup.MarginLayoutParams monthParams5 = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                monthParams5.setMargins(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -2 + lineHeight, mContext.getResources().getDisplayMetrics()), 0, 0);
                month5.setLayoutParams(monthParams5);

                final LinearLayout right5 = new LinearLayout(mContext);
                LinearLayout.LayoutParams rightLayoutParams5 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.MATCH_PARENT);
                rightLayoutParams5.gravity = Gravity.CENTER;
                right5.setLayoutParams(rightLayoutParams5);
                right5.setOrientation(LinearLayout.VERTICAL);
                right5.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 16, mContext.getResources().getDisplayMetrics()));
                right5.setGravity(Gravity.CENTER);

                right5.addView(day5);
                right5.addView(date5);
                right5.addView(month5);

                final LinearLayout container5 = new LinearLayout(mContext);
                LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams5.gravity = Gravity.CENTER_HORIZONTAL;
                layoutParams5.setMargins((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, topMargin, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottomMargin, mContext.getResources().getDisplayMetrics()));
                container5.setLayoutParams(layoutParams5);
                container5.setOrientation(LinearLayout.HORIZONTAL);
                container5.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 12, mContext.getResources().getDisplayMetrics()));
                GradientDrawable mDrawable5 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{mContext.getResources().getColor(R.color.holo_blue_light, mContext.getTheme()), mContext.getResources().getColor(R.color.holo_blue_light, mContext.getTheme())});
                mDrawable5.setCornerRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 28, mContext.getResources().getDisplayMetrics()));
                container5.setBackground(mDrawable5);

                container5.addView(time5);
                container5.addView(right5);

                container = container5;
                break;
            case 6:
                int margin6 = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 14 * textScaling, mContext.getResources().getDisplayMetrics());

                final TextClock day6 = new TextClock(mContext);
                day6.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                day6.setFormat12Hour("EEE");
                day6.setFormat24Hour("EEE");
                day6.setAllCaps(true);
                day6.setTextColor(mContext.getResources().getColor(android.R.color.white, mContext.getTheme()));
                day6.setTextSize(TypedValue.COMPLEX_UNIT_SP, 42 * textScaling);
                day6.setTypeface(typeface != null ? typeface : day6.getTypeface(), Typeface.NORMAL);
                day6.setIncludeFontPadding(false);
                int maxLength6 = 2;
                InputFilter[] fArray6 = new InputFilter[1];
                fArray6[0] = new InputFilter.LengthFilter(maxLength6);
                day6.setFilters(fArray6);

                final TextView dayText6 = new TextView(mContext);
                dayText6.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                dayText6.setText("DAY");
                dayText6.setAllCaps(true);
                dayText6.setTextColor(mContext.getResources().getColor(android.R.color.white, mContext.getTheme()));
                dayText6.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16 * textScaling);
                dayText6.setTypeface(typeface != null ? typeface : dayText6.getTypeface(), Typeface.NORMAL);
                dayText6.setIncludeFontPadding(false);
                dayText6.setAlpha(0.4f);
                ViewGroup.MarginLayoutParams dayTextParams6 = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                dayTextParams6.setMargins(0, 12 + topMargin, 0, 0);
                dayText6.setLayoutParams(dayTextParams6);

                final LinearLayout dayContainer6 = new LinearLayout(mContext);
                LinearLayout.LayoutParams dayLayoutParams6 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                dayLayoutParams6.gravity = Gravity.CENTER;
                dayLayoutParams6.setMargins(margin6, margin6, margin6, margin6);
                dayContainer6.setLayoutParams(dayLayoutParams6);
                dayContainer6.setGravity(Gravity.CENTER);
                dayContainer6.setOrientation(LinearLayout.VERTICAL);

                dayContainer6.addView(day6);
                dayContainer6.addView(dayText6);

                final TextClock hour6 = new TextClock(mContext);
                hour6.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                hour6.setFormat12Hour("hh");
                hour6.setFormat24Hour("HH");
                hour6.setAllCaps(true);
                hour6.setTextColor(mContext.getResources().getColor(android.R.color.white, mContext.getTheme()));
                hour6.setTextSize(TypedValue.COMPLEX_UNIT_SP, 42 * textScaling);
                hour6.setTypeface(typeface != null ? typeface : hour6.getTypeface(), Typeface.NORMAL);
                hour6.setIncludeFontPadding(false);

                final TextView hourText6 = new TextView(mContext);
                hourText6.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                hourText6.setText("HOURS");
                hourText6.setAllCaps(true);
                hourText6.setTextColor(mContext.getResources().getColor(android.R.color.white, mContext.getTheme()));
                hourText6.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16 * textScaling);
                hourText6.setTypeface(typeface != null ? typeface : hourText6.getTypeface(), Typeface.NORMAL);
                hourText6.setIncludeFontPadding(false);
                hourText6.setAlpha(0.4f);
                ViewGroup.MarginLayoutParams hourTextParams6 = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                hourTextParams6.setMargins(0, 12 + topMargin, 0, 0);
                hourText6.setLayoutParams(hourTextParams6);

                final LinearLayout hourContainer6 = new LinearLayout(mContext);
                LinearLayout.LayoutParams hourLayoutParams6 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                hourLayoutParams6.gravity = Gravity.CENTER;
                hourLayoutParams6.setMargins(margin6, margin6, margin6, margin6);
                hourContainer6.setLayoutParams(hourLayoutParams6);
                hourContainer6.setGravity(Gravity.CENTER);
                hourContainer6.setOrientation(LinearLayout.VERTICAL);

                hourContainer6.addView(hour6);
                hourContainer6.addView(hourText6);

                final TextClock minute6 = new TextClock(mContext);
                minute6.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                minute6.setFormat12Hour("mm");
                minute6.setFormat24Hour("mm");
                minute6.setAllCaps(true);
                minute6.setTextColor(mContext.getResources().getColor(android.R.color.white, mContext.getTheme()));
                minute6.setTextSize(TypedValue.COMPLEX_UNIT_SP, 42 * textScaling);
                minute6.setTypeface(typeface != null ? typeface : minute6.getTypeface(), Typeface.NORMAL);
                minute6.setIncludeFontPadding(false);

                final TextView minuteText6 = new TextView(mContext);
                minuteText6.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                minuteText6.setText("MINUTES");
                minuteText6.setAllCaps(true);
                minuteText6.setTextColor(mContext.getResources().getColor(android.R.color.white, mContext.getTheme()));
                minuteText6.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16 * textScaling);
                minuteText6.setTypeface(typeface != null ? typeface : minuteText6.getTypeface(), Typeface.NORMAL);
                minuteText6.setIncludeFontPadding(false);
                minuteText6.setAlpha(0.4f);
                ViewGroup.MarginLayoutParams minuteTextParams6 = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                minuteTextParams6.setMargins(0, 12 + topMargin, 0, 0);
                minuteText6.setLayoutParams(minuteTextParams6);

                final LinearLayout minuteContainer6 = new LinearLayout(mContext);
                LinearLayout.LayoutParams minuteLayoutParams6 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                minuteLayoutParams6.gravity = Gravity.CENTER;
                minuteLayoutParams6.setMargins(margin6, margin6, margin6, margin6);
                minuteContainer6.setLayoutParams(minuteLayoutParams6);
                minuteContainer6.setGravity(Gravity.CENTER);
                minuteContainer6.setOrientation(LinearLayout.VERTICAL);

                minuteContainer6.addView(minute6);
                minuteContainer6.addView(minuteText6);

                final LinearLayout container6 = new LinearLayout(mContext);
                LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams6.gravity = Gravity.CENTER_HORIZONTAL;
                container6.setLayoutParams(layoutParams6);
                container6.setGravity(Gravity.CENTER);
                container6.setOrientation(LinearLayout.HORIZONTAL);
                container6.setPadding(margin6, margin6, margin6, margin6 + (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, mContext.getResources().getDisplayMetrics()));
                GradientDrawable mDrawable6 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{Color.parseColor("#090909"), Color.parseColor("#090909")});
                mDrawable6.setCornerRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, mContext.getResources().getDisplayMetrics()));
                container6.setBackground(mDrawable6);

                container6.addView(dayContainer6);
                container6.addView(hourContainer6);
                container6.addView(minuteContainer6);

                container = container6;
                break;
            case 7:
                final TextView time71 = new TextView(mContext);
                String timeFormat71 = "It's";
                time71.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                time71.setText(timeFormat71);
                time71.setTextColor(forceWhiteText ? mContext.getResources().getColor(android.R.color.white, mContext.getTheme()) : mContext.getResources().getColor(R.color.textColorPrimary, mContext.getTheme()));
                time71.setTextSize(TypedValue.COMPLEX_UNIT_SP, 42 * textScaling);
                time71.setTypeface(typeface != null ? typeface : time71.getTypeface(), Typeface.NORMAL);
                time71.setIncludeFontPadding(false);
                ViewGroup.MarginLayoutParams timeLayoutParams71 = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                timeLayoutParams71.setMargins(0, 12 + lineHeight, 0, 0);
                time71.setLayoutParams(timeLayoutParams71);

                final TextView time72 = new TextView(mContext);
                String timeFormat72 = "One";
                time72.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                time72.setText(timeFormat72);
                time72.setTextColor(forceWhiteText ? mContext.getResources().getColor(android.R.color.white, mContext.getTheme()) : mContext.getResources().getColor(R.color.textColorPrimary, mContext.getTheme()));
                time72.setTextSize(TypedValue.COMPLEX_UNIT_SP, 42 * textScaling);
                time72.setTypeface(typeface != null ? typeface : time72.getTypeface(), Typeface.NORMAL);
                time72.setIncludeFontPadding(false);
                ViewGroup.MarginLayoutParams timeLayoutParams72 = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                timeLayoutParams72.setMargins(0, 12 + lineHeight, 0, 0);
                time72.setLayoutParams(timeLayoutParams72);

                final TextView time73 = new TextView(mContext);
                String timeFormat73 = "Sixteen";
                time73.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                time73.setText(timeFormat73);
                time73.setTextColor(forceWhiteText ? mContext.getResources().getColor(android.R.color.white, mContext.getTheme()) : mContext.getResources().getColor(R.color.textColorPrimary, mContext.getTheme()));
                time73.setTextSize(TypedValue.COMPLEX_UNIT_SP, 42 * textScaling);
                time73.setTypeface(typeface != null ? typeface : time73.getTypeface(), Typeface.NORMAL);
                time73.setIncludeFontPadding(false);
                ViewGroup.MarginLayoutParams timeLayoutParams73 = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                timeLayoutParams73.setMargins(0, 12 + lineHeight, 0, 0);
                time73.setLayoutParams(timeLayoutParams73);

                final TextClock date7 = new TextClock(mContext);
                date7.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                date7.setFormat12Hour("EEEE, MMM dd");
                date7.setFormat24Hour("EEEE, MMM dd");
                date7.setTextColor(forceWhiteText ? mContext.getResources().getColor(android.R.color.white, mContext.getTheme()) : mContext.getResources().getColor(R.color.textColorPrimary, mContext.getTheme()));
                date7.setTextSize(TypedValue.COMPLEX_UNIT_SP, 22 * textScaling);
                date7.setTypeface(typeface != null ? typeface : date7.getTypeface(), Typeface.NORMAL);
                date7.setIncludeFontPadding(false);
                ViewGroup.MarginLayoutParams dateLayoutParams7 = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                dateLayoutParams7.setMargins(0, 16 + lineHeight, 0, 0);
                date7.setLayoutParams(dateLayoutParams7);

                final LinearLayout container7 = new LinearLayout(mContext);
                LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams7.gravity = Gravity.CENTER_HORIZONTAL;
                layoutParams7.setMargins((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, topMargin, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottomMargin, mContext.getResources().getDisplayMetrics()));
                container7.setLayoutParams(layoutParams7);
                container7.setGravity(Gravity.START | Gravity.CENTER_HORIZONTAL);
                container7.setOrientation(LinearLayout.VERTICAL);

                container7.addView(time71);
                container7.addView(time72);
                container7.addView(time73);
                container7.addView(date7);

                container = container7;
                break;
            case 8:
                final TextClock day8 = new TextClock(mContext);
                ViewGroup.MarginLayoutParams dayParams8 = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                dayParams8.setMargins(0, 0, 0, 0);
                day8.setLayoutParams(dayParams8);
                day8.setFormat12Hour("EEEE");
                day8.setFormat24Hour("EEEE");
                day8.setTextColor(mContext.getResources().getColor(forceWhiteText ? android.R.color.white : R.color.textColorPrimary, mContext.getTheme()));
                day8.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28 * textScaling);
                day8.setTypeface(typeface != null ? typeface : day8.getTypeface(), Typeface.BOLD);
                day8.setIncludeFontPadding(false);

                final TextClock clock8 = new TextClock(mContext);
                ViewGroup.MarginLayoutParams clockParams8 = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                clockParams8.setMargins(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, -4 + lineHeight, mContext.getResources().getDisplayMetrics()), 0, 0);
                clock8.setLayoutParams(clockParams8);
                clock8.setFormat12Hour("hh:mm");
                clock8.setFormat24Hour("HH:mm");
                clock8.setTextColor(mContext.getResources().getColor(forceWhiteText ? android.R.color.white : R.color.textColorPrimary, mContext.getTheme()));
                clock8.setTextSize(TypedValue.COMPLEX_UNIT_SP, 100 * textScaling);
                clock8.setTypeface(typeface != null ? typeface : clock8.getTypeface(), Typeface.BOLD);
                clock8.setIncludeFontPadding(false);

                final TextClock date8 = new TextClock(mContext);
                ViewGroup.MarginLayoutParams dateParams8 = new ViewGroup.MarginLayoutParams(ViewGroup.MarginLayoutParams.WRAP_CONTENT, ViewGroup.MarginLayoutParams.WRAP_CONTENT);
                dateParams8.setMargins(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 6 + lineHeight, mContext.getResources().getDisplayMetrics()), 0, 0);
                date8.setLayoutParams(dateParams8);
                date8.setFormat12Hour("MMMM dd");
                date8.setFormat24Hour("MMMM dd");
                date8.setTextColor(mContext.getResources().getColor(forceWhiteText ? android.R.color.white : R.color.textColorPrimary, mContext.getTheme()));
                date8.setTextSize(TypedValue.COMPLEX_UNIT_SP, 28 * textScaling);
                date8.setTypeface(typeface != null ? typeface : date8.getTypeface(), Typeface.NORMAL);
                date8.setIncludeFontPadding(false);

                final LinearLayout container8 = new LinearLayout(mContext);
                LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                layoutParams8.gravity = Gravity.CENTER_HORIZONTAL;
                layoutParams8.setMargins(0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, topMargin, mContext.getResources().getDisplayMetrics()), 0, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, bottomMargin, mContext.getResources().getDisplayMetrics()));
                container8.setLayoutParams(layoutParams8);
                container8.setGravity(Gravity.CENTER);
                container8.setOrientation(LinearLayout.VERTICAL);
                container8.setPadding((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40 * textScaling, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24 * textScaling, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 40 * textScaling, mContext.getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24 * textScaling, mContext.getResources().getDisplayMetrics()));
                GradientDrawable mDrawable8 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[]{forceWhiteText ? android.R.color.white : (customColorEnabled ? customColorCode : mContext.getResources().getColor(R.color.textColorPrimary, mContext.getTheme())), forceWhiteText ? android.R.color.white : (customColorEnabled ? customColorCode : mContext.getResources().getColor(R.color.textColorPrimary, mContext.getTheme()))});
                mDrawable8.setCornerRadius((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 24 * textScaling, mContext.getResources().getDisplayMetrics()));
                mDrawable8.setAlpha(50);
                container8.setBackground(mDrawable8);

                container8.addView(day8);
                container8.addView(clock8);
                container8.addView(date8);

                container = container8;
                break;
        }

        return container;
    }
}
