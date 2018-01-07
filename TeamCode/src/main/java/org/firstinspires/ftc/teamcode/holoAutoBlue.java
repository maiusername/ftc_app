package org.firstinspires.ftc.teamcode;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by mai on 1/6/18.
 */

public class holoAutoBlue extends LinearOpMode{
    DcMotor motor0, motor1, motor2, motor3;
    ColorSensor colSensor;
    Servo pushServo;
    private ElapsedTime runtime = new ElapsedTime();



    public void runOpMode(){

        motor0 = hardwareMap.dcMotor.get("motor0");
        motor1 = hardwareMap.dcMotor.get("motor1");
        motor2 = hardwareMap.dcMotor.get("motor2");
        motor3 = hardwareMap.dcMotor.get("motor3");
        colSensor = hardwareMap.colorSensor.get("colSensor");
        pushServo = hardwareMap.servo.get("pushServo");


        pushServo.setPosition(-1);



        //******************* COLOR SENSOR ******************************************************


        // hsvValues is an array that will hold the hue, saturation, and value information.
        float hsvValues[] = {0F, 0F, 0F};

        // values is a reference to the hsvValues array.
        final float values[] = hsvValues;

        // sometimes it helps to multiply the raw RGB values with a scale factor
        // to amplify/attentuate the measured values.
        final double SCALE_FACTOR = 255;

        // get a reference to the RelativeLayout so we can change the background
        // color of the Robot Controller app to match the hue detected by the RGB sensor.
        int relativeLayoutId = hardwareMap.appContext.getResources().getIdentifier("RelativeLayout", "id", hardwareMap.appContext.getPackageName());
        final View relativeLayout = ((Activity) hardwareMap.appContext).findViewById(relativeLayoutId);



        //****************************************************************************************


        waitForStart();





        // wait for the start button to be pressed.
        waitForStart();

        // loop and read the RGB and distance data.
        // Note we use opModeIsActive() as our loop condition because it is an interruptible method.
        while (opModeIsActive()) {
            // convert the RGB values to HSV values.
            // multiply by the SCALE_FACTOR.
            // then cast it back to int (SCALE_FACTOR is a double)

            /**
             Color.RGBToHSV((int) (colSensor.red() * SCALE_FACTOR),
             (int) (colSensor.green() * SCALE_FACTOR),
             (int) (colSensor.blue() * SCALE_FACTOR),
             hsvValues);
             **/

            // send the info back to driver station using telemetry function.
            telemetry.addData("Alpha", colSensor.alpha());
            telemetry.addData("Red  ", colSensor.red());
            telemetry.addData("Green", colSensor.green());
            telemetry.addData("Blue ", colSensor.blue());
            telemetry.addData("Hue", hsvValues[0]);




/**
 // press b(red button) if on the red team
 if (gamepad1.b) {

 // color sensor looking for red
 if (colSensor.blue() >= 40) {      //if sees blue then turn to the red ball
 pushServo.setPosition(1);
 } else if (colSensor.red() >= 40) {  // if sees red then turn to red ball
 pushServo.setPosition(1);
 }


 }
 **/
            // color sensor looking for red
            if (colSensor.blue() >= 40) {      //if sees blue then turn to the red ball
                pushServo.setPosition(1);
            } else if (colSensor.red() >= 40) {  // if sees red then turn to red ball
                pushServo.setPosition(1);
            }


            /**
             // press x(blue) if on the blue team
             else if (gamepad1.x) {

             // color sensor looking for blue
             if (colSensor.blue() >= 40) {      //if sees blue then turn to the blue ball
             pushServo.setPosition(-1);
             } else if (colSensor.red() >= 40) {  // if sees red then turn to blue ball
             pushServo.setPosition(-1);
             }

             }
             **/

            // change the background color to match the color detected by the RGB sensor.
            // pass a reference to the hue, saturation, and value array as an argument
            // to the HSVToColor method.
            relativeLayout.post(new Runnable() {
                public void run() {
                    relativeLayout.setBackgroundColor(Color.HSVToColor(0xff, values));
                }
            });

            telemetry.update();

        }

        // Set the panel back to the default color
        relativeLayout.post(new Runnable() {
            public void run() {
                relativeLayout.setBackgroundColor(Color.WHITE);
            }
        });



        /**
         while(opModeIsActive()) {




         // press b(red button) if on the red team
         if (gamepad1.b) {

         // color sensor looking for red
         if (colSensor.blue() >= 40) {      //if sees blue then turn to the red ball
         pushServo.setPosition(1);
         } else if (colSensor.red() >= 40) {  // if sees red then turn to red ball
         pushServo.setPosition(1);
         }


         }

         // press x(blue) if on the blue team
         else if (gamepad1.x) {

         // color sensor looking for blue
         if (colSensor.blue() >= 40) {      //if sees blue then turn to the blue ball
         pushServo.setPosition(-1);
         } else if (colSensor.red() >= 40) {  // if sees red then turn to blue ball
         pushServo.setPosition(-1);
         }

         }

         }

         telemetry.update();

         **/



    }



}
