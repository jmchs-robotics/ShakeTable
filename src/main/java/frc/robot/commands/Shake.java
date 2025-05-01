package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandGenericHID;

import java.util.function.DoubleSupplier;

import frc.robot.subsystems.ShakeSubsystem;


public class Shake extends Command {

        private final ShakeSubsystem m_shake;
        private final String position;

    public Shake(ShakeSubsystem shake, String pos) {


        m_shake = shake;
        addRequirements(m_shake);

        position = pos;

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {

        if (position.equals("up")) {
            m_shake.setTopLevelMotors(0.2);
        }

        if (position.equals("upRight")) {
            m_shake.setTopLevelMotors(0.2);
            m_shake.setBottomLevelMotors(0.2);
        }

        if (position.equals("right")) {
            m_shake.setBottomLevelMotors(0.2);
        }
        if (position.equals("downRight")) {
            m_shake.setTopLevelMotors(-0.2);
            m_shake.setBottomLevelMotors(0.2);
        }
        if (position.equals("down")) {
            m_shake.setTopLevelMotors(-0.2);
        }
        if (position.equals("downLeft")) {
            m_shake.setTopLevelMotors(-0.2);
            m_shake.setBottomLevelMotors(-0.2);
        }
        if (position.equals("left")) {
            m_shake.setBottomLevelMotors(-0.2);
        }
        if (position.equals("upLeft")) {
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
