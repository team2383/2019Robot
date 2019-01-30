/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.networktables.*;

/**
 * Add your docs here.
 */
public class LimelightSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  private double get(String name) {
    return NetworkTableInstance.getDefault().getTable("limelight").getEntry(name).getDouble(0);
  }

  public boolean hasTargets() {
    return get("tv") > 0;
  }

  public double xOffset() {
    return get("tx");
  }

  public double yOffset() {
    return get("ty");
  }

  public double area() {
    return get("ta");
  }

  public double skew() {
    return get("ts");
  }

  public double latency() {
    return get("tl");
  }

  public double shortSideLength() {
    return get("tshort");
  }

  public double longSideLength() {
    return get("tlong");
  }

  public double horizontalLength() {
    return get("thoriz");
  }

  public double verticalLength() {
    return get("tvert");
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
