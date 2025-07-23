package frc.robot.subsystems;


import frc.robot.Constants.ShakeConstants;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShakeSubsystem extends SubsystemBase {

    private final TalonFX topLevelShakeMotor;
    private final TalonFX bottomLevelShakeMotor;
    private final TalonFXConfiguration config;

    public ShakeSubsystem() {

        topLevelShakeMotor = new TalonFX(ShakeConstants.topLevelShakeMotorID);
        bottomLevelShakeMotor = new TalonFX(ShakeConstants.bottomLevelShakeMotorID);
        config = new TalonFXConfiguration();

        config.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

        config.MotorOutput.NeutralMode = NeutralModeValue.Brake;

        topLevelShakeMotor.getConfigurator().apply(config);
        bottomLevelShakeMotor.getConfigurator().apply(config);

    }

    public void setTopLevelMotors(double speed) {
        topLevelShakeMotor.set(speed);
    }

    public void setBottomLevelMotors(double speed) {
        bottomLevelShakeMotor.set(speed);
    }

    public void stopTopLevelMotors() {
        topLevelShakeMotor.stopMotor();
    }

    public void stopBottomLevelMotors() {
        bottomLevelShakeMotor.stopMotor();
    }

}