package de.arraying.arraybot.command.custom.type.actions

import de.arraying.arraybot.command.CommandEnvironment
import de.arraying.arraybot.command.custom.type.CustomCommandAction
import de.arraying.arraybot.language.Message
import net.dv8tion.jda.core.entities.TextChannel
import net.dv8tion.jda.core.exceptions.PermissionException

/**
 * Copyright 2017 Arraying
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
class RemoveRoleAction: CustomCommandAction, RoleAction() {

    /**
     * Gets the message.
     */
    override fun getMessage(channel: TextChannel): String {
        return Message.CUSTOM_TYPE_ROLE_REMOVED.getContent(channel)
    }

    /**
     * Removes the specified role from the specified user.
     */
    override fun onAction(environment: CommandEnvironment, value: String): Boolean {
        val channel = environment.channel
        val guild = environment.guild
        val action = preprocess(environment, value) ?: return false
        val user = if(action.b == null) environment.member.user.idLong else action.b!!
        return try {
            guild.controller.removeSingleRoleFromMember(guild.getMemberById(user), guild.getRoleById(action.a)).queue()
            true
        } catch(exception: PermissionException) {
            Message.CUSTOM_TYPE_ROLE_PERMISSION.send(channel).queue()
            false
        }
    }

}