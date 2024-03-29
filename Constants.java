package frc.robot;

import edu.wpi.first.math.geometry.Translation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;

public final class Constants {
  public static final class OIConstants {
    public static final int kDriverControllerPort = 0;

    public static final int kDriverYAxis = 1;
    public static final int kDriverXAxis = 0;
    public static final int kDriverRotAxis = 4;
    public static final int kDriverFieldOrientedButtonIdx = 1;

    public static final double kDeadband = 0.05;
  }

  public static class ModuleConstants{
    // 輪子轉向的kP常數
    public static final double kPTurning = 0.2;

    // 輪子單位換算
    public static final double kWheelDiameterMeters = 0.0992;
    public static final double kDriveMotorGearRatio = 1 / 6.12;
    public static final double kTurningMotorGearRatio = 7/150;

    public static final double kDriveEncoderRot2Meter = kDriveMotorGearRatio * Math.PI * kWheelDiameterMeters; // Position
    public static final double kDriveEncoderRot2MeterPerSec = kDriveEncoderRot2Meter / 60; // Velocity
    public static final double kTurningEncoderRot2Rad = kTurningMotorGearRatio * 2 * Math.PI; // Position
    public static final double kTurningEncoderRot2RadPerSec = kTurningEncoderRot2Rad / 60; // Velocity
  }

  public static class DriveConstants{
    // 記得改
    public static final double Length = 60/2.54; // inch
    public static final double Width = 63/2.54;  // inch

    public static final double kPhysicalMaxSpeedMeterPerSecond = 5;

    // 四顆輪子的DriveMotorID
    public static final int kFrontLeftDriveMotorPort = 1;
    public static final int kBackLeftDriveMotorPort = 5;
    public static final int kFrontRightDriveMotorPort = 4;
    public static final int kBackRightDriveMotorPort = 7;

    // 四顆輪子的TurningMotorID
    public static final int kFrontLeftTurningMotorPort = 2;
    public static final int kBackLeftTurningMotorPort = 6;
    public static final int kFrontRightTurningMotorPort = 4;
    public static final int kBackRightTurningMotorPort = 8;

    // 四個輪子的TurningEncoder要不要反轉
    public static final boolean kFrontLeftTurningEncoderReversed = true;
    public static final boolean kBackLeftTurningEncoderReversed = true;
    public static final boolean kFrontRightTurningEncoderReversed = true;
    public static final boolean kBackRightTurningEncoderReversed = true;

    // 四顆輪子的DriveEncoder要不要反轉
    public static final boolean kFrontLeftDriveEncoderReversed = true;
    public static final boolean kBackLeftDriveEncoderReversed = true;
    public static final boolean kFrontRightDriveEncoderReversed = false;
    public static final boolean kBackRightDriveEncoderReversed = false;

    // 四顆輪子的AbsoluteEncoderPort
    public static final int kFrontLeftDriveAbsoluteEncoderPort = 30;
    public static final int kBackLeftDriveAbsoluteEncoderPort = 32;
    public static final int kFrontRightDriveAbsoluteEncoderPort = 31;
    public static final int kBackRightDriveAbsoluteEncoderPort = 33;

    // 四顆輪子的Encoder要不要反轉
    public static final boolean kFrontLeftAbsoluteEncoderReversed = false;
    public static final boolean kBackLeftAbsoluteEncoderReversed = false;
    public static final boolean kFrontRightAbsoluteEncoderReversed = false;
    public static final boolean kBackRightAbsoluteEncoderReversed = false;

    // 四顆輪子AbsoluteEncoder的Offset(要自己調參數)
    public static final double kFrontLeftAbsoluteEncoderOffsetRad = 0;
    public static final double kBackLeftAbsoluteEncoderOffsetRad = 0;
    public static final double kFrontRightAbsoluteEncoderOffsetRad = 0;
    public static final double kBackRightAbsoluteEncoderOffsetRad = 0;

    public static final SwerveDriveKinematics kSwerveKinematics = new SwerveDriveKinematics(
      new Translation2d(Length/2, Width/2),
      new Translation2d(Length/2, -Width/2),
      new Translation2d(-Length/2, Width/2),
      new Translation2d(-Length/2, -Width/2)
    );

    // 調底盤速度
    public static final double kPhysicalMaxSpeedMetersPerSecond = 5;
    
    public static final double kPhysicalMaxAngularSpeedRadiansPerSecond = 2 * 2 * Math.PI;

    public static final double kTeleDriveMaxSpeedMetersPerSecond = kPhysicalMaxSpeedMetersPerSecond / 4;
    public static final double kTeleDriveMaxAngularSpeedRadiansPerSecond = kPhysicalMaxAngularSpeedRadiansPerSecond / 4;
    public static final double kTeleDriveMaxAccelerationUnitsPerSecond = 3;
    public static final double kTeleDriveMaxAngularAccelerationUnitsPerSecond = 3;
  }

  public static class ShooterConstants{
    public static final int kShooterMotorPort = 9;
  }

  public static class IntakeConstants{
    public static final int kIntakeMotorPort = 10;
    public static final int kIntakeCtrlMotorPort = 11;
  }
}
