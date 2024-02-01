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
        
        y = yLimiter.calculate(y);
        x = xLimiter.calculate(x);
        rot = rotLimiter.calculate(rot);


    }

    @Override
    public void end(boolean interrupted){
        System.out.println("SwerveDriveJoystickCmd End");
    }

    @Override
    public boolean isFinished(){
        return false;
    }
}
