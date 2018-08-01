/**
 * Copyright (C) :     2012
 *
 * 	Synchrotron Soleil
 * 	L'Orme des merisiers
 * 	Saint Aubin
 * 	BP48
 * 	91192 GIF-SUR-YVETTE CEDEX
 *
 * This file is part of Tango.
 *
 * Tango is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Tango is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with Tango.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.tango.server.events;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tango.server.Constants;
import org.tango.server.ServerManager;
import org.tango.utils.DevFailedUtils;

import fr.esrf.Tango.DevFailed;
import fr.esrf.Tango.DevIntrChange;

public class DeviceInterfaceChangedSender {
    private class EventSenderTask implements Runnable {
        private final LinkedBlockingDeque<DevIntrChange> interfaces = new LinkedBlockingDeque<DevIntrChange>(1);
        private final String deviceName;

        public EventSenderTask(final String deviceName) {
            this.deviceName = deviceName;
        }

        public void add(final DevIntrChange deviceInterface) {
            interfaces.clear();
            interfaces.add(deviceInterface);
        }

        public void clear() {
            interfaces.clear();
        }

        @Override
        public void run() {
            boolean stop = false;
            while (!stop && EventManager.getInstance().hasSubscriber(deviceName)) {
                try {
                    final DevIntrChange devInterface = interfaces.take();
                    EventManager.getInstance().pushInterfaceChangedEvent(deviceName, devInterface);
                    Thread.sleep(50);
                } catch (final InterruptedException e) {
                    stop = true;
                } catch (final DevFailed e) {
                    logger.error(DevFailedUtils.toString(e));
                    logger.error("impossible to send event", e);
                }
            }
        }
    }

    private final Logger logger = LoggerFactory.getLogger(DeviceInterfaceChangedSender.class);
    private ExecutorService executor;
    private final String deviceName;
    private final EventSenderTask task;
    private Future<?> future;

    public DeviceInterfaceChangedSender(final String deviceName) {
        this.deviceName = deviceName;
        task = new EventSenderTask(deviceName);
        executor = Executors.newFixedThreadPool(1, new ThreadFactory() {
            @Override
            public Thread newThread(final Runnable r) {
                return new Thread(r, "DeviceInterfaceChangedSender-" + deviceName);
            }
        });
    }

    public synchronized void pushEvent(final DevIntrChange deviceInterface, final boolean isStarted) {
        if (isStarted) { // device startup, send event and empty queue
            if (!deviceName.equalsIgnoreCase(Constants.ADMIN_DEVICE_DOMAIN + "/"
                    + ServerManager.getInstance().getServerName())) {
                logger.debug("send event for interface changed of {}", deviceName);
                try {
                    EventManager.getInstance().pushInterfaceChangedEvent(deviceName, deviceInterface);
                } catch (final DevFailed e) {
                    logger.error(DevFailedUtils.toString(e));
                    logger.error("impossible to send event", e);
                }
                task.clear();
            }
        } else {
            // queue event
            logger.debug("request for interface changed of {} queued", deviceName);
            task.add(deviceInterface);
            if (future == null && EventManager.getInstance().hasSubscriber(deviceName)) {
                future = executor.submit(task);
            }
        }
    }

    public synchronized void stop() {
        task.clear();
        if (future != null) {
            future.cancel(true);
            future = null;
        }
    }
}
