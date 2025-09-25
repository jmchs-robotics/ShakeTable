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

  public final ShakeSubsystem m_shakeSubsystem = new ShakeSubsystem();

// Joysticks
  CommandGenericHID joystick = new CommandGenericHID(ShakeConstants.kJoystickPort);

  private final GenericEntry[] speeds = new GenericEntry[3];
  private static final boolean[] speedBoolean = {true, false, false};

  public double speed = ShakeConstants.lowSpeed;
  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  public RobotContainer() {
    // Smartdashboard Subsystems
    // Configure the button bindings
    configureButtonBindings();
    m_shakeSubsystem.setDefaultCommand(new DefaultShakeCommand(m_shakeSubsystem, joystick, speed));
    setUpShakerTab();
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

     shakerTab.add("output", toString())
     .withWidget(BuiltInWidgets.kTextView)
     .withSize(1, 1)
     .withPosition(0, 0);

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

    decideSpeed();

  }

  public void decideSpeed() {

    if (speedBoolean[0]) {
      speed = ShakeConstants.lowSpeed;
    } else if (speedBoolean[1]) {
      speed = ShakeConstants.mediumSpeed;
    } else if (speedBoolean[2]) {
      speed = ShakeConstants.highSpeed;
    }

  }

}

