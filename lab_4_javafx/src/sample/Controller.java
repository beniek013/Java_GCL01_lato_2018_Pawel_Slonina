package sample;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import java.util.Calendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

public class Controller
{
    @FXML
    Canvas canvas;
    GraphicsContext gc;
    //tarcza
    public void drawClock(GraphicsContext gc) {
        int width,equalHoursSize,normalHoursSize,minutesSize;
        width = 400;
        equalHoursSize = 30;
        normalHoursSize = 20;
        minutesSize = 10;
        double r = width / 2;

        int hour = 3, positioning = 300;
        //odleglosc numerow od znacznikow
        double padding = 40;
        double x1,y1,x2,y2,hourX, hourY;
        for (int i = 0; i < 60; i++) {
            double radians = Math.toRadians(i*6);
            //tu rysujemy godziny
            if (i % 5 == 0) {
                hourX = ((r - padding) * (Math.cos(radians)) + positioning);
                hourY = ((r - padding) * (Math.sin(radians)) + positioning);

                gc.strokeText(Integer.toString(hour), hourX, hourY);
                hour++;
                hour = hour > 12 ? 1 : hour;
            }

            x1 = ((r - minutesSize) * Math.cos(radians)) + positioning;
            y1 = ((r - minutesSize) * Math.sin(radians)) + positioning;
            //rowne godziny - 12,3,6,9
            if (i % 15 == 0) {
                x1 = ((r - equalHoursSize) * Math.cos(radians)) + positioning;
                y1 = ((r - equalHoursSize) * Math.sin(radians)) + positioning;
            }
            //pomiędzy rownymi godzinami - np. 2,8
            else if (i % 5 == 0) {
                x1 = ((r - normalHoursSize) * Math.cos(radians)) + positioning;
                y1 = ((r - normalHoursSize) * Math.sin(radians)) + positioning;
            }
            x2 = (Math.cos(radians) * r) + positioning;
            y2 = (Math.sin(radians) * r) + positioning;
            //rysujemy male znaczniki
            gc.strokeLine(x1, y1, x2, y2);
        }
    }
    //wskazowki
    public void drawClockHands(GraphicsContext gc) {
        double r = 200;
        double x0 = 300;
        double y0 = 300;
        double hourX, hourY, minuteX, minuteY, secondX, secondY;

        Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

        /*System.out.println("h: " + hours);
        System.out.println("m: " + minute);
        System.out.println("s: " + second);*/

        double hourRadians = Math.toRadians((double)((calendar.get(Calendar.HOUR_OF_DAY)) * 30)) - (Math.PI / 2);
        double minuteRadians = Math.toRadians((double)((calendar.get(Calendar.MINUTE)) * 6)) - (Math.PI / 2);
        double secondRadians = Math.toRadians((double)((calendar.get(Calendar.SECOND)) * 6)) - (Math.PI / 2);

        int positioning = 300;

        hourX = ((r - 100) * Math.cos(hourRadians)) + positioning;
        hourY = ((r - 100) * Math.sin(hourRadians)) + positioning;
        minuteX = ((r - 70) * Math.cos(minuteRadians)) + positioning;
        minuteY = ((r - 70) * Math.sin(minuteRadians)) + positioning;
        secondX = ((r - 40) * Math.cos(secondRadians)) + positioning;
        secondY = ((r - 40) * Math.sin(secondRadians)) + positioning;

        //rysujemy minutnik, sekundik i godzinnik
        gc.strokeLine(x0, y0, hourX, hourY);
        gc.strokeLine(x0, y0, minuteX, minuteY);
        gc.strokeLine(x0, y0, secondX, secondY);
    }


    @FXML
    public void initialize() {
        gc = canvas.getGraphicsContext2D();
        Timer timer = new Timer();
        TimerTask taskNew = new TimerTask() {
            @Override
            public void run() {
                gc.clearRect(0, 0, 500, 500);
                drawClock(gc);
                drawClockHands(gc);
            }
        };
        timer.scheduleAtFixedRate(taskNew,0,1000);
    }
}
