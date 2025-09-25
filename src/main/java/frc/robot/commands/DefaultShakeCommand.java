package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandGenericHID;

import java.util.function.Supplier;

import frc.robot.Constants.ShakeConstants;
import frc.robot.subsystems.ShakeSubsystem;


public class DefaultShakeCommand extends Command {

        private final ShakeSubsystem m_shake;
        private final CommandGenericHID m_joystick;
        private final double m_speed;
        private double yDirection;

    public DefaultShakeCommand(ShakeSubsystem shake, CommandGenericHID joystick, double speed) {


        m_shake = shake;
        addRequirements(m_shake);

        m_joystick = joystick;

        m_speed = speed;

        yDirection = m_joystick.getRawAxis(1);

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {

        // if (yDirection < 0.5 && yDirection > -0.5)
        //     m_shake.stopBottomLevelMotors();


        // else if (yDirection > 0.5) {
        //     m_shake.setBottomLevelMotors(m_speed);
        //     }
            
        // else if (yDirection < -0.5) {
        //     m_shake.setBottomLevelMotors(-m_speed);
        // }

        m_shake.setBottomLevelMotors(m_joystick.getRawAxis(1) * m_speed);
 
        // if (m_speed == Speed.MEDIUM_SPEED) {
        //     if (m_joystick.getRawAxis(0) == 1.0) {
        //         m_shake.setTopLevelMotors(ShakeConstants.MEDIUM_SPEED);
        //     }

        //     if (m_joystick.getRawAxis(0) == 1.0 && m_joystick.getRawAxis(1) == 1.0) {
        //         m_shake.setTopLevelMotors(ShakeConstants.MEDIUM_SPEED);
        //         m_shake.setBottomLevelMotors(ShakeConstants.MEDIUM_SPEED);
        //     }

        //     if (m_joystick.getRawAxis(1) == 1.0) {
        //         m_shake.setBottomLevelMotors(ShakeConstants.MEDIUM_SPEED);
        //     }
        //     if (m_joystick.getRawAxis(0) == -1.0 && m_joystick.getRawAxis(1) == 1.0) {
        //         m_shake.setTopLevelMotors(-ShakeConstants.MEDIUM_SPEED);
        //         m_shake.setBottomLevelMotors(ShakeConstants.MEDIUM_SPEED);
        //     }
        //     if (m_joystick.getRawAxis(0) == -1.0) {
        //         m_shake.setTopLevelMotors(-ShakeConstants.MEDIUM_SPEED);
        //     }
        //     if (m_joystick.getRawAxis(0) == -1.0 && m_joystick.getRawAxis(1) == -1.0) {
        //         m_shake.setTopLevelMotors(-ShakeConstants.MEDIUM_SPEED);
        //         m_shake.setBottomLevelMotors(-ShakeConstants.MEDIUM_SPEED);
        //     }
        //     if (m_joystick.getRawAxis(1) == -1.0) {
        //         m_shake.setBottomLevelMotors(-ShakeConstants.MEDIUM_SPEED);
        //     }
        //     if (m_joystick.getRawAxis(0) == 1.0 && m_joystick.getRawAxis(1) == -1.0) {
        //         m_shake.setTopLevelMotors(ShakeConstants.MEDIUM_SPEED);
        //         m_shake.setBottomLevelMotors(-ShakeConstants.MEDIUM_SPEED);
        //     }
        // }

        // if (m_speed == Speed.HIGH_SPEED) {
        //     if (m_joystick.getRawAxis(0) == 1.0) {
        //         m_shake.setTopLevelMotors(ShakeConstants.HIGH_SPEED);
        //     }

        //     if (m_joystick.getRawAxis(0) == 1.0 && m_joystick.getRawAxis(1) == 1.0) {
        //         m_shake.setTopLevelMotors(ShakeConstants.HIGH_SPEED);
        //         m_shake.setBottomLevelMotors(ShakeConstants.HIGH_SPEED);
        //     }

        //     if (m_joystick.getRawAxis(1) == 1.0) {
        //         m_shake.setBottomLevelMotors(ShakeConstants.HIGH_SPEED);
        //     }
        //     if (m_joystick.getRawAxis(0) == -1.0 && m_joystick.getRawAxis(1) == 1.0) {
        //         m_shake.setTopLevelMotors(-ShakeConstants.HIGH_SPEED);
        //         m_shake.setBottomLevelMotors(ShakeConstants.HIGH_SPEED);
        //     }
        //     if (m_joystick.getRawAxis(0) == -1.0) {
        //         m_shake.setTopLevelMotors(-ShakeConstants.HIGH_SPEED);
        //     }
        //     if (m_joystick.getRawAxis(0) == -1.0 && m_joystick.getRawAxis(1) == -1.0) {
        //         m_shake.setTopLevelMotors(-ShakeConstants.HIGH_SPEED);
        //         m_shake.setBottomLevelMotors(-ShakeConstants.HIGH_SPEED);
        //     }
        //     if (m_joystick.getRawAxis(1) == -1.0) {
        //         m_shake.setBottomLevelMotors(-ShakeConstants.HIGH_SPEED);
        //     }
        //     if (m_joystick.getRawAxis(0) == 1.0 && m_joystick.getRawAxis(1) == -1.0) {
        //         m_shake.setTopLevelMotors(ShakeConstants.HIGH_SPEED);
        //         m_shake.setBottomLevelMotors(-ShakeConstants.HIGH_SPEED);
        //     }
        // }

    }

    @Override
    public void end(boolean interrupted) {
    }

    @Override
    public boolean isFinished() {
        return false;
    }

    @Override
    public boolean runsWhenDisabled() {
        return false;
    }
} 
