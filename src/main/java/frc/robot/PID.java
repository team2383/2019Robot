package frc.robot;

import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;

public class PID {

    public static void getP(CANSparkMax controller) {
        new CANPIDController(controller).getP();
    }

    public static void getI(CANSparkMax controller) {
        new CANPIDController(controller).getI();
    }

    public static void getD(CANSparkMax controller) {
        new CANPIDController(controller).getD();
    }
    
}