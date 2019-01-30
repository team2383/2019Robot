/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.NetworkButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.XboxController;



import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.DoubleUnaryOperator;

import frc.robot.ninjaLib.Gamepad;


import frc.robot.subsystems.feedBallSubsytem;;

      
/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
  
  
	
	
  //// CREATING BUTTONS
  // One type of button is a joystick button which is any button on a
  //// joystick.
  // You create one by telling it which joystick it's on and which button
  // number it is.
  public static Gamepad driver = new Gamepad(0);
  
  public static DoubleSupplier turn = () -> (-driver.getRightX());
  public static DoubleSupplier throttle = () -> (driver.getLeftY());

  public static Button feedOn = new JoystickButton(driver,Gamepad.BUTTON_A);
  public static Button feedOff = new JoystickButton(driver,Gamepad.BUTTON_B);

  public static Joystick turtleFront = new Joystick(1);
  public static Joystick turtleBack = new Joystick(2);

  public static DoubleSupplier tail = () -> (turtleBack.getY());
  public static DoubleSupplier intake = () -> (turtleFront.getY());


  

  // There are a few additional built in buttons you can use. Additionally,
  // by subclassing Button you can create custom triggers and bind those to
  // commands the same as any other Button.

  //// TRIGGERING COMMANDS WITH BUTTONS
  // Once you have a button, it's trivial to bind it to a button in one of
  // three ways:
  
  // Start the command when the button is pressed and let it run the command
  // until it is finished as determined by it's isFinished method.
  
  private feedBallSubsytem feed = new feedBallSubsytem();
  public OI() {
  feedOff.whileHeld(feed.setStateCommand(feedBallSubsytem.State.STOP));
  feedOn.whileHeld(feed.setStateCommand(feedBallSubsytem.State.FEED));


  }
  
  
  // Run the command while the button is being held down and interrupt it once
  // the button is released.
  //button.whileHeld(new ExampleCommand());

  // Start the command when the button is released and let it run the command
  // until it is finished as determined by it's isFinished method.
  // button.whenReleased(new ExampleCommand());
}
