/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.HAL;
import frc.robot.subsystems.LimelightSubsystem;

public class TurretAlignLime extends Command {
  private static final double kP = 1;
 
  public TurretAlignLime() {
    requires(HAL.turret);
  }
  
  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    double xOffset = HAL.limelight.xOffset();
    double power = kP * ((xOffset - 7)/27);
    double nopower = 0;
    if (HAL.limelight.hasTargets())
    {
      HAL.turret.setSpeed(power);
    }
    else
    {
      HAL.turret.setSpeed(nopower);
    }

  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
    //HAL.limelight.setPipeline(8);
  }
}
