/*
 * Copyright (C) 2004-2017, GoodData(R) Corporation. All rights reserved.
 * This source code is licensed under the BSD-style license found in the
 * LICENSE.txt file in the root directory of this source tree.
 */
package com.gooddata.dataload.processes;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

class ScheduleIdMatcher extends TypeSafeMatcher<Schedule> {
    private final Schedule schedule;

    public ScheduleIdMatcher(final Schedule schedule) {
        this.schedule = schedule;
    }

    @Override
    public void describeTo(final Description description) {
        description.appendText("Schedule id " + schedule.getId());
    }

    public static ScheduleIdMatcher hasSameScheduleIdAs(final Schedule schedule) {
        return new ScheduleIdMatcher(schedule);
    }

    @Override
    protected boolean matchesSafely(Schedule item) {
        return schedule.getId().equals(item.getId());
    }
}