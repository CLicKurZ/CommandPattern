package vendors;

import java.util.ArrayList;
import java.util.Arrays;

public class SecurityCam 
{
    public static final String[] CAM_CHANNELS = {
        "1.1", "1.2", "1.3", "2.1", "2.2", "2.3", 
        "3.1", "3.2", "3.3"
    };

    private ArrayList<String> securityChannels;

    private int maxResolution;

    private int resolution;

    private int currentChannel;

    private boolean isOn;

    public SecurityCam(int maxResolution)
    {
        this.securityChannels = new ArrayList<String>(Arrays.asList(CAM_CHANNELS));
        this.maxResolution = Math.abs(maxResolution);
        this.resolution = 75;
        this.currentChannel = 0;
        this.isOn = false;
    }

    public void power()
    {
        isOn = !isOn;
    }

    public boolean increaseChannel()
    {
        if (isOn && resolution < maxResolution)
        {
            resolution++;
            return true;
        }
        return false;
    }

    public boolean decreaseResolution()
    {
        if (isOn && resolution > 0)
        {
            resolution--;
            return true;
        }
        return false;
    }

    public boolean goToChannel(int channel)
    {
        if (isOn && channel > 0 && channel <= securityChannels.size())
        {
            currentChannel = channel;
            return true;
        }
        return false;
    }

    public String[] getChannels()
    {
        return securityChannels.toArray(new String[securityChannels.size()]);
    }

    public boolean isOn()
    {
        return isOn();
    }

    public int getResolution()
    {
        return resolution;
    }

    public int getMaxResolution()
    {
        return maxResolution;
    }

    public String getCurrentChannel()
    {
        return securityChannels.get(currentChannel);
    }

    public int getCurrentSecurityChannel()
    {
        return currentChannel;
    }

    public int getNumChannels()
    {
        return securityChannels.size();
    }

    public String getChannelAtCurrentChannel(int currentChannel)
    {
        if (currentChannel < 0 || currentChannel >= securityChannels.size())
        {
            return String.format("Station %d not found", currentChannel);
        }
        else
        {
            return securityChannels.get(currentChannel);
        }
    }

    public int getCurrentChannelAtChannel(String channel)
    {
        return securityChannels.indexOf(channel);
    }

    public void setSecurityChannels(String[] channels)
    {
        this.securityChannels = new ArrayList<String>(Arrays.asList(channels));
    }

    public void setSecurityChannels(ArrayList<String> channels)
    {
        this.securityChannels = channels;
    }

    public void addToChannels(String channelName)
    {
        securityChannels.add(channelName);
    }

    public void removeFromChannels(String channelName)
    {
        securityChannels.remove(channelName);
    }

    public boolean hasChannel(String channelName)
    {
        return securityChannels.contains(channelName);
    }
}
