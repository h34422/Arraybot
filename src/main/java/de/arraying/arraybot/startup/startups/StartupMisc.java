package de.arraying.arraybot.startup.startups;

import de.arraying.arraybot.Arraybot;
import de.arraying.arraybot.manager.PunishmentManager;
import de.arraying.arraybot.manager.StorageManager;
import de.arraying.arraybot.startup.StartupTask;

/**
 * Copyright 2017 Arraying
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * <p>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
public class StartupMisc extends StartupTask {

    /**
     * Creates the language startup task.
     */
    public StartupMisc() {
        super("Startup-Misc");
    }

    /**
     * Runs the actual startup task.
     * @throws Exception If an error occurs.
     */
    @Override
    public void onTask() throws Exception {
        logger.info("Creating punishment manager...");
        Arraybot.getInstance().setPunishmentManager(new PunishmentManager());
        logger.info("Creating storage manager...");
        Arraybot.getInstance().setStorageManager(new StorageManager());
    }

}
