/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;

  //drive
  public static final int RIGHT_MASTER_PORT = 0;
  public static final int RIGHT_SLAVE_PORT = 1;
  public static final int LEFT_MASTER_PORT = 2;
  public static final int LEFT_SLAVE_PORT = 3;

  //oi
  public static final int JOYSTICK_PORT = 0;

  
  public final static int ULTRA_PING_CHANNEL = 1;
  public final static int ULTRA_ECHO_CHANNEL = 1;
  //TURTLE
  public final static int TURTLE_PORT = 4;
  public final static int TURRET_PORT = 4;
  //Intake

  public final static int INTAKE_BALL_PORT = 6;
  public final static int INTAKE_ARM_PORT = 5;

  

}
