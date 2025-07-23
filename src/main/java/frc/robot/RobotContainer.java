package frc.robot;

import frc.robot.Constants.ShakeConstants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.networktables.GenericEntry;
import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.shuffleboard.BuiltInWidgets;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.shuffleboard.ShuffleboardTab;
import edu.wpi.first.wpilibj2.command.button.CommandGenericHID;

public class RobotContainer {

  private static RobotContainer m_robotContainer = new RobotContainer();
  public final ShakeSubsystem m_shakeSubsystem = new ShakeSubsystem();

// Joysticks
  CommandGenericHID joystick = new CommandGenericHID(ShakeConstants.kJoystickPort);

  private final GenericEntry[] speeds = new GenericEntry[3];
  private static final boolean[] speedBoolean = {true, false, false};

  public static Speed speed = Speed.LOW_SPEED;
  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
    // Smartdashboard Subsystems
    // Configure the button bindings
    configureButtonBindings();
    m_shakeSubsystem.setDefaultCommand(new DefaultShakeCommand(m_shakeSubsystem, joystick, () -> speed));
    setUpShakerTab();
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {}

  private void setUpShakerTab() {

     ShuffleboardTab shakerTab = Shuffleboard.getTab("Shaker Tab");

     speeds[0] = shakerTab.add("low", true)
     .withWidget(BuiltInWidgets.kToggleButton)
     .withSize(3, 2)
     .withPosition(1, 0)
     .getEntry();

     speeds[1] = shakerTab.add("medium", false)
     .withWidget(BuiltInWidgets.kToggleButton)
     .withSize(3, 2)
     .withPosition(4, 0)
     .getEntry();

     speeds[2] = shakerTab.add("high", false)
     .withWidget(BuiltInWidgets.kToggleButton)
     .withSize(3, 2)
     .withPosition(7, 0)
     .getEntry();

  }

  public void updateShakerTab() {
    
    for (int i = 0; i < 3; i++) {
      if (speeds[i].getBoolean(false) != speedBoolean[i] & speeds[i].getBoolean(false)) {
          speeds[0].setBoolean(false);
          speedBoolean[0] = false;
          speeds[1].setBoolean(false);
          speedBoolean[1] = false;
          speeds[2].setBoolean(false);
          speedBoolean[2] = false;
          speeds[i].setBoolean(true);
          speedBoolean[i] = true;
      } else if (speeds[i].getBoolean(false) != speedBoolean[i]) {
          speedBoolean[i] = false;
      }
    }

    // Should actually decide speed depending on what button is active
    // (decidSpeed the method wasn't actually used before adding this)
    decideSpeed();

  }

  public void decideSpeed() {

    speed = Speed.LOW_SPEED;

    if (speedBoolean[0]) {
      speed = Speed.LOW_SPEED;
    } else if (speedBoolean[1]) {
      speed = Speed.MEDIUM_SPEED;
    } else if (speedBoolean[2]) {
      speed = Speed.HIGH_SPEED;
    }

  }

  // private void setSpeed(int num) {

  //   for (int i = 0; i < speedBoolean.length; i++) {
  //     speedBoolean[i] = false;
  //   }

  //   speedBoolean[num] = true;

  // }
  
  public enum Speed {
    LOW_SPEED,
    MEDIUM_SPEED,
    HIGH_SPEED
  }

}

