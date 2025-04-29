package frc.robot.commands;
import edu.wpi.first.wpilibj2.command.Command;
import java.util.function.DoubleSupplier;

import frc.robot.subsystems.ShakeSubsystem;


public class Shake extends Command {

        private final ShakeSubsystem m_shakeSubsystem;


    public Shake(ShakeSubsystem subsystem) {


        m_shakeSubsystem = subsystem;
        addRequirements(m_shakeSubsystem);

    }

    @Override
    public void initialize() {
    }

    @Override
    public void execute() {
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
