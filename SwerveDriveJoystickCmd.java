package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.math.kinematics.ChassisSpeeds;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants.DriveConstants;
import frc.robot.subsystems.SwerveSubsystem;

public class SwerveDriveJoystickCmd extends Command{
    private final SwerveSubsystem swerveSubsystem;

    private final Supplier<Double> y_spd, x_spd, rot_spd;
    private final Supplier<Boolean> fieldOriented;

    private final SlewRateLimiter xLimiter, yLimiter, rotLimiter;

    // Constructor
    public SwerveDriveJoystickCmd(SwerveSubsystem swerveSubsystem, Supplier<Double> y_spd, Supplier<Double> x_spd, Supplier<Double> rot_spd, Supplier<Boolean> fieldOriented){
        this.swerveSubsystem = swerveSubsystem;

        this.y_spd = y_spd;
        this.x_spd = x_spd;
        this.rot_spd = rot_spd;
        this.fieldOriented = fieldOriented;

        xLimiter = new SlewRateLimiter(3); // m/s
        yLimiter = new SlewRateLimiter(3); // m/s
        rotLimiter = new SlewRateLimiter(3); //rad/s

        addRequirements(swerveSubsystem);
    }

    @Override
    public void initialize() {
        System.out.println("SwerveDriveJoystickCmd Start");
    }

    @Override
    public void execute(){
        double y = y_spd.get();
        double x = x_spd.get();
        double rot = rot_spd.get();
        
        y = Math.abs(y) < 0.01 ? 0 : y;
        x = Math.abs(x) < 0.01 ? 0 : x;
        rot = Math.abs(rot) < 0.01 ? 0 : rot;

        y = yLimiter.calculate(y);
        x = xLimiter.calculate(x);
        rot = rotLimiter.calculate(rot);

        ChassisSpeeds chassisSpeeds;
        if(fieldOriented.get()){
            chassisSpeeds = ChassisSpeeds.fromFieldRelativeSpeeds(x, y, rot, swerveSubsystem.getRotation2d());
        }
        else{
            chassisSpeeds = new ChassisSpeeds(x, y, rot);
        }

        SwerveModuleState[] swerveModuleStates = DriveConstants.kSwerveKinematics.toSwerveModuleStates(chassisSpeeds);
        swerveSubsystem.setModuleStates(swerveModuleStates);
        printMoudleRadOffset();
    }

    @Override
    public void end(boolean interrupted){
        System.out.println("SwerveDriveJoystickCmd End");
    }

    @Override
    public boolean isFinished(){
        return false;
    }

    private void printMoudleRadOffset(){
        System.out.println("FrontLeft: " + swerveSubsystem.getModuleAbsoluteEncoderRad()[0]);
        System.out.println("FrontRight: " + swerveSubsystem.getModuleAbsoluteEncoderRad()[1]);
        System.out.println("BackLeft: " + swerveSubsystem.getModuleAbsoluteEncoderRad()[2]);
        System.out.println("BackRight: " + swerveSubsystem.getModuleAbsoluteEncoderRad()[3]);
    }
}
