// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import com.ctre.phoenix.led.Animation;
import com.ctre.phoenix.led.LarsonAnimation;
import com.ctre.phoenix.led.LarsonAnimation.BounceMode;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.LightEmittingDiode;

public class LedCoolAnimation extends CommandBase {
  Animation m_animationOne = new LarsonAnimation(255, 255, 0, 0, 0,40, BounceMode.Back, 1, 0);
  Animation m_animationTwo = new LarsonAnimation(255,255, 0, 0, 0, 30, BounceMode.Back, 1, 40);
  LightEmittingDiode m_LED = new LightEmittingDiode();
  /** Creates a new LedCoolAnimation. */
  public LedCoolAnimation(LightEmittingDiode LED) {
m_LED = LED;
addRequirements(LED);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_LED.LedAnimate(null, 0);
    m_LED.LedAnimate(null, 1);
    m_LED.LedAnimate(null, 2);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    m_LED.LedAnimate(m_animationOne, 1);
    m_LED.LedAnimate(m_animationTwo, 2);
  } 

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
 
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
