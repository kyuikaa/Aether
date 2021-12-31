package de.presti.ree6.utils;

import de.presti.ree6.bot.BotInfo;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.User;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Utility class used to store Data for a shorter period of time.
 */
@SuppressWarnings("Java8MapApi")
public class ArrayUtil {

    //TODO rework. Such as removing the botJoin HashMap.

    // HashMap used to store message contents and their IDs, to show the content when the message gets deleted.
    public static final HashMap<String, String> messageIDwithMessage = new HashMap<>();

    // HashMap used to store user Ids that are associated with a message, to show the content when the message gets deleted.
    public static final HashMap<String, User> messageIDwithUser = new HashMap<>();

    // HashMap used to store user Ids and their VC join time, to track VoiceXP.
    public static final HashMap<User, Long> voiceJoined = new HashMap<>();

    // HashMap used to store a Guild ID and a Member, for later Music Bot Join.
    public static final HashMap<Guild, Member> botJoin = new HashMap<>();

    // HashMap used to store a users Ids, to keep them from spamming commands.
    public static final ArrayList<String> commandCooldown = new ArrayList<>();

    // HashMap used to store a users Ids, to keep them from earning XP with every message.
    public static final ArrayList<Member> timeout = new ArrayList<>();

    // String Array used to store answer options, for later use by the 8Ball command.
    public static final String[] answers = new String[]{"It is certain.", "It is decidedly so.", "Without a doubt.", "Yes – definitely.", "You may rely on it.", "As I see it, yes.", "Most likely.", "Outlook good.", "Yes.", "Signs point to yes", "Reply hazy, try again.", "Ask again later.", "Better not tell you now.", "Cannot predict now.", "Concentrate and ask again.", "Don't count on it.", "My reply is no.", "My sources say no.", "Outlook not so good.", "Very doubtful."};

    /**
     * Get a String fully of random Number by the given length.
     * @param length the wanted Length.
     * @return the {@link String} with the wanted Length.
     */
    public static String getRandomShit(int length) {
        StringBuilder end = new StringBuilder();

        for (int i = 0; i < length; i++) {
            end.append(RandomUtils.random.nextInt(9));
        }

        return end.toString();
    }

    /**
     * Get the User from that send a specific Message that has been deleted.
     * @param id the ID of the Message.
     * @return the {@link User} that send the Message.
     */
    public static User getUserFromMessageList(String id) {
        if (!messageIDwithUser.containsKey(id)) {
            return BotInfo.botInstance.getSelfUser();
        } else {
            return messageIDwithUser.get(id);
        }
    }

    /**
     * Get the Message content, of a deleted Message, by the ID.
     * @param id the ID of the Message.
     * @return the Content of the deleted Message.
     */
    public static String getMessageFromMessageList(String id) {
        if (!messageIDwithMessage.containsKey(id)) {
            return "Couldn't be found!";
        } else {
            return messageIDwithMessage.get(id);
        }
    }

    /**
     * Methode used to update Messages in the HashMap.
     * @param messageId the ID of the Message.
     * @param contentRaw the current Content of the Message.
     */
    @Deprecated(since = "1.4.5", forRemoval = true)
    public static void updateMessage(String messageId, String contentRaw) {
        messageIDwithMessage.remove(messageId);
        messageIDwithMessage.put(messageId, contentRaw);
    }
}