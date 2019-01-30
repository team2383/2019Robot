package frc.robot;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMax;

public class Encoder {

    public static double getPosition(CANSparkMax controller) {
        return new CANEncoder(controller).getPosition();    
    }

    public static double getVelocity(CANSparkMax controller) {
        return new CANEncoder(controller).getVelocity();
    }

    

}