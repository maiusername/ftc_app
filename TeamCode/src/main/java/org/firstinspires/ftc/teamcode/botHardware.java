package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorColor;

/**
 * Created by mai on 1/25/18.
 */

public class botHardware {

    DcMotor motor0 = null;
    DcMotor motor1 = null;
    DcMotor motor2 = null;
    DcMotor motor3 = null;
    DcMotor arm = null;

    Servo jewelServo = null;
    Servo BL = null;
    Servo TL = null;
    Servo BR = null;
    Servo TR = null;
    Servo s = null;

    ColorSensor colSensor = null;

    HardwareMap hwdmap = null;

    public botHardware(){

    }

    /**
     * Method that initializes the robot
     */
    public void init(HardwareMap ahwmap){

        hwdmap = ahwmap;

        //define the names that go into the configuration.
        //Names are in green
        motor0 = hwdmap.dcMotor.get("motor0");
        motor1 = hwdmap.dcMotor.get("motor1");
        motor2 = hwdmap.dcMotor.get("motor2");
        motor3 = hwdmap.dcMotor.get("motor3");
        arm = hwdmap.dcMotor.get("arm");
        jewelServo = hwdmap.servo.get("jewelServo");
        BL = hwdmap.servo.get("bl");
        TL = hwdmap.servo.get("tl");
        BR = hwdmap.servo.get("br");
        TR = hwdmap.servo.get("tr");
        colSensor = hwdmap.colorSensor.get("colSensor");
        s = hwdmap.servo.get("s");

        motor0.setPower(0);
        motor1.setPower(0);
        motor2.setPower(0);
        motor3.setPower(0);
        arm.setPower(0);



    }

}
