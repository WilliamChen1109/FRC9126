package frc.robot.subsystems;

import com.ctre.phoenix6.mechanisms.swerve.SwerveDrivetrain.SwerveDriveState;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveDriveKinematics;
import edu.wpi.first.math.kinematics.SwerveDriveOdometry;
import edu.wpi.first.math.kinematics.SwerveModulePosition;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class SwerveSubsystem extends SubsystemBase{
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

    private final AHRS gyro = new AHRS();

    private final SwerveDriveOdometry odometer = new SwerveDriveOdometry(null, null, null);

    public SwerveSubsystem() {
        new Thread(() -> {
            try {
                Thread.sleep(1000);
                zeroHeading();
            } catch (Exception e){

            }
        }).start();
    }

    public void zeroHeading(){
        gyro.reset();
        //gyro.zeroYaw();
    }

    public double getHeading(){
        return Math.IEEEremainder(gyro.getAngle(), 360);
    }

    public Rotation2d getRotation2d(){
        return new Rotation2d(getHeading());
    }

    public Pose2d getPose(){
        return odometer.getPoseMeters();
    }

    public SwerveModulePosition[] getModulePositions(){
        return new SwerveModulePosition[]{
            frontLeft.getPosition(), 
            frontRight.getPosition(),
            backLeft.getPosition(),
            backRight.getPosition()
        };
    }

    public void resetOdometry(Pose2d pose){
        odometer.resetPosition(getRotation2d(), getModulePositions(), pose);
    }

    public void stopModules(){
        frontLeft.stop();
        frontRight.stop();
        backLeft.stop();
        backRight.stop();
    }

    public void setModuleStates(SwerveModuleState[] desireStates){
        SwerveDriveKinematics.desaturateWheelSpeeds(desireStates, 1d); // 會影響到速度上限
        frontLeft.setDesiredState(desireStates[0]);
        frontRight.setDesiredState(desireStates[1]);
        backLeft.setDesiredState(desireStates[2]);
        backRight.setDesiredState(desireStates[3]);
    }

    @Override
    public void periodic(){
        
    }
}
