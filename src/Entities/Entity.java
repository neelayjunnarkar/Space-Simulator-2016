package Entities;

import physics.Vector;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.HashMap;

/**
 * Entity base class
 *
 * @author Neelay Junnarkar
 */
public abstract class Entity {
    HashMap<String, Vector> forces;
    Point2D.Double pos;

    public Entity() {
        this(new Point2D.Double(0, 0));
    }

    public Entity(Point2D.Double pos) {
        this.pos = pos;
    }

    public Point2D.Double getPos() {
        return (Point2D.Double)pos.clone();
    }

    public void setPos(Point2D.Double pt) {
        pos.setLocation(pt.getX(), pt.getY());
    }

    public void setPos(double x, double y) {
        pos.setLocation(x, y);
    }

    public Point2D.Double offset(double x, double y) {
        pos.setLocation(pos.getX() + x, pos.getY() + y);
        return (Point2D.Double)pos.clone();
    }

    public void addForce(String key, Vector force) {
        forces.put(key, force);
    }

    /**
     * @param key
     * @return returns the Value that is removed
     */
    public Vector removeForce(String key) {
        return forces.remove(key).clone();
    }
}
