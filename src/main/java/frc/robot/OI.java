package frc.robot;

import edu.wpi.first.wpilibj.Joystick;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import java.util.function.DoubleSupplier;

import frc.robot.commands.SetFrontClimber;

import frc.robot.commands.*;
import frc.robot.ninjaLib.Gamepad;
import frc.robot.subsystems.*;
import frc.robot.ninjaLib.CustomButton;
import frc.robot.ninjaLib.ButtonBoard;
import frc.robot.ninjaLib.ButtonBoard.Direction;
  
import frc.robot.HAL;
import static frc.robot.HAL.ballFeed;
import static frc.robot.HAL.hatchGroundIntake;


public class OI {
 
  /////////////////////
  // XBOX CONTROLLER //
  /////////////////////

  public static Gamepad driver = new Gamepad(0);
  public static Gamepad vision = new Gamepad(4);
  
  // DRIVE
  public static DoubleSupplier turn = () -> (0.7 * -driver.getRightX());
  public static DoubleSupplier throttle = () -> (0.9 * driver.getLeftY());

  // BALL INTAKE
  public static Button ballFeedIn = new JoystickButton(driver,Gamepad.BUTTON_SHOULDER_RIGHT);
  public static Button ballFeedOut = new JoystickButton(driver,Gamepad.BUTTON_SHOULDER_LEFT);

  // GROUND HATCH INTAKE
  public static Button groundHatchFeedIn = new JoystickButton(driver, Gamepad.BUTTON_A);
  public static Button groundHatchFeedOut = new JoystickButton(driver, Gamepad.BUTTON_B);

  // VISION
  public static Button visionLow = new JoystickButton(driver, Gamepad.BUTTON_X);
  public static Button visionMidHigh = new JoystickButton(driver, Gamepad.BUTTON_Y);

  //public static Button switchPipeline = new JoystickButton(driver, Gamepad.BUTTON_X);
  //public static Button trackPipeline = new JoystickButton(driver, Gamepad.BUTTON_Y);
  //public static Button drivePipeline = new JoystickButton(driver, Gamepad.BUTTON_X);
  //public static Button visionFoward = new JoystickButton(driver, Gamepad.BUTTON_A);
  //public static Button turretAllign = new JoystickButton(driver, Gamepad.BUTTON_B);
  //public static Button travel = new JoystickButton(driver,Gamepad.BUTTON_X);
  //public static Button driveAllign = new JoystickButton(vision, Gamepad.BUTTON_X);
  //public static Button tracking = new JoystickButton(driver, Gamepad.BUTTON_Y);

  
  /////////////////
  // BUTTONBOARD //
  /////////////////

  public static ButtonBoard buttonBoardA = new ButtonBoard(1);
  public static ButtonBoard buttonBoardB = new ButtonBoard(2);

  

  ////////////////////////////
  // OLD LAMBDA BUTTONBOARD //
  ////////////////////////////
  
  // Button ballFeedGround = new JoystickButton(buttonBoardA, 4);

  // Button hatchFeederStation = new JoystickButton(buttonBoardB, 5);
  // Button ballFeederStation = new JoystickButton(buttonBoardB, 6);

  // Button lowBallRocket = new JoystickButton(buttonBoardA, 1);
  // Button midBallRocket = new JoystickButton(buttonBoardA, 2);
  // Button highBallRocket = new JoystickButton(buttonBoardA, 3);

  // Button lowHatchRocket = new JoystickButton(buttonBoardB, 2);
  // Button midHatchRocket = new JoystickButton(buttonBoardB, 3);
  // Button highHatchRocket = new JoystickButton(buttonBoardB, 4);
  
  // Button travelPosition = new JoystickButton(buttonBoardB, 1);
  // Button hatchGrab = new JoystickButton(buttonBoardA,5);
  // Button hatchRelease = new JoystickButton(buttonBoardA, 6);

  // Button turretFront = new JoystickButton(buttonBoardA, 8);
  // Button turretBack = new JoystickButton(buttonBoardA, 9);

  // Button frontClimbHome = new JoystickButton(buttonBoardB, 7);
  // Button frontClimbPass = new JoystickButton(buttonBoardB,8);
  // Button frontClimbGround = new JoystickButton(buttonBoardB, 9);

  // Button cargoshipBall = new JoystickButton(buttonBoardA, 7);
  // Button climbAuto = new JoystickButton(buttonBoardA, 10);

  // Button transfer = new JoystickButton(buttonBoardB, 10);
      
  //////////////////////////////
  // NEW SCORPION BUTTONBOARD //
  //////////////////////////////
  //visionTurret
  public static Button hatchFeederStation = new JoystickButton(buttonBoardA, 10);
  public static Button visionTurret = new JoystickButton(buttonBoardA, 9);

  Button ballFeedGround = new JoystickButton(buttonBoardA, 1);

  Button lowBallRocketStag = new JoystickButton(buttonBoardB, 3);
  Button midBallRocketStag = new JoystickButton(buttonBoardB, 6);
  Button highBallRocketStag = new JoystickButton(buttonBoardB, 5);

  Button lowHatchRocketStag = new JoystickButton(buttonBoardB, 7);
  Button midHatchRocketStag = new JoystickButton(buttonBoardB, 11);
  Button highHatchRocketStag = new JoystickButton(buttonBoardB, 12);
  
  Button cargoshipBallStag = new JoystickButton(buttonBoardB, 8);
  Button cargoshipHatchStag = new JoystickButton(buttonBoardA, 9);
  

  Button travelPosition = new JoystickButton(buttonBoardA, 12);
  Button hatchGrab = new JoystickButton(buttonBoardA, 11);
  Button hatchRelease = new JoystickButton(buttonBoardA, 2);

  Button turretFront = new JoystickButton(buttonBoardA, 7);
  Button turretBack = new JoystickButton(buttonBoardA, 8);
  Button turretRight = new JoystickButton(buttonBoardA, 6);
  Button turretLeft = new JoystickButton(buttonBoardA, 5);
  
  // Button turretRocketRightBack = new JoystickButton(buttonBoardB, 9);

  Button frontClimbHome = new JoystickButton(buttonBoardA, 3);
  Button frontClimbPassLvl_3 = new JoystickButton(buttonBoardB, 2); //should be B2
  Button frontClimbPassLvl_2 = new JoystickButton(buttonBoardB, 9); //should be B2

  // Button frontClimbGround = new JoystickButton(buttonBoardA, 2);

  
  Button climbAutoLvl_3 = new JoystickButton(buttonBoardB, 4);
  Button climbAutoLvl_2 = new JoystickButton(buttonBoardB, 10);
  Button climbStop = new JoystickButton(buttonBoardB, 1);

  Button turretZero = new JoystickButton(buttonBoardA, 4); //should be A4
  
    Button anyTurret = new CustomButton(() -> {
      return turretFront.get() || turretBack.get() || turretRight.get() || turretLeft.get();
    });

  ///////////////////
  // BUTONBOARD V1 //
  ///////////////////

  // Button ballFeedGround = new JoystickButton(buttonBoardA, 1);
 
  // Button lowBallRocketStag = new JoystickButton(buttonBoardB, 3);
  // Button midBallRocketStag = new JoystickButton(buttonBoardB, 6);
  // Button highBallRocketStag = new JoystickButton(buttonBoardB, 5);

  // Button lowHatchRocketStag = new JoystickButton(buttonBoardB, 7);
  // Button midHatchRocketStag = new JoystickButton(buttonBoardB, 11);
  // Button highHatchRocketStag = new JoystickButton(buttonBoardB, 12);
  
  // Button cargoshipBallStag = new JoystickButton(buttonBoardB, 8);

  // Button travelPosition = new JoystickButton(buttonBoardA, 12);
  // Button hatchGrab = new JoystickButton(buttonBoardB, 10);
  // Button hatchRelease = new JoystickButton(buttonBoardA, 11);

  // Button turretFront = new JoystickButton(buttonBoardA, 7);
  // Button turretBack = new JoystickButton(buttonBoardA, 8);
  // Button turretRight = new JoystickButton(buttonBoardA, 6);
  // Button turretLeft = new JoystickButton(buttonBoardA, 5);
  
  // Button turretRocketRightBack = new JoystickButton(buttonBoardB, 9);

  // Button frontClimbHome = new JoystickButton(buttonBoardA, 3);
  // Button frontClimbPass = new JoystickButton(buttonBoardB, 2); //should be B2
  // Button frontClimbGround = new JoystickButton(buttonBoardA, 2);

  
  // Button climbAuto = new JoystickButton(buttonBoardB, 4);
  // Button climbStop = new JoystickButton(buttonBoardB, 1);

  // Button transfer = new JoystickButton(buttonBoardA, 4); //should be A4

  // Button anyTurret = new CustomButton(() -> {
  //   return turretFront.get() || turretBack.get() || turretRight.get() || turretLeft.get();
  // });


  ////////////////////////////
  // TESTING MANUAL CONTROL //
  ////////////////////////////
  public static DoubleSupplier turret = () -> -buttonBoardA.getX()/8;
  public static DoubleSupplier elevator = () -> buttonBoardA.getY();

  public static Joystick turtleFront = new Joystick(4);
  public static Joystick turtleBack = new Joystick(3);
  Button zeroTurret = new JoystickButton(turtleBack, 7);
  
  public static DoubleSupplier tail = () -> (turtleBack.getY()*0.75);//buttonBoardB.getY();//
  public static DoubleSupplier intake = () -> (turtleFront.getY());//buttonBoardB.getX(); //

  public static Joystick shoulderControl = new Joystick(5);
  public static DoubleSupplier shoulder = () -> (shoulderControl.getY());

  public static Joystick wristControl = new Joystick(5);
  public static DoubleSupplier wrist = () -> (wristControl.getY());

  public OI() {

    ////////////
    // STATES //
    ////////////

    ballFeedIn.whileHeld(ballFeed.setStateCommand(BallFeeder.State.FEED,BallFeeder.State.STOP, false));
    ballFeedOut.whileHeld(ballFeed.setStateCommand(BallFeeder.State.UNFEED,BallFeeder.State.STOP, false));

    groundHatchFeedIn.whileHeld(hatchGroundIntake.setStateCommand(HatchGroundIntake.State.FEED, HatchGroundIntake.State.STOP, false));
    groundHatchFeedOut.whileHeld(hatchGroundIntake.setStateCommand(HatchGroundIntake.State.UNFEED, HatchGroundIntake.State.STOP, false));

    hatchGrab.whileHeld(HAL.hatch.setStateCommand(HatchPatchSubsystem.State.OUT));
    hatchRelease.whileHeld(HAL.hatch.setStateCommand(HatchPatchSubsystem.State.IN));

    //switchPipeline.whileHeld(new SwitchPipeline(7));
    //trackPipeline.whenPressed(new SwitchPipeline(7));
    
    //drivePipeline.whenPressed(new SwitchPipeline(8));
    //climbStop.whenPressed(HAL.frontClimber.set);

    //////////////
    // COMMANDS //
    //////////////
    zeroTurret.whileHeld(new Zeros("turret"));
    
    travelPosition.whenPressed(new SetElevatorShoulderWrist(Wrist.WristPreset.TRAVEL,Shoulder.ShoulderPreset.TRAVEL,Elevator.ElevatorPreset.TRAVEL));    

    // GROUND
    ballFeedGround.whenPressed(new SetElevatorShoulderWrist(Wrist.WristPreset.GROUND_BALL,Shoulder.ShoulderPreset.GROUND_BALL,Elevator.ElevatorPreset.GROUND_BALL));
    
    // FEEDER STATION
    //ballFeederStation.whenPressed(new SetElevatorShoulderWrist(Wrist.WristPreset.FEEDER_STATION_BALL, Shoulder.ShoulderPreset.FEEDER_STATION_BALL,Elevator.ElevatorPreset.FEEDER_STATION_BALL));
    hatchFeederStation.whenPressed(new SetElevatorShoulderWrist(Wrist.WristPreset.FEEDER_STATION_HATCH, Shoulder.ShoulderPreset.FEEDER_STATION_HATCH, Elevator.ElevatorPreset.FEEDER_STATION_HATCH));

    /////////////////////////////
    // ROCKET & CARGO SHIP OLD //
    /////////////////////////////
    // lowBallRocket.whenPressed(new SetElevatorShoulderWrist(Wrist.WristPreset.ROCKET_LOW_BALL,Shoulder.ShoulderPreset.ROCKET_LOW_BALL,Elevator.ElevatorPreset.ROCKET_LOW_BALL));
    // midBallRocket.whenPressed(new SetElevatorShoulderWrist(Wrist.WristPreset.ROCKET_MID_BALL,Shoulder.ShoulderPreset.ROCKET_MID_BALL,Elevator.ElevatorPreset.ROCKET_MID_BALL));
    // highBallRocket.whenPressed(new SetElevatorShoulderWrist(Wrist.WristPreset.ROCKET_HIGH_BALL,Shoulder.ShoulderPreset.ROCKET_HIGH_BALL,Elevator.ElevatorPreset.ROCKET_HIGH_BALL));

    // lowHatchRocket.whenPressed(new SetElevatorShoulderWrist(Wrist.WristPreset.ROCKET_LOW_HATCH,Shoulder.ShoulderPreset.ROCKET_LOW_HATCH,Elevator.ElevatorPreset.ROCKET_LOW_HATCH));
    // midHatchRocket.whenPressed(new SetElevatorShoulderWrist(Wrist.WristPreset.ROCKET_MID_HATCH,Shoulder.ShoulderPreset.ROCKET_MID_HATCH,Elevator.ElevatorPreset.ROCKET_MID_HATCH));
    // highHatchRocket.whenPressed(new SetElevatorShoulderWrist(Wrist.WristPreset.ROCKET_HIGH_HATCH,Shoulder.ShoulderPreset.ROCKET_HIGH_HATCH,Elevator.ElevatorPreset.ROCKET_HIGH_HATCH));
    
    // cargoshipHatch.whenPressed(new SetElevatorShoulderWrist(Wrist.WristPreset.ROCKET_LOW_HATCH,Shoulder.ShoulderPreset.ROCKET_LOW_HATCH,Elevator.ElevatorPreset.ROCKET_LOW_HATCH));
    // cargoshipBall.whenPressed(new SetElevatorShoulderWrist(Wrist.WristPreset.CARGOSHIP_BALL, Shoulder.ShoulderPreset.CARGOSHIP_BALL, Elevator.ElevatorPreset.CARGOSHIP_BALL));

    ///////////////////////////////////
    // ROCKET & CARGO SHIP STAGGERED //
    ///////////////////////////////////
    lowBallRocketStag.whenPressed(new SetElevatorShoulderWrist(Wrist.WristPreset.ROCKET_LOW_BALL,Shoulder.ShoulderPreset.ROCKET_LOW_BALL,Elevator.ElevatorPreset.ROCKET_LOW_BALL));
    midBallRocketStag.whenPressed(new Staggered_E_S_W(Wrist.WristPreset.ROCKET_MID_BALL,Shoulder.ShoulderPreset.ROCKET_MID_BALL,Elevator.ElevatorPreset.ROCKET_MID_BALL));
    highBallRocketStag.whenPressed(new Staggered_E_S_W(Wrist.WristPreset.ROCKET_HIGH_BALL,Shoulder.ShoulderPreset.ROCKET_HIGH_BALL,Elevator.ElevatorPreset.ROCKET_HIGH_BALL));

    lowHatchRocketStag.whenPressed(new SetElevatorShoulderWrist(Wrist.WristPreset.ROCKET_LOW_HATCH,Shoulder.ShoulderPreset.ROCKET_LOW_HATCH,Elevator.ElevatorPreset.ROCKET_LOW_HATCH));
    midHatchRocketStag.whenPressed(new Staggered_E_S_W(Wrist.WristPreset.ROCKET_MID_HATCH,Shoulder.ShoulderPreset.ROCKET_MID_HATCH,Elevator.ElevatorPreset.ROCKET_MID_HATCH));
    highHatchRocketStag.whenPressed(new Staggered_E_S_W(Wrist.WristPreset.ROCKET_HIGH_HATCH,Shoulder.ShoulderPreset.ROCKET_HIGH_HATCH,Elevator.ElevatorPreset.ROCKET_HIGH_HATCH));
    
    cargoshipHatchStag.whenPressed(new SetElevatorShoulderWrist(Wrist.WristPreset.FEEDER_STATION_HATCH, Shoulder.ShoulderPreset.FEEDER_STATION_HATCH, Elevator.ElevatorPreset.FEEDER_STATION_HATCH));
    cargoshipBallStag.whenPressed(new Staggered_E_S_W(Wrist.WristPreset.CARGOSHIP_BALL, Shoulder.ShoulderPreset.CARGOSHIP_BALL, Elevator.ElevatorPreset.CARGOSHIP_BALL));    

    // CLIMBER
    frontClimbHome.whenPressed(new SetFrontClimber(FrontClimber.FrontClimberPreset.HOME));
    //frontClimbGround.whenPressed(new Climb(FrontClimber.FrontClimberPreset.AUTO_CLIMB,BackClimber.BackClimberPreset.AUTO_CLIMB,2));
    frontClimbPassLvl_3.whenPressed(new SetFrontClimber(FrontClimber.FrontClimberPreset.PASS3));

    // TURRET
    turretFront.whileHeld(new SetTurret(Turret.TurretPreset.FRONT));
    turretRight.whileHeld(new SetTurret(Turret.TurretPreset.RIGHT));
    turretLeft.whileHeld(new SetTurret(Turret.TurretPreset.LEFT));
    turretBack.whileHeld(new SetTurret(Turret.TurretPreset.BACK));
    //turretRocketRightBack.whileHeld(new SetTurret(Turret.TurretPreset.RIGHT_ROCKET_BACK));

    anyTurret.whenReleased(new HoldTurret(OI.turret));
    
    // FRONT CLIMBER
    turretZero.whenPressed(new Zeros("turret"));
    //hatchToElevatorTransfer.whenPressed(new SetElevatorShoulderWrist(Wrist.WristPreset.HATCH_GROUND_2_ELEVATOR_TRANSFER,Shoulder.ShoulderPreset.HATCH_GROUND_2_ELEVATOR_TRANSFER,Elevator.ElevatorPreset.HATCH_GROUND_2_ELEVATOR_TRANSFER));
    climbAutoLvl_3.whenPressed(new Climb(FrontClimber.FrontClimberPreset.AUTO_CLIMB,BackClimber.BackClimberPreset.AUTO_CLIMB,3));
    climbAutoLvl_2.whenPressed(new Climb(FrontClimber.FrontClimberPreset.AUTO_CLIMB,BackClimber.BackClimberPreset.AUTO_CLIMB,2));
    climbStop.whenPressed(new StopClimb());

    // VISION
    visionLow.whileHeld(new SnakeLime());

    visionMidHigh.whenPressed(new SetElevatorShoulderWrist(Wrist.WristPreset.TRAVEL, Shoulder.ShoulderPreset.TRAVEL, Elevator.ElevatorPreset.VISION_TRAVEL));
    visionMidHigh.whileHeld(new VisionAgainstRocket());
    
    visionTurret.whenPressed(new SetElevatorShoulderWrist(Wrist.WristPreset.TRAVEL, Shoulder.ShoulderPreset.TRAVEL, Elevator.ElevatorPreset.VISION_TRAVEL));
    visionTurret.whileHeld(new TurretAlignLime());
  }
}