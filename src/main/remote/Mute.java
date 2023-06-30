package remote;

import vendors.Television;

/**
 * Remote command to Mute the Television object.
 * 
 * @author Austin Blaylock
 * @version 6.29.23
 */
public class Mute extends Action
{
    private Television tv;

    public Mute(Television tv)
    {
        super("Mute");
        this.tv = tv;
    }

    @Override
    public boolean performAction()
    {
        if (!tv.isOn())
        {
            System.out.println("You need to turn on the tv before you can change the volume.");
            return false;
        }
        else
        {
            tv.muteVolume();
            if (tv.getVolume() > 0)
            {
                System.out.printf("TV unmuted. Now at %d\n", tv.getVolume());
            }
            else if (tv.getVolume() <= 0)
            {
                System.out.printf("TV muted. Now at %d\n", tv.getVolume());
            }
            return true;
        }
    }
}
