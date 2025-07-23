package frc.robot.subsystems;


import frc.robot.Constants.ShakeConstants;
import frc.robot.commands.*;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.Follower;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShakeSubsystem extends SubsystemBase {
private final TalonFX topLevelShakePrimaryMotor;
private final TalonFX bottomLevelShakePrimaryMotor;
private final TalonFXConfiguration config;

    public ShakeSubsystem() {

        topLevelShakePrimaryMotor = new TalonFX(ShakeConstants.topLevelShakePrimaryMotorID);
        bottomLevelShakePrimaryMotor = new TalonFX(ShakeConstants.bottomLevelShakePrimaryMotorID);
        config = new TalonFXConfiguration();

        config.MotorOutput.Inverted = InvertedValue.CounterClockwise_Positive;

        config.MotorOutput.NeutralMode = NeutralModeValue.Brake;

        topLevelShakePrimaryMotor.getConfigurator().apply(config);
        bottomLevelShakePrimaryMotor.getConfigurator().apply(config);
    }

    public void setTopLevelMotors(double speed) {
        topLevelShakePrimaryMotor.set(speed);
    }

    public void setBottomLevelMotors(double speed) {
        bottomLevelShakePrimaryMotor.set(speed);
    }

    public void stopTopLevelMotors() {
        topLevelShakePrimaryMotor.stopMotor();
    }

    public void stopBottomLevelMotors() {
        bottomLevelShakePrimaryMotor.stopMotor();
    }

}