package de.presti.ree6.streamtools.action.impl;

import de.presti.ree6.main.Main;
import de.presti.ree6.streamtools.action.StreamActionInfo;
import de.presti.ree6.streamtools.action.IStreamAction;
import lombok.NoArgsConstructor;
import net.dv8tion.jda.api.entities.Guild;
import org.jetbrains.annotations.NotNull;

/**
 * StreamAction used to play a URL.
 */
@NoArgsConstructor
@StreamActionInfo(name = "PlayUrl", command = "play-url", description = "Plays a URL.", introduced = "2.2.0")
public class PlayUrlStreamAction implements IStreamAction {

    /**
     * @param guild     The guild where the action should be executed.
     * @param arguments Arguments for the action. (Can be null)
     */
    @Override
    public void runAction(@NotNull Guild guild, String[] arguments) {
        if (arguments == null || arguments.length == 0) {
            return;
        }

        if (!Main.getInstance().getMusicWorker().isConnectedMember(guild.getSelfMember())) return;

        Main.getInstance().getMusicWorker().loadAndPlay(guild, null, null, arguments[0], null, true, false);
    }
}