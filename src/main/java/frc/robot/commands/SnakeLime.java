package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Constants;
import frc.robot.HAL;
import frc.robot.commands.SwitchPipeline;

public class SnakeLime extends Command {
  boolean kill;
  public SnakeLime() {
    requires(HAL.limelight);
    requires(HAL.drive);
    HAL.limelight.setPipeline(6);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    kill = false;
    
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    
    
    //HAL.limelight.setPipeline(7);
    double xOffset = HAL.limelight.xOffset();
    double turPos = HAL.turret.getCurrentPosition();
    double area = HAL.limelight.area();
    double minArea = 1.0;
    if(area <= 0.01){
      HAL.limelight.setPipeline(6);
      area = HAL.limelight.area();
    }


    ////////////////////
    // FRONT POSITION //
    ////////////////////
    if (turPos > -6000 && turPos < 6000) {

      /*
      //double drive = area * kDrive;
      double turn = -(xOffset)/27 * kTurn;

      HAL.drive.arcade(-0.5, turn);
      */
      
      // OFFSET NEGATIVE IS TO THE LEFT
      // OFFSET POSITIVE IS TO THE RIGHT
      if((area > 0.001) && (area <= minArea)){
        HAL.drive.arcade(-0.5, -(xOffset+3.25)/27); //xOffset+1.0) //COMP is -2
      }
      
      else if(kill && area <= minArea){
        HAL.drive.leftMaster.set(0.0);
        HAL.drive.rightMaster.set(0.0);
        end();
      }

      else if((area > 0.001) && (area <= 1.0)){
        kill = true;
        HAL.drive.arcade(-0.5, -(xOffset+3.25)/27); //xOffset+1.0) //COMP is -2
      }

      else if ((area > 1.0) && (area <= 1.6)){
        //HAL.turret.turret.set(ControlMode.PercentOutput, ((HAL.limelight.xOffset())/27));
        HAL.drive.leftMaster.set(0.0);
        HAL.drive.rightMaster.set(0.0);
      }

      else {
        HAL.drive.leftMaster.set(0.0);
        HAL.drive.rightMaster.set(0.0);
        
        end();
      }
    } 

    ///////////////////
    // BACK POSITION //
    ///////////////////
    else if ((turPos > 27000 && turPos < 37000) || (turPos < -27000 && turPos > -37000) ) {

      /*(xOffset > 1 || xOffset < -1) && */
      if((area > 0.01) && (area <= minArea)){
        HAL.drive.arcade(0.5, (-xOffset+2)/27); //offset +1
      }

      else if ((area > minArea) && (area <= 1.6)){
        //HAL.turret.turret.set(ControlMode.PercentOutput, ((HAL.limelight.xOffset())/27));
        HAL.drive.leftMaster.set(0.0);
        HAL.drive.rightMaster.set(0.0);
      }
      
      else {
        HAL.drive.leftMaster.set(0.0);
        HAL.drive.rightMaster.set(0.0);
      }
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {

    if(HAL.limelight.area() > 1.0){    /*(xOffset < 1 && xOffset > -1) &&*/
      return true;
    }
    else if((kill == true) && (HAL.limelight.area() <= 1.0)){
      return true;
    }
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
    HAL.limelight.setPipeline(8);
  }
}
