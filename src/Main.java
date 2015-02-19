import entities.Entity;
import entities.Polygon2D;
import gui.Panel;
import physics.Force;
import physics.Vector;

import javax.swing.*;
import java.awt.geom.Point2D;
import java.util.*;

/**
 *               ████████████████████
 *             ████████████████████████
 *           ████████████████████████████
 *           ████████████████████████████
 *         ████████████████████████████████
 *         ██████░░██████░░░░████░░████████
 *         ████░░░░░░░░░░░░░░░░░░░░░░░░████
 *         ░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░██
 *         ██████████░░░░██████████░░░░░░██
 *         ██  ▓▓  ████████  ▓▓  ██████████
 *         ██████████░░░░██████████░░░░░░░░
 *         ░░░░░░░░░░▒▒▒▒░░░░░░░░░░░░░░░░░░
 *         ░░░░░░░░░░▒▒░░░░░░░░░░░░░░░░░░
 *         ░░░░░░░░░░░░░░░░░░░░░░░░░░░░
 *           ░░░░░░▒▒▒▒▒▒▒▒░░░░░░░░░░░░
 *           ░░░░░░░░▒▒▒▒░░░░░░░░░░░░
 *             ░░░░░░░░░░░░░░░░░░░░▒▒
 *             ░░░░░░░░░░░░░░░░░░▒▒▒▒
 *               ░░░░░░░░░░░░▒▒▒▒▒▒▒▒
 *             ▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓
 *         ▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓
 *     ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▒▒▒▒▒▒▒▒▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
 *   ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
 *   ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
 * ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
 * ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
 * ▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓
 *    ______ ______ ___    ______ ______      ______ ___ _______ ______ ___    ___  ________ ______ ______      ______ ______ ___ ______
 *   /  ___//  _  //   |  /  ___//  ___/     /  ___//  //   /  //  /  //  /   /   |/__   __//     //  _  /     /___  //     //  //  ___/
 *  /___  //  ___//  _ | /  /__ /  ___/     /___  //  //      //  /  //  /__ /  _ |  /  /  /  /  //    _/     /  ___//  /  //  //  _  /
 * /_____//__/   /__/__|/_____//_____/     /_____//__//__/_/_//_____//_____//__/__| /__/  /_____//__/__\     /_____//_____//__//_____/
 *              ________ ___ ________ ___  ___      ______ ___  ___ ___    ___ ______ ______ ___
 *             |  / /  //  //__   __//  /_/  /     /  ___//  /_/  //   |  /  //  _  //  ___//  /
 *  __  __  __ |      //  /   /  /  /  __   /     /  /__ /  __   //  _ | /  //    _//___  //__/
 * /_/ /_/ /_/ |__/__//__/   /__/  /__/ /__/     /_____//__/ /__//__/__|/__//__/__\/_____//__/
 * A pro space simulator.

 * @author Tyler Packard
 * @author Neelay Junnarkar
 */
public class Main {
    public final static JFrame window = new JFrame("Space Simulator 2016");
    public final static Panel panel = new Panel(640, 480);

    public final static HashMap<String, Entity> entities = new HashMap<>();

    public static void main(String[] args) {
        window.add(panel);
        window.pack();
        window.setResizable(false);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        entities.put("asteroid 1", new Entity(new Polygon2D(new double[]{0, 0, 30, 30}, new double[]{0, 20, 20, 0}),
                                              new Point2D.Double(0, 0), 100));
        entities.get("asteroid 1").addVelocity("propellant", new Vector(100, Math.PI/4.0));

        entities.put("asteroid 2", new Entity(new Polygon2D(new double[]{0, 30, 30}, new double[]{20, 20, 0})));
        entities.get("asteroid 2").setPos(100, 100);
        System.out.println(entities.get("asteroid 2").getVelocity() + " " + entities.get("asteroid 2").getMass());


//        Vector axis = new Vector(1, Math.PI/6.0);
//        Vector other = new Vector(1, Math.PI/3.0);
//        Vector projection = other.project(axis);
//        Vector rejection = other.reject(axis);
//
//        Vector result = Vector.add(projection, rejection);
//
//        System.out.println("axis: "+axis.getMagnitude()+" "+axis.getAngle());
//        System.out.println("other: "+other.getMagnitude()+" "+other.getAngle());
//        System.out.println("projection: "+projection.getMagnitude()+" "+projection.getAngle());
//        System.out.println("rejection: "+rejection.getMagnitude()+" "+rejection.getAngle());
//        System.out.println("result: " + result.getMagnitude()+" "+result.getAngle());

        double prevTime = System.nanoTime();
        while (true) {
            double curTime = System.nanoTime();

            update(curTime - prevTime);
            panel.repaint(entities.values().toArray(new Entity[entities.size()]));

            prevTime = curTime;

            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static boolean hit = false;
    public static void update(double nanoDelta) {
        double delta = nanoDelta / 1_000_000_000.0;
        for (Entity entity : entities.values()) {
            entity.update(delta);
        }

       if (entities.get("asteroid 1").overlaps(entities.get("asteroid 2"))) {
           hit = true;
           
           Vector rejection = entities.get("asteroid 1").getVelocity().reject(entities.get("asteroid 2").getVelocity());
           double ma = entities.get("asteroid 1").getMass();
           double vai = rejection.getMagnitude();
           System.out.println(rejection);
           double mb = entities.get("asteroid 2").getMass();
           double vbi = entities.get("asteroid 2").getVelocity().getMagnitude();

           double vaf = (ma*vai - mb*(vai-2*vbi)) / (ma + mb);
           double vbf = (ma*vai + mb*vbi - ma*vaf) / (mb);
           System.out.println(vai + " " + vbf);
           entities.get("asteroid 1").addVelocity("rejection", new Vector(vaf-vai, Math.PI + rejection.getAngle()));
           entities.get("asteroid 2").addVelocity("veocity", new Vector(vbf-vbi, rejection.getAngle()));
       }
    }
}
