package vendors;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * A very simple blueprint for a television.
 * 
 * @author Willow Sapphire
 * @version Fall 2022
 */
public class Television
{
    /**
     * The channels that the tv has by default.
     */
    public static final String[] DEFAULT_CHANNELS = {
        "HBO", "NBC", "ABC", 
        "Fox", "CNN", "A&E",
        "Showtime", "C-Span"
    };

    /**
     * The list of available channels.
     */
    private ArrayList<String> channels;

    /**
     * The maximum volume that the tv can reach.
     */
    private int maxVolume;

    /**
     * The current volume of the tv.
     */
    private int volume;

    private int lastVolume;

    /**
     * The index of the current channel in the channels array.
     */
    private int currStation;

    /**
     * Indicates if the tv is currently on.
     */
    private boolean isOn;

    /**
     * Creates a new television object.
     * Sets the maxVolume to the provided value.
     * Sets the volume to 50 and the channel to 0.
     * Starts turned off.
     * 
     * @param maxVolume the maximum volume of the television.
     */
    public Television(int maxVolume)
    {
        this.channels = new ArrayList<String>(Arrays.asList(DEFAULT_CHANNELS));
        this.maxVolume = Math.abs(maxVolume);
        this.volume = 50;
        this.lastVolume = volume;
        this.currStation = 0;
        this.isOn = false;
    }

    /**
     * Turns the tv on if it is off or off if it is on.
     */
    public void power()
    {
        isOn = !isOn;
    }

    /**
     * Increase volume by one.
     * Does not go above MAX_VOLUME.
     * Does nothing if the tv is not on yet.
     * 
     * @return true if the volume is succesfully increased
     */
    public boolean increaseVolume()
    {
        if (isOn && volume < maxVolume)
        {
            lastVolume = volume;
            volume++;
            return true;
        }
        return false;
    }

    /**
     * Decrease volume by one.
     * Does not go below zero.
     * Does nothing if the tv is not on yet.
     * 
     * @return true if the volume is succesfully decreased
     */
    public boolean decreaseVolume()
    {
        if (isOn && volume > 0)
        {
            lastVolume = volume;
            volume--;
            return true;
        }
        return false;
    }

    public boolean muteVolume()
    {
        if (isOn && volume > 0)
        {
            lastVolume = volume;
            volume = 0; 
            return true;
        }
        else if (isOn && volume <= 0)
        {
            volume = lastVolume;
            return true;
        }
        return false;
    }

    /**
     * Changest the current station to the provided station.
     * 
     * @param station the station to go to
     * @return true if the station was valid and successfully changed
     */
    public boolean goToChannel(int station)
    {
        if (isOn && station > 0 && station <= channels.size())
        {
            currStation = station;
            return true;
        }
        return false;
    }

    /**
     * Gets a list of all the channels currently subscribed to.
     */
    public String[] getChannels()
    {
        return channels.toArray(new String[channels.size()]);
    }

    /**
     * Checks if the tv is on.
     * 
     * @return true if the tv is on. false if the tv is off.
     */
    public boolean isOn()
    {
        return isOn;
    }
    
    /**
     * Gets the current volume.
     * 
     * @return the current volume
     */
    public int getVolume()
    {
        return volume;
    }

    /**
     * Gets the maximum volume for this tv.
     * 
     * @return the maximum volume
     */
    public int getMaxVolume()
    {
        return maxVolume;
    }

    /**
     * Gets the current channel.
     * 
     * @return the current channel
     */
    public String getCurrentChannel()
    {
        return channels.get(currStation);
    }

    /**
     * Gets the station number.
     * 
     * @return the current station number
     */
    public int getCurrentStation()
    {
        return currStation;
    }

    /**
     * Gets the current number of subscribed channels.
     * 
     * @return the size of the channels list
     */
    public int getNumChannels()
    {
        return channels.size();
    }

    /**
     * Gets the channel from a particular station.
     * 
     * @param station The station to check
     * @return The channel at the station if found. "Station <station> not found" otherwise
     */
    public String getChannelAtStation(int station)
    {
        if (station < 0 || station >= channels.size())
        {
            return String.format("Station %d not found", station);
        }
        else
        {
            return channels.get(station);
        }
    }

    /**
     * Searches for a given channel. If found, the station number is returned.
     * 
     * @param channel the channel of which to get the station
     * @return the station of the channel. -1 if it is not found
     */
    public int getStationAtChannel(String channel)
    {
        return channels.indexOf(channel);
    }

    /**
     * Sets all of the channels from a given list.
     * All current channels are removed.
     * 
     * @param channels the channels to set.
     */
    public void setChannels(String[] channels)
    {
        this.channels = new ArrayList<String>(Arrays.asList(channels));
    }

    /**
     * Sets all of the channels from a given list.
     * All current channels are removed.
     * 
     * @param channels the channels to set.
     */
    public void setChannels(ArrayList<String> channels)
    {
        this.channels = channels;
    }

    /**
     * Adds a channel to the list of available channels.
     * 
     * @param channelName the new channel
     */
    public void subscribeToChannel(String channelName)
    {
        channels.add(channelName);
    }

    /**
     * Removes a channel from the list of available channels.
     * 
     * @param channelName the channel to remove
     */
    public void unsubscribeFromChannel(String channelName)
    {
        channels.remove(channelName);
    }

    /**
     * Checks if a given channel is in the channel list
     * 
     * @param channelName the channel for which to search
     * @return true if the channel is found. false otherwise
     */
    public boolean hasChannel(String channelName)
    {
        return channels.contains(channelName);
    }
}
