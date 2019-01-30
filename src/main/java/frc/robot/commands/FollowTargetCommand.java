/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.PIDCommand;
import frc.robot.Constants;
import frc.robot.HAL;

public class FollowTargetCommand extends PIDCommand{
  private final double tolerance;
  private final double wait;
  
  public FollowTargetCommand() {
    super("Set Heading", Constants.kTurret_Motion_turnP, 0.0, Constants.kTurret_Motion_turnD);
    requires(HAL.limelight);
    requires(HAL.turret);
    this.getPIDController().setInputRange(-180, 180);
    this.getPIDController().setOutputRange(-0.5, 0.5);
    this.getPIDController().setContinuous();
    this.getPIDController().setSetpoint(0);
    this.tolerance = 0.5;
		this.wait = 0.5;
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    HAL.turret.initialize();
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if (Math.abs(this.getPIDController().getError()) <= Constants.kTurret_Motion_turnI) {
      Constants.kTurret_Motion_turnP = this.getPIDController().getP();
      Constants.kTurret_Motion_turnI = this.getPIDController().getI();
      Constants.kTurret_Motion_turnD = this.getPIDController().getD();
			this.getPIDController().setPID(Constants.kTurret_Motion_turnP, Constants.kTurret_Motion_turnI, Constants.kTurret_Motion_turnD);
		} else {
      Constants.kTurret_Motion_turnP = this.getPIDController().getP();
      Constants.kTurret_Motion_turnD = this.getPIDController().getD();
			this.getPIDController().setPID(Constants.kTurret_Motion_turnP, 0.0, Constants.kTurret_Motion_turnD);
		}
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }

  @Override
  protected double returnPIDInput() {
    return HAL.limelight.xOffset();
  }

  @Override
  protected void usePIDOutput(double output) {
    HAL.turret.rotate.pidWrite(output);
  }
}
