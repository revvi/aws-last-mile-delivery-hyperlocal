/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package dev.aws.proto.apps.sameday.directpudo.domain.planning;

import dev.aws.proto.apps.sameday.directpudo.domain.planning.capacity.CurrentCapacity;
import dev.aws.proto.apps.sameday.directpudo.domain.planning.capacity.MaxCapacity;
import dev.aws.proto.apps.sameday.directpudo.location.DriverLocation;
import dev.aws.proto.core.routing.location.LocationBase;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlanningDriver implements VisitOrDriver {

    private DriverLocation location;
    private MaxCapacity maxCapacity;

    // shadow variables
    private CurrentCapacity currentCapacity;
    private PlanningVisit nextVisit;

    // overrides
    @Override
    public LocationBase getLocation() {
        return this.location;
    }

    @Override
    public PlanningDriver getPlanningDriver() {
        return this;
    }

    @Override
    public Integer getVisitIndex() {
        return 0;
    }

    @Override
    public PlanningVisit getNextPlanningVisit() {
        return this.nextVisit;
    }

    @Override
    public void setNextPlanningVisit(PlanningVisit nextPlanningVisit) {
        this.nextVisit = nextPlanningVisit;
    }

    // TODO: add getDistanceTo methods
}
