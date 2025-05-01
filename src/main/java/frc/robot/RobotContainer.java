package frc.robot;

import frc.robot.Constants.ShakeConstants;
import frc.robot.commands.*;
import frc.robot.subsystems.*;
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

  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
    // Smartdashboard Subsystems


    // SmartDashboard Buttons
    // SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
    // SmartDashboard.putData("Shake", new Shake( m_shakeSubsystem ));
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands

    // Configure autonomous sendable chooser

    m_chooser.setDefaultOption("Autonomous Command", new AutonomousCommand());

    SmartDashboard.putData("Auto Mode", m_chooser);
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
  private void configureButtonBindings() {

    joystick.povUp().whileTrue(
      new Shake(m_shakeSubsystem, "up")
    );

    joystick.povUpRight().whileTrue(
      new Shake(m_shakeSubsystem, "upRight")
    );

    joystick.povRight().whileTrue(
      new Shake(m_shakeSubsystem, "right")
    );

    joystick.povDownRight().whileTrue(
      new Shake(m_shakeSubsystem, "downRight")
    );

    joystick.povDown().whileTrue(
      new Shake(m_shakeSubsystem, "down")
    );

    joystick.povDownLeft().whileTrue(
      new Shake(m_shakeSubsystem, "downLeft")
    );

    joystick.povLeft().whileTrue(
      new Shake(m_shakeSubsystem, "left")
    );

    joystick.povUpLeft().whileTrue(
      new Shake(m_shakeSubsystem, "upLeft")
    );

  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
  

}

