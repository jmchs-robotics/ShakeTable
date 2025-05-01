package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandGenericHID;

import java.util.function.DoubleSupplier;

import frc.robot.subsystems.ShakeSubsystem;


public class DefaultShakeCommand extends Command {

        private final ShakeSubsystem m_shake;
        private final CommandGenericHID m_joystick;

    public DefaultShakeCommand(ShakeSubsystem shake, CommandGenericHID joystick) {


        m_shake = shake;
        addRequirements(m_shake);

        m_joystick = joystick;

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {

        if (m_joystick.getRawAxis(0) == 1.0) {
            m_shake.setTopLevelMotors(0.2);
        }

        if (m_joystick.getRawAxis(0) == 1.0 && m_joystick.getRawAxis(1) == 1.0) {
            m_shake.setTopLevelMotors(0.2);
            m_shake.setBottomLevelMotors(0.2);
        }

        if (m_joystick.getRawAxis(1) == 1.0) {
            m_shake.setBottomLevelMotors(0.2);
        }
        if (m_joystick.getRawAxis(0) == -1.0 && m_joystick.getRawAxis(1) == 1.0) {
            m_shake.setTopLevelMotors(-0.2);
            m_shake.setBottomLevelMotors(0.2);
        }
        if (m_joystick.getRawAxis(0) == -1.0) {
            m_shake.setTopLevelMotors(-0.2);
        }
        if (m_joystick.getRawAxis(0) == -1.0 && m_joystick.getRawAxis(1) == -1.0) {
            m_shake.setTopLevelMotors(-0.2);
            m_shake.setBottomLevelMotors(-0.2);
        }
        if (m_joystick.getRawAxis(1) == -1.0) {
            m_shake.setBottomLevelMotors(-0.2);
        }
        if (m_joystick.getRawAxis(0) == 1.0 && m_joystick.getRawAxis(1) == -1.0) {
            m_shake.setTopLevelMotors(0.2);
            m_shake.setBottomLevelMotors(-0.2);
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
