package frc.robot.subsystems;

import frc.robot.Constants;

public class SwerveSubsystem {
    private final SwerveModule frontLeft = new SwerveModule(
            Constants.DriveConstants.kFrontLeftDriveMotorPort,
            Constants.DriveConstants.kFrontLeftTurningMotorPort, 
            Constants.DriveConstants.kFrontLeftDriveEncoderReversed, 
            Constants.DriveConstants.kFrontLeftTurningEncoderReversed, 
            Constants.DriveConstants.kFrontLeftDriveAbsoluteEncoderPort, 
            Constants.DriveConstants.kFrontLeftAbsoluteEncoderOffsetRad,
            Constants.DriveConstants.kFrontLeftAbsoluteEncoderReversed);

    private final SwerveModule frontRight = new SwerveModule(
            Constants.DriveConstants.kFrontRightDriveMotorPort,
            Constants.DriveConstants.kFrontRightTurningMotorPort, 
            Constants.DriveConstants.kFrontRightDriveEncoderReversed, 
            Constants.DriveConstants.kFrontRightTurningEncoderReversed, 
            Constants.DriveConstants.kFrontRightDriveAbsoluteEncoderPort, 
            Constants.DriveConstants.kFrontRightAbsoluteEncoderOffsetRad, 
            Constants.DriveConstants.kFrontRightAbsoluteEncoderReversed);

    private final SwerveModule backLeft = new SwerveModule(
            Constants.DriveConstants.kBackLeftDriveMotorPort,
            Constants.DriveConstants.kBackLeftTurningMotorPort, 
            Constants.DriveConstants.kBackLeftDriveEncoderReversed, 
            Constants.DriveConstants.kBackLeftTurningEncoderReversed, 
            Constants.DriveConstants.kBackLeftDriveAbsoluteEncoderPort, 
            Constants.DriveConstants.kBackLeftAbsoluteEncoderOffsetRad, 
            Constants.DriveConstants.kBackLeftAbsoluteEncoderReversed);

    private final SwerveModule backRight = new SwerveModule(
            Constants.DriveConstants.kBackRightDriveMotorPort,
            Constants.DriveConstants.kBackRightTurningMotorPort, 
            Constants.DriveConstants.kBackRightDriveEncoderReversed, 
            Constants.DriveConstants.kBackRightTurningEncoderReversed, 
            Constants.DriveConstants.kBackRightDriveAbsoluteEncoderPort, 
            Constants.DriveConstants.kBackRightAbsoluteEncoderOffsetRad, 
            Constants.DriveConstants.kBackRightAbsoluteEncoderReversed);
}
