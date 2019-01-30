package frc.robot;

public class Preset
{
    public static enum LiftSet
    {
        HIGH_GOAL(30), 
        MID_GOAL(20), 
        LOW_GOAL(10);
      
        public double liftPosition;
      
        private LiftSet(double liftPosition) 
        {
          this.liftPosition = liftPosition;
        }
    }

    public static enum IntakeSet
    {
        FRONT_POS(0), 
        BACK_POS(0), 
        MIDDLE_POS(0);
      
        public double intakePosition;
      
        private IntakeSet(double intakePosition) 
        {
          this.intakePosition = intakePosition;
        }
    }

    public static enum ArmSet
    {
        STRAIGHT(90), 
        ANGLED(45), 
        DOWN(10);
      
        public double armPosition;
      
        private ArmSet(double armPosition) 
        {
          this.armPosition = armPosition;
        }
    }

}
