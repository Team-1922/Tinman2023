// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autocommands;

import edu.wpi.first.math.MathUtil;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.PIDCommand;
import frc.robot.subsystems.DriveTrainSubsystem;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoBalance extends PIDCommand {
  /** Creates a new AutoBalance. */
  private DriveTrainSubsystem m_driveTrain; 





  public AutoBalance(DriveTrainSubsystem driveTrain) {
    super(
        // The controller that the command will use
        new PIDController(55.0, .0, 5.0), 
        // This should return the measurement
        () -> driveTrain.robotPitch() + .6,
        // This should return the setpoint (can also be a constant)
        0,
        // This uses the output
        output -> {
          // Use the output here
          SmartDashboard.putNumber("output", output);
          driveTrain.velocityDrive(MathUtil.clamp((-output*2), -2000, 2000), MathUtil.clamp((-output*2), -2000, 2000)); // Pitch down is pos, wheels need to go same sign as pitch
        });

        m_driveTrain = driveTrain;
    // Use addRequirements() here to declare subsystem dependencies.
        addRequirements(m_driveTrain);
    // Configure additional PID options by calling `getController` here.
    getController().setTolerance(2); //this is the angular range (deg) that it is okay stopping in, also waiting until testing
    getController().enableContinuousInput(-180, 180);

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(getController().atSetpoint()){
      m_driveTrain.startBalance();
    }
    return (getController().atSetpoint() && m_driveTrain.balanceTimer(2)); 
  }

}
