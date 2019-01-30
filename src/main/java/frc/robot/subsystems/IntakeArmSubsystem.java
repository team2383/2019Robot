/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.Constants;
import frc.robot.Constants.*;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

/**
 * Add your docs here.
 */
public class IntakeArmSubsystem extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  public TalonSRX feedArm =  new TalonSRX(RobotMap.INTAKE_ARM_PORT);

  
  public enum State{
    RISE,
    FALL,
    STOP,
  }

  public void configMotorController(int timeout){
    feedArm.config_kP(0, Constants.intakeArmP, timeout);
    feedArm.config_kI(0, Constants.intakeArmI, timeout);
    feedArm.config_kD(0, Constants.intakeArmD, timeout);
    feedArm.config_kF(0, Constants.intakeArmF, timeout);
    //feedArm.config_IntegralZone(0, Constants.intakeArmIZone, timeout);

  }

  public int getCurrentPosition() {
    return feedArm.getSelectedSensorPosition(0);
  }

  public void setPosition(int position){
    feedArm.set(ControlMode.MotionMagic, position);
  }

  public void setSpeed(double speed){
    feedArm.set(ControlMode.PercentOutput, speed);
  }

  public void setState(State state) {
		switch (state) {
      case RISE:
      //runs up at 50%
      feedArm.set(ControlMode.PercentOutput, 0.5);
      break;
      case FALL:
      //runs down at 50%
      feedArm.set(ControlMode.PercentOutput, -0.5);
      break;
      default:
      case STOP:
        feedArm.set(ControlMode.PercentOutput,0.0);
        break;
    }
    }
  
  
  
  


  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }
}
