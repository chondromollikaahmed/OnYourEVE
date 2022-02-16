/*
 * *
 *  * Created by Chondromolika Ahmed on 2/15/22, 2:42 PM
 *  *chondromollikaahmed@gmail.com
 *  * Copyright (c) 2022 . All rights reserved.
 *  * Last modified 2/15/22, 2:42 PM
 *  *Current Path E:/OnYourEVE/src/main/java/com/ca/onyoureve/ScrollAnimate.java
 *  *OnYourEVE
 *
 */



//under construction not used in code

package com.ca.onyoureve;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Font;


public class ScrollAnimate {

    public static void main(String[] args) throws InterruptedException {

        JFrame jf = new JFrame("Scroll Effect");

        JPanel jp = new JPanel();

        jf.setSize(800, 600);

        jp.setSize(800, 600);

        JLabel lab = new JLabel("Hello World");

        lab.setHorizontalAlignment(SwingConstants.CENTER);

        lab.setFont(new Font("Arial", Font.PLAIN, 20));

        jp.setLayout(null);

        jp.add(lab);

        jf.getContentPane().add(jp);

        jf.setVisible(true);

        int effect = 7;

        long speed = 5;

        /*
         * Change value of variable called effect:
         *
         * [1] LEFT TO RIGHT AND REVERSE
         *
         * [2] RIGHT TO LEFT AND REVERSE
         *
         * [3] TOP TO BOTTOM AND REVERSE
         *
         * [4] BOTTOM TO TOP AND REVERSE
         *
         * [5] LEFT TO RIGHT
         *
         * [6] RIGHT TO LEFT
         *
         * [7] TOP TO BOTTOM
         *
         * [8] BOTTOM TO TOP
         *
         */

        scrollEffect(lab, effect, speed, jf);

    }

    private static void scrollEffect(JLabel lab, int tipe, long espera, JFrame jf) throws InterruptedException {

        boolean reverse = false;

        Dimension size = lab.getPreferredSize();

        int x =jf.getHeight()-50;

        int y = jf.getWidth() - 120;

        int z = 0;

        while (true) {

            switch (tipe) {

                case 1:

                    if (z == 3) {
                        reverse = false;
                    }

                    if (z == jf.getWidth() - 120) {
                        reverse = true;
                    }

                    if (reverse) {
                        z--;
                    } else {
                        z++;
                    }

                    lab.setBounds(z, lab.getHeight(), size.width, size.height);

                    break;

                case 2:

                    if (y == 3 && !reverse) {
                        reverse = true;
                    }

                    if (y == jf.getWidth() - 120) {
                        reverse = false;
                    }

                    if (reverse) {
                        y++;
                    } else {
                        y--;
                    }

                    lab.setBounds(y, lab.getHeight(), size.width, size.height);

                    break;

                case 3:

                    if (z == jf.getHeight() - 40 && !reverse) {
                        reverse = true;

                    }

                    if (z == 0) {
                        reverse = false;

                    }

                    if (reverse) {
                        z--;

                    } else {
                        z++;
                    }

                    lab.setBounds(size.height, z, size.width, size.height);

                    break;

                case 4:

                    if (x ==jf.getHeight()-35 ) {
                        reverse = false;

                    }

                    if (x == 0) {
                        reverse = true;

                    }

                    if (reverse) {
                        x++;

                    } else {
                        x--;
                    }

                    lab.setBounds(size.height,x, size.width, size.height);

                    break;

                case 5:

                    if (z == jf.getWidth() - 120) {
                        z=0;
                    }

                    z++;


                    lab.setBounds(z, lab.getHeight(), size.width, size.height);
                    break;

                case 6:

                    if (y == 3 && !reverse) {
                        y=jf.getWidth() - 120;
                    }

                    if (y == jf.getWidth() - 120) {
                        reverse = false;
                    }

                    y--;

                    lab.setBounds(y, lab.getHeight(), size.width, size.height);

                    break;

                case 7:

                    if (z == jf.getHeight() - 35 && !reverse) {
                        reverse = true;
                        z = 0;
                    }

                    else {
                        reverse = false;
                        z++;
                    }

                    lab.setBounds(size.height, z, size.width, size.height);

                    break;

                case 8:

                    if (x == 0) {
                        x =jf.getHeight()-35;

                    }


                    x--;


                    lab.setBounds(size.height,x, size.width, size.height);

                    break;

            }

            Thread.sleep(espera);

        }

    }
}