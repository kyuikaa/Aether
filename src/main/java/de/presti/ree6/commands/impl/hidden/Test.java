package de.presti.ree6.commands.impl.hidden;

import de.presti.ree6.commands.*;
import de.presti.ree6.commands.interfaces.*;
import net.dv8tion.jda.api.interactions.commands.build.CommandData;

@Command(name = "test", description = "test", category = Category.HIDDEN)
public class Test implements ICommand {

    @Override
    public void onPerform(CommandEvent commandEvent) {
        // Nothing to test rn.
    }

    @Override
    public CommandData getCommandData() {
        return null;
    }

    @Override
    public String[] getAlias() {
        return new String[0];
    }
}
