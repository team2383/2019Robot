package frc.robot;

import frc.robot.subsystems.*;

public class HAL {

    public static Drivetrain drive = new Drivetrain();
    public static LimelightSubsystem limelight = new LimelightSubsystem();
    public static Turret turret = new Turret();
    public static FrontClimber frontClimber = new FrontClimber();
    public static BackClimber backClimber = new BackClimber();
    public static Elevator elevator = new Elevator();
    public static HatchPatchSubsystem hatch = new HatchPatchSubsystem();
    public static BallFeeder ballFeed = new BallFeeder();
    public static Shoulder shoulder = new Shoulder(); //relies on hatch, init hatch first
    public static Wrist wrist = new Wrist();
    public static HatchGroundIntake hatchGroundIntake = new HatchGroundIntake();
}