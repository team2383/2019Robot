/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.Encoder;
import frc.robot.HAL;
import frc.robot.OI;
import frc.robot.RobotMap;
import frc.robot.commands.DriveCommand;
/**
 * Add your docs here.
 */
public class Drivetrain extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.
  DifferentialDrive drive;

  public CANSparkMax rightMaster = new CANSparkMax(RobotMap.RIGHT_MASTER_PORT, MotorType.kBrushless);
  CANSparkMax rightSlave = new CANSparkMax(RobotMap.RIGHT_SLAVE_PORT, MotorType.kBrushless);
  public CANSparkMax leftMaster = new CANSparkMax(RobotMap.LEFT_MASTER_PORT, MotorType.kBrushless);
  CANSparkMax leftSlave = new CANSparkMax(RobotMap.LEFT_SLAVE_PORT, MotorType.kBrushless);

  public Drivetrain (){
    rightSlave.follow(rightMaster);
    leftSlave.follow(leftMaster);
    Encoder.getPosition(rightMaster);
    Encoder.getPosition(leftMaster);
    drive = new DifferentialDrive(leftMaster, rightMaster);

    drive.setSafetyEnabled(false);
  }

  public void arcade(double move, double turn){
    drive.arcadeDrive(move, turn);
  }

  public double getRightPosition() {
    return Encoder.getPosition(rightMaster);
  }

  public double getLeftPosition(){
    return Encoder.getPosition(leftMaster);
  }

  public double getRightVelocity(){
    return Encoder.getVelocity(rightMaster);
  }

  public double getLeftVelocity(){
    return Encoder.getVelocity(leftMaster);
  }

  public void setBrake(boolean brake) {
    if(brake) {
      leftMaster.setIdleMode(CANSparkMax.IdleMode.kBrake);
      leftSlave.setIdleMode(CANSparkMax.IdleMode.kBrake);
      rightMaster.setIdleMode(CANSparkMax.IdleMode.kBrake);
      rightSlave.setIdleMode(CANSparkMax.IdleMode.kBrake);
    } else {
      leftMaster.setIdleMode(CANSparkMax.IdleMode.kCoast);
      leftSlave.setIdleMode(CANSparkMax.IdleMode.kCoast);
      rightMaster.setIdleMode(CANSparkMax.IdleMode.kCoast);
      rightSlave.setIdleMode(CANSparkMax.IdleMode.kCoast);
    }
  }

  public void moveFoward(int speed, int timeout){
    rightMaster.set(speed);
    rightMaster.setCANTimeout(timeout);
  }

  public void followLimeLight()
  {
      leftMaster.set(-HAL.limelight.xOffset()/108);
      rightMaster.set(-HAL.limelight.xOffset()/108);
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    setDefaultCommand(new DriveCommand(OI.throttle,OI.turn));
    
  }
}
