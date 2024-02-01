package frc.robot.commands;

import java.util.function.Supplier;

import edu.wpi.first.math.filter.SlewRateLimiter;
import edu.wpi.first.wpilibj2.command.Command;
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

        xLimiter = new SlewRateLimiter(3);
        yLimiter = new SlewRateLimiter(3);
        rotLimiter = new SlewRateLimiter(3);
        
        addRequirements(swerveSubsystem);
    }
}
