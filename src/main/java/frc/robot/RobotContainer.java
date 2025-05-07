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
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command.InterruptionBehavior;
import edu.wpi.first.wpilibj2.command.button.CommandGenericHID;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

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
    m_shakeSubsystem.setDefaultCommand(new DefaultShakeCommand(m_shakeSubsystem, joystick, speed));
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
     .withWidget(BuiltInWidgets.kBooleanBox)
     .withSize(2, 2)
     .withPosition(0, 0)
     .getEntry();

     speeds[1] = shakerTab.add("medium", false)
     .withWidget(BuiltInWidgets.kBooleanBox)
     .withSize(2, 2)
     .withPosition(2, 0)
     .getEntry();

     speeds[2] = shakerTab.add("high", false)
     .withWidget(BuiltInWidgets.kBooleanBox)
     .withSize(2, 2)
     .withPosition(4, 0)
     .getEntry();

  }

  public void updateShakerTab() {
    
    for (int i = 0 ; i < 3; i++) {
      if (speedBoolean[i]) {
        speeds[i].setBoolean(true);
      } else {
        speeds[i].setBoolean(false);
      }
    }

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

  public enum Speed {
    LOW_SPEED,
    MEDIUM_SPEED,
    HIGH_SPEED
  }

}

