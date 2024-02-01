package frc.robot.subsystems;

import com.ctre.phoenix6.hardware.CANcoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import frc.robot.Constants;

public class SwerveModule {
    private final CANSparkMax driveMotor;
    private final CANSparkMax turningMotor;

    private final RelativeEncoder driveEncoder;
    private final RelativeEncoder turningEncoder;
    
    private final PIDController turningPIDController; //PID控制器

    private final CANcoder cancoder;

    private final boolean absoluteEncoderReversed;
    private final double absoluteEncoderOffsetRad; //Radians

    public SwerveModule(int driveMotorID, int turningMotorID, boolean driveMotorReversed, boolean turningMotorReversed,
     int absoluteEncoderID, double absoluteEncoderOffset, boolean absoluteEncoderReversed){
        driveMotor = new CANSparkMax(driveMotorID, MotorType.kBrushless);
        turningMotor = new CANSparkMax(turningMotorID, MotorType.kBrushless);

        this.absoluteEncoderReversed = absoluteEncoderReversed;
        this.absoluteEncoderOffsetRad = absoluteEncoderOffset;

        driveMotor.setInverted(driveMotorReversed);
        turningMotor.setInverted(turningMotorReversed);

        driveEncoder = driveMotor.getEncoder();
        turningEncoder = turningMotor.getEncoder();

        turningPIDController = new PIDController(1, 0, 0);
        turningPIDController.enableContinuousInput(-Math.PI, Math.PI);

        driveEncoder.setPositionConversionFactor(Constants.ModuleConstants.kDriveEncoderRot2Meter);
        driveEncoder.setVelocityConversionFactor(Constants.ModuleConstants.kDriveEncoderRot2MeterPerSec);
        turningEncoder.setPositionConversionFactor(Constants.ModuleConstants.kTurningEncoderRot2Rad);
        turningEncoder.setVelocityConversionFactor(Constants.ModuleConstants.kTurningEncoderRot2RadPerSec);

        cancoder = new CANcoder(absoluteEncoderID);
    }
}
