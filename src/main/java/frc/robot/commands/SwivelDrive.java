// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class SwivelDrive extends CommandBase {
  DriveTrainSubsystem m_driveTrain;
  Joystick m_joystick;
  /** Creates a new SwivelDrive. */
  public SwivelDrive(DriveTrainSubsystem driveTrain, Joystick rightJoystick) {
    m_driveTrain = driveTrain;
    m_joystick = rightJoystick;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(m_driveTrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_driveTrain.velocityDrive(m_joystick.getX()*2000, -m_joystick.getX()*2000);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
