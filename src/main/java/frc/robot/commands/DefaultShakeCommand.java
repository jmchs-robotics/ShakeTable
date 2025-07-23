package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandGenericHID;

import java.util.function.Supplier;

import frc.robot.Constants.ShakeConstants;
import frc.robot.RobotContainer.Speed;
import frc.robot.subsystems.ShakeSubsystem;


public class DefaultShakeCommand extends Command {

        private final ShakeSubsystem m_shake;
        private final CommandGenericHID m_joystick;
        private final Speed m_speed;

    public DefaultShakeCommand(ShakeSubsystem shake, CommandGenericHID joystick, Supplier<Speed> speed) {


        m_shake = shake;
        addRequirements(m_shake);

        m_joystick = joystick;

        m_speed = speed.get();

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {

        // You need to actually tell the motors to stop at some point
        // or else they'll keep going forever
        if (m_joystick.getRawAxis(0) < 0.05) {
            m_shake.stopTopLevelMotors();
        }

        if (m_joystick.getRawAxis(1) < 0.05) {
            m_shake.stopBottomLevelMotors();
        }

        if (m_speed == Speed.LOW_SPEED) {
            if (m_joystick.getRawAxis(0) > 0.95) {
                m_shake.setTopLevelMotors(ShakeConstants.LOW_SPEED);
            }

            if (m_joystick.getRawAxis(0) > 0.95 && m_joystick.getRawAxis(1) > 0.95) {
                m_shake.setTopLevelMotors(ShakeConstants.LOW_SPEED);
                m_shake.setBottomLevelMotors(ShakeConstants.LOW_SPEED);
            }

            if (m_joystick.getRawAxis(1) > 0.95) {
                m_shake.setBottomLevelMotors(ShakeConstants.LOW_SPEED);
            }
            if (m_joystick.getRawAxis(0) < -0.95 && m_joystick.getRawAxis(1) > 0.95) {
                m_shake.setTopLevelMotors(-ShakeConstants.LOW_SPEED);
                m_shake.setBottomLevelMotors(ShakeConstants.LOW_SPEED);
            }
            if (m_joystick.getRawAxis(0) < -0.95) {
                m_shake.setTopLevelMotors(-ShakeConstants.LOW_SPEED);
            }
            if (m_joystick.getRawAxis(0) < -0.95 && m_joystick.getRawAxis(1) < -0.95) {
                m_shake.setTopLevelMotors(-ShakeConstants.LOW_SPEED);
                m_shake.setBottomLevelMotors(-ShakeConstants.LOW_SPEED);
            }
            if (m_joystick.getRawAxis(1) < -0.95) {
                m_shake.setBottomLevelMotors(-ShakeConstants.LOW_SPEED);
            }
            if (m_joystick.getRawAxis(0) > 0.95 && m_joystick.getRawAxis(1) < -0.95) {
                m_shake.setTopLevelMotors(ShakeConstants.LOW_SPEED);
                m_shake.setBottomLevelMotors(-ShakeConstants.LOW_SPEED);
            }
        }

        if (m_speed == Speed.MEDIUM_SPEED) {
            if (m_joystick.getRawAxis(0) > 0.95) {
                m_shake.setTopLevelMotors(ShakeConstants.MEDIUM_SPEED);
            }

            if (m_joystick.getRawAxis(0) > 0.95 && m_joystick.getRawAxis(1) > 0.95) {
                m_shake.setTopLevelMotors(ShakeConstants.MEDIUM_SPEED);
                m_shake.setBottomLevelMotors(ShakeConstants.MEDIUM_SPEED);
            }

            if (m_joystick.getRawAxis(1) > 0.95) {
                m_shake.setBottomLevelMotors(ShakeConstants.MEDIUM_SPEED);
            }
            if (m_joystick.getRawAxis(0) < -0.95 && m_joystick.getRawAxis(1) > 0.95) {
                m_shake.setTopLevelMotors(-ShakeConstants.MEDIUM_SPEED);
                m_shake.setBottomLevelMotors(ShakeConstants.MEDIUM_SPEED);
            }
            if (m_joystick.getRawAxis(0) < -0.95) {
                m_shake.setTopLevelMotors(-ShakeConstants.MEDIUM_SPEED);
            }
            if (m_joystick.getRawAxis(0) < -0.95 && m_joystick.getRawAxis(1) < -0.95) {
                m_shake.setTopLevelMotors(-ShakeConstants.MEDIUM_SPEED);
                m_shake.setBottomLevelMotors(-ShakeConstants.MEDIUM_SPEED);
            }
            if (m_joystick.getRawAxis(1) < -0.95) {
                m_shake.setBottomLevelMotors(-ShakeConstants.MEDIUM_SPEED);
            }
            if (m_joystick.getRawAxis(0) > 0.95 && m_joystick.getRawAxis(1) < -0.95) {
                m_shake.setTopLevelMotors(ShakeConstants.MEDIUM_SPEED);
                m_shake.setBottomLevelMotors(-ShakeConstants.MEDIUM_SPEED);
            }
        }

        if (m_speed == Speed.HIGH_SPEED) {
            if (m_joystick.getRawAxis(0) > 0.95) {
                m_shake.setTopLevelMotors(ShakeConstants.HIGH_SPEED);
            }

            if (m_joystick.getRawAxis(0) > 0.95 && m_joystick.getRawAxis(1) > 0.95) {
                m_shake.setTopLevelMotors(ShakeConstants.HIGH_SPEED);
                m_shake.setBottomLevelMotors(ShakeConstants.HIGH_SPEED);
            }

            if (m_joystick.getRawAxis(1) > 0.95) {
                m_shake.setBottomLevelMotors(ShakeConstants.HIGH_SPEED);
            }
            if (m_joystick.getRawAxis(0) < -0.95 && m_joystick.getRawAxis(1) > 0.95) {
                m_shake.setTopLevelMotors(-ShakeConstants.HIGH_SPEED);
                m_shake.setBottomLevelMotors(ShakeConstants.HIGH_SPEED);
            }
            if (m_joystick.getRawAxis(0) < -0.95) {
                m_shake.setTopLevelMotors(-ShakeConstants.HIGH_SPEED);
            }
            if (m_joystick.getRawAxis(0) < -0.95 && m_joystick.getRawAxis(1) < -0.95) {
                m_shake.setTopLevelMotors(-ShakeConstants.HIGH_SPEED);
                m_shake.setBottomLevelMotors(-ShakeConstants.HIGH_SPEED);
            }
            if (m_joystick.getRawAxis(1) < -0.95) {
                m_shake.setBottomLevelMotors(-ShakeConstants.HIGH_SPEED);
            }
            if (m_joystick.getRawAxis(0) > 0.95 && m_joystick.getRawAxis(1) < -0.95) {
                m_shake.setTopLevelMotors(ShakeConstants.HIGH_SPEED);
                m_shake.setBottomLevelMotors(-ShakeConstants.HIGH_SPEED);
            }
        }

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
