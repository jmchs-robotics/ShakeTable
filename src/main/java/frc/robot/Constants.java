package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public class Constants {

   public static final class ShakeConstants {

    public static final int topLevelShakeMotorID = 1;
    public static final int bottomLevelShakeMotorID = 2;
    public static final int kJoystickPort = 0;
    
    public static final double LOW_SPEED = 0.2;
    public static final double MEDIUM_SPEED = 0.35;
    public static final double HIGH_SPEED = 0.5;

   }
   
}

