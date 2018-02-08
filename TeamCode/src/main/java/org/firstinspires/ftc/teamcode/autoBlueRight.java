package org.firstinspires.ftc.teamcode;

import com.qualcomm.hardware.bosch.JustLoggingAccelerationIntegrator;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;

/**
 * Created by mai on 1/25/18.
 *
 * *** BLUE ALLIANCE, RIGHT BALANCE ***
 *
 * AUTONOMOUS MODE FOR TIME
 *
 * 1. Moves out servo to middle
 * 2. Moves forward
 * 3. Senses the color of the ball on the right and kicks the jewel
 * 4. moves backward
 * 5. moves right
 * 6. moves forward to park
 */
@Autonomous
public class autoBlueRight extends LinearOpMode {

    //get the hardware from the class botHardware()
    botHardware robot = new botHardware();
    private ElapsedTime runtime = new ElapsedTime();
    private ElapsedTime mintime = new ElapsedTime();

    @Override
    public void runOpMode() {



        int count = 0;
        robot.init(hardwareMap);


        waitForStart();

        //move jewelServo to the middle
        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < 1) {
            robot.jewelServo.setPosition(.45);
            robot.arm.setPower(.2);



        }



        //move the robot RIGHT to the jewels
        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < .5) {
            robot.motor0.setPower(.2);
            robot.motor1.setPower(.2);
            robot.motor2.setPower(-.2);
            robot.motor3.setPower(-.2);


        }

        //keep moving the robot RIGHT until the sensor can see the blue/red.
        //Afterwards, stop and kick the red ball away.
        runtime.reset();
        while (opModeIsActive() && runtime.seconds() < 5) {



            mintime.reset();
            while (count != 1) {
                while (mintime.seconds() < 3 && (robot.colSensor.blue() < 80 || robot.colSensor.red() < 80)) {
                    robot.motor0.setPower(.15);
                    robot.motor1.setPower(.15);
                    robot.motor2.setPower(-.15);
                    robot.motor3.setPower(-.15);

                }
                count++;
            }


            robot.motor0.setPower(0);
            robot.motor1.setPower(0);
            robot.motor2.setPower(0);
            robot.motor3.setPower(0);

            // color sensor looking for red
           if (robot.colSensor.red() > robot.colSensor.blue() + 20) {  // if sees red then turn to red ball

                robot.jewelServo.setPosition(-1);
               telemetry.addLine("red");
            }

            else if (robot.colSensor.blue() > robot.colSensor.red() + 20) { //if sees blue then turn to the red ball

                robot.jewelServo.setPosition(1);
                telemetry.addLine("blue");
            }



        }



            //move LEFT
        // ORIGINAL : .4 POWER .5 TIME
            runtime.reset();
            while (opModeIsActive() && runtime.seconds() < .5) {
                robot.motor0.setPower(-.4);
                robot.motor1.setPower(-.4);
                robot.motor2.setPower(.4);
                robot.motor3.setPower(.4);

            }

            //move to the BACKWARD
            runtime.reset();
            while (opModeIsActive() && runtime.seconds() < 1.5) {
                robot.motor0.setPower(-1);
                robot.motor1.setPower(1);
                robot.motor2.setPower(1);
                robot.motor3.setPower(-1);

            }






            //move RIGHT
            runtime.reset();
            while (opModeIsActive() && runtime.seconds() < .8) {
                robot.motor0.setPower(.25);
                robot.motor1.setPower(.25);
                robot.motor2.setPower(-.25);
                robot.motor3.setPower(-.25);

            }











    }
}
