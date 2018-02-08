package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;

/**
 * Created by mai on 1/6/18.
 */

public class holoAutoBlue extends LinearOpMode{
    DcMotor motor0, motor1, motor2, motor3;
    ColorSensor colSensor;
    //Servo pushServo;
    private ElapsedTime runtime = new ElapsedTime();



    public void runOpMode(){

        motor0 = hardwareMap.dcMotor.get("motor0");
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor3 = hardwareMap.dcMotor.get("motor3");
       // colSensor = hardwareMap.colorSensor.get("colSensor");
        //pushServo = hardwareMap.servo.get("pushServo");

        //pushServo.setPosition(-1);


       /**

        //******************* COLOR SENSOR ******************************************************


        // hsvValues is an array that will hold the hue, saturation, and value information.
        float hsvValues[] = {0F, 0F, 0F};

        // values is a reference to the hsvValues array.
        final float values[] = hsvValues;

        // sometimes it helps to multiply the raw RGB values with a scale factor
        // to amplify/attentuate the measured values.
        final double SCALE_FACTOR = 255;


        **/


        //****************************************************************************************



        //********************HOLONOMIC DRIVE - MOTORS*********************************************




        //******************************************************************************************


        // wait for the start button to be pressed.
        waitForStart();

        /*
        // loop and read the RGB and distance data.
        // Note we use opModeIsActive() as our loop condition because it is an interruptible method.
        while (opModeIsActive() && runtime.seconds() < 30) {




            // convert the RGB values to HSV values.
            // multiply by the SCALE_FACTOR.
            // then cast it back to int (SCALE_FACTOR is a double)

            /**
             Color.RGBToHSV((int) (colSensor.red() * SCALE_FACTOR),
             (int) (colSensor.green() * SCALE_FACTOR),
             (int) (colSensor.blue() * SCALE_FACTOR),
             hsvValues);
             **/

        /**
            // send the info back to driver station using telemetry function.
            telemetry.addData("Alpha", colSensor.alpha());
            telemetry.addData("Red  ", colSensor.red());
            telemetry.addData("Green", colSensor.green());
            telemetry.addData("Blue ", colSensor.blue());
            telemetry.addData("Hue", hsvValues[0]);


            // color sensor looking for red
            if (colSensor.blue() >= 40) {      //if sees blue then turn to the red ball
                pushServo.setPosition(1);
            } else if (colSensor.red() >= 40) {  // if sees red then turn to red ball
                pushServo.setPosition(1);
            }




            telemetry.update();




        }

        **/

        //have the robot move forward for ten seconds
        while(opModeIsActive() && runtime.seconds() < 3){


            motor0.setPower(.4);
            motor1.setPower(-.4);
            motor2.setPower(.4);
            motor3.setPower(-.4);


        }

        //move backward
        while(opModeIsActive() && runtime.seconds() > 3 && runtime.seconds() < 7){


            motor0.setPower(-.4);
            motor1.setPower(.4);
            motor2.setPower(-.4);
            motor3.setPower(.4);


        }

        //move right
        while(opModeIsActive() && runtime.seconds() > 7 && runtime.seconds() < 11){


            motor0.setPower(.4);
            motor1.setPower(.4);
            motor2.setPower(-.4);
            motor3.setPower(-.4);


        }

        //move left
        while(opModeIsActive() && runtime.seconds() > 11 && runtime.seconds() < 15){


            motor0.setPower(-.4);
            motor1.setPower(-.4);
            motor2.setPower(.4);
            motor3.setPower(.4);


        }









    }



}
