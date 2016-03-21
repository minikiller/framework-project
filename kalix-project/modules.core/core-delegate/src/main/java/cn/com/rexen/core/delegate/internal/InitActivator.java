/**
 * Licensed to the Austrian Association for Software Tool Integration (AASTI)
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. The AASTI licenses this file to you under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.com.rexen.core.delegate.internal;

import org.apache.log4j.Logger;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.BundleEvent;
import org.osgi.util.tracker.BundleTracker;

public class InitActivator implements BundleActivator {

    private static final Logger LOGGER = Logger.getLogger(InitActivator.class);

    private BundleTracker bundleTracker;

    @Override
    public void start(BundleContext context) {
        bundleTracker = new BundleTracker(context, Bundle.ACTIVE, null) {
            @Override
            public Object addingBundle(Bundle bundle, BundleEvent event) {
                LOGGER.info(String.format("adding bundle {0} {1}", bundle.getSymbolicName(), bundle));
                BundleHandler.processBundle(bundle);
                return null;
            }
        };
        bundleTracker.open();
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        bundleTracker.close();
    }

}
