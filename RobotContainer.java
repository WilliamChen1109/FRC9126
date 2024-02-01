package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.SwerveDriveJoystickCmd;
import frc.robot.subsystems.SwerveSubsystem;

public class RobotContainer {
  private final SwerveSubsystem swerveSubsystem = new SwerveSubsystem();

  private final XboxController stick = new XboxController(0);

  public RobotContainer() {
    swerveSubsystem.setDefaultCommand(
      new SwerveDriveJoystickCmd(swerveSubsystem,
        () -> stick.getLeftY(),
        () -> stick.getLeftX(),
        () -> stick.getRightX(),
        () -> !stick.getAButton())
    );
    configureBindings();
  }

  // 按鈕控制
  private void configureBindings() {
    new JoystickButton(stick, Button.kB.value).onTrue(new InstantCommand(() -> swerveSubsystem.zeroHeading()));
  }

  public Command getAutonomousCommand() {
    return null;
  }
}
