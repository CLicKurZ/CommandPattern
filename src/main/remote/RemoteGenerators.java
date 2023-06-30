package remote;

import java.util.Scanner;

import vendors.Television;

/**
 * Library of methods to create specific types of remotes.
 */
public class RemoteGenerators
{
    /**
     * Creates a remote for managing a tv.
     * Here the client connects the receiver (tv) to concrete commands (ie Power) and sets them in the invoker (Remote)
     * 
     * @param tv the tv to connect the remote to
     * @param userInput a method of getting input when subscribing or unsubsrcibing to channels.
     * @return the created remote.
     */
    public static Remote tvRemote(Television tv, Scanner userInput)
    {
        Remote tvRemote = new Remote(9);
        tvRemote.setButton(new Power(tv), 0);
        tvRemote.setButton(new ChannelListing(tv), 1);
        tvRemote.setButton(new VolumeUp(tv), 2);
        tvRemote.setButton(new VolumeDown(tv), 3);
        tvRemote.setButton(new ChannelForward(tv), 4);
        tvRemote.setButton(new ChannelBackward(tv), 5);
        tvRemote.setButton(new Subscribe(tv, userInput), 6);
        tvRemote.setButton(new Unsubscribe(tv, userInput), 7);
        tvRemote.setButton(new Mute(tv), 8);
        return tvRemote;
    }
}
