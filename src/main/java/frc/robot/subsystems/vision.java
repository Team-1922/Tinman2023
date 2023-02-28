// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.function.BooleanSupplier;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class vision extends SubsystemBase {
  /** Creates a new vision. */
  boolean m_CubeSpotted;
  boolean m_ApriltagSpotted;
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");

  double x = tx.getDouble(0.0);
  double y = ty.getDouble(0.0);
  double area = ta.getDouble(0.0);


  public vision() {
    SmartDashboard.putNumber("LimelightX", x);
    SmartDashboard.putNumber("LimelightY", y);
    SmartDashboard.putNumber("LimelightArea", area);
  }

  public boolean detectCube(boolean cubeFound) {
    cubeFound = false;
    return cubeFound;
  }

  public boolean detectApriltag(boolean apriltagFound) {
    apriltagFound = false;
    return apriltagFound;
  }

  @Override
  public void periodic() {
    detectCube(m_CubeSpotted);
    detectApriltag(m_ApriltagSpotted);
    // This method will be called once per scheduler run
    //putting a loop here would probably cause multiple problems, so a boolean supplier would work best
  }
}
